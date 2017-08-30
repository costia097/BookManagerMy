package net.service.BookService;

import net.dao.BookDao.BookDao;
import net.model.Books;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Service
public class Book_service_impl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public void addBook(String books, String a, String b, User user) {
        bookDao.addBook(books,a,b,user);
    }

    @Override
    public void updateBook(Books books) {
        //TODO
    }

    @Override
    public void deleteBook(int id) {
        //TODO
    }

    @Override
    public Books getBookById(int id) {
        return null;
    }

    @Override
    public List<Books> listBooks() {
        return null;
    }
}
