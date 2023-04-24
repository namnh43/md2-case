package menu;

import news.News;
import news.NewsManager;
import user.User;
import user.UserManager;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ADMIN_DELETE_USER;

public class MenuAdminDeleteUser extends State implements IState{

    public MenuAdminDeleteUser(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Enter username:");
                String name = scanner.next();
                User user = UserManager.getInstance().searchUser(name);

                if (user != null) {
                    if (menuManager.getCurrentUser().equals(user)) {
                        System.out.println("User is in using, cannot delete");
                    } else {
                        System.out.println("Are you sure (1-yes, 0-no)?");
                        int choose = scanner.nextInt();
                        if (choose == 1) {
                            UserManager.getInstance().removeUser(name);
                        }
                    }
                }else {
                    System.out.println("User not existed!");
                }
            }
            case 1 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
        }
    }

    @Override
    public void doState() {
        UserManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_DELETE_USER);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
