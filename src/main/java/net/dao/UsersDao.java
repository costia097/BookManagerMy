package net.dao;

import net.model.Users;

/**
 * Created by BeNdEr on 22.06.2017.
 */
public interface UsersDao {
    void addUser(Users users);

    void updateUser(Users users);

    void deleteUser(int id);
}
