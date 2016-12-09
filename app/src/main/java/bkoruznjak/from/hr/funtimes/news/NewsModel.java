package bkoruznjak.from.hr.funtimes.news;

import bkoruznjak.from.hr.funtimes.network.model.Doc;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public class NewsModel implements NewsActivityMVP.Model {

    private Repository repository;

    public NewsModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        return repository.getResultData().map(new Func1<Doc, ViewModel>() {

            @Override
            public ViewModel call(Doc docResult) {
                String mediaUrl = "";
                if (docResult.getMultimedia() != null && !docResult.getMultimedia().isEmpty()) {
                    mediaUrl = docResult.getMultimedia().get(0).getUrl();
                }
                return new ViewModel(docResult.getLeadParagraph(), docResult.getPubDate(), docResult.getAbstract(), mediaUrl);
            }
        });
    }

    @Override
    public Observable<ViewModel> newResults(int pageNumber) {
        return repository.getPageResultsFromNetwork(pageNumber).map(new Func1<Doc, ViewModel>() {

            @Override
            public ViewModel call(Doc docResult) {
                String mediaUrl = "";
                if (docResult.getMultimedia() != null && !docResult.getMultimedia().isEmpty()) {
                    mediaUrl = docResult.getMultimedia().get(0).getUrl();
                }
                return new ViewModel(docResult.getLeadParagraph(), docResult.getPubDate(), docResult.getAbstract(), mediaUrl);
            }
        });
    }
}
