package menu;

import user.User;
import user.UserManager;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ADMIN_DELETE_USER;

public class MenuAdminDeleteUserState extends State implements IState{

    public MenuAdminDeleteUserState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Nhập username:");
                String name = scanner.next();
                User user = UserManager.getInstance().searchUser(name);

                if (user != null) {
                    if (menuManager.getCurrentUser().equals(user)) {
                        System.out.println("User đang trong phiên sử dụng, không thể xóa.");
                    } else {
                        System.out.println("Thím có chắc không (1-yes, 0-no)?");
                        int choose = scanner.nextInt();
                        if (choose == 1) {
                            UserManager.getInstance().removeUser(name);
                        }
                    }
                }else {
                    System.out.println("User không tồn tại!");
                }
            }
            case 1 -> {
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
        display(MENU_ADMIN_DELETE_USER);
    }
}
