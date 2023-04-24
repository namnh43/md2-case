package news;

import user.UserObserver;

import java.util.ArrayList;
import java.util.List;

public class NewsService implements Subject{
    private List<UserObserver> observers = new ArrayList<>();
    @Override
    public void attach(UserObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void dettach(UserObserver observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObserver(SubscriberNews news) {
        for (UserObserver observer: observers) {
            observer.update(news);
        }
    }
}
