package net.controller;

import net.dao.UserDao;
import net.model.Books;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class LoginController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(ModelMap modelMap) {
        User user = new User();
        modelMap.put("userLogin", user);
        return "loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String hello(@Valid @ModelAttribute("userLogin") User user, BindingResult result, ModelMap modelMap) {
        if (!result.hasErrors()) {
            return "loginForm";
        } else {
            try {
                User user1 = userDao.checkUser(user);
                if (user1 == null) {
                    return "unsuLoggin";
                }
                modelMap.put("user", user1);
                return "bookdata";

            } catch (Exception e) {
                return "unsuLoggin";
            }
        }
    }

}
