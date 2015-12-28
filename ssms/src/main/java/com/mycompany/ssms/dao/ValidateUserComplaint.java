package com.mycompany.ssms.dao;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 *
 * @author Samim
 */
public class ValidateUserComplaint {

    ComplaintRepo complrepo;

    public ValidateUserComplaint(ComplaintRepo complrepo) {
        this.complrepo = complrepo;
    }

    public void validate(Errors err, Complaint complaint) {
        if (complaint.getComplaintType().equals("")) {
            err.rejectValue("complaintType", null, "Select Type");
        }
        if (!StringUtils.hasText(complaint.getComplaintDesc())) {
            err.rejectValue("complaintDesc", null, "Please Give Definite Information");
        }
    }
}
