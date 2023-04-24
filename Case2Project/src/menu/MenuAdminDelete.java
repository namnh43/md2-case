package menu;

import news.News;
import news.NewsManager;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.*;

public class MenuAdminDelete extends State implements IState{
    public MenuAdminDelete(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Enter index:");
                int i = scanner.nextInt();
                News news = NewsManager.getInstance().delete(i);
            }
            case 1 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
        }
    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_DELETE);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}
