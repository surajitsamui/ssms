package com.mycompany.complaintregistration.complaintReg.validation;

import com.mycompany.complaintregistration.complaintReg.ProgrammerAnalystDetail;
import com.mycompany.complaintregistration.complaintReg.repoDAO.pgmRepo;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 *
 * @author Sintu Pal
 */
public class ValidatePgm {
    pgmRepo pgmRep;

    public ValidatePgm(pgmRepo pgmRep) {
        this.pgmRep = pgmRep;
    }
    public void valid(Errors err, ProgrammerAnalystDetail pad, boolean add) {
    
        if(!StringUtils.hasText(pad.getProgrammerName())){
        
        err.rejectValue("ProgrammerName", null, "name cannot be blank");
        }else {
            try {
                pgmRep.read(pad.getProgrammerName());
                if (add) {
                    err.rejectValue("ProgrammerName", null, "name already exists");
                }
            } catch (Exception e) {
                if (!add) {
                    err.rejectValue("ProgrammerName", null, "name does not exists");
                }
            }
        }
    if(!StringUtils.hasText(pad.getProgrammerSpecl())){
    
    err.rejectValue("ProgrammerSpecl", null, "specialization cannot be blank");
   }
    if(pad.getProgrammerExperience()==0){
    
    err.rejectValue("ProgrammerExperience", null, "Experience cannot be blank");
    
    }
      if (StringUtils.hasText(pad.getProgrammerMobileNo())) {
            for (int i = 0; i < pad.getProgrammerMobileNo().length(); i++) {
                if (pad.getProgrammerMobileNo().charAt(i) >= '0' && pad.getProgrammerMobileNo().charAt(i) <= '9' && pad.getProgrammerMobileNo().length() == 10) {
                    System.out.println();
                } else {
                    err.rejectValue("ProgrammerMobileNo", null, "Enter Valid Phone Number");
                }
            }
        } else {
            err.rejectValue("ProgrammerMobileNo", null, "Enter Valid Phone Number");
        }
     if (StringUtils.hasText(pad.getProgrammerEmailId())) {//Email
            for (int i = 0; i < pad.getProgrammerEmailId().length(); i++) {
                if (pad.getProgrammerEmailId().contains("@") && pad.getProgrammerEmailId().contains(".")) {
                    
                } else {
                    err.rejectValue("ProgrammerEmailId", null, "Not Valid E mail");
                }
            }
        }else {
                    err.rejectValue("ProgrammerEmailId", null, "Blank E mail");
                }
    
    }
}
