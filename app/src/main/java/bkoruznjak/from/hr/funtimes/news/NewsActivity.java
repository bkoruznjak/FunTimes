package bkoruznjak.from.hr.funtimes.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkoruznjak.from.hr.funtimes.R;
import bkoruznjak.from.hr.funtimes.databinding.ActivityMainBinding;
import bkoruznjak.from.hr.funtimes.network.NetworkConstants;
import bkoruznjak.from.hr.funtimes.root.FunApplication;

public class NewsActivity extends AppCompatActivity implements NewsActivityMVP.View {

    //todo need to implement starter persistance of the query string to survive orientation changes
    private static String queryString = NetworkConstants.GENERIC_SEARCH_QUERY_STRING;
    @Inject
    NewsActivityMVP.Presenter presenter;
    ActivityMainBinding mBinding;
    private NewsCardAdapter mNewsCardAdapter;
    private List<ViewModel> resultList = new ArrayList<>();
    private int pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((FunApplication) getApplication()).getAppComponent().inject(this);

        Toolbar myToolbar = mBinding.toolbar;
        setSupportActionBar(myToolbar);

        mNewsCardAdapter = new NewsCardAdapter(resultList);
        mBinding.recyclerView.setAdapter(mNewsCardAdapter);

        mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBinding.recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (isLastItemDisplaying(mBinding.recyclerView)) {
                        presenter.fetchDataByPageAndQuery(++pageNumber, queryString);
                    }
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView =
                (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            //todo need to figure out a better way to prevent onQueryTextChange after onQueryTextSubmit
            boolean willReload = true;

            @Override
            public boolean onQueryTextSubmit(String query) {
                willReload = false;
                MenuItemCompat.collapseActionView(searchItem);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (willReload) {
                    if (TextUtils.isEmpty(newText)) {
                        newText = NetworkConstants.GENERIC_SEARCH_QUERY_STRING;
                    }
                    queryString = newText;
                    resultList.clear();
                    mNewsCardAdapter.notifyDataSetChanged();
                    presenter.fetchDataByPageAndQuery(0, queryString);
                } else {
                    willReload = true;
                }

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        presenter.fetchDataByPageAndQuery(0, queryString);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        resultList.clear();
        mNewsCardAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        mNewsCardAdapter.notifyItemInserted(resultList.size() - 1);
    }

    @Override
    public void showSnackbar(String s) {
        Snackbar.make(mBinding.activityMain, s, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean isLastItemDisplaying(RecyclerView recyclerView) {
        if (recyclerView.getAdapter().getItemCount() != 0) {
            int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
            if (lastVisibleItemPosition != RecyclerView.NO_POSITION && lastVisibleItemPosition == recyclerView.getAdapter().getItemCount() - 1)
                return true;
        }
        return false;
    }
}
