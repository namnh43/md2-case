package user;

import news.News;

public interface UserObserver {
    void update(News news);
}
