package net.service.UserService;

import net.model.User;
import net.model.UserLoginDTO;
import net.model.UserSaver;

public interface UserService {
    boolean addUser(User user);

    void deleteUser(User user);

    int generateCode(User user);

    User checkUserAtRegistration(String name, String email);

    User takeUser(String s);

    int emailValidation(User user);

    User takeInfo(UserLoginDTO userLoginDTO);

    void mailSender(User user,Integer cod);

    User setContext(User user);

    UserSaver getRegistationCode(Integer key);

    void registrateThread(Integer key,Integer value, User user);
}
