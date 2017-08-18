package net.service;

import net.model.User;

public interface UserService {
    boolean addUser(User user);

    void deleteUser(User user);

}
