package net.dao.BookDao;

import net.model.Books;
import net.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by BeNdEr on 19.06.2017.
 */
@Repository
public class Book_Dao_Impl implements BookDao {
    private static final Logger log = LoggerFactory.getLogger(Book_Dao_Impl.class);

    @Autowired
    private SessionFactory sessionFactory;

    /*
    So this method must add new Books in db
     */
    @Override
    @Transactional
    public void addBook(String books, String a, String b, User user) {
        Session session = sessionFactory.openSession();
        Books booksi = new Books();
        booksi.setBook_audio_url(books);
        booksi.setBook_name(a);
        booksi.setBook_author(b);
        booksi.setUser(user);
        user.getBooks().add(booksi);
        session.save(booksi);
        session.close();
        log.info("Books added: " +books);
    }


    public void updateBook(Books books) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(books);
        log.info("Books was updatied:  "+ books);
    }


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


    public Books getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Books books = (Books) session.load(Books.class, id);
        log.info("Books was sucusesfuly loaded!: "+ books);
        return books;
    }

    public List<Books> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Books> list = (List<Books>) session.createQuery("from Books").list();
        for (Books books : list) {
            log.info("Books is: "+ books);
        }
        return list;
    }
}
