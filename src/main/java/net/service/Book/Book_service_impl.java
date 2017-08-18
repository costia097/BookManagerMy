package net.service.Book;

import net.dao.Book.BookDao;
import net.model.Books;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Service
public class Book_service_impl implements BookService {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Books books) {
        this.bookDao.addBook(books);
    }

    @Override
    @Transactional
    public void updateBook(Books books) {
        this.bookDao.updateBook(books);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        this.bookDao.deleteBook(id);
    }

    @Override
    @Transactional
    public Books getBookById(int id) {
        Books books = this.bookDao.getBookById(id);
        return books;
    }

    @Override
    @Transactional
    public List<Books> listBooks() {
        List<Books> books = this.bookDao.listBooks();
        return books;
    }
}
