package menu;

import user.User;
import util.Utils;

import java.util.*;

import static menu.EState.*;


public class MenuManager {
    private IState current;
    private IState previous;
    private User currentUser;
    public static final Map<EState, ArrayList<String>> menuMap = new HashMap<>();

    public MenuManager() {
        menuMap.put(MENU_ORIGIN,new ArrayList<>(Arrays.asList("Duyệt tin","Đăng nhập")));
        menuMap.put(MENU_READER,new ArrayList<>(Arrays.asList("Chọn tin tức","Trở lại")));
        menuMap.put(MENU_NORMAL,new ArrayList<>(Arrays.asList("Duyệt tin","Đăng ký","Trở lại")));
        menuMap.put(MENU_SUBSCRIBER,new ArrayList<>(Arrays.asList("Duyệt tin","Đăng ký","Trở lại")));
        menuMap.put(MENU_SUBSCRIBER_UPDATED,new ArrayList<>(Arrays.asList("Danh sách tin cập nhật","Trở lại")));
        menuMap.put(MENU_ADMIN,new ArrayList<>(Arrays.asList("Duyệt tin","Thêm tin","Sửa tin","Xóa tin","Tạo user mới","Xóa user","Trở lại")));
        menuMap.put(MENU_ADMIN_ADD,new ArrayList<>(Arrays.asList("Thêm tin tức","Trở lại")));
        menuMap.put(MENU_ADMIN_EDIT,new ArrayList<>(Arrays.asList("Nhập index tin sửa","Trở lại")));
        menuMap.put(MENU_ADMIN_DELETE,new ArrayList<>(Arrays.asList("Nhập index tin xóa","Trở lại")));
        menuMap.put(MENU_ADMIN_CREATE_USER,new ArrayList<>(Arrays.asList("Tạo user thường","Tạo user admin","Trở lại")));
        menuMap.put(MENU_ADMIN_DELETE_USER,new ArrayList<>(Arrays.asList("Nhập username cần xóa","Trở lại")));
        current = new MenuOriginState(this, null);
        currentUser = null;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrent(IState state) {
        if (state != this.current) {
            this.previous = this.current;
            this.current = state;
        }
    }

    public IState getCurrent() {
        return current;
    }

    public IState getPrevious() {
        return previous;
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try{
                current.doState();
                System.out.println("Mời thím nhập lựa chọn:");
                int index = scanner.nextInt();
                current.nextState(index);
            } catch (Exception e) {
                System.err.println("Nhập sai, mời thím nhập lại!");
                scanner.nextLine();
            }

        }
    }
}
