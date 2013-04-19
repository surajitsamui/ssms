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
    private String adminStatus = "P";////// P - Pending// S - Solved///  R - Return
    private String userFeedback;
    private int adminAsign;
    //private long pendingDays=((complaintDate.getTime()-complaintSolved.getTime())/(1000 * 60 * 60 * 24));
    Date programmerAssignDate;
   // private long PendingDays=(Days/(1000 * 60 * 60 * 24));

    public Date getProgrammerAssignDate() {
        return programmerAssignDate;
    }

    public void setProgrammerAssignDate(Date programmerAssignDate) {
        this.programmerAssignDate = programmerAssignDate;
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
     * @return the adminStatus
     */
    public String getAdminStatus() {
        return adminStatus;
    }

    /**
     * @param adminStatus the adminStatus to set
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

    /**
     * @return the adminAsign
     */
    public int getAdminAsign() {
        return adminAsign;
    }

    /**
     * @param adminAsign the adminAsign to set
     */
    public void setAdminAsign(int adminAsign) {
        this.adminAsign = adminAsign;
    }

    /**
     * @return the pendingDays
     */
   /* public long getPendingDays() {
        return pendingDays;
    }

    /**
     * @param pendingDays the pendingDays to set
     */
   /* public void setPendingDays(long pendingDays) {
        this.pendingDays = pendingDays;
    }*/
    
}
