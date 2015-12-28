
package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.FileAttachRepo;
import com.mycompany.ssms.dao.FilesAttach;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author srini
 */
@Controller
public class Attach {
    @Autowired
    FileAttachRepo repo;
    
    @RequestMapping(value="attach/{attId}",method= RequestMethod.GET)
    public void show(@PathVariable Integer attId, HttpServletResponse res) throws IOException{
        if(attId!=null){
            FilesAttach fa = repo.findOne(attId);
            if(fa!=null){                
                res.getOutputStream().write(fa.getFileData());
            }
        }        
    }
    
    @RequestMapping(value="attach.htm",method= RequestMethod.GET)
    public String show(){
        return "attach";
    }
    
    @RequestMapping(value="attach.htm",method= RequestMethod.POST)
    public String submit(FilesAttach fa, @RequestParam("dd") MultipartFile dd) throws Exception{ 
        System.out.println(dd.getName());
        fa.setFileData(dd.getBytes());
        fa.setFileName(dd.getName());
        repo.save(fa);
        return "redirect:attach/"+fa.getAttId();
    }
}
