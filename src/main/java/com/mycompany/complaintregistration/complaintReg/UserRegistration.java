/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg;

import java.util.Date;

/**
 *
 * @author mmc-pc1
 */
public class UserRegistration {

    private int userId;
    private String initial;
    private String name;
    private String add;
    private String mobile;
    private String eMail;
    private String desiredPassWord;
    private String tempPassWord;
    private int adminUser = 1; //0 = User, 1 = Programmer, 2= Admin

    public int getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(int adminUser) {
        this.adminUser = adminUser;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the initial
     */
    public String getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(String initial) {
        this.initial = initial;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the add
     */
    public String getAdd() {
        return add;
    }

    /**
     * @param add the add to set
     */
    public void setAdd(String add) {
        this.add = add;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * @param eMail the eMail to set
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * @return the desiredPassWord
     */
    public String getDesiredPassWord() {
        return desiredPassWord;
    }

    /**
     * @param desiredPassWord the desiredPassWord to set
     */
    public void setDesiredPassWord(String desiredPassWord) {
        this.desiredPassWord = desiredPassWord;
    }

    /**
     * @return the tempPassWord
     */
    public String getTempPassWord() {
        return tempPassWord;
    }

    /**
     * @param tempPassWord the tempPassWord to set
     */
    public void setTempPassWord(String tempPassWord) {
        this.tempPassWord = tempPassWord;
    }
}
