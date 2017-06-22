package net.dao;

import net.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Created by BeNdEr on 22.06.2017.
 */
@Repository
public class UserDao_impl implements UsersDao {
    private static final Logger log = LoggerFactory.getLogger(Book_Dao_Impl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(Users users) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.persist(users);
        log.info("User was added  "+users);
    }

    @Override
    public void updateUser(Users users) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
