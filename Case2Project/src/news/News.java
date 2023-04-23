package news;

public class News {
    private NewsStatus publishing;
    private String title;
    private String content;
    private long views;
    private boolean trending;

    public News(NewsStatus publishing, String title) {
        this.publishing = publishing;
        this.title = title;
    }

    public NewsStatus getPublishing() {
        return publishing;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getViews() {
        return views;
    }

    public void setViews(long views) {
        this.views = views;
    }

    public boolean isTrending() {
        return trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }
}
