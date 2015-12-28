/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.ComplaintRepo;
import com.mycompany.ssms.dao.UserRegistration;
import com.mycompany.ssms.dao.UserRegistrationValidation;
import com.mycompany.ssms.dao.UserRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ratul
 */
@Controller
public class profileUpdate extends UsingMap {

    @Autowired
    ComplaintRepo comRepo;
    @Autowired
    UserRepository ur;

    @RequestMapping(value = "/profileUpdate.htm", method = RequestMethod.GET)
    public String adminProfileUpdateGet(HttpSession session, Model m) {
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        UserRegistration us = new UserRegistration();
        m.addAttribute("userForm", us);
        return "complaint/profileUpdate";
    }

    @RequestMapping(value = "/profileUpdate.htm", method = RequestMethod.POST)
    public String adminProfileUpdatepost(@ModelAttribute("userForm") UserRegistration ureg, Model m, BindingResult err, HttpSession session) {
        new UserRegistrationValidation().validate(err, ureg);
        if (err.hasErrors()) {
            return "complaint/profileUpdate";
        }
        ur.save(ureg);
        m.addAttribute("uupdatationComplete", "Your Profile Is Updated");
        session.setAttribute("user", ureg);
        return "complaint/profileUpdate";
    }

    @RequestMapping(value = "/changePassword.htm", method = RequestMethod.GET)
    public String changePasswordGet(Model m, HttpSession ses) {
        UserRegistration uss = (UserRegistration) ses.getAttribute("user");
        m.addAttribute("pass", uss);
        return "complaint/changePassword";
    }

    @RequestMapping(value = "/changePassword.htm", method = RequestMethod.POST)
    public String changePasswordSet(@ModelAttribute("pass") UserRegistration u, Model m, HttpSession session) {
        UserRegistration us = (UserRegistration) session.getAttribute("user");
        if (!u.getTempPassWord().equals(ur.findOne(us.getUserId()).getTempPassWord()) || u.getDesiredPassWord().length() != 10) {
            m.addAttribute("notUpdate", "Type Correct Password");
            return "complaint/changePassword";
        } else {
            ur.save(u);
            m.addAttribute("Update", "Password Changed Succesfully");
            return "complaint/changePassword";
        }
    }
}
