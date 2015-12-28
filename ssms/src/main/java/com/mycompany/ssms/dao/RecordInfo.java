package com.mycompany.ssms.dao;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Sudipta
 */
@MappedSuperclass
public class RecordInfo {

    private int createUserId;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdDate;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date modifiedDate;

    /**
     * @return the createUserId
     */
    public int getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @PrePersist
    public void createDate() {
        this.createdDate = new Date();
    }

    @PreUpdate
    public void updateDate() {
        this.modifiedDate = new Date();
    }

    /**
     * @return the modifiedDate
     */
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate the modifiedDate to set
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
