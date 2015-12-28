package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.UserRegistration;
import com.mycompany.ssms.dao.UserRegistrationValidation;
import com.mycompany.ssms.dao.UserRepository;
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
 * @author Ratul
 */
@Controller
public class UserRegistrationController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/userRegistration.htm", method = RequestMethod.GET)
    public String getUserRegForm(@RequestParam(value = "userId", required = false) Integer userId, Model m) {
        UserRegistration ur = null;
        if (userId == null) {
            ur = new UserRegistration();
        } else {
            ur = userRepo.findOne(userId);
        }
        m.addAttribute("userForm", ur);
        m.addAttribute("userList", userRepo.findAll());
        return "complaint/userRegistration";
    }

    @RequestMapping(value = "/userRegistration.htm", method = RequestMethod.POST)
    public String saveUserRegform(@ModelAttribute("userForm") UserRegistration ureg, @RequestParam(value = "userId", defaultValue = "0") Integer userId, Model m, BindingResult err) {
        new UserRegistrationValidation().validate(err, ureg);
        if (err.hasErrors()) {
            return "complaint/userRegistration";
        }
        userRepo.save(ureg);
        m.addAttribute("userCountShow", "Your System Generated User Id is " + userRepo.findAll().size() + 1);
        return "complaint/userRegistration";
    }
}
