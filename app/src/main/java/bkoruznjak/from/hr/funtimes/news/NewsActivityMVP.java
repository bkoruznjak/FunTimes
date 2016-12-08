package bkoruznjak.from.hr.funtimes.news;

import rx.Observable;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public interface NewsActivityMVP {
    interface View {

        void updateData(ViewModel viewModel);

        void showSnackbar(String s);
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
