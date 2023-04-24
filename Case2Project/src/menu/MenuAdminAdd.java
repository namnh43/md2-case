package menu;

import news.NewsManager;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN_ADD;

public class MenuAdminAdd extends State implements IState{
    public MenuAdminAdd(MenuManager menuManager, IState previousState) {
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
        }

    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_ADD);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
