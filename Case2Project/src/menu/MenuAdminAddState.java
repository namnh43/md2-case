package menu;

import news.NewsManager;
import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN_ADD;

public class MenuAdminAddState extends State implements IState{
    public MenuAdminAddState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        switch (index) {
            case 0 -> {
                NewsManager.getInstance().createRandom();
            }
            case 1 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
            default -> {
                System.err.println("Nhập sai, mời nhập lại!");
            }
        }

    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        display(MENU_ADMIN_ADD);
    }
}
