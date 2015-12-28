package com.mycompany.ssms.dao;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author surajit
 */
@Entity
public class Tender extends RecordInfo {

    @Id
    private int tenderId;
    private String tenderNo;
    private String tenderType;
    private Date closingDate;
    private Date openingDate;
    private String description;
    private String shortDesc;

    /**
     * @return the tenderId
     */
    public int getTenderId() {
        return tenderId;
    }

    /**
     * @param tenderId the tenderId to set
     */
    public void setTenderId(int tenderId) {
        this.tenderId = tenderId;
    }

    /**
     * @return the tenderNo
     */
    public String getTenderNo() {
        return tenderNo;
    }

    /**
     * @param tenderNo the tenderNo to set
     */
    public void setTenderNo(String tenderNo) {
        this.tenderNo = tenderNo;
    }

    /**
     * @return the tenderType
     */
    public String getTenderType() {
        return tenderType;
    }

    /**
     * @param tenderType the tenderType to set
     */
    public void setTenderType(String tenderType) {
        this.tenderType = tenderType;
    }

    /**
     * @return the closingDate
     */
    public Date getClosingDate() {
        return closingDate;
    }

    /**
     * @param closingDate the closingDate to set
     */
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * @return the openingDate
     */
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     * @param openingDate the openingDate to set
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public static Map<Integer, String> tenderOption() {

        Map<Integer, String> type = new HashMap<Integer, String>();
        type.put(1, "OPEN");
        type.put(2, "LIMITED");
        return type;

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
     * @return the shortDesc
     */
    public String getShortDesc() {
        return shortDesc;
    }

    /**
     * @param shortDesc the shortDesc to set
     */
    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
