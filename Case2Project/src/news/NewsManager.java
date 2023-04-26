package news;

import file.ReadFile;
import file.WriteFile;
import user.Subscriber;
import user.User;
import util.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static util.Utils.*;

public class NewsManager {
    private NewsService newsService;
    List<News> newsList;
    private static NewsManager instance;

    private NewsManager() {
        //Read from file
        List<News> list = readFromFile();
        if (list != null) {
            newsList = list;
        } else {
            newsList = new ArrayList<>();
            //push some sample news
            newsList.add(new News(new NewsStatus(true), "Thế giới quanh ta"));
            newsList.add(new News(new NewsStatus(true), "Tin thời sự 24h qua"));
            newsList.add(new News(new NewsStatus(true), "Tin bóng đá C1"));
        }
        newsService = new NewsService();
    }

    public void writeToFile() {
        WriteFile<News> newsWrite = new WriteFile<>("news.dat");
        newsWrite.writeToFile(newsList);
    }
    public List<News> readFromFile() {
        ReadFile<News> newsRead = new ReadFile<>("news.dat");
        return newsRead.readFromFile();
    }
    public static synchronized NewsManager getInstance(){
        if (instance == null) {
            instance = new NewsManager();
        }
        return instance;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public NewsService getNewsService() {
        return newsService;
    }

    public void addNews(News news){
        newsList.add(news);
        writeToFile();
    }
    public void display() {
        String formatH ="%-5s     %-15s      %-10s      %-10s      %-5s\n";
        String format = "%-5d     %-15s      %-10b      %-10s      %-5d\n";
        System.out.println(ANSI_YELLOW);
        System.out.println("Danh sách tin tức:");
        Utils.printFooterDisplay();
        System.out.printf(formatH,"index","title","trending","published","views");
        for (int index = 0; index < newsList.size(); index++) {
            System.out.printf(format,index,newsList.get(index).getTitle(),newsList.get(index).isTrending(),newsList.get(index).getPublishing().isStatus(), newsList.get(index).getViews());
        }
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public void displaySimple() {
        String formatH ="%-5s     %-30s\n";
        String format = "%-5d     %-30s\n";
        System.out.println(ANSI_YELLOW);
        System.out.println("Danh sách tin tức:");
        Utils.printFooterDisplay();
        System.out.printf(formatH,"index","title");
        for (int index = 0, simple = 0; index < newsList.size(); index++) {
            if (newsList.get(index).getPublishing().isStatus()) {
                System.out.printf(format,simple,newsList.get(index).getTitle());
                simple++;
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
        System.out.println("<== Nội dung ==>");
        System.out.println("Title: "+newsList.get(index).getTitle());
        System.out.println("Date published: "+newsList.get(index).getPublishing().getDate());
        System.out.printf(format,"Content:", newsList.get(index).getContent());
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public void displaySimple(int index) {
        List<News> simpleList = newsList.stream().filter(e -> e.getPublishing().isStatus() == true)
                .toList();
        String format = "%s %s\n";
        if (index >= simpleList.size()) {
            System.err.println("Index not valid");
            return;
        }
        System.out.println(ANSI_YELLOW);
        Utils.printFooterDisplay();
        System.out.println("<== Nội dung ==>");
        System.out.println("Title: "+simpleList.get(index).getTitle());
        System.out.println("Date published: "+simpleList.get(index).getPublishing().getDate());
        System.out.printf(format,"Content:", simpleList.get(index).getContent());
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public void displaySimpleNews(News news) {
        String format = "%s %s\n";
        Utils.printFooterDisplay();
        System.out.println("Title: "+news.getTitle());
        System.out.println("Date published: "+news.getPublishing().getDate());
        System.out.printf(format,"Content:", news.getContent());
        Utils.printFooterDisplay();
    }
    public void createRandom() {
        News news = new News(new NewsStatus(true), "title");
        news.setTitle(Utils.generateRandomString(5));
        addNews(news);
        //notify subscribers
        newsService.notifyAllObserver(new SubscriberNews(news, SubscriberNews.CHANGED.ADD));
    }
    public News delete(int index) {
        if (index >= newsList.size()) {
            return null;
        }
        News news = newsList.get(index);
        newsList.remove(index);
        writeToFile();
        //notify to subsribers
        newsService.notifyAllObserver(new SubscriberNews(news, SubscriberNews.CHANGED.DELETE));
        return news;
    }
    public News editNews(int index) {
        if (index >= newsList.size()) {
            return null;
        }
        News news = newsList.get(index);
        news.reveseStatus();
        writeToFile();
        //notify to subsribers
        newsService.notifyAllObserver(new SubscriberNews(news, SubscriberNews.CHANGED.EDIT));
        return news;
    }
    public void increaseViews(int index) {
        newsList.get(index).increaseViews();
    }
    public void displayUpdatedNews(ArrayList<SubscriberNews> newsArrayList) {
        System.out.println(ANSI_YELLOW);
        if (newsArrayList.size() == 0) {
            System.out.println("Không có thông báo tin tức thay đổi");
            System.out.println(ANSI_RESET);
            return;
        }
        System.out.println("Bảng thông báo tin tức thay đổi");
        Utils.printFooterDisplay();
        int index = 0;
        for (SubscriberNews element: newsArrayList){
            index ++;
            switch (element.getChanged()) {
                case ADD -> {
                    System.out.println("THAY ĐỔI "+index+": THÊM");
                }
                case EDIT -> {
                    System.out.println("THAY ĐỔI "+index+": SỬA");
                }
                case DELETE -> {
                    System.out.println("THAY ĐỔI "+index+": XÓA");
                }
            }
            displaySimpleNews(element.getNews());
        }
        System.out.println(ANSI_RESET);
    }
}
