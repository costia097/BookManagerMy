package net.service.BookService;

import net.model.Book;
import net.model.User;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
public interface BookService {
    void addBook(String books, String a, String b, User user);

    void updateBook(Book books);

    void deleteBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
