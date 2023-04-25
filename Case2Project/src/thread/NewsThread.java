package thread;

import news.News;
import news.NewsManager;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NewsThread extends Thread{
    public NewsThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            List<News> newsList = NewsManager.getInstance().getNewsList();
            Collections.sort(newsList, new Comparator<News>() {
                @Override
                public int compare(News o1, News o2) {
                    if (o1.isTrending() || o2.isTrending()){
                        return (int) (o1.getViews() - o2.getViews());
                    } else {
                        return o1.getPublishing().getDate().compareTo(o2.getPublishing().getDate());
                    }

                }
            }.reversed());
            //set trending
            newsList.forEach(news -> {
                if(news.getViews() >= 5) {
                    news.setTrending(true);
                }
            });
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
