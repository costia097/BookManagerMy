package net.dao;

import net.model.User;

public interface UserDao {
    boolean addUser(User user);

    void deleteUser(User user);

    User checkUser(User user);
}
