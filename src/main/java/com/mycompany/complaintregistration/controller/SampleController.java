package com.mycompany.complaintregistration.controller;

import com.mycompany.complaintregistration.dao.SampleDao;
import com.mycompany.complaintregistration.dao.Vendor;
import com.mycompany.complaintregistration.dao.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srini
 */
@Controller
public class SampleController {

    @Autowired
    SampleDao dc;
    
    @Autowired            
    VendorRepository venRepo;

    @RequestMapping(value = "/home.htm")
    public String showHome(Model m) {
        m.addAttribute("dataBaseTime", dc.getDataBaseTime());
        return "sample";

    }

//    @RequestMapping(value = "/vendor/{venId}", method = RequestMethod.PUT)
//    public  @ResponseBody String showItemDescription(@PathVariable int venId, Model m) {
//        Vendor v = venRepo.findOne(venId);
//        if(v==null){
//            throw new RuntimeException("Vendor Not Found");
//        }        
//        return v.getName();
//    }
//    
   @RequestMapping(value = "/vendor/{venId}",method= RequestMethod.GET)
    public   String showItemDescription(@PathVariable int venId, Model m) {
        Vendor v = venRepo.findOne(venId);
        if(v==null){
            v = new Vendor();
           
        }  
         m.addAttribute("ven", v);
        return "vendor";
    }
    
    
    @RequestMapping(value = "/vendor/vendor.htm", method = RequestMethod.POST)
    public String showItemDescription1(@ModelAttribute Vendor v) {
       venRepo.save(v);
       return "redirect:/vendor/"+v.getCode();
    }
    
}
