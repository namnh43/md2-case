package news;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class NewsManager {
    private NewsService newsService;
    List<News> newsList;
    private static NewsManager instance;

    private NewsManager() {
        newsService = new NewsService();
        newsList = new ArrayList<>();
        //push some sample news
        newsList.add(new News(new NewsStatus(true), "Thế giới quanh ta"));
        newsList.add(new News(new NewsStatus(true), "Tin thời sự 24h qua"));
        newsList.add(new News(new NewsStatus(true), "Tin bóng đá C1"));
    }
    public static synchronized NewsManager getInstance(){
        if (instance == null) {
            instance = new NewsManager();
        }
        return instance;
    }
    public void display() {
        String formatH ="%s    %s     %s\n";
        String format ="%d    %s     %s\n";
        System.out.printf(formatH,"index","title","published");
        for (int index = 0; index < newsList.size(); index++) {
            System.out.printf(format,index,newsList.get(index).getTitle(),newsList.get(index).getPublishing().isStatus());
        }
    }
    public void display(int index) {
        String format = "         %s\n";
        if (index >= newsList.size()) {
            System.err.println("Index not valid");
            return;
        }
        System.out.println(newsList.get(index).getTitle());
        System.out.println(newsList.get(index).getPublishing().getDate());
        System.out.printf(format, newsList.get(index).getContent());
    }
    public void createRandom() {
        News news = new News(new NewsStatus(true), "title");
        news.setTitle(Utils.generateRandomString(5));
        newsList.add(news);
    }
    public News delete(int index) {
//        News
        if (index >= newsList.size()) {
            return null;
        }
        News news = newsList.get(index);
        newsList.remove(index);
        return news;
    }
}
