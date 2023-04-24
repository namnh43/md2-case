package menu;

import news.NewsManager;
import user.Subscriber;
import user.User;
import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_NORMAL;

public class MenuNormalState extends State implements IState{


    public MenuNormalState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        switch (index) {
            case 0 -> {
                menuManager.setCurrent(new MenuReaderState(menuManager, this));
            }
            case 1 -> {
                User user = menuManager.getCurrentUser();
                if (user instanceof Subscriber) {
                    ((Subscriber) user).subscribe(NewsManager.getInstance().getNewsService());
                    menuManager.setCurrent(new MenuSubscriberState(menuManager, this));
                }
            }
            case 2 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
            default -> {
                System.err.println("Nhập sai, mời nhập lại!");
            }
        }
    }

    @Override
    public void doState() {
        display(MENU_NORMAL);
    }
}
