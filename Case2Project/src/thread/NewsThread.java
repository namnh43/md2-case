package thread;

import news.News;
import news.NewsManager;

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
            newsList.sort(new Comparator<News>() {
                @Override
                public int compare(News o1, News o2) {
                    return (int) (o1.getViews() - o2.getViews());
                }
            });
            System.out.println("thread running");
            //set trending
            newsList.forEach(news -> {
                if(news.getViews() > 5) {
                    news.setTrending(true);
                }
            });
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
