package user;

import news.News;
import news.SubscriberNews;

public interface UserObserver {
    void update(SubscriberNews news);
}
