package news;

import util.Utils;

import java.io.Serializable;

public class News implements Serializable {
    private NewsStatus publishing;
    private String title;
    private String content;
    private long views;
    private boolean trending;

    public News(NewsStatus publishing, String title) {
        this.publishing = publishing;
        this.title = title;
        this.content = Utils.generateRandomString(100);
        this.views = 0;
        this.trending = false;
    }

    public void reveseStatus() {
        this.publishing.setStatus(!this.publishing.isStatus());
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
    public void increaseViews(){
        this.views++;
    }

    public boolean isTrending() {
        return trending;
    }

    public void setTrending(boolean trending) {
        this.trending = trending;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "News{" +
                "publishing=" + publishing +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", trending=" + trending +
                '}';
    }
}
