package menu;

import news.News;
import news.NewsManager;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_ADMIN_EDIT;

public class MenuAdminEditState extends State implements IState{

    public MenuAdminEditState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }
    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index){
            case 0 -> {
                System.out.println("Nhập index:");
                int i = scanner.nextInt();
                News news = NewsManager.getInstance().editNews(i);
                if (news != null) {
                    System.out.println("Cập nhật thành công!");
                } else {
                    System.err.println("Cập nhật không thành công!");
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
        display(MENU_ADMIN_EDIT);
    }
}
