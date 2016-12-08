package bkoruznjak.from.hr.funtimes.news;

/**
 * Created by bkoruznjak on 05/12/2016.
 */

public class Article {

    private String id;
    private String text;

    public Article(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
