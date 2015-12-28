package com.mycompany.ssms.controller;
import com.mycompany.ssms.dao.JqGridData;
import com.mycompany.ssms.dao.ListUtilsClass;
import com.mycompany.ssms.dao.Tender;
import com.mycompany.ssms.dao.TenderRepo;
import com.mycompany.ssms.dao.UserRegistration;
import com.mycompany.ssms.dao.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mmc-pc1
 */
@Controller
public class LoginAllUser {

    @Autowired
    UserRepository urp;
    
    @Autowired
    TenderRepo tRepo;

    @RequestMapping(value = "/mainLogin.htm", method = RequestMethod.GET) 
    public String getLogin(Model m) {
        UserRegistration log = new UserRegistration();
     //   m.addAttribute("dropDownValue", ListUtilsClass.ListToLOVJson(tRepo.findAll(), "tenderId", "description"));
        m.addAttribute("login", log);
        return "complaint/mainLogin";
    }
  

    @RequestMapping(value = "/admin/updatetender.htm")
    @ResponseBody
    public String updateExistTenderModel(@ModelAttribute Tender tender, UserRegistration uo) {
        tRepo.save(tender);
        return "---update---";
    }

    @RequestMapping(value = "/addtender.htm")
    @ResponseBody
    public String addNewTenderModel(@ModelAttribute Tender tender, UserRegistration uo) {
        tRepo.save(tender);
        return "---Add---";
    }

    @RequestMapping(value = "/deletetender.htm")
    @ResponseBody
    public String deleteTenderModel(@RequestParam("id") int id) {
        tRepo.delete(id);
        return "---delete---";
    }

    @RequestMapping(value = "/tenderGridlink.htm", method = RequestMethod.GET)
    public @ResponseBody 
    JqGridData<Tender> getLocationGrid(JqGridData jd) {
        Integer rowNos = Integer.parseInt((String) jd.getRows().get(0));
        Integer pageNo = jd.getPage();
        Page<Tender> tenders = null;
        if (!StringUtils.hasText(jd.getSearchString())) {
            tenders = tRepo.findAll(new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
        } else {
            String searchString = jd.getSearchString().trim();
            if (jd.getSearchField().equalsIgnoreCase("description") || jd.getSearchField().equalsIgnoreCase("shortDesc")) {
                if (jd.getSearchOper().equalsIgnoreCase("bw")) {
                    tenders = tRepo.findByDescriptionOrShortDescIgnoreCaseLike(searchString + "%", searchString + "%", new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("cn")) {
                    tenders = tRepo.findByDescriptionOrShortDescIgnoreCaseLike("%" + searchString + "%", "%" + searchString + "%", new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("eq")) {
                    tenders = tRepo.findByDescriptionOrShortDescIgnoreCaseLike(searchString, searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ew")) {
                    tenders = tRepo.findByDescriptionOrShortDescIgnoreCaseLike("%" + searchString, "%" + searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ne")) {
                    tenders = tRepo.findByDescriptionOrShortDescIgnoreCaseNotLike(searchString, searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                }
            } 
        }
        return new JqGridData<Tender>(tenders);
    }
    
    @RequestMapping(value = "/tenderGrid.htm", method = RequestMethod.GET)
    public @ResponseBody JqGridData<Tender> getRoleGrid(@RequestParam("page") Integer pageNo, @RequestParam("rows") Integer rowNos) {
        List<Tender> tender = tRepo.findAll(sortByTenderIdAsc());  
        if (rowNos == null || rowNos == 0) {
            rowNos = 10;
        }
        int totalPages = tRepo.findAll().size() / rowNos;
        if (tRepo.findAll().size() % rowNos > 0) {
            totalPages++;
        }
        return new JqGridData<Tender>(totalPages, pageNo, tender.size(), gridValueByPage(pageNo, rowNos));
    }
     private Sort sortByTenderIdAsc() {
        return new Sort(Sort.Direction.ASC, "tenderId");
    }

    List<Tender> gridValueByPage(int pageNo, int rowNos) {
        pageNo = pageNo - 1;
        List<Tender> unitPage = new ArrayList<Tender>(); 
        int listValueCreate = pageNo * rowNos;
        List<Tender> models = tRepo.findAll(); 
        for (int i = listValueCreate; i < models.size() && i < listValueCreate + rowNos; i++) {
            unitPage.add(models.get(i));
        }
        return unitPage;
    }
    @RequestMapping(value = "/mainLogin.htm", method = RequestMethod.POST)
    public String matchLogin(@ModelAttribute("login") UserRegistration uu, BindingResult e, Model o, HttpSession session) {
        try {
            UserRegistration ur = urp.findOne(uu.getUserId());
            if (!ur.getDesiredPassWord().equals(uu.getDesiredPassWord())) {
                e.reject(null, "Invalid Login  ");
                o.addAttribute("error", "Login Information Invalid");
                return "complaint/mainLogin";
            }
            session.setAttribute("user", ur);
            String path = null;
            switch(ur.getAdminUser()) {
                case 0:
                    path = "redirect:/userHomePage.htm";
                    break;
                case 1:
                    path = "redirect:/programmerHomePage.htm";
                    break;
                case 2:
                    path = "redirect:/adminViewCComplainDetails.htm";
                    break;
                default:
                    throw new RuntimeException("categor not found");
            }
            return path;
        } catch (EmptyResultDataAccessException dataAccessException) {
            o.addAttribute("error", "Invalid Login Information ");
            return "complaint/mainLogin";
        }
    }
    
    @RequestMapping(value="/logout.htm")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/mainLogin.htm";
    }
}