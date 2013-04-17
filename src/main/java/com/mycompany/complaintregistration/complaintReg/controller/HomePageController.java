/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author mmc-pc1
 */
@Controller
public class HomePageController {

    @RequestMapping(value = "/userHomePage.htm", method = RequestMethod.GET)
    public String homePage(HttpSession session, Model m) {
        if (session.getAttribute("user") == null) {
            return "redirect:/mainLogin.htm";
        }
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        return "complaint/userHomePage";
    }

    @RequestMapping(value = "/programmerHomePage.htm", method = RequestMethod.GET)
    public String homePageProgrammer(HttpSession session, Model m) {
        if (session.getAttribute("user") == null) {
            return "redirect:/mainLogin.htm";
        }
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        return "complaint/programmerHomePage";
    }

    @RequestMapping(value = "/adminHomePage.htm", method = RequestMethod.GET)
    public String homePageAdmin(HttpSession session, Model m) {
        if (session.getAttribute("user") == null) {
            return "redirect:/mainLogin.htm";
        }
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        return "complaint/adminHomePage";
    }
}
