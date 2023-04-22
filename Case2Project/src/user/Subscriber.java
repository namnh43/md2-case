package user;

import news.News;
import news.NewsService;

import java.util.ArrayList;

public class Subscriber extends User implements UserObserver{
    ArrayList<News> newsList;
    private NewsService newsService;

    public Subscriber(String username, String password) {
        super(username, password);
        this.newsList = new ArrayList<>();
    }
    public void subscribe(NewsService newsService) {
        this.newsService = newsService;
        this.newsService.attach(this);
    }
    public void unsubscribe() {
        if (newsService != null) {
            newsService.dettach(this);
        }
        //Free array news
        newsList.clear();
    }
    public ArrayList<News> updateNews(){
        ArrayList<News> copiedList = new ArrayList<>(newsList);
        //empty news
        newsList.clear();
        return copiedList;
    }

    @Override
    public void update(News news) {
        if (news != null) {
            newsList.add(news);
        }
    }
}
