package net.controller;

import net.Config.MailConfig;
import net.model.User;
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

@Controller
//@Scope("session")
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

    /*
    So this method must check if login exist so return unsuccusess registration.
    If hasErrors() return registrationFirstForm.jsp.
    If email exist return unsuccusess registration.
    Password may repeat.
    Query return list Users and just check all af this users for equals email , login.
     */

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationFirstStep(@Valid @ModelAttribute("userRegist")User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/registrationFirstForm";
        } else {
            /*
            Check its
            */
            User user1 = userService.checkUserAtRegistration(user);
            if (user1 == null) {
                return "registration/unsucussesRegistartion";
            }
            /*
            Sending Email Validation
            and save user code
            */
            cod = userService.generateCode(user);
            user.setUser_code(cod);
            String code = String.valueOf(cod);
            MailConfig mailMail = (MailConfig) context.getBean("mailConfig");
            String reserver = user.getUser_email();
            mailMail.sendMail("adaw36909@gmail.com",reserver,"Its your code",code);
            /*
            Save model and send reference to this object
            */
            userSave = user;
            return "registration/RegistrationSecondForm";
        }
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkCode(@ModelAttribute("userRegistr")User user) {
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
