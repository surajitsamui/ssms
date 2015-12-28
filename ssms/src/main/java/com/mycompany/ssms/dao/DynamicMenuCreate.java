package com.mycompany.ssms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.commons.collections.map.ListOrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author Asu
 */
@Service
public class DynamicMenuCreate {

    @Autowired
    MenuRepo menuRepo;
        
    Map<Integer, Menu> urlName = new ListOrderedMap();
    Map<Integer, List<Menu>>  childMap = new ListOrderedMap();
//    public DynamicMenuCreate(MenuRepo menuRepo) {
//        this.menuRepo = menuRepo;
//        loadAllUrl();
//    }
    @Cacheable("gmenu" )
    public String getMenu(int userId) {
        System.out.println("inside menu -- loading");
        StringBuffer sb = new StringBuffer();
      //  HashMap<Integer, List<Menu>>  tmpMap = (HashMap<Integer, List<Menu>>) ((HashMap)childMap).clone();
        menuList(0, sb);
        return sb.toString();
    }


    private void loadMenuItems(Collection<Menu> list) {
        //list.stream().forEach((menu) -> 
        for(Menu menu: list){
            List<Menu> m = childMap.get(menu.getParentId());
            if (m == null) {
                m = new ArrayList<>();  
                childMap.put(menu.getParentId(), m);
            }
            m.add(menu);
        }
    }

    private void menuList(Integer menuId, StringBuffer sb) {
        List<Menu> children = childMap.get(menuId);
        if (children == null) {
            return;
        }
        sb.append("<ul class=\"sf-menu\">");
        for (Menu m : children) {
            sb.append("<li align='left'>");
            sb.append("<a href='").append(StringUtils.hasText(m.getUrl()) ? m.getUrl() : "javascript:void").append("'>");
            sb.append(m.getName());
            sb.append(m.getParentId() > 0 && (m.getUrl() == null || m.getUrl().equalsIgnoreCase("javascript:void")) ? "<span class='right-arrow'>&raquo;</span>" : "");
            sb.append("</a>");
            menuList(m.getMenuId(), sb);
            sb.append("</li>");
        }
        sb.append("</ul>");
    }

    public String getAllMenu() {
        StringBuffer sb = new StringBuffer();
//        loadMenuItems(menuRepo.findAll());
        menuListEdit(0, sb);
        return sb.toString();
    }

    private void menuListEdit(Integer menuId, StringBuffer sb) {
        List<Menu> children = childMap.get(menuId);
        if (children == null) {
            return;
        }
        sb.append("<ul class='fusheveprimet'>");
        for (Menu m : children) {
            sb.append("<li align='left'><input type='checkbox'value='");
            sb.append(m.getMenuId());
            sb.append("'/><label>");
            sb.append(m.getName());
            menuListEdit(m.getMenuId(), sb);
            sb.append("</label></li>");
        }
        sb.append("</ul>");
    }

    
    public void loadAllUrl() {
        for (Menu menu : menuRepo.getAllSorted()) {
            urlName.put(menu.getMenuId(), menu);
        }
    }

    public String getURI(final String url) {
        StringBuilder sb = new StringBuilder();
        List<String> paths = new ArrayList<String>();
        Menu m=null;
        for(Menu u:urlName.values()){
            if(url.equals(u.getUrl())){
                m=u;
                break;
               }
        }
        
        if (m != null) {
            paths.add(m.getName());
            addPath(m.getParentId(), paths);
        }
        for (int i = paths.size() - 1; i >= 0; i--) {
            sb.append(paths.get(i)).append(i == 0 ? "" : " &raquo;");
        }
        System.out.println("path::" + sb.toString());
        return sb.toString();
    }

    public void addPath(Integer parentId, List<String> paths) {
        Menu menu = urlName.get(parentId);//menuRepo.findOne(parentId);
        if (menu != null) {
            if (parentId == menu.getMenuId()) {
                paths.add(menu.getName());
                addPath(menu.getParentId(), paths);
            }
        }
    }
    
    @PostConstruct
    public void setup(){
        System.out.println("inside post construct");
        loadAllUrl();
        loadMenuItems(urlName.values());
    }
}
