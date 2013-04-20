package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
import com.mycompany.complaintregistration.complaintReg.validation.UserRegistrationValidation;
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
 * @author mmc-pc1
 */
@Controller
public class UserRegistrationController extends UsingMap {

    @Autowired
    UserRegistrationRepo userRepo;

    @RequestMapping(value = "/userRegistration.htm", method = RequestMethod.GET)
    public String getUserRegForm(@RequestParam(value = "userId", required = false) Integer userId, Model m) {
        UserRegistration ur = null;
        if (userId == null) {
            ur = new UserRegistration();
        } else {
            ur = userRepo.read(userId);
        }
        m.addAttribute("userForm", ur);
        m.addAttribute("userList", userRepo.getUserDetal());
        return "complaint/userRegistration";
    }

    @RequestMapping(value = "/userRegistration.htm", method = RequestMethod.POST)
    public String saveUserRegform(@ModelAttribute("userForm") UserRegistration ureg, @RequestParam(value = "userId", defaultValue = "0") Integer userId, Model m, BindingResult err) {
        new UserRegistrationValidation().validate(err, ureg);
        if (err.hasErrors()) {
            return "complaint/userRegistration";
        }
        userRepo.saveInsert(ureg);
        m.addAttribute("userCountShow", "Your System Generated User Id is " + ureg.getUserId());
        return "complaint/userRegistration";
    }
}
