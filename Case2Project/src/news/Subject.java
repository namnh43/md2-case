package news;

import user.UserObserver;

public interface Subject {
    void attach(UserObserver observer);
    void dettach(UserObserver observer);
    void notifyAllObserver(News news);
}
