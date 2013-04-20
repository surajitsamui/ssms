/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.validation;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 *
 * @author mmc-pc1
 */
public class UserRegistrationValidation {

    UserRegistrationRepo usrRepo;

    private boolean isNumber(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) >= '0' && value.charAt(i) <= '9') {
            } else {
                return false;
            }
        }
        return true;
    }

    public void validate(Errors err, UserRegistration usr) {

        if (usr.getInitial().equals("")) {
            err.rejectValue("initial", null, "Select Initial");
        }
        if (!StringUtils.hasText(usr.getAdd())) {
            err.rejectValue("add", null, "Address cannot be blank");
        }

        if (!StringUtils.hasText(usr.getMobile()) && !isNumber(usr.getMobile()) && usr.getMobile().length() < 10) {
            err.rejectValue("mobile", null, "Enter Valid Phone Number");
        }
        if (StringUtils.hasText(usr.getName())) {
            for (int i = 0; i < (usr.getName()).length(); i++) {
                if (usr.getName().charAt(i) >= '0' && usr.getName().charAt(i) <= '9') {
                    err.rejectValue("Name", null, "Enter Name Correctly");
                }
            }
        } else {
            err.rejectValue("Name", null, "Enter Name Correctly");
        }
        if (StringUtils.hasText(usr.geteMail())) {//Email
            for (int i = 0; i < usr.geteMail().length(); i++) {
                if (usr.geteMail().contains("@") && usr.geteMail().contains(".")) {
                    System.out.println("");
                } else {
                    err.rejectValue("eMail", null, "Not Valid E mail");
                }
            }
        } else {
            err.rejectValue("eMail", null, "Blank E mail");
        }

        if (!StringUtils.hasText(usr.getDesiredPassWord())) {
            err.rejectValue("desiredPassWord", null, "Blank Password!");
        } else if (usr.getDesiredPassWord().length() != 10) {
            err.rejectValue("desiredPassWord", null, " 10 Char");
        }

        if (!usr.getTempPassWord().equals(usr.getDesiredPassWord())) {//confPass
            err.rejectValue("tempPassWord", null, "PassError");
        }
    }
}
