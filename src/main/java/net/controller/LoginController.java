package net.controller;

import net.model.Users;
import net.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by BeNdEr on 21.06.2017.
 */
@Controller
@RequestMapping(value = "/loging")
public class LoginController {
    private UserService service;

    @Autowired
    @Qualifier("usersService")
    public void setService(UserService userService) {
        this.service = userService;
    }

    //    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView login(@RequestParam("login") String login,@RequestParam("password") String password, Model model) {
//
//        BeanExample user = new BeanExample();
//        user.setName(login);
//        user.setPassword(password);
//
//        return new ModelAndView("Succuses","model",user);
//    }
//    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
//    public ModelAndView login(@PathVariable("id") int id, Model model) {
//        return new ModelAndView("Succuses","id",id);
//       }
//    }

    @RequestMapping(value = "/regist", method = RequestMethod.GET)
    public String regist() {
        return "logging/Register";
    }


    //TODO Spring SECURITy!!!
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("login")String login,@RequestParam("password")String password) {

        if (service.checkUser(login, password)) {
            return "context/bookdata";
        } else {
            return "logging/Unsuccuses";
        }

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("login")String login,
                           @RequestParam("password")String password,
                           @RequestParam("email")String email,
                           @RequestParam("bio")String bio) {

        Users users = new Users();
        users.setLogin(login);
        users.setPassword(password);
        users.setEmail(email);
        users.setBio(bio);
        service.addUser(users);

        return "/context/index";
    }

}
