/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.controller;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author mmc-pc1
 */
public abstract class UsingMap {

    @ModelAttribute("menu")
    public Map<String, String> Menu(HttpSession session) {
        UserRegistration us = (UserRegistration) session.getAttribute("user");
        Map<String, String> home = new HashMap<String, String>();
        if (us.getAdminUser() == 0) {

            home.put("New Complaint", "/userComplaint.htm");
            home.put("Home", "/userHomePage.htm");
            home.put("Status", "/userComplainStatus.htm");
        }
        if (us.getAdminUser() == 1) {
            home.put("Home", "/programmerHomePage.htm");
            home.put(("Profile Update"), "/pgmDetails.htm");
            home.put("Complaints", "/programmerViewComplain.htm");
        }
        if (us.getAdminUser() == 2) {
            //home.put("Home", "/adminHomePage.htm");
            home.put("Complaints", "/adminViewCComplainDetails.htm");
        }
        home.put("Log Out", "/index.jsp");
        return home;
    }
}
