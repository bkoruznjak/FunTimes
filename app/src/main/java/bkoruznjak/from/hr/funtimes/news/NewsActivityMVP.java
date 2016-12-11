package bkoruznjak.from.hr.funtimes.news;

import android.support.v7.widget.RecyclerView;

import rx.Observable;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public interface NewsActivityMVP {
    interface View {

        void updateData(ViewModel viewModel);

        void showSnackbar(String s);

        boolean isLastItemDisplaying(RecyclerView recyclerView);
    }

    interface Presenter {

        void setView(NewsActivityMVP.View view);

        void loadData();

        void rxUnsubscribe();

        void fetchMoreData(int pageNumber);

        void fetchFilteredData(String queryString);

        void fetchDataByPageAndQuery(int pagenumber, String Query);
    }

    interface Model {

        Observable<ViewModel> result();

        Observable<ViewModel> newResults(int pageNumber);

        Observable<ViewModel> fileteredResults(String queryString);

        Observable<ViewModel> filteredResultsByPageAndQuery(int pageNumber, String queryString);
    }
}
