package com.mycompany.ssms.dao;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ratul
 */
@Entity
public class Role extends RecordInfo {

    @Id
    private Long roleId;
    private String description;
    

    /**
     * @return the roleId
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
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
    
    @Override
    public String toString(){
        return "["+getRoleId()+",'"+getDescription()+"',"+getCreatedDate()+","+getCreateUserId()+"]";
    }
}
