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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import bkoruznjak.from.hr.funtimes.R;
import bkoruznjak.from.hr.funtimes.databinding.ActivityMainBinding;
import bkoruznjak.from.hr.funtimes.root.FunApplication;

public class NewsActivity extends AppCompatActivity implements NewsActivityMVP.View {

    @Inject
    NewsActivityMVP.Presenter presenter;

    ActivityMainBinding mBinding;

    private ListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList<>();
    private int pageNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((FunApplication) getApplication()).getAppComponent().inject(this);

        Toolbar myToolbar = mBinding.toolbar;
        setSupportActionBar(myToolbar);

        listAdapter = new ListAdapter(resultList);
        mBinding.recyclerView.setAdapter(listAdapter);
        mBinding.recyclerView.addItemDecoration(new DividerItemDecoration(this));

        mBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBinding.recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (isLastItemDisplaying(mBinding.recyclerView)) {
                        presenter.fetchMoreData(++pageNumber);
                        Log.d("bbb", "loading data for page:" + pageNumber);
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
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("bbb", "text submitted:" + query);
                MenuItemCompat.collapseActionView(searchItem);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("bbb", "new:" + newText);
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
                Log.d("bbb", "search pressed");
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
        presenter.loadData();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.rxUnsubscribe();
        resultList.clear();
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        listAdapter.notifyItemInserted(resultList.size() - 1);
        Log.d("bbb", "updateData: " + resultList.size());
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
