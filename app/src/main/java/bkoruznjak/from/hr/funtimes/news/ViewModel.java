package bkoruznjak.from.hr.funtimes.news;

public class ViewModel {

    private String title;
    private String publishedTime;
    private String abstraction;
    private String mediaUrl;

    public ViewModel(String title, String publishedTime, String abstraction, String mediaUrl) {
        this.title = title;
        this.publishedTime = publishedTime;
        this.abstraction = abstraction;
        this.mediaUrl = mediaUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public String getAbstraction() {
        return abstraction;
    }

    public void setAbstraction(String abstraction) {
        this.abstraction = abstraction;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}