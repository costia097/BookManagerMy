package net.dao.UserDao;

import net.model.User;

public interface UserDao {
    boolean addUser(User user);

    void deleteUser(User user);

    User checkUserAtLogin(User user);

    User checkUserAtRegistration(User user);

    User takeUser(String s);
}
