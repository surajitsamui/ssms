package com.mycompany.ssms.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class AccountCenter extends RecordInfo{
    @Id
    private int id;
    private String description;
    @ManyToOne
    private Unit unit;
    private int nlcBranchCode;
    private int nlcBankNo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * @return the nlcBranchCode
     */
    public int getNlcBranchCode() {
        return nlcBranchCode;
    }

    /**
     * @param nlcBranchCode the nlcBranchCode to set
     */
    public void setNlcBranchCode(int nlcBranchCode) {
        this.nlcBranchCode = nlcBranchCode;
    }

    /**
     * @return the nlcBankNo
     */
    public int getNlcBankNo() {
        return nlcBankNo;
    }

    /**
     * @param nlcBankNo the nlcBankNo to set
     */
    public void setNlcBankNo(int nlcBankNo) {
        this.nlcBankNo = nlcBankNo;
    }
    
}
