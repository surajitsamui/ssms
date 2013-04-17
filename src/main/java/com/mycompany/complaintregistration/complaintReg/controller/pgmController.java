package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.ProgrammerAnalystDetail;
import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.pgmRepo;
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
 * @author Sintu Pal
 */
@Controller
public class pgmController {

    @Autowired
    pgmRepo repo;
   

    @RequestMapping(value = "/pgmDetails.htm", method = RequestMethod.GET)
    public String getPgmDetail(@RequestParam(value = "name", required = false) String name, Model m, HttpSession session ) {
        if(session.getAttribute("user")==null){
            return "redirec:/mainLogin.htm";
        }
        UserRegistration u = (UserRegistration) session.getAttribute("user");
        ProgrammerAnalystDetail details = null;
        if (name == null) {
            details = new ProgrammerAnalystDetail();
        } else {
            details = repo.read(name);
        }
        m.addAttribute("userProgrLink",u);
           m.addAttribute("pgm", details);
         //  m.addAttribute("all", repo.read(name));
           //m.addAttribute("list", repo.getAllDetails());
           return "complaint/pgmDetails";
    }
     @RequestMapping(value = "/pgmDetails.htm", method = RequestMethod.POST)
      public String submitForm(@ModelAttribute("pgm") ProgrammerAnalystDetail details, @RequestParam(value = "name", required = false) String name, Model m, BindingResult err) {   
    
    /*   new ValidatePgm(repo).valid(err, details, (name == null));
        if (err.hasErrors()) {
            return "complaint/pgmDetails";
        }*/
        repo.save(details, (name == null));
        return "redirect:/pgmDetails.htm";
    }
}