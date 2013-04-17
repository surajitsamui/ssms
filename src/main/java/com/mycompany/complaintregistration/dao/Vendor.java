package com.mycompany.complaintregistration.dao;

import java.sql.Blob;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author srini
 */
@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
   
    private int code;
    private String name;
    private String address;
    private String city;

    

    @Override
    public String toString() {
        return "code="+getCode()+"name="+getName()+"address="+getAddress()+"city="+getCity();
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }




    
}
