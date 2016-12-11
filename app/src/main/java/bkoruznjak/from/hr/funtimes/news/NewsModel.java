package bkoruznjak.from.hr.funtimes.news;

import java.text.SimpleDateFormat;

import bkoruznjak.from.hr.funtimes.network.model.Doc;
import bkoruznjak.from.hr.funtimes.util.TimeConverter;
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
    public Observable<ViewModel> filteredResultsByPageAndQuery(int pageNumber, String queryString) {
        return repository.getResultsByQueryAndPage(pageNumber, queryString).map(new Func1<Doc, ViewModel>() {

            @Override
            public ViewModel call(Doc docResult) {
                String mediaUrl = "";
                if (docResult.getMultimedia() != null && !docResult.getMultimedia().isEmpty()) {
                    mediaUrl = docResult.getMultimedia().get(0).getUrl();
                }
                String prettyTime = TimeConverter.INSTANCE.convertToPrettyTime(docResult.getPubDate(), new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ"));
                return new ViewModel(docResult.getHeadline().getMain(), prettyTime, docResult.getAbstract(), mediaUrl);
            }
        });
    }
}
