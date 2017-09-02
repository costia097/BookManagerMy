package net.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "book_author")
    private String bookAuthor;

    @Column(name = "book_image")
    private byte[] bookImage;

    @Column(name = "book_context")
    private byte[] bookContext;

    @Column(name = "book_url_img")
    private String bookUrlImg;

    @Column(name = "book_audio")
    private byte[] bookAudio;

    @Column(name = "book_audio_url")
    private String bookAudioUrl;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Book() {
    }

    public Book(String bookName, String bookAuthor, User user) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.user = user;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public byte[] getBookImage() {
        return bookImage;
    }

    public void setBookImage(byte[] bookImage) {
        this.bookImage = bookImage;
    }

    public byte[] getBookContext() {
        return bookContext;
    }

    public void setBookContext(byte[] bookContext) {
        this.bookContext = bookContext;
    }

    public String getBookUrlImg() {
        return bookUrlImg;
    }

    public void setBookUrlImg(String bookUrlImg) {
        this.bookUrlImg = bookUrlImg;
    }

    public byte[] getBookAudio() {
        return bookAudio;
    }

    public void setBookAudio(byte[] bookAudio) {
        this.bookAudio = bookAudio;
    }

    public String getBookAudioUrl() {
        return bookAudioUrl;
    }

    public void setBookAudioUrl(String bookAudioUrl) {
        this.bookAudioUrl = bookAudioUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
