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
    }

    interface Model {

        Observable<ViewModel> result();

    }
}
