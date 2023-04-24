package menu;

import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN;

public class MenuAdminState extends State implements IState{
    public MenuAdminState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }

    @Override
    public void nextState(int index) {
        switch (index) {
            case 0 -> { //go to reader state
                menuManager.setCurrent(new MenuReaderState(menuManager, this));
            }
            case 1 -> { //go to add news state
                menuManager.setCurrent(new MenuAdminAddState(menuManager, this));
            }
            case 2 -> {
                menuManager.setCurrent(new MenuAdminEditState(menuManager, this));
            }
            case 3 -> {
                menuManager.setCurrent(new MenuAdminDeleteState(menuManager, this));
            }
            case 4 -> {
                menuManager.setCurrent(new MenuAdminCreateUserState(menuManager, this));
            }
            case 5 -> {
                menuManager.setCurrent(new MenuAdminDeleteUserState(menuManager, this));
            }
            case 6 -> {
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
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
        Utils.printFooterMenu();
    }
}
