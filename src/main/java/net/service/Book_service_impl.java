package net.service;

import net.dao.BookDao;
import net.dao.Book_Dao_Impl;
import net.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Service
public class Book_service_impl implements BookService {

    @Autowired
    private Book_Dao_Impl bookDao;


    @Transactional
    public void addBook(Books book) {
        bookDao.addBook(book);
    }


    public void updateBook(Books books) {
        //TODO
    }


    public void deleteBook(int id) {
        //TODO
    }


    public Books getBookById(int id) {
        return null;
    }


    public List<Books> listBooks() {
        return null;
    }
}
