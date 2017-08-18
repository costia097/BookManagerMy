package net.controller;

import net.model.User;
import net.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        User user = new User();
        model.addAttribute("userRegist", user);
        return "registrationForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registr(@Valid @ModelAttribute("userRegist")User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registrationForm";
        } else {
            boolean b = userService.addUser(user);
            if (b) {
                return "sucussecRegistartion";
            } else {
                return "unsucussesRegistartion";
            }
        }
    }
}
