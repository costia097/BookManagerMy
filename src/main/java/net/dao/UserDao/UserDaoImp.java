package net.dao.UserDao;

import net.model.Books;
import net.model.Test;
import net.model.User;
import net.service.IdChekerService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Arrays;
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
        Set<Books> set = new HashSet<Books>();
        Books books1 = new Books("a", "AA", user);
        books1.setBook_url_img("http://lfly.ru/wp-content/uploads/2017/03/w585h345-crop-stretch-129fbc2a.jpg");
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
    Acctually if login correct but password no its return null.
    If user dont exist in db return null.
    If user exist and password correct return this User.
     */
    @Override
    @Transactional
    public User checkUser(User user) {
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
}
