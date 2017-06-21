package net.dao;

import net.model.Books;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by BeNdEr on 19.06.2017.
 */
@Repository
public class Book_Dao_Impl implements BookDao {
    private static final Logger log = LoggerFactory.getLogger(Book_Dao_Impl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Books books) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(books);
        log.info("Books added: "+ books);
    }

    @Override
    public void updateBook(Books books) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(books);
        log.info("Books was updatied:  "+ books);
    }

    @Override
    public void deleteBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Books books = (Books) session.load(Books.class, id);
        if (books != null) {
            session.delete(books);
            log.info("Books was deleted: " + books);
        } else {
            log.info("Books is exist!!!:  "+ books);
        }
    }

    @Override
    public Books getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Books books = (Books) session.load(Books.class, id);
        log.info("Books was sucusesfuly loaded!: "+ books);
        return books;
    }

    @Override
    public List<Books> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Books> list = (List<Books>) session.createQuery(" from Books").list();
        for (Books books : list) {
            log.info("Books is: "+ books);
        }
        return list;
    }
}
