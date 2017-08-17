package net.controller;

import net.model.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Controller
public class BookController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(ModelMap modelMap) {
        Books books = new Books();
        modelMap.put("book", books);
        return "loginForm";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String hello(@Valid @ModelAttribute("book") Books books, BindingResult result) {
        if (result.hasErrors()) {
            return "loginForm";
        } else {
            return "bookdata";
        }
    }
}
