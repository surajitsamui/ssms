/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ssms.dao;

import java.sql.Clob;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author mmc-pc1
 */
public class ClobHelperClass {

    public static String ClobToString(Clob c) {
        try {
            return IOUtils.toString(c.getAsciiStream());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
