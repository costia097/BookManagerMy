package net.service.BookService;

import net.dao.BookDao.BookRepository;
import net.model.Book;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookDao;


    @Override
    public void addBook(String books, String a, String b, User user) {
        bookDao.addBook(books,a,b,user);
    }

    @Override
    public void updateBook(Book books) {
        //TODO
    }

    @Override
    public void deleteBook(int id) {
        //TODO
    }

    @Override
    public Book getBookById(int id) {
        return null;
    }

    @Override
    public List<Book> listBooks() {
        return null;
    }
}
