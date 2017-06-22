package net.service.User;

import net.model.Users;

/**
 * Created by BeNdEr on 22.06.2017.
 */
public interface UserService {
    void addUser(Users users);

    void deleteUser(int id);
}
