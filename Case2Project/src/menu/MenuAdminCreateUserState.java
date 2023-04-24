package menu;

import user.UserManager;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ADMIN_CREATE_USER;

public class MenuAdminCreateUserState extends State implements IState{
    public MenuAdminCreateUserState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Nhập username:");
                String username = scanner.next();
                System.out.println("Nhập password:");
                String password = scanner.next();
                boolean created = UserManager.getInstance().createSubscriber(username,password);
                if (created) {
                    System.out.println("Tạo user thành công!");
                } else {
                    System.out.println("Không thể tạo user, mời thím thử lại");
                }
            }
            case 1 -> {
                System.out.println("Nhập username:");
                String username = scanner.next();
                System.out.println("Nhập password:");
                String password = scanner.next();
                boolean created = UserManager.getInstance().createAdmin(username,password);
                if (created) {
                    System.out.println("Tạo user thành công!");
                } else {
                    System.err.println("Không thể tạo user, mời thím thử lại");
                }
            }
            case 2 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
            default -> {
                System.err.println("Nhập sai, mời nhập lại!");
            }
        }
    }

    @Override
    public void doState() {
        UserManager.getInstance().display();
        display(MENU_ADMIN_CREATE_USER);
    }
}
