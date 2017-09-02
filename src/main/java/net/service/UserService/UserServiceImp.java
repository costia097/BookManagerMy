package net.service.UserService;

import net.dao.UserDao.UserRepository;
import net.model.User;
import net.model.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userDao;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

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
    public User checkUserAtRegistration(String name, String email) {
       return userDao.checkUserAtRegistration(name, email);
    }

    @Override
    public User takeUser(String s) {
        return userDao.takeUser(s);
    }

    @Override
    public int emailValidation(User user) {
        int code = generateCode(user);
        user.setUserCode(code);
        return code;
    }

    @Override
    public User takeInfo(UserLoginDTO userLoginDTO) {
        User user = new User();
        user.setUserLogin(user.getUserLogin());
        user.setUserPassword(user.getUserPassword());
        user.setUserEmail(user.getUserEmail());
        user.setUserStatus("cheked");
        return user;
    }

}
