package com.mycompany.ssms.dao;
/**
 *
 * @author mmc-pc1
 */
import java.util.HashMap;
import java.util.Map;

public class HibernateUtils {

    public static Map<Integer, String> getResponseType() {
        Map<Integer, String> map = new HashMap();
        map.put(Integer.valueOf(3), "Agreed with details");
        map.put(Integer.valueOf(2), "Text Entry");
        map.put(Integer.valueOf(1), "Agreed/Deviation");
        map.put(Integer.valueOf(0), "Select Response Type");
        return map;
    }
}
