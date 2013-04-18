package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mmc-pc1
 */
@Controller
public class HomePageController extends UsingMap{
    @Autowired
     ComplaintRepo comRepo;
    @Autowired
    UserRegistrationRepo ur;

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

   /* @RequestMapping(value = "/adminViewCComplaintViewSolved.htm", method = RequestMethod.GET)
    public String homePageAdmin(HttpSession session, Model m) {
        if (session.getAttribute("user") == null) {
            return "redirect:/mainLogin.htm";
        }
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        return "complaint/adminViewCComplaintViewSolved";
    }*/
    
}
