package user;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> userList;
    private static UserManager instance;
    private UserManager() {
        userList = new ArrayList<User>();
        //add 1 user admin & 1 user normal
        User admin = new Admin("admin","1");
        User reader = new Subscriber("reader","1");
        userList.add(admin);
        userList.add(reader);
    }
    public void addUser(User user) {
        userList.add(user);
    }
    public void removeUser(int index) {
        userList.remove(index);
    }
    public User searchUser(String name, String passwd) {
        User find = userList.stream()
                    .filter(e-> (e.getUsername().equals(name) && e.getPassword().equals(passwd)))
                    .findFirst()
                    .orElse(null);
        return find;
    }
    public User searchUser(String name) {
        User find = userList.stream()
                .filter(e -> (e.getUsername().equals(name)))
                .findFirst()
                .orElse(null);
        return find;
    }
    public void removeUser(String name){
        boolean deleted = userList.removeIf(e->e.getUsername().equals(name));
    }
    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    public void display() {
        String formatH ="%s    %s     %s\n";
        String format ="%d    %s     %s\n";
        System.out.printf(formatH,"index","username","role");
        for (int index = 0; index < userList.size(); index++) {
            System.out.printf(format,index,userList.get(index).getUsername(),userList.get(index).getClass().getName());
        }
    }
    public boolean createAdmin(String username, String password) {
        User user = searchUser(username);
        if (user != null) {
            return false;
        }
        user = new Admin(username, password);
        userList.add(user);
        return true;
    }
    public boolean createSubscriber(String username, String password) {
        User user = searchUser(username);
        if (user != null) {
            return false;
        }
        user = new Subscriber(username, password);
        userList.add(user);
        return true;
    }
}
