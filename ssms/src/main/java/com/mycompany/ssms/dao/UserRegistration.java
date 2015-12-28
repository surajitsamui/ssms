/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ssms.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mmc-pc1
 */

@Entity
@Table(name = "T_ADM_USER_DETAILS")
public class UserRegistration {
    @Id
    @GeneratedValue
    @Column(name = "NU_USER_ID")
    private int userId;
    @Column(name = "VC_INITIAL")
    private String initial;
    @Column(name = "VC_USER_NAME")
    private String name;
    @Column(name = "VC_ADDRESS")
    private String add;
    @Column(name = "NU_MOBILE_ID")
    private String mobile;
    @Column(name = "VC_EMAIL")
    private String eMail;
    @Column(name = "VC_DESIRED_PASS")
    private String desiredPassWord;
    @Column(name = "VC_TEMP_PASS")
    private String tempPassWord;
    @Column(name = "NU_USER_TYPE")
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
