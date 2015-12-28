package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.DynamicMenuCreate;
import com.mycompany.ssms.dao.JqGridData;
import com.mycompany.ssms.dao.ListUtilsClass;
import com.mycompany.ssms.dao.Menu;
import com.mycompany.ssms.dao.MenuRepo;
import com.mycompany.ssms.dao.MenuValidation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class MenuController {

    @Autowired
    MenuRepo menuRepo;
    @Autowired
    DynamicMenuCreate dmenu;

    @RequestMapping(value = "/admin/menu.htm", method = RequestMethod.GET)
    public String menuGet(Model m) {
        m.addAttribute("menu", new Menu());
        m.addAttribute("menus", ListUtilsClass.ListToLOVJson(menuRepo.findAll(), "menuId", "name"));
        m.addAttribute("menuList", dmenu.getAllMenu());
        return "admin/menu";
    }

    @RequestMapping(value = "/admin/menu.htm", method = RequestMethod.POST)
    @Transactional
    public String menuPost(@ModelAttribute("menu") Menu menu, Model m, BindingResult err) {
        new MenuValidation().validate(menu, err); 
        if (err.hasErrors()) {
            return "admin/menu";
        } else {
            menuRepo.save(menu);
            return "redirect:/admin/menu.htm";
        }
    }

    @ModelAttribute("parentIdLists")
    public List<Menu> getAllParentId() {
        return menuRepo.getAllParentId();
    }

    @RequestMapping(value = "/admin/allmenu.htm", method = RequestMethod.GET)
    public @ResponseBody
    JqGridData<Menu> getMenuGrid(JqGridData jd) {
        Integer rowNos = Integer.parseInt((String) jd.getRows().get(0));
        Integer pageNo = jd.getPage();
        Page<Menu> menu = null;
        if (!StringUtils.hasText(jd.getSearchString())) {
            menu = menuRepo.findAll(new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
        } else {
            String searchString = jd.getSearchString().trim();
            if (jd.getSearchField().equalsIgnoreCase("name")) {
                if (jd.getSearchOper().equalsIgnoreCase("bw")) {
                    menu = menuRepo.findByNameIgnoreCaseLike(searchString + "%",new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
                } else if (jd.getSearchOper().equalsIgnoreCase("cn")) {
                    menu = menuRepo.findByNameIgnoreCaseLike("%" + searchString + "%",  new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
                } else if (jd.getSearchOper().equalsIgnoreCase("eq")) {
                    menu = menuRepo.findByNameIgnoreCaseLike(searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ew")) {
                    menu = menuRepo.findByNameIgnoreCaseLike("%" + searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ne")) {
                    menu = menuRepo.findByNameIgnoreCaseNotLike(searchString,  new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "name"));
                }
            }
        }
        return new JqGridData<Menu>(menu);
    }

    @RequestMapping(value = "/admin/updatemenu.htm")
    @ResponseBody
    @Transactional
    public String updateExistMenu(@ModelAttribute Menu menu, @RequestParam("menuId") int menuId) {
        menu.setMenuId(menuId);
        menuRepo.save(menu);
        return "---update---";
    }

    @RequestMapping(value = "/admin/addmenu.htm")
    @ResponseBody 
    @Transactional
    public String addNewMenu(@ModelAttribute Menu menu) {
        menuRepo.save(menu);
        return "---Add---";
    }

    @RequestMapping(value = "/admin/deletemenu.htm")
    @ResponseBody
    @Transactional
    public String deleteMenu(@RequestParam("id") int id) {
        menuRepo.delete(id);
        return "---delete---";
    }
}
