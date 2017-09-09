package net.dao.UserDao;

import net.model.Book;
import net.model.User;
import net.model.UserLoginDTO;
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
public class UserRepositoryImp implements UserRepository {

    private static final Logger log = LoggerFactory.getLogger(UserRepositoryImp.class);

    @Autowired
    private SessionFactory sessionFactory;


    /*
    Много всякой всячині Убрать оставить только саве
     */

    @Override
    @Transactional
    public boolean addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        /*
        So i have exeptions when iam trying to save just user so i think me need to add some books by default. Must work!!!
         */
        Set<Book> set = new HashSet<>();
        Book books1 = new Book("Decadance", "Disturbed", user);
        books1.setBookUrlImg("http://music-pesni.com/main/get_cd_cover/original/2417331a5709e3b2401018e63079fb95");
        books1.setBookAudioUrl("http://music-pesni.com/music/2417331a5709e3b2401018e63079fb95.mp3");
        set.add(books1);
        user.setBooks(set);
        user.setUserStatus("checked");
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
        Query query = currentSession.createQuery("from User where userLogin = :login and userEmail = :email");
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
