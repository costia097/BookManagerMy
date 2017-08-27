package net.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "books")
public class Books implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer book_id;

    @Column(name = "book_name")
    private String book_name;

    @Column(name = "book_author")
    private String book_author;

    @Column(name = "book_image")
    private byte[] book_image;

    @Column(name = "book_context")
    private byte[] book_context;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Books(String book_name, String book_author, User user) {
        this.book_name = book_name;
        this.book_author = book_author;
        this.user = user;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public byte[] getBook_image() {
        return book_image;
    }

    public void setBook_image(byte[] book_image) {
        this.book_image = book_image;
    }

    public byte[] getBook_context() {
        return book_context;
    }

    public void setBook_context(byte[] book_context) {
        this.book_context = book_context;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




}
