package com.mycompany.ssms.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.data.annotation.Transient;

/**
 *
 * @author Sudipta
 */
@Entity
public class Documents extends RecordInfo{

    @Id
    private int docId;
    private String shortDesc;
    private String fullDesc;    
    @Transient
    private boolean workflowRequired;

   
  /**
     * @return the docId
     */
    public long getDocId() {
        return docId;
    }

    /**
     * @param docId the docId to set
     */
    public void setDocId(int docId) {
        this.docId = docId;
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
     * @return the fullDesc
     */
    public String getFullDesc() {
        return fullDesc;
    }

    /**
     * @param fullDesc the fullDesc to set
     */
    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
    }
   
    /**
     * @return the workflowRequired
     */
    public boolean isWorkflowRequired() {
        return workflowRequired;
    }
    
    @Override
    public String toString() {
        return "Documents{" + "docId=" + getDocId() + ", shortDesc=" + getShortDesc() + ", fullDesc=" + getFullDesc()+"}";
    }

}
