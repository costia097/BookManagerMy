package net.controller;

import net.model.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @Autowired
    private SessionFactory sessionFactory;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @Transactional
    public String test() {
        Test test = new Test();
        test.setTest_name("A");
        sessionFactory.getCurrentSession().persist(test);
        return "registration/sucussecRegistartion";
    }
}
