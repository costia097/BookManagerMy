package net.dao.BookDao;

import net.model.Book;
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

/*
Book repository
логи в сервисе
 */

@Repository
public class BookRepositoryImpl implements BookRepository {
    private static final Logger log = LoggerFactory.getLogger(BookRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    /*
    So this method must add new Book in db
     */
    @Override
    @Transactional
    public void addBook(String books, String a, String b, User user) {
        Session session = sessionFactory.getCurrentSession();
        Book booksi = new Book();
        booksi.setBookAudioUrl(books);
        booksi.setBookAuthor(a);
        booksi.setBookName(b);
        booksi.setUser(user);
        user.getBooks().add(booksi);
        try {
            session.save(booksi);
        } catch (Exception e) {
            log.debug("Exeption: addBook "+e.getStackTrace().toString());
        }
    }


    public void updateBook(Book books) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(books);
        log.info("Book was updatied:  "+ books);
    }


    /*
    Не изать лоад сесион  просто делит и передать ид
     */

    public void deleteBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book books = (Book) session.load(Book.class, id);
        if (books != null) {
            session.delete(books);
            log.info("Book was deleted: " + books);
        } else {
            log.info("Book is exist!!!:  "+ books);
        }
    }


    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book books = (Book) session.load(Book.class, id);
        log.info("Book was sucusesfuly loaded!: "+ books);
        return books;
    }

    /*
    лист на букс
    лог дебаг количество книжек
    Got {} +size
       */
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> list = (List<Book>) session.createQuery("from Book").list();
        for (Book books : list) {
            log.info("Book is: "+ books);
        }
        return list;
    }
}
