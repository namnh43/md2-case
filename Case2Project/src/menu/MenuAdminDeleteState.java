package menu;

import news.News;
import news.NewsManager;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.*;

public class MenuAdminDeleteState extends State implements IState{
    public MenuAdminDeleteState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Nhập index:");
                int i = scanner.nextInt();
                News news = NewsManager.getInstance().delete(i);
                if (news != null) {
                    System.out.println("Xóa thành công!");
                } else {
                    System.err.println("Xóa không thành công!");
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
        NewsManager.getInstance().display();
        display(MENU_ADMIN_DELETE);
    }
}
