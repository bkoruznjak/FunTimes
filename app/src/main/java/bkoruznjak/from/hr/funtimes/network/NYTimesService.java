package bkoruznjak.from.hr.funtimes.network;

import bkoruznjak.from.hr.funtimes.network.model.ArticleModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public interface NYTimesService {

    @GET("svc/search/v2/articlesearch.json")
    Observable<ArticleModel> listAllArticles(@Query("sort") String sort);

    @GET("svc/search/v2/articlesearch.json")
    Observable<ArticleModel> listArticlesByPage(@Query("page") String pagenumber, @Query("sort") String sort);

    @GET("svc/search/v2/articlesearch.json")
    Observable<ArticleModel> listArticlesByQuery(@Path("q") String query, @Query("sort") String sort);

}