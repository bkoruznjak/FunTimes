package bkoruznjak.from.hr.funtimes.news;

import bkoruznjak.from.hr.funtimes.network.model.Doc;
import rx.Observable;

/**
 * Created by bkoruznjak on 06/12/2016.
 */

public interface Repository {

    Observable<Doc> getResultsFromMemory();

    Observable<Doc> getPageResultsFromNetwork(int pageNumber);

    Observable<Doc> getResultData();

}