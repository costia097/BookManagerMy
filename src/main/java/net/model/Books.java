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

    @Column(name = "book_url_img")
    private String book_url_img;

    @Column(name = "book_audio")
    private byte[] book_audio;

    @Column(name = "book_audio_url")
    private String book_audio_url;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Books() {
    }

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

    public String getBook_url_img() {
        return book_url_img;
    }

    public void setBook_url_img(String book_url_img) {
        this.book_url_img = book_url_img;
    }

    public byte[] getBook_audio() {
        return book_audio;
    }

    public void setBook_audio(byte[] book_audio) {
        this.book_audio = book_audio;
    }

    public String getBook_audio_url() {
        return book_audio_url;
    }

    public void setBook_audio_url(String book_audio_url) {
        this.book_audio_url = book_audio_url;
    }
}
