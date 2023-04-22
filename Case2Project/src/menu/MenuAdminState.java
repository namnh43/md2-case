package menu;

import java.util.ArrayList;

import static menu.State.MENU_ADMIN;
import static menu.State.MENU_READER;

public class MenuAdminState implements IState{
    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
