package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import com.mycompany.complaintregistration.complaintReg.UserRegistration;
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
public class ProgrammerComplaintController {

    @Autowired
    ComplaintRepo comRepo;

    @RequestMapping(value = "/programmerViewComplain.htm", method = RequestMethod.GET )
    public String getProgComplaint(Model m, HttpSession sess) {
        UserRegistration id= (UserRegistration) sess.getAttribute("user");
        Complaint complaint = new Complaint();
        m.addAttribute("complaint", comRepo.getAllComplaintAgainstProgrammer(id.getUserId()));
        //Complaint comId= comRepo.read(cmId);
        //n.addAttribute("detail",comId);

        return "complaint/programmerViewComplain";
    }
    @RequestMapping(value = "/programmerViewComplainDetail.htm", method = RequestMethod.GET)
    public String getComplaintDetailByCompNoProgrammer(Model m,Model n,Model k, @RequestParam(value = "cmId", required = false) Integer cmId,HttpSession sess){
       Complaint pComp=null;
      if(cmId==null){
          pComp=new Complaint();
      }else{
         pComp= comRepo.read(cmId);
      }
        n.addAttribute("detail",pComp);
        UserRegistration id= (UserRegistration) sess.getAttribute("user");
        Complaint complaint = new Complaint();
        m.addAttribute("complaint", comRepo.getAllComplaintAgainstProgrammer(id.getUserId()));
        Complaint comm= new Complaint();
        k.addAttribute("setval",comm);
        return "complaint/programmerViewComplainDetail";
    }

    @RequestMapping(value = "/programmerViewComplainDetail.htm", method = RequestMethod.POST)
    public String setStatus(@ModelAttribute ("setval") Complaint co,Model l){
        comRepo.statusUpdate(co);
        l.addAttribute("msz","Updated");
        return "complaint/programmerViewComplain";
    }
    
}
