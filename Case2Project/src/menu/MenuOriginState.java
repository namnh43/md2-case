package menu;

import user.Admin;
import user.Subscriber;
import user.User;
import user.UserManager;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ORIGIN;

public class MenuOriginState extends State implements IState{
    public MenuOriginState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        if (index == 0) {
            menuManager.setCurrent(new MenuReaderState(menuManager, this));
        }else if (index == 1) {
            //Validate user/password
            System.out.println("Nhập username:");
            String username = scanner.next();
            System.out.println("Nhập password:");
            String passwd = scanner.next();
            User user = UserManager.getInstance().searchUser(username,passwd);
            if (user != null && (user instanceof Subscriber)) {
                menuManager.setCurrent(new MenuNormalState(menuManager, this));
                menuManager.setCurrentUser(user);
                System.out.println("******* Welcome "+user.getUsername()+" *******");
            } else if (user != null && (user instanceof Admin)) {
                menuManager.setCurrent(new MenuAdminState(menuManager, this));
                menuManager.setCurrentUser(user);
                System.out.println("******* Welcome "+user.getUsername()+" *******");
            } else {
                System.out.println("username/password sai, mời thím nhập lại!");
                //do nothing, not change state
            }
        }else {
            //do nothing
            System.err.println("Nhập sai, mời thím nhập lại!");
        }
    }

    @Override
    public void doState() {
        display(MENU_ORIGIN);
    }
}
