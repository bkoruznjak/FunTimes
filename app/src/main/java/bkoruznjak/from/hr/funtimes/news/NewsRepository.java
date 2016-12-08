package bkoruznjak.from.hr.funtimes.news;

import java.util.ArrayList;
import java.util.List;

import bkoruznjak.from.hr.funtimes.network.NYTimesService;
import bkoruznjak.from.hr.funtimes.network.NetworkConstants;
import bkoruznjak.from.hr.funtimes.network.model.ArticleModel;
import bkoruznjak.from.hr.funtimes.network.model.Doc;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public class NewsRepository implements Repository {

    private static final long CACHE_EXPIRATION_TIME = 60 * 1000 * 5; // Data expires after 5 minutes
    private NYTimesService timesApiService;
    private List<Doc> results;
    private long timestamp;

    public NewsRepository(NYTimesService timesApiService) {
        this.timestamp = System.currentTimeMillis();
        this.timesApiService = timesApiService;
        results = new ArrayList<>();

    }

    public boolean isUpToDate() {
        return System.currentTimeMillis() - timestamp < CACHE_EXPIRATION_TIME;
    }


    @Override
    public Observable<Doc> getResultsFromMemory() {
        if (isUpToDate()) {
            return Observable.from(results);
        } else {
            timestamp = System.currentTimeMillis();
            results.clear();
            return Observable.empty();
        }
    }

    @Override
    public Observable<Doc> getResultsFromNetwork() {

        Observable<ArticleModel> newsObservable = timesApiService.listArticlesByPage("0", NetworkConstants.SORT_NEWEST);

        return newsObservable.concatMap(new Func1<ArticleModel, Observable<Doc>>() {
            @Override
            public Observable<Doc> call(ArticleModel articleModel) {
                return Observable.from(articleModel.getResponse().getDocs());
            }
        }).doOnNext(new Action1<Doc>() {
            @Override
            public void call(Doc result) {
                results.add(result);
            }
        });
    }

    @Override
    public Observable<Doc> getResultData() {
        return getResultsFromMemory().switchIfEmpty(getResultsFromNetwork());
    }
}
