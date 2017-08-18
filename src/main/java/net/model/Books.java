package net.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BeNdEr on 29.06.2017.
 */
@Entity
public class Books {
    private int id;
    private String bookTitle;
    private String bookAuthor;
    private int bookPrice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_title")
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Basic
    @Column(name = "book_author")
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Basic
    @Column(name = "book_price")
    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (bookPrice != books.bookPrice) return false;
        if (bookTitle != null ? !bookTitle.equals(books.bookTitle) : books.bookTitle != null) return false;
        if (bookAuthor != null ? !bookAuthor.equals(books.bookAuthor) : books.bookAuthor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        result = 31 * result + bookPrice;
        return result;
    }
}
