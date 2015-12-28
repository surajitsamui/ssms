package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.Documents;
import com.mycompany.ssms.dao.DocumentsRepo;
import com.mycompany.ssms.dao.JqGridData;
import com.mycompany.ssms.dao.UserRegistration;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sudipta
 *
 */
@Controller
public class DocumentsController {

    @Autowired
    DocumentsRepo drepo; 

    @RequestMapping(value = "/docEntry.htm", method = RequestMethod.GET)
    public String setDocs(Model m) {
        m.addAttribute("docs", new Documents()); 
        return "master/docDetails";
    }

    @RequestMapping(value = "/docEntries.htm", method = RequestMethod.GET)
    public @ResponseBody
    JqGridData<Documents> getDoc() {
        List<Documents> d = drepo.getAllDocumentOrderByDocId();
        return new JqGridData(1, 1, d.size(), d);
    }

    @RequestMapping(value = "/newDocEntry.htm")
     @ResponseBody
    public String setDocEntry(@ModelAttribute("docs") Documents doc, @RequestParam int docId, @RequestParam String shortDesc, @RequestParam String fullDesc, UserRegistration um) {
        doc.setDocId(docId);
        doc.setShortDesc(shortDesc);
        doc.setFullDesc(fullDesc);
        doc.setCreatedDate(new Date());
        doc.setCreateUserId(um.getUserId());
        drepo.save(doc);
        return "_Ok_";
    }

    @RequestMapping(value = "/editDoc.htm")
    @ResponseBody
    public String EditDocs(@ModelAttribute("docs") Documents doc, @RequestParam("id") int id, UserRegistration um) {
        doc.setDocId(id);
        doc.setCreateUserId(um.getUserId());
        doc.setCreatedDate(new Date());
        drepo.save(doc);
        return "_edit_";
    }
    @RequestMapping(value="/deleteDoc.htm")
    @ResponseBody
    public void DeleteDocs(@ModelAttribute("docs") Documents doc,@RequestParam ("id") int id)
    {
        doc.setDocId(id);
        drepo.delete(id);
    }
}
