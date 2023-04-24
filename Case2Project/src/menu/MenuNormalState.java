package menu;

import java.util.ArrayList;

import static menu.EState.MENU_NORMAL;

public class MenuNormalState extends State implements IState{


    public MenuNormalState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
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
