package user;

import file.ReadFile;
import file.WriteFile;
import util.Utils;

import java.io.Reader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static util.Utils.ANSI_RESET;
import static util.Utils.ANSI_YELLOW;

public class UserManager {
    private List<User> userList;
    private static UserManager instance;
    private UserManager() {
        List<User> users = readFromFile();
        if (users != null) {
            userList = users;
        } else {
            userList = new ArrayList<User>();
            //add 1 user admin & 1 user normal
            User admin = new Admin("admin","1");
            User reader = new Subscriber("reader","1");
            userList.add(admin);
            userList.add(reader);
        }
    }

    public List<User> getUserList() {
        return userList;
    }
    public void writeToFile() {
        WriteFile<User> userWrite = new WriteFile<>("user.dat");
        userWrite.writeToFile(userList);
    }
    public List<User> readFromFile() {
        ReadFile<User> userRead = new ReadFile<>("user.dat");
        return userRead.readFromFile();
    }
    public void addUser(User user) {
        userList.add(user);
        writeToFile();
    }
    public void removeUser(int index) {
        userList.remove(index);
        writeToFile();
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
        writeToFile();
    }
    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
    public void display() {
        String formatH ="%s    %-20s     %s\n";
        String format ="%d        %-20s     %s\n";
        System.out.println(ANSI_YELLOW);
        System.out.printf(formatH,"Index","Username","Role");
        for (int index = 0; index < userList.size(); index++) {
            System.out.printf(format,index,userList.get(index).getUsername(),userList.get(index).getClass().getName());
        }
        Utils.printFooterDisplay();
        System.out.println(ANSI_RESET);
    }
    public boolean createAdmin(String username, String password) {
        User user = searchUser(username);
        if (user != null) {
            return false;
        }
        user = new Admin(username, password);
        addUser(user);
        return true;
    }
    public boolean createSubscriber(String username, String password) {
        User user = searchUser(username);
        if (user != null) {
            return false;
        }
        user = new Subscriber(username, password);
        addUser(user);
        return true;
    }
}
