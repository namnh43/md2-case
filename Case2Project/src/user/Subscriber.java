package user;

import news.News;
import news.NewsService;
import news.SubscriberNews;

import java.util.ArrayList;

public class Subscriber extends User implements UserObserver{
    private ArrayList<SubscriberNews> updatedNews;
    private NewsService newsService;
    private boolean isSubsriber;

    public boolean isSubsriber() {
        return isSubsriber;
    }

    public ArrayList<SubscriberNews> getUpdatedNews() {
        return updatedNews;
    }

    public Subscriber(String username, String password) {
        super(username, password);
        this.updatedNews = new ArrayList<>();
    }
    public void subscribe(NewsService newsService) {
        this.newsService = newsService;
        this.isSubsriber = true;
        this.newsService.attach(this);
    }
    public void unsubscribe() {
        if (newsService != null) {
            newsService.dettach(this);
        }
        this.isSubsriber = false;
        //Free array news
        updatedNews.clear();
    }
    public ArrayList<SubscriberNews> updateNews(){
        ArrayList<SubscriberNews> copiedList = new ArrayList<>(updatedNews);
        //empty news
        updatedNews.clear();
        return copiedList;
    }

    @Override
    public void update(SubscriberNews news) {
        if (news != null) {
            updatedNews.add(news);
        }
    }
}
