package net.controller;

import net.model.Books;
import net.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Controller
public class BookController {
    private BookService bookService;

    @Autowired(required = true)
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        model.addAttribute("books", new Books());
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("books") Books books) {
        if (books.getId() == 0) {
            this.bookService.addBook(books);
        } else {
            this.bookService.updateBook(books);
        }
        return "redirect:/books";
    }

    @RequestMapping("/remove/{id}")
    public String remoteBook(@PathVariable("id") int id) {
        this.bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBooks());
        return "books";
    }

    @RequestMapping("bookdata/{id}")
    public String bookData(@PathVariable("id") int id, Model model) {
        model.addAttribute("books", this.bookService.getBookById(id));
        return "bookdata";
    }
}
