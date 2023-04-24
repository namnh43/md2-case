package menu;

import news.NewsManager;
import util.Utils;

import java.util.ArrayList;

import static menu.EState.MENU_ADMIN_EDIT;

public class MenuAdminEditState extends State implements IState{

    public MenuAdminEditState(MenuManager menuManager, IState previousState) {
        super(menuManager, previousState);
    }
    @Override
    public void nextState(int index) {
        switch (index){
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
        ArrayList<String> menu = MenuManager.menuMap.get(MENU_ADMIN_EDIT);
        for (int index = 0; index < menu.size(); index++) {
            System.out.println(index+"."+menu.get(index));
        }
        Utils.printFooterMenu();
    }
}
