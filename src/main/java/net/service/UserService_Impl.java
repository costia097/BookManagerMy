package net.service;

import net.dao.UsersDao;
import net.model.Users;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by BeNdEr on 22.06.2017.
 */
@Service
public class UserService_Impl implements UserService {
    private UsersDao usersDao;


    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    @Transactional
    public void addUser(Users users) {
        usersDao.addUser(users);
    }

    @Override
    @Transactional
    public void updateUser(Users users) {

    }

    @Override
    @Transactional
    public void deleteUser(int id) {

    }
}
