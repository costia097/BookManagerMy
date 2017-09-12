package net.controller;

import net.dao.UserDao.UserRepository;
import net.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by BeNdEr on 19.06.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserRepository userDao;

    private User user1;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(ModelMap modelMap) {
        User user = new User();
        modelMap.put("userLogin", user);
        return "login/loginForm";
    }

    /*
    So actually i dont know why validator working not correctly so i just check 2 fields only not empty.
     */
    /*
    MODEL DTO
   1) промежній дто
    2)ексоптіон обвернуть не все
   3) все в один сервис
    service.valid

     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String hello(@ModelAttribute("userLogin") User user, ModelMap modelMap) {
        if (user.getUserLogin() == null || user.getUserPassword() == null) {
            return "login/unsuLoggin";
        }
        try {
            user1 = userDao.checkUserAtLogin(user);
        } catch (Exception e) {
            return "login/unsuLoggin";
        }
        if (user1 == null) {
            return "login/unsuLoggin";
        }
        modelMap.put("user", user1);
        return "bookdata";
    }

}
