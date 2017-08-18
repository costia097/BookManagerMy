package net.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "books")
public class Books implements Serializable {
    private int id;
    @NotEmpty(message = "Please ener here something")
    @Size(min = 6, max = 20, message = "Book title must be from 6 to 20 characters!!")
    private String bookTitle;
    private String bookAuthor;
    private int price;
    private byte[] context;
    private int userId;

    @Id
    @Column(name = "id_book")

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "bookTitle")
    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Basic
    @Column(name = "bookAuthor")
    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "book")
    public byte[] getContext() {
        return context;
    }

    public void setContext(byte[] context) {
        this.context = context;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_user")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (price != books.price) return false;
        if (bookTitle != null ? !bookTitle.equals(books.bookTitle) : books.bookTitle != null) return false;
        if (bookAuthor != null ? !bookAuthor.equals(books.bookAuthor) : books.bookAuthor != null) return false;
        return Arrays.equals(context, books.context);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookTitle != null ? bookTitle.hashCode() : 0);
        result = 31 * result + (bookAuthor != null ? bookAuthor.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + Arrays.hashCode(context);
        return result;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", price=" + price +
                ", context=" + Arrays.toString(context) +
                '}';
    }
}
