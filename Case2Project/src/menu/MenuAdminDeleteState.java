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
        Utils.printHeaderMenu();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_DELETE);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
        Utils.printFooterMenu();
    }
}
