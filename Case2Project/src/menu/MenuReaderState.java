package menu;

import news.NewsManager;

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
                System.out.println("Enter index of news:");
                int i = scanner.nextInt();
                NewsManager.getInstance().display(i);
            }
            case 1 -> {
                menuManager.setCurrent(this.getPreviousState());
            }
        }
    }

    @Override
    public void doState() {
        NewsManager.getInstance().display();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_READER);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
    }
}