package menu;

import news.NewsManager;
import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_READER;

public abstract class State {
    protected MenuManager menuManager;
    protected IState previousState;

    public State(MenuManager menuManager, IState previousState) {
        this.menuManager = menuManager;
        this.previousState = previousState;
    }

    public IState getPreviousState() {
        return previousState;
    }
    public void display(EState state) {
        Utils.printHeaderMenu();
        ArrayList<String> menu = MenuManager.menuMap.get(state);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
        Utils.printFooterMenu();
    }
}
