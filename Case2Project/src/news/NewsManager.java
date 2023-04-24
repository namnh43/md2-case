package news;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

import static util.Utils.*;

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
        String formatH ="%s     %-30s      %s\n";
        String format = "%d      %-30s          %s\n";
        System.out.println(ANSI_YELLOW);
        Utils.printFooterDisplay();
        System.out.println("Danh sách tin tức:");
        System.out.printf(formatH,"index","title","published");
        for (int index = 0; index < newsList.size(); index++) {
            System.out.printf(format,index,newsList.get(index).getTitle(),newsList.get(index).getPublishing().isStatus());
        }
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public void displaySimple() {
        String formatH ="%s     %-30s\n";
        String format = "%d      %-30s\n";
        System.out.println(ANSI_YELLOW);
        Utils.printFooterDisplay();
        System.out.println("Danh sách tin tức:");
        System.out.printf(formatH,"index","title");
        for (int index = 0; index < newsList.size(); index++) {
            if (newsList.get(index).getPublishing().isStatus()) {
                System.out.printf(format,index,newsList.get(index).getTitle());
            }
        }
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public void display(int index) {
        String format = "%s %s\n";
        if (index >= newsList.size()) {
            System.err.println("Index not valid");
            return;
        }
        System.out.println(ANSI_YELLOW);
        Utils.printFooterDisplay();
        System.out.println("Title: "+newsList.get(index).getTitle());
        System.out.println("Date published: "+newsList.get(index).getPublishing().getDate());
        System.out.printf(format,"Content:", newsList.get(index).getContent());
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
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
