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
@Table(name = "T_ADM_PROGRAMMER")
public class ProgrammerAnalystDetail {
    @Id
    @GeneratedValue
    @Column(name = "NU_PROGRAMMER_ID")
    private Long ProgrammerId;
    @Column(name = "VC_NAME")
    private String ProgrammerName;
    @Column(name = "VC_PROG_TYPE")
    private String ProgrammerSpecl;
    @Column(name = "NU_EXPERIENCE")
    private int ProgrammerExperience;
    @Column(name = "NU_MOB_NO")
    private String ProgrammerMobileNo;
    @Column(name = "VC_EMAIL")
    private String ProgrammerEmailId;
    

    /**
     * @return the ProgrammerName
     */
    public String getProgrammerName() {
        return ProgrammerName;
    }

    /**
     * @param ProgrammerName the ProgrammerName to set
     */
    public void setProgrammerName(String ProgrammerName) {
        this.ProgrammerName = ProgrammerName;
    }

    /**
     * @return the ProgrammerSpecl
     */
    public String getProgrammerSpecl() {
        return ProgrammerSpecl;
    }

    /**
     * @param ProgrammerSpecl the ProgrammerSpecl to set
     */
    public void setProgrammerSpecl(String ProgrammerSpecl) {
        this.ProgrammerSpecl = ProgrammerSpecl;
    }

    /**
     * @return the ProgrammerExperience
     */
    public int getProgrammerExperience() {
        return ProgrammerExperience;
    }

    /**
     * @param ProgrammerExperience the ProgrammerExperience to set
     */
    public void setProgrammerExperience(int ProgrammerExperience) {
        this.ProgrammerExperience = ProgrammerExperience;
    }

    /**
     * @return the ProgrammerMobileNo
     */
    public String getProgrammerMobileNo() {
        return ProgrammerMobileNo;
    }

    /**
     * @param ProgrammerMobileNo the ProgrammerMobileNo to set
     */
    public void setProgrammerMobileNo(String ProgrammerMobileNo) {
        this.ProgrammerMobileNo = ProgrammerMobileNo;
    }

    /**
     * @return the ProgrammerEmailId
     */
    public String getProgrammerEmailId() {
        return ProgrammerEmailId;
    }

    /**
     * @param ProgrammerEmailId the ProgrammerEmailId to set
     */
    public void setProgrammerEmailId(String ProgrammerEmailId) {
        this.ProgrammerEmailId = ProgrammerEmailId;
    }

    /**
     * @return the ProgrammerId
     */
    public Long getProgrammerId() {
        return ProgrammerId;
    }

    /**
     * @param ProgrammerId the ProgrammerId to set
     */
    public void setProgrammerId(Long ProgrammerId) {
        this.ProgrammerId = ProgrammerId;
    }
}
