package net.controller;

import net.model.User;
import net.model.UserLoginDTO;
import net.model.UserSaver;
import net.service.UserService.UserService;
import net.service.UserService.UserServiceImp;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private static final Logger log = Logger.getLogger(UserServiceImp.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String viewRegistration(Model model) {
        UserLoginDTO user = new UserLoginDTO();
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
    public String registrationFirstStep(@Valid @ModelAttribute("userRegist")UserLoginDTO userModel, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return "registration/registrationFirstForm";
        } else {
            User userMain = userService.takeInfo(userModel);
            if (userService.checkUserAtRegistration(userMain.getUserLogin(),userMain.getUserEmail()) == null) {
                return "registration/unsucussesRegistartion";
            }
            Integer cod = userService.emailValidation(userMain);
            userService.mailSender(userMain,cod);
            Integer i = cod.hashCode();
            userService.registrateThread(i,cod,userMain);
            model.addAttribute("kode", i);
            return "registration/RegistrationSecondForm";
        }
    }


    @RequestMapping(value = "/checkCode", method = RequestMethod.POST)
    public String checkCode(@ModelAttribute("userRegistr")UserLoginDTO user) {
        Integer integerUserPassword = Integer.parseInt(user.getUserPassword());
        UserSaver userSaver = userService.getRegistationCode(integerUserPassword);
        if (userSaver.getCode().equals(user.getUserCode())) {
           return userService.addUser(userSaver.getUserSave()) ? "registration/sucussecRegistartion" : "registration/unsucussesRegistartion";
        }
        return "registration/unsucussesRegistartion";
    }

}
