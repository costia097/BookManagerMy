package net.controller;

import net.Config.MailConfig;
import net.model.User;
import net.model.UserLoginDTO;
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
        UserLoginDTO user = new UserLoginDTO();
        user.setUserStatus("unchecked");
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
    public String registrationFirstStep(@Valid @ModelAttribute("userRegist")UserLoginDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/registrationFirstForm";
        } else {
            User userMain = userService.takeInfo(user);
            User chekedUser = userService.checkUserAtRegistration(userMain.getUserLogin(),userMain.getUserEmail());
            if (chekedUser == null) {
                return "registration/unsucussesRegistartion";
            }
            cod = userService.emailValidation(userMain);
            MailConfig mailMail = (MailConfig) context.getBean("mailConfig");
            mailMail.sendMail("adaw36909@gmail.com",user.getUserEmail(),"Its your code", String.valueOf(userService.emailValidation(userMain)));
            userSave = userMain;
            return "registration/RegistrationSecondForm";
        }
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkCode(@ModelAttribute("userRegistr")User user) {
        if (cod.equals(user.getUserCode())) {
            boolean userStatus = userService.addUser(userSave);
           return userStatus ? "registration/sucussecRegistartion" : "registration/unsucussesRegistartion";
        }
        return "registration/unsucussesRegistartion";
    }
}
