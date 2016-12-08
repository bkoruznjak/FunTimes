package bkoruznjak.from.hr.funtimes.news;

import javax.inject.Singleton;

import bkoruznjak.from.hr.funtimes.network.NYTimesService;
import dagger.Module;
import dagger.Provides;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

@Module
public class NewsModule {

    @Provides
    public NewsActivityMVP.Presenter provideNewsActivityPresenter(NewsActivityMVP.Model repositoryModel) {
        return new NewsActivityPresenter(repositoryModel);
    }

    @Provides
    public NewsActivityMVP.Model provideNewsActivityModel(Repository repository) {
        return new NewsModel(repository);
    }

    @Singleton
    @Provides
    public Repository provideRepository(NYTimesService nyTimesService) {
        return new NewsRepository(nyTimesService);
    }
}
