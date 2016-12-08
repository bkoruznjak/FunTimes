package bkoruznjak.from.hr.funtimes.root;

import android.app.Application;

import bkoruznjak.from.hr.funtimes.network.NewsApiModule;
import bkoruznjak.from.hr.funtimes.news.NewsModule;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public class FunApplication extends Application {

    private ApplicationComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .newsApiModule(new NewsApiModule())
                .newsModule(new NewsModule())
                .build();

    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }
}
