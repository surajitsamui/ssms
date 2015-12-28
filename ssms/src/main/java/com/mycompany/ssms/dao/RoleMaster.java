package com.mycompany.ssms.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author mmc-pc1
 */
@Entity
public class RoleMaster extends RecordInfo implements Serializable{

    @Id
    private int id;
    private String roleDescr;
    private int docId;
    @Type(type = "yes_no")
    private boolean preDefinedRole;

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
     * @return the roleDescr
     */
    public String getRoleDescr() {
        return roleDescr;
    }

    /**
     * @param roleDescr the roleDescr to set
     */
    public void setRoleDescr(String roleDescr) {
        this.roleDescr = roleDescr;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public boolean isPreDefinedRole() {
        return preDefinedRole;
    }

    public void setPreDefinedRole(boolean preDefinedRole) {
        this.preDefinedRole = preDefinedRole;
    }
}
