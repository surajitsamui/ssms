/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mmc-pc1
 */
@Controller
public class LoginAllUser {

    @Autowired
    UserRegistrationRepo urp;

    @RequestMapping(value = "/mainLogin.htm", method = RequestMethod.GET)
    public String getLogin(Model m) {
        UserRegistration log = new UserRegistration();
        m.addAttribute("login", log);
        return "complaint/mainLogin";
    }

    @RequestMapping(value = "/mainLogin.htm", method = RequestMethod.POST)
    public String matchLogin(@ModelAttribute("login") UserRegistration uu, BindingResult e, Model o, HttpSession session) {
        try {
            UserRegistration ur = urp.read(uu.getUserId());
            if (!ur.getDesiredPassWord().equals(uu.getDesiredPassWord())) {
                e.reject(null, "Invalid Login  ");
                o.addAttribute("error", "Login Information Invalid");
                return "complaint/mainLogin";
            }
            //session.invalidate();

            session.setAttribute("user", ur);
            String path = null;
            switch (ur.getAdminUser()) {
                case 0:
                    path = "redirect:/userHomePage.htm";
                    break;
                case 1:
                    path = "redirect:/programmerHomePage.htm";
                    break;
                case 2:
                    path = "redirect:/adminHomePage.htm";
                    break;
                default:
                    throw new RuntimeException("categor not found");
            }
            return path;
        } catch (EmptyResultDataAccessException dataAccessException) {
            o.addAttribute("error", "Invalid Login Information ");
            return "complaint/mainLogin";
        }
    }
}