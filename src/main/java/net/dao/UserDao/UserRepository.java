package net.dao.UserDao;

import net.model.User;
import net.model.UserLoginDTO;

public interface UserRepository {
    boolean addUser(User user);

    void deleteUser(User user);

    User checkUserAtLogin(User user);

    User checkUserAtRegistration(String name, String email);

    User takeUser(String s);
}
