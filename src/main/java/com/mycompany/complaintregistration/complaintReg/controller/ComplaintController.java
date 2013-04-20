package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.validation.ValidateUserComplaint;
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
 * @author Samim
 */
@Controller
public class ComplaintController extends UsingMap {

    @Autowired
    ComplaintRepo complrepo;

    @RequestMapping(value = "/userComplaint.htm", method = RequestMethod.GET)
    public String getUserComplaint(Model m, HttpSession session) {
        UserRegistration ssC = (UserRegistration) session.getAttribute("user");
        Complaint compl = new Complaint();
        m.addAttribute("userId", ssC);
        m.addAttribute("usercompl", compl);
        return "complaint/userComplaint";
    }

    @RequestMapping(value = "/userComplaint.htm", method = RequestMethod.POST)
    public String saveUserComplaint(@ModelAttribute("usercompl") Complaint complaint, Model m, BindingResult err) {
        new ValidateUserComplaint(complrepo).validate(err, complaint);
        if (err.hasErrors()) {
            return "complaint/userComplaint";
        }
        complrepo.save(complaint);
        m.addAttribute("comNoGen", "Your Generated Complaint No is " + complaint.getComplaintNo());
        return "complaint/userComplaint";
    }

    @RequestMapping(value = "/userComplainStatus.htm", method = RequestMethod.GET)
    public String getUserStatus(Model m, HttpSession session) {
        UserRegistration ssC = (UserRegistration) session.getAttribute("user");
        Complaint com = new Complaint();

        m.addAttribute("statusPendingUnsolved", complrepo.statusPendingUnsolvedProgToUser(ssC.getUserId()));
        m.addAttribute("statusSolved", complrepo.statusSolvedProgToUser(ssC.getUserId()));
        m.addAttribute("feedback", com);
        return "complaint/userComplainStatus";
    }

    @RequestMapping(value = "/userComplainStatus.htm", method = RequestMethod.POST)
    public String saveFeedback(@ModelAttribute("feedback") Complaint com, Model m) {
        complrepo.feedbackUpdate(com);
        m.addAttribute("msgz", "Submitted Successfully");
        return "complaint/userComplainStatus";
    }
}
