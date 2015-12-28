package com.mycompany.ssms.controller;


import com.mycompany.ssms.dao.ComplaintRepo;
import com.mycompany.ssms.dao.UserRegistration;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ratul
 */
@Controller
public class HomePageController extends UsingMap {

    @Autowired
    ComplaintRepo comRepo;

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
}
