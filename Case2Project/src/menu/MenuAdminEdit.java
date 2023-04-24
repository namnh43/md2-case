package menu;

import news.NewsManager;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN_EDIT;

public class MenuAdminEdit extends State implements IState{

    public MenuAdminEdit(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }
    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_EDIT);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
