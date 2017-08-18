package net.dao;

import net.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDaoImp implements UserDao {

    private static final Logger log = LoggerFactory.getLogger(UserDaoImp.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean addUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
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
        User load = (User) currentSession.load(User.class, user.getLoggin());
        if (!(load==null)) {
            if (load.getPassword().equals(user.getPassword())) {
                return load;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}
