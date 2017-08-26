package net.dao.UserDao;

import net.model.Books;
import net.model.User;
import net.service.IdChekerService;
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
        So i have exeptions when iam trying to save just user so ithink me need to add some books by default. Must work!!!
         */


//            Set<Books> set = new HashSet<Books>();
//
//
//            Books books1 = new Books("A","A", user);
//            Books books2 = new Books("B","A", user);
//            Books books3 = new Books("C","A", user);
//
//            set.add(books1);
//            set.add(books2);
//            set.add(books3);

        //TODO WTF with forein key???
        currentSession.persist(user);
        log.info("User added: "+user);
        return true;
    }

    @Override
    public void deleteUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(user);
        log.info("User deleted: "+ user);
    }

    @Override
    @Transactional
    public User checkUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
//        User load = (User) currentSession.load(User.class, user.getLoggin());
//        if (!(load==null)) {
//            if (load.getPassword().equals(user.getPassword())) {
//                return load;
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
        return new User();
    }
}
