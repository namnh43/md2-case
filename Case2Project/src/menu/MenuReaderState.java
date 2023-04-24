package menu;

import news.NewsManager;
import user.Admin;
import user.Subscriber;
import util.Utils;

import java.util.ArrayList;
import java.util.Scanner;

import static menu.EState.MENU_READER;

public class MenuReaderState extends State implements IState{
    public MenuReaderState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        Scanner scanner = new Scanner(System.in);
        switch (index) {
            case 0 -> {
                System.out.println("Nhập index:");
                int i = scanner.nextInt();
                if (menuManager.getCurrentUser() instanceof Admin) {
                    NewsManager.getInstance().display(i);
                } else {
                    NewsManager.getInstance().displaySimple(i);
                }
                //increase views
                NewsManager.getInstance().increaseViews(i);
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
        if (menuManager.getCurrentUser() instanceof Admin) {
            NewsManager.getInstance().display();
        } else {
            NewsManager.getInstance().displaySimple();
        }
        display(MENU_READER);
    }
}
