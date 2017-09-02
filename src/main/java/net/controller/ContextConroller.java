package net.controller;


import net.model.User;
import net.service.BookService.BookService;
import net.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ContextConroller {

    @Autowired
    private UserService service;

    @Autowired
    private BookService bookService;

    /*
    So this method must take user from user_login with db and
    add to this user reference to List<Book> so what url was given
     */
    /*
    Закинуть все в один сервис и візівать один метод сервіса
     */
    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    public String add(@ModelAttribute("user")User user) {
        String userLogin = user.getUserLogin();
        String trackUrl = user.getUserEmail();
        User user_main = service.takeUser(userLogin);
        if (user_main == null) {
            return "Context/UnsAdd";
        }
        bookService.addBook(trackUrl,"test","test",user_main);
        return "Context/sucAdd";
    }
}
