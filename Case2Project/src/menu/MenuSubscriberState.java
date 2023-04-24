package menu;

import news.NewsManager;
import news.SubscriberNews;
import user.Subscriber;
import user.User;

import java.util.ArrayList;

public class MenuSubscriberState extends State implements IState{
    public MenuSubscriberState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        User user = menuManager.getCurrentUser();
        switch (index) {
            case 0 -> {
                menuManager.setCurrent(new MenuReaderState(menuManager, this));
            }
            case 1 -> {
                if (user instanceof Subscriber) {
                    ArrayList<SubscriberNews> newsArrayList = ((Subscriber) user).updateNews();
                    NewsManager.getInstance().displayUpdatedNews(newsArrayList);
                }
            }
            case 2 -> {
                if (user instanceof Subscriber) {
                    ((Subscriber) user).unsubscribe();
                    menuManager.setCurrent(new MenuNormalState(menuManager, this));
                }
            }
            case 3 -> {
                menuManager.setCurrent(new MenuOriginState(menuManager, this));
            }
            default -> {
                System.err.println("Nhập sai, mời nhập lại!");
            }
        }
    }

    @Override
    public void doState() {
        display(EState.MENU_SUBSCRIBER);
    }
}
