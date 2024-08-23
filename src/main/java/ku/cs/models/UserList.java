package ku.cs.models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        // สร้าง ArrayList เมื่อ UserList ถูกสร้าง
        this.users = new ArrayList<>();
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = findUserByUsername(username);
        if (user != null && user.checkPassword(oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }
}
