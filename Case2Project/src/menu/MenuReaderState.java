package menu;

import news.NewsManager;

import java.util.ArrayList;

import static menu.State.MENU_READER;

public class MenuReaderState implements IState{
    MenuManager menuManager;

    public MenuReaderState(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_READER);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
