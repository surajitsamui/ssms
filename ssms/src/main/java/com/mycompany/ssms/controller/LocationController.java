package com.mycompany.ssms.controller;

import com.mycompany.ssms.dao.JqGridData;
import com.mycompany.ssms.dao.ListUtilsClass;
import com.mycompany.ssms.dao.Location;
import com.mycompany.ssms.dao.LocationRepo;
import com.mycompany.ssms.dao.UnitRepo;
import com.mycompany.ssms.dao.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class LocationController {

    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private UnitRepo unitRepo;

    @RequestMapping(value = "/admin/location.htm", method = RequestMethod.GET)
    public String unitGet(Model m) {
        m.addAttribute("dropDownValue", ListUtilsClass.ListToLOVJson(unitRepo.findAll(), "id", "description"));
        return "admin/location";
    }

    @RequestMapping(value = "/admin/updatelocation.htm")
    @ResponseBody
    public String updateExistLocationModel(@ModelAttribute Location location, UserRegistration uo) {
        location.setCreateUserId(uo.getUserId());
        locationRepo.save(location);
        return "---update---";
    }

    @RequestMapping(value = "/admin/addlocation.htm")
    @ResponseBody
    public String addNewLocationModel(@ModelAttribute Location location, UserRegistration uo) {
        location.setCreateUserId(uo.getUserId());
        locationRepo.save(location);
        return "---Add---";
    }

    @RequestMapping(value = "/admin/deletelocation.htm")
    @ResponseBody
    public String deleteLocationModel(@RequestParam("id") int id) {
        locationRepo.delete(id);
        return "---delete---";
    }

    @RequestMapping(value = "/admin/locationGrid.htm", method = RequestMethod.GET)
    public @ResponseBody
    JqGridData<Location> getLocationGrid(JqGridData jd) {
        Integer rowNos = Integer.parseInt((String) jd.getRows().get(0));
        Integer pageNo = jd.getPage();
        Page<Location> locations = null;
        if (!StringUtils.hasText(jd.getSearchString())) {
            locations = locationRepo.findAll(new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
        } else {
            String searchString = jd.getSearchString().trim();
            if (jd.getSearchField().equalsIgnoreCase("description") || jd.getSearchField().equalsIgnoreCase("shortDesc")) {
                if (jd.getSearchOper().equalsIgnoreCase("bw")) {
                    locations = locationRepo.findByDescriptionOrShortDescIgnoreCaseLike(searchString + "%", searchString + "%", new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("cn")) {
                    locations = locationRepo.findByDescriptionOrShortDescIgnoreCaseLike("%" + searchString + "%", "%" + searchString + "%", new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("eq")) {
                    locations = locationRepo.findByDescriptionOrShortDescIgnoreCaseLike(searchString, searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ew")) {
                    locations = locationRepo.findByDescriptionOrShortDescIgnoreCaseLike("%" + searchString, "%" + searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                } else if (jd.getSearchOper().equalsIgnoreCase("ne")) {
                    locations = locationRepo.findByDescriptionOrShortDescIgnoreCaseNotLike(searchString, searchString, new PageRequest(pageNo - 1, rowNos, Sort.Direction.ASC, "shortDesc"));
                }
            }
        }
        return new JqGridData<Location>(locations);
    }
}
 