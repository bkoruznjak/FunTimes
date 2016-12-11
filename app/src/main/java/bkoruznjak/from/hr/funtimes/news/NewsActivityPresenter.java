package bkoruznjak.from.hr.funtimes.news;

import android.support.annotation.Nullable;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public class NewsActivityPresenter implements NewsActivityMVP.Presenter {

    @Nullable
    private NewsActivityMVP.View mNewsView;
    private NewsActivityMVP.Model mRepositoryModel;

    private Subscription subscription = null;

    public NewsActivityPresenter(NewsActivityMVP.Model repositoryModel) {
        this.mRepositoryModel = repositoryModel;
    }

    @Override
    public void setView(NewsActivityMVP.View view) {
        this.mNewsView = view;
    }

    @Override
    public void loadData() {
        subscription = mRepositoryModel.result().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ViewModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (mNewsView != null) {
                    mNewsView.showSnackbar("Error loading news data");
                }
            }

            @Override
            public void onNext(ViewModel viewModel) {
                if (mNewsView != null) {
                    mNewsView.updateData(viewModel);
                }
            }
        });
    }

    @Override
    public void rxUnsubscribe() {
        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void fetchMoreData(int pageNumber) {
        mNewsView.showSnackbar("Fetching more news");
        subscription = mRepositoryModel.newResults(pageNumber).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ViewModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (mNewsView != null) {
                    mNewsView.showSnackbar("Error fetching more news");
                }
            }

            @Override
            public void onNext(ViewModel viewModel) {
                if (mNewsView != null) {
                    mNewsView.updateData(viewModel);
                }
            }
        });
    }

    @Override
    public void fetchFilteredData(String queryString) {
        subscription = mRepositoryModel.fileteredResults(queryString).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ViewModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (mNewsView != null) {
                    mNewsView.showSnackbar("Error fetching more news");
                }
            }

            @Override
            public void onNext(ViewModel viewModel) {
                if (mNewsView != null) {
                    mNewsView.updateData(viewModel);
                }
            }
        });
    }

    @Override
    public void fetchDataByPageAndQuery(int pagenumber, String queryString) {
        subscription = mRepositoryModel.filteredResultsByPageAndQuery(pagenumber, queryString).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ViewModel>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                if (mNewsView != null) {
                    mNewsView.showSnackbar("Error fetching more news");
                }
            }

            @Override
            public void onNext(ViewModel viewModel) {
                if (mNewsView != null) {
                    mNewsView.updateData(viewModel);
                }
            }
        });
    }


}
