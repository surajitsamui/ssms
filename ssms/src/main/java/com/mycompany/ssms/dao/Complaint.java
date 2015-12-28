package com.mycompany.ssms.dao;

import java.util.Date;
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
@Table(name = "T_ADM_COMPLAIN")
public class Complaint {
    @Id
    @GeneratedValue
    @Column(name = "nu_complain_no")
    private int complaintNo;
    @Column(name = "vc_complain_desc")
    private String complaintDesc;
    @Column(name = "NU_COMPLAIN_USER_ID")
    private int complaintUserId;
    @Column(name = "ch_complain_type")
    private String complaintType;
    @Column(name = "DT_COMPLAIN_DATE")
    private Date complaintDate = new Date();
    @Column(name = "DT_SOLVE_DATE")
    private Date complaintSolved;
    @Column(name = "CH_COMPLAIN_STATUS")
    private String adminStatus = "P";////// P - Pending// S - Solved///  R - Return
    @Column(name = "vc_user_feedback")
    private String userFeedback;
    @Column(name = "nu_assign_type")
    private int adminAsign;
    @Column(name = "dt_assign_date")
    Date programmerAssignDate;

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
}
