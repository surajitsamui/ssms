package com.mycompany.ssms.dao;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mmc-pc1
 */
public class ConstantsClass {
  public static final int LTE = 4;
  public static final int PTE = 1;
  public static final int GTE = 2;
  public static final int STE = 3;
  public static final Map<String, Integer> hibernateConstants = new HashMap();
  
  static
  {
    hibernateConstants.put("LTE", Integer.valueOf(4));
    hibernateConstants.put("PTE", Integer.valueOf(1));
    hibernateConstants.put("GTE", Integer.valueOf(2));
    hibernateConstants.put("STE", Integer.valueOf(3));
  }
}
