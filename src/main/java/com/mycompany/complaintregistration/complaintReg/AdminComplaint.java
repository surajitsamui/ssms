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
public class AdminComplaint {
    private int complaintNo;
    private Date adminToPa;
    private Date paToAdmin;
    private String paStatus;

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
     * @return the adminToPa
     */
    public Date getAdminToPa() {
        return adminToPa;
    }

    /**
     * @param adminToPa the adminToPa to set
     */
    public void setAdminToPa(Date adminToPa) {
        this.adminToPa = adminToPa;
    }

    /**
     * @return the paToAdmin
     */
    public Date getPaToAdmin() {
        return paToAdmin;
    }

    /**
     * @param paToAdmin the paToAdmin to set
     */
    public void setPaToAdmin(Date paToAdmin) {
        this.paToAdmin = paToAdmin;
    }

    /**
     * @return the paStatus
     */
    public String getPaStatus() {
        return paStatus;
    }

    /**
     * @param paStatus the paStatus to set
     */
    public void setPaStatus(String paStatus) {
        this.paStatus = paStatus;
    }

}
