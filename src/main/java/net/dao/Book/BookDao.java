package net.dao.Book;

import net.model.Books;

import java.util.List;

/**
 * Created by BeNdEr on 19.06.2017.
 */
public interface BookDao {
    void addBook(Books books);

    void updateBook(Books books);

    void deleteBook(int id);

    Books getBookById(int id);

    List<Books> listBooks();
}
