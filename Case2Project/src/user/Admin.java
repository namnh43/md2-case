package user;

public class Admin extends User {

    public Admin(String username, String password) {
        super(username, password);
    }
    public void createNormalUser(String username, String password) {
        User user = new Subscriber(username, password);
        UserManager.getInstance().addUser(user);
    }
    public void createAdminUser(String username, String password) {
        User user = new Admin(username, password);
        UserManager.getInstance().addUser(user);
    }
//    public void createNews()
}
