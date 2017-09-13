package net.dao.UserDao;

import net.model.User;
import net.service.UserService.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserService userService;

    /*
    Много всякой всячині Убрать оставить только саве
     */

    @Override
    @Transactional
    public boolean addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user1 = userService.setContext(user);
        try {
            currentSession.save(user1);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void deleteUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
    }


    /*
    So this method must return User if he passed check.
    Actually if login correct but password no its return null.
    If user don't exist in db return null.
    If user exist and password correct return this User.
     */

    /*
    Optional (null)
     */
    @Override
    @Transactional
    public User checkUserAtLogin(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where userLogin = :param");
        query.setParameter("param", user.getUserLogin());
        List<User> list = query.list();
        if (list.size() == 0) {
            return null;
        }
        if (list.get(0).getUserPassword().equals(user.getUserPassword())) {
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
    public User checkUserAtRegistration(String login, String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where userLogin = :login or userEmail = :email");
        query.setParameter("login",login);
        query.setParameter("email", email);
        return query.list().size()== 0 ?  new User() : null;
    }

    /*
    Just take user from bd with login
    If user don't exist return null
     */
    @Override
    @Transactional
    public User takeUser(String s) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query query = currentSession.createQuery("from User where userLogin = :param");
        query.setParameter("param", s);
        return query.list().size() == 0 ? null : (User) query.list().get(0);

//                вся логика в сервисе а візовы к базе в репозиторие
    }
}
