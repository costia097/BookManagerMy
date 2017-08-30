package net.service.UserService;

import net.dao.UserDao.UserDao;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean b = userDao.addUser(user);
        return b;
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    /*
    So this method must return only + value(int)
     */
    @Override
    public int generateCode(User user) {
        Random random = new Random();
        int i = random.nextInt();
        while (i < 0) {
            i = random.nextInt();
        }
        return i;
    }

    @Override
    public User checkUserAtRegistration(User user) {
       return userDao.checkUserAtRegistration(user);
    }

    @Override
    public User takeUser(String s) {
        return userDao.takeUser(s);
    }
}
