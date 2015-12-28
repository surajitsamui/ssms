package com.mycompany.ssms.dao;

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
        if (!StringUtils.hasText(pad.getProgrammerSpecl())) {
            err.rejectValue("ProgrammerSpecl", null, "specialization cannot be blank");
        }
        if (pad.getProgrammerExperience() == 0) {
            err.rejectValue("ProgrammerExperience", null, "Experience cannot be blank");
        }
        if (StringUtils.hasText(pad.getProgrammerEmailId())) {//Email
            for (int i = 0; i < pad.getProgrammerEmailId().length(); i++) {
                if (pad.getProgrammerEmailId().contains("@") && pad.getProgrammerEmailId().contains(".")) {
                } else {
                    err.rejectValue("ProgrammerEmailId", null, "Not Valid E mail");
                }
            }
        } else {
            err.rejectValue("ProgrammerEmailId", null, "Blank E mail");
        }
    }
}
