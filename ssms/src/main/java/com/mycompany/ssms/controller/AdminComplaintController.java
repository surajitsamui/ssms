package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.Complaint;
import com.mycompany.ssms.dao.ComplaintRepo;
import com.mycompany.ssms.dao.UserRegistration;
import com.mycompany.ssms.dao.UserRegistrationValidation;
import com.mycompany.ssms.dao.UserRepository;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Samim
 */
@Controller
public class AdminComplaintController extends UsingMap {

    @Autowired
    ComplaintRepo comRepo;
    @Autowired
    UserRepository ur;

    @RequestMapping(value = "/adminViewComplain.htm", method = RequestMethod.GET)
    public String getAdminComplaint(Model m) {

        m.addAttribute("comp", comRepo.findAll());
        return "complaint/adminViewComplain";
    }

    @RequestMapping(value = "/adminViewCComplainDetails.htm", method = RequestMethod.GET)
    public String getComplaintDetailByCompNo(Model m, @RequestParam(value = "cId", required = false) Integer cId, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/mainLogin.htm";
        }
        UserRegistration uu = (UserRegistration) session.getAttribute("user");
        m.addAttribute("homePageS", uu);
        Complaint com = null;
        if (cId == null) {
            com = new Complaint();
        } else {
            com = comRepo.findOne(cId);
        }
//      
//        m.addAttribute("pending", comRepo.getAllComplaintPending("P"));
//        m.addAttribute("solved", comRepo.getAllComplaintPending("S"));
//        m.addAttribute("unsolved", comRepo.getAllComplaintPending("R"));
        m.addAttribute("detail", com);
        m.addAttribute("prog", ur.findOne(1));
        return "complaint/adminViewCComplainDetails";
    }

    @RequestMapping(value = "/adminViewCComplainDetails.htm", method = RequestMethod.POST)
    public String assignProgrammer(@ModelAttribute("detail") Complaint compla, Model m) {
        Date dt = new Date();
        compla.setProgrammerAssignDate(dt);
        //comRepo.assingUpdate(compla);
        m.addAttribute("mszz", "Updated OK");
        return "complaint/adminViewCComplainDetails";
    }

    @RequestMapping(value = "/programmerCreationPagebyAdmin.htm", method = RequestMethod.GET)
    public String programmerCreationbyAdmin(Model m) {
        UserRegistration us = new UserRegistration();
        int userCount = ur.findAll().size() + 1;
        m.addAttribute("usrCont", userCount);
        m.addAttribute("userForm", us);
        m.addAttribute("userList", ur.findAll());
        return "complaint/programmerCreationPagebyAdmin";
    }

    @RequestMapping(value = "/programmerCreationPagebyAdmin.htm", method = RequestMethod.POST)
    public String programmerCreationbyAdminSave(@ModelAttribute("userForm") UserRegistration ureg, Model m, BindingResult err) {
        new UserRegistrationValidation().validate(err, ureg);
        if (err.hasErrors()) {
            return "complaint/programmerCreationPagebyAdmin";
        }
        ur.save(ureg);
        m.addAttribute("userCountShow", "Your System Generated User Id is " + ureg.getUserId());
        return "complaint/programmerCreationPagebyAdmin";
    }
}
