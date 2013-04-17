
package com.mycompany.complaintregistration.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 *
 * @author srini
 */
@Entity

public class FilesAttach {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int attId;
    private String fileName;
    @Lob
    private byte[] fileData;

    /**
     * @return the attId
     */
    public int getAttId() {
        return attId;
    }

    /**
     * @param attId the attId to set
     */
    public void setAttId(int attId) {
        this.attId = attId;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileData
     */
    public byte[] getFileData() {
        return fileData;
    }

    /**
     * @param fileData the fileData to set
     */
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    
}
