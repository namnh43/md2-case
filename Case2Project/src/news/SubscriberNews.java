package news;

public class SubscriberNews {
    public enum CHANGED {
        ADD,
        EDIT,
        DELETE
    }
    private News news;
    private CHANGED changed;

    public SubscriberNews(News news, CHANGED changed) {
        this.news = news;
        this.changed = changed;
    }

    public CHANGED getChanged() {
        return changed;
    }

    public News getNews() {
        return news;
    }
}
