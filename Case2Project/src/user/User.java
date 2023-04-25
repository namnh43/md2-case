package user;

import news.Subject;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1234567L;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public void readNews(int index) {

    }
}
