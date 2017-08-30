package net.dao.UserDao;

import net.model.Books;
import net.model.User;
import net.service.IdChekerService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private IdChekerService service;


    @Override
    @Transactional
    public boolean addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        /*
        So i have exeptions when iam trying to save just user so i think me need to add some books by default. Must work!!!
         */
        Set<Books> set = new HashSet<>();
        Books books1 = new Books("Decadance", "Disturbed", user);
        books1.setBook_url_img("http://music-pesni.com/main/get_cd_cover/original/2417331a5709e3b2401018e63079fb95");
        books1.setBook_audio_url("http://music-pesni.com/music/2417331a5709e3b2401018e63079fb95.mp3");
        set.add(books1);
        user.setBooks(set);
        user.setUser_status("checked");
        currentSession.save(user);
        log.info("User added: " + user);
        return true;
    }

    @Override
    public void deleteUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
        log.info("User deleted: " + user);
    }


    /*
    So this method must return User if he passed check.
    Actually if login correct but password no its return null.
    If user don't exist in db return null.
    If user exist and password correct return this User.
     */
    @Override
    @Transactional
    public User checkUserAtLogin(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where user_login = :param");
        query.setParameter("param", user.getUser_login());
        List<User> list = query.list();
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).getUser_password().equals(user.getUser_password())) {
            User o = list.get(0);
            return o;
        } else {
            return null;
        }
    }

    /*
    So this method must check exist user at db or not.
    If exist return null.
    If not exist return User.
     */
    @Override
    @Transactional
    public User checkUserAtRegistration(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User");
        List<User> list = query.list();
        boolean b = list.stream().anyMatch(user1 -> user1.getUser_login().equals(user.getUser_login()) || user1.getUser_email().equals(user.getUser_email()));
        if (b) {
            return null;
        } else {
            return user;
        }
    }

    /*
    Just take user from bd with login
    If user don't exist return null
     */
    @Override
    @Transactional
    public User takeUser(String s) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where user_login = :param");
        query.setParameter("param", s);
        List<User> list = query.list();
        if (list.size() == 0) {
            return null;
        }
        User user = list.get(0);
        return user;
    }
}
