package menu;

import java.util.*;

import static menu.State.*;


public class MenuManager {
    private IState current;
    public static final Map<State, ArrayList<String>> menuMap = new HashMap<>();
    private static MenuManager instance;

    private MenuManager() {
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
        menuMap.put(MENU_ADMIN_DELETE_USER,new ArrayList<>(Arrays.asList("Chọn id user","Trở lại")));
        current = new MenuOriginState();
    }
    public static MenuManager getInstance(){
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }
    public void setCurrent(IState state) {
        this.current = state;
//        this.current.doState();
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            current.doState();
            System.out.println("Please enter the selection:");
            int index = scanner.nextInt();
            current.nextState(index);
        }
    }
}
