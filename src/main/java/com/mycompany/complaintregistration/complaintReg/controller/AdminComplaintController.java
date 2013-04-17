package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
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
 * @author Samim
 */
@Controller
public class AdminComplaintController {

    @Autowired
    ComplaintRepo comRepo;
    @Autowired
    UserRegistrationRepo ur;

    @RequestMapping(value = "/adminViewComplain.htm", method = RequestMethod.GET)
    public String getAdminComplaint(Model m) {

        m.addAttribute("comp", comRepo.getAllComplaint());
        return "complaint/adminViewComplain";
    }

    @RequestMapping(value = "/adminViewCComplainDetails.htm", method = RequestMethod.GET)
    public String getComplaintDetailByCompNo(Model m, @RequestParam(value = "cId", required = false) Integer cId) {
        Complaint com = null;
        if (cId == null) {
            com = new Complaint();
        } else {
            com = comRepo.read(cId);
        }
        //Complaint compl = new Complaint();
        m.addAttribute("pending", comRepo.getAllComplaintPending());
        m.addAttribute("solved", comRepo.getAllComplaintSolved());
        m.addAttribute("unsolved", comRepo.getAllComplaintUnSolved());
        m.addAttribute("detail", com);
        m.addAttribute("dd", com);// check and remove this
        m.addAttribute("prog", ur.getProgrammer(1));// check and remove this
        return "complaint/adminViewCComplainDetails";
    }

    @RequestMapping(value = "/adminViewCComplainDetails.htm", method = RequestMethod.POST)
    public String assignProgrammer(@ModelAttribute("dd") Complaint compla, Model m) {
        comRepo.assingUpdate(compla);
        m.addAttribute("mszz", "Updated OK");
        return "complaint/adminViewCComplainDetails";
    }
    /*@RequestMapping(value = "/adminViewCComplaintViewSolved.htm", method = RequestMethod.GET)
     public String getComplaintDetailByCompNoSolved(Model m, @RequestParam(value = "cId", required = false) Integer cId){
     Complaint com = null;
     if(cId==null){
     com= new Complaint();
     }else{
     com= comRepo.read(cId);
     }
     //Complaint compl = new Complaint();
     m.addAttribute("pending", comRepo.getAllComplaintPending());
     m.addAttribute("solved",comRepo.getAllComplaintSolved());
     m.addAttribute("unsolved",comRepo.getAllComplaintUnSolved());
     m.addAttribute("detail",com);
     m.addAttribute("dd",com);
     m.addAttribute("prog",ur.getProgrammer(1));
     return "complaint/adminViewCComplaintViewSolved";
     }*/
}
