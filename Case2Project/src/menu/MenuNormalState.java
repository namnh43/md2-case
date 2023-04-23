package menu;

import java.util.ArrayList;

import static menu.State.MENU_NORMAL;

public class MenuNormalState implements IState{
    MenuManager menuManager;

    public MenuNormalState(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_NORMAL);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
