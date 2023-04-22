package menu;

import java.util.ArrayList;

import static menu.State.MENU_ORIGIN;
import static menu.State.MENU_READER;

public class MenuReaderState implements IState{
    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_READER);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
