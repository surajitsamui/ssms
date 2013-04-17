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
public class Complaint {

    private int complaintNo;
    private String complaintDesc;
    private int complaintUserId;
    private String complaintType;
    private Date complaintDate = new Date();
    private Date complaintSolved;
    private String adminStatus = "Pending";
    private String userFeedback;
    private int adminAsign;

    public int getAdminAsign() {
        return adminAsign;
    }

    public void setAdminAsign(int adminAsign) {
        this.adminAsign = adminAsign;
    }

    /**
     * @return the complaintNo
     */
    public int getComplaintNo() {
        return complaintNo;
    }

    /**
     * @param complaintNo the complaintNo to set
     */
    public void setComplaintNo(int complaintNo) {
        this.complaintNo = complaintNo;
    }

    /**
     * @return the complaintDesc
     */
    public String getComplaintDesc() {
        return complaintDesc;
    }

    /**
     * @param complaintDesc the complaintDesc to set
     */
    public void setComplaintDesc(String complaintDesc) {
        this.complaintDesc = complaintDesc;
    }

    /**
     * @return the complaintUserId
     */
    public int getComplaintUserId() {
        return complaintUserId;
    }

    /**
     * @param complaintUserId the complaintUserId to set
     */
    public void setComplaintUserId(int complaintUserId) {
        this.complaintUserId = complaintUserId;
    }

    /**
     * @return the complaintType
     */
    public String getComplaintType() {
        return complaintType;
    }

    /**
     * @param complaintType the complaintType to set
     */
    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    /**
     * @return the complaintDate
     */
    public Date getComplaintDate() {
        return complaintDate;
    }

    /**
     * @param complaintDate the complaintDate to set
     */
    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    /**
     * @return the complaintSolved
     */
    public Date getComplaintSolved() {
        return complaintSolved;
    }

    /**
     * @param complaintSolved the complaintSolved to set
     */
    public void setComplaintSolved(Date complaintSolved) {
        this.complaintSolved = complaintSolved;
    }

    /**
     * @return the status
     */
    public String getAdminStatus() {
        return adminStatus;
    }

    /**
     * @param status the status to set
     */
    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    /**
     * @return the userFeedback
     */
    public String getUserFeedback() {
        return userFeedback;
    }

    /**
     * @param userFeedback the userFeedback to set
     */
    public void setUserFeedback(String userFeedback) {
        this.userFeedback = userFeedback;
    }
}
