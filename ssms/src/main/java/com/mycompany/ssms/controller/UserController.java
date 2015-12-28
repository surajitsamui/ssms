/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.UserRegistration;
import com.mycompany.ssms.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author mmc-pc1
 */
@Controller
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/user/user.htm", method = RequestMethod.GET)
    public String showUserget(@RequestParam(required = false, value = "userId") Integer userId, Model m) {
        m.addAttribute("user", userId==null?new UserRegistration():userRepo.findOne(userId));
        return "user";
    }

    @RequestMapping(value = "/user/user.htm", method = RequestMethod.POST)
    public String showUserDetails(@ModelAttribute("user") UserRegistration user) {
        userRepo.save(user);
        return "redirect:/user/" + user.getUserId();
    }

}
