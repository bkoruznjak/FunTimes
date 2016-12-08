package bkoruznjak.from.hr.funtimes.root;

import javax.inject.Singleton;

import bkoruznjak.from.hr.funtimes.network.NewsApiModule;
import bkoruznjak.from.hr.funtimes.news.NewsActivity;
import bkoruznjak.from.hr.funtimes.news.NewsModule;
import dagger.Component;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NewsModule.class, NewsApiModule.class})
public interface ApplicationComponent {

    void inject(NewsActivity destination);
}
