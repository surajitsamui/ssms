package com.mycompany.ssms.controller;
import com.mycompany.ssms.dao.AccountCenter;
import com.mycompany.ssms.dao.AccountCenterRepo;
import com.mycompany.ssms.dao.JqGridData;
import com.mycompany.ssms.dao.ListUtilsClass;
import com.mycompany.ssms.dao.UnitRepo;
import com.mycompany.ssms.dao.UserRegistration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class AccountController {

    @Autowired
    private AccountCenterRepo accountCenterRepo;
    @Autowired
    UnitRepo unitRepo;

    @RequestMapping(value = "/admin/account.htm", method = RequestMethod.GET)
    public String unitGet(Model m) {
        m.addAttribute("dropDownValue", ListUtilsClass.ListToLOVJson(unitRepo.findAll(), "id", "description"));
        return "admin/account";
    }

    @RequestMapping(value = "/admin/accountGrid.htm", method = RequestMethod.GET)
    public @ResponseBody
    JqGridData<AccountCenter> getRoleGrid(@RequestParam("page") Integer pageNo, @RequestParam("rows") Integer rowNos) {
        List<AccountCenter> unit = accountCenterRepo.findAll(sortByUnitIdAsc());
        if (rowNos == null || rowNos == 0) {
            rowNos = 10;
        }
        int totalPages = accountCenterRepo.findAll().size() / rowNos;
        if (accountCenterRepo.findAll().size() % rowNos > 0) {
            totalPages++;
        }
        return new JqGridData<AccountCenter>(totalPages, pageNo, unit.size(), gridValueByPage(pageNo, rowNos));
    }

    private Sort sortByUnitIdAsc() {
        return new Sort(Sort.Direction.ASC, "unitId");
    }

    List<AccountCenter> gridValueByPage(int pageNo, int rowNos) {
        pageNo = pageNo - 1;
        List<AccountCenter> unitPage = new ArrayList<AccountCenter>();
        int listValueCreate = pageNo * rowNos;
        List<AccountCenter> models = accountCenterRepo.findAll();
        for (int i = listValueCreate; i < models.size() && i < listValueCreate + rowNos; i++) {
            unitPage.add(models.get(i));
        }
        return unitPage;
    }

    @RequestMapping(value = "/admin/updateaccount.htm")
    @ResponseBody
    public String updateExistAccountCenter(@ModelAttribute AccountCenter accountCenter, UserRegistration uo) {
        accountCenter.setCreateUserId(uo.getUserId());
        accountCenterRepo.save(accountCenter);
        return "---update---";
    }

    @RequestMapping(value = "/admin/addaccount.htm")
    @ResponseBody
    public String addNewAccountCenter(@ModelAttribute AccountCenter accountCenter, UserRegistration uo) {
        accountCenter.setCreateUserId(uo.getUserId());
        accountCenterRepo.save(accountCenter);
        return "---Add---";
    }

    @RequestMapping(value = "/admin/deleteaccount.htm")
    @ResponseBody
    public String deleteAccountCenter(@RequestParam("id") int id) {
        accountCenterRepo.delete(id);
        return "---delete---";
    }
}
