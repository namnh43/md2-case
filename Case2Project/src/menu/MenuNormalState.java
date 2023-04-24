package menu;

import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_NORMAL;

public class MenuNormalState extends State implements IState{


    public MenuNormalState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        switch (index) {
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
        Utils.printHeaderMenu();
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_NORMAL);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
        Utils.printFooterMenu();
    }
}
