package menu;

import user.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ADMIN_CREATE_USER;

public class MenuAdminCreateUser extends State implements IState{
    public MenuAdminCreateUser(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Enter username:");
                String username = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                boolean created = UserManager.getInstance().createSubscriber(username,password);
                if (created) {
                    System.out.println("Create user successful!");
                } else {
                    System.out.println("Cannot create user, please try again!");
                }
            }
            case 1 -> {
                System.out.println("Enter username:");
                String username = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                boolean created = UserManager.getInstance().createAdmin(username,password);
                if (created) {
                    System.out.println("Create user successful!");
                } else {
                    System.out.println("Cannot create user, please try again!");
                }
            }
            case 2 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
        }
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
