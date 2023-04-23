package menu;

import user.Admin;
import user.Subscriber;
import user.User;
import user.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.MenuManager.*;
import static menu.State.MENU_ORIGIN;

public class MenuOriginState implements IState{
    MenuManager menuManager;

    public MenuOriginState(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        if (index == 0) {
            menuManager.setCurrent(new MenuReaderState(menuManager));
        }else if (index == 1) {
            //Validate user/password
            System.out.println("Enter user name:");
            String username = scanner.next();
            System.out.println("Enter password:");
            String passwd = scanner.next();
            User user = UserManager.getInstance().searchUser(username,passwd);
            if (user != null && (user instanceof Subscriber)) {
                menuManager.setCurrent(new MenuNormalState(menuManager));
            } else if (user != null && (user instanceof Admin)) {
                menuManager.setCurrent(new MenuAdminState(menuManager));
            } else {
                //do nothing, not change state
            }
        }else {
            //do nothing
        }
    }

    @Override
    public void doState() {
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ORIGIN);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
