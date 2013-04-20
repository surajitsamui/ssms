/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
import com.mycompany.complaintregistration.complaintReg.validation.UserRegistrationValidation;
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
 * @author mmc-pc1
 */
@Controller
public class profileUpdate extends UsingMap {

    @Autowired
    ComplaintRepo comRepo;
    @Autowired
    UserRegistrationRepo ur;

    @RequestMapping(value = "/profileUpdate.htm", method = RequestMethod.GET)
    public String adminProfileUpdateGet(HttpSession session, Model m) {
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        UserRegistration us = new UserRegistration();
        // int userCount = ur.userCount() + 1;
        // m.addAttribute("usrCont", userCount);
        m.addAttribute("userForm", us);
        //m.addAttribute("log",uu);
        return "complaint/profileUpdate";
    }

    @RequestMapping(value = "/profileUpdate.htm", method = RequestMethod.POST)
    public String adminProfileUpdatepost(@ModelAttribute("userForm") UserRegistration ureg, Model m, BindingResult err, HttpSession session) {
        //UserRegistration uu = (UserRegistration) sAdmin.getAttribute("user");

        new UserRegistrationValidation().validate(err, ureg);
        if (err.hasErrors()) {
            return "complaint/profileUpdate";
        }
        ur.save(ureg);
        m.addAttribute("uupdatationComplete", "Your Profile Is Updated");
        session.setAttribute("user", ureg);
        //adminProfileUpdateGet(sAdmin, m);
        //sAdmin.invalidate();
        return "complaint/profileUpdate";
    }

    @RequestMapping(value = "/changePassword.htm", method = RequestMethod.GET)
    public String changePasswordGet(Model m, HttpSession ses) {
        UserRegistration uss = (UserRegistration) ses.getAttribute("user");
        m.addAttribute("pass", uss);
        return "complaint/changePassword";
    }

    @RequestMapping(value = "/changePassword.htm", method = RequestMethod.POST)
    public String changePasswordSet(@ModelAttribute("pass") UserRegistration u, Model m,HttpSession session) {
        UserRegistration us= (UserRegistration)session.getAttribute("user");
        if (!u.getTempPassWord().equals(ur.checkPass(us.getUserId())) || u.getDesiredPassWord().length()!=10) {
            
             m.addAttribute("notUpdate", "Type Correct Password");
            return "complaint/changePassword";
        } else {
            ur.updatePassword(u, us.getUserId());
            m.addAttribute("Update", "Password Changed Succesfully");
            return "complaint/changePassword";
           
        }
    }
}
