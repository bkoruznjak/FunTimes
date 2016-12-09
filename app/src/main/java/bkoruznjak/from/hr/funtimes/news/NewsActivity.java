package bkoruznjak.from.hr.funtimes.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private int pageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ((FunApplication) getApplication()).getAppComponent().inject(this);

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
                        Log.d("bbb", "dosao do kraja ucitaj novi page:" + pageNumber);
                    }
                }
                return false;
            }
        });

        presenter.setView(this);
        presenter.loadData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
    }

    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        if (resultList.isEmpty()) {
            listAdapter.notifyItemInserted(0);
        } else {
            listAdapter.notifyItemInserted(resultList.size() - 1);
        }
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