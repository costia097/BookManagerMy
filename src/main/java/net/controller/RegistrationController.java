package net.controller;

import net.model.User;
import net.service.MailMail;
import net.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Scope("session")
public class RegistrationController {

    private  User userSave;

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationContext context;

    private Integer cod;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        User user = new User();
        user.setUser_status("unchecked");
        model.addAttribute("userRegist", user);
        return "registration/registrationFirstForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationFirstStep(@Valid @ModelAttribute("userRegist")User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/registrationFirstForm";
        } else {
            /*
            Sending Email Validation
            */
            String name = user.getUser_login();
            cod = userService.generateCode(user);
            user.setUser_code(cod);
            String code = String.valueOf(cod);
            MailMail mailMail = (MailMail) context.getBean("mailMail");
            mailMail.sendMail(name,code);
            /*
            Save model and send reference to this object
            */
            userSave = user;
            return "registration/RegistrationSecondForm";
        }
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkCode(@ModelAttribute("userRegistr")User user,User ref) {
        if (cod.equals(user.getUser_code())) {
            boolean b = userService.addUser(userSave);
            if (b) {
                return "registration/sucussecRegistartion";
            } else {
                return "registration/unsucussesRegistartion";
            }
        } else {
            return "registration/unsucussesRegistartion";
        }
    }
}
