package net.service.UserService;

import net.model.User;

public interface UserService {
    boolean addUser(User user);

    void deleteUser(User user);

    int generateCode(User user);

    User checkUserAtRegistration(User user);

    User takeUser(String s);

}
