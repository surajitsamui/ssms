package com.mycompany.ssms.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Location extends RecordInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int divId;
    private String description;
    private String shortDesc;
    @ManyToOne
    private Unit unit;

    public Location(int id, int divId, String description, String shortDesc) {
        this.id = id;
        this.divId = divId;
        this.description = description;
        this.shortDesc = shortDesc;
    }

    public Location() {
    }

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
     * @return the divId
     */
    public int getDivId() {
        return divId;
    }

    /**
     * @param divId the divId to set
     */
    public void setDivId(int divId) {
        this.divId = divId;
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
}
