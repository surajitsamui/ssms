package com.mycompany.ssms.dao;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

public class MenuValidation {
    public MenuValidation(){
    }
    public void validate(Menu m, BindingResult err)
    {
        if(!StringUtils.hasText(m.getName()))
        {
            err.rejectValue("name", null, "Name can not be blank");
        }
    }
}
