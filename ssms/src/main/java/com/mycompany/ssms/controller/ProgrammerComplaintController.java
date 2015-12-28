package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.Complaint;
import com.mycompany.ssms.dao.ComplaintRepo;
import com.mycompany.ssms.dao.UserRegistration;
import java.util.Date;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Ratul
 */
@Controller
public class ProgrammerComplaintController extends UsingMap {

    @Autowired
    ComplaintRepo comRepo;

    @RequestMapping(value = "/programmerViewComplain.htm", method = RequestMethod.GET)
    public String getProgComplaint(Model m, HttpSession sess) {
        UserRegistration id = (UserRegistration) sess.getAttribute("user");
        Complaint complaint = new Complaint();
        m.addAttribute("complaint", comRepo.findAll());
        return "complaint/programmerViewComplain";
    }

    @RequestMapping(value = "/programmerViewComplainDetail.htm", method = RequestMethod.GET)
    public String getComplaintDetailByCompNoProgrammer(Model m, Model n, Model k, @RequestParam(value = "cmId", required = false) Integer cmId, HttpSession sess) {
        Complaint pComp = null;
        if (cmId == null) {
            pComp = new Complaint();
        } else {
            pComp = comRepo.findOne(cmId);
        }
        n.addAttribute("detail", pComp);
        UserRegistration id = (UserRegistration) sess.getAttribute("user");
        Complaint complaint = new Complaint();
        m.addAttribute("complaint", comRepo.findAll());
        k.addAttribute("setval", complaint);
        return "complaint/programmerViewComplainDetail";
    }

    @RequestMapping(value = "/programmerViewComplainDetail.htm", method = RequestMethod.POST)
    public String setStatus(@ModelAttribute("setval") Complaint co, Model l) {
        co.setComplaintSolved(new Date());
        comRepo.save(co);
        l.addAttribute("msz", "Updated");
        return "complaint/programmerViewComplain";
    }
}
