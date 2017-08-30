package net.dao.BookDao;

import net.model.Books;
import net.model.User;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
public interface BookDao {
    void addBook(String books, String a, String b, User user);

    void updateBook(Books books);

    void deleteBook(int id);

    Books getBookById(int id);

    List<Books> listBooks();
}
