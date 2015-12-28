package com.mycompany.ssms.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class ListUtilsClass
{
  public static <T> T findElement(List<T> listSrc, Object elementToFind)
  {
    for (int i = 0; i < listSrc.size(); i++) {
      if (listSrc.get(i).equals(elementToFind)) {
        return (T)listSrc.get(i);
      }
    }
    return null;
  }
  
  public static <T, K> T findElement(List<T> listSrc, String property, K value)
  {
    if (listSrc == null) {
      return null;
    }
    for (int i = 0; i < listSrc.size(); i++)
    {
      BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(listSrc.get(i));
     // K beanValue = bw.getPropertyValue(property);
//      if (value.equals(beanValue)) {
//        return (T)listSrc.get(i);
//      }
    }
    return null;
  }
  
  private static int getMethodIndex(Class<?> c, String field)
  {
    for (int i = 0; i < c.getMethods().length; i++) {
      if (c.getMethods()[i].getName().equalsIgnoreCase("get" + field)) {
        return i;
      }
    }
    throw new RuntimeException(" field " + field + " not found in class " + c.getName());
  }
  
  public static String ListToHtmlSelect(List<?> objs, String key, String value)
  {
    int k = getMethodIndex(objs.get(0).getClass(), key);
    int v = getMethodIndex(objs.get(0).getClass(), value);
    
    StringBuilder sb = new StringBuilder();
    
    sb.append("<select>");
    try
    {
      for (Object o : objs)
      {
        sb.append("<option value=\"");
        sb.append(o.getClass().getMethods()[k].invoke(o, new Object[0]));
        sb.append("\">");
        sb.append(o.getClass().getMethods()[v].invoke(o, new Object[0]));
        sb.append("</option>");
      }
    }
    catch (Exception ex)
    {
      throw new RuntimeException(ex);
    }
    sb.append("</select>");
    return sb.toString();
  }
  
  public static String ListToLOVJson(List<?> objs, String key, String value)
  {
    Map<Object, Object> values = new HashMap();
    if ((objs == null) || (objs.isEmpty()))
    {
      values.put(Integer.valueOf(-1), "No data found");
    }
    else
    {
      int k = getMethodIndex(objs.get(0).getClass(), key);
      int v = getMethodIndex(objs.get(0).getClass(), value);
      try
      {
        for (Object o : objs) {
          values.put(o.getClass().getMethods()[k].invoke(o, new Object[0]), o.getClass().getMethods()[v].invoke(o, new Object[0]));
        }
      }
      catch (Exception ex)
      {
        throw new RuntimeException(ex);
      }
    }
    return JsonHelperClass.Object2String(values);
  }
  
  public static <T> void addElement(List<T> listSrc, T obj, String key, int index)
  {
    int maxno = 0;
    int idx = 0;
    for (int i = 0; i < listSrc.size(); i++)
    {
      BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(listSrc.get(i));
      int id = ((Integer)bw.getPropertyValue(key)).intValue();
      if (id > maxno) {
        maxno = id;
      }
      if (id == index) {
        idx = i + 1;
      }
    }
    maxno++;
    BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(obj);
    bw.setPropertyValue(key, Integer.valueOf(maxno));
    if (index == -1) {
      listSrc.add(obj);
    } else {
      listSrc.add(idx, obj);
    }
  }
}
