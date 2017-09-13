package net.service.UserService;

import net.Config.MailConfig;
import net.dao.UserDao.UserRepository;
import net.model.Book;
import net.model.User;
import net.model.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private ApplicationContext context;

    private static Map<String, Integer> map = new ConcurrentHashMap<>();

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

    public Integer getRegistationCode(Thread thread) {
        return map.get(thread.getName());
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
    public User takeInfo(UserLoginDTO userLoginDTO) throws NullPointerException {
        if (userLoginDTO == null) {
            throw new NullPointerException();
        }
        User user = new User();
        user.setUserLogin(userLoginDTO.getUserLogin());
        user.setUserPassword(userLoginDTO.getUserPassword());
        user.setUserEmail(userLoginDTO.getUserEmail());
        return user;
    }

    @Override
    public void mailSender(User user, Integer cod) {
        MailConfig mailMail = (MailConfig) context.getBean("mailConfig");
        mailMail.sendMail("adaw36909@gmail.com",user.getUserEmail(),"Its your code", String.valueOf(cod));
    }

    @Override
    public User setContext(User user) {
        Set<Book> set = new HashSet<>();
        Book books1 = new Book("Decadance", "Disturbed", user);
        books1.setBookUrlImg("http://music-pesni.com/main/get_cd_cover/original/2417331a5709e3b2401018e63079fb95");
        books1.setBookAudioUrl("http://music-pesni.com/music/2417331a5709e3b2401018e63079fb95.mp3");
        set.add(books1);
        user.setBooks(set);
        user.setUserStatus("checked");
        return user;
    }

}
