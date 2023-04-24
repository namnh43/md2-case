package menu;

import user.UserManager;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN_CREATE_USER;

public class MenuAdminCreateUser extends State implements IState{
    public MenuAdminCreateUser(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {

    }

    @Override
    public void doState() {
        UserManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_CREATE_USER);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
