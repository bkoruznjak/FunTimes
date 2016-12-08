package bkoruznjak.from.hr.funtimes.news;

public class ViewModel {

    private String title;
    private String publishedTime;
    private String abstraction;
    private String mediaUrl;

    public ViewModel(String publishedTime, String title, String abstraction, String mediaUrl) {
        this.title = title;
        this.publishedTime = publishedTime;
        this.abstraction = abstraction;
        this.mediaUrl = mediaUrl;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getpublishedTime() {
        return publishedTime;
    }

    public void setpublishedTime(String publishedTime) {
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