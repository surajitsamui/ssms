
package com.mycompany.complaintregistration.dao;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author srini
 */
@Repository
public class SampleDao {
    
    @Autowired
    JdbcTemplate jd;
    
    public Date getDataBaseTime(){
        return jd.queryForObject("select sysdate from dual",Date.class );
    }
    
    
    public String getMatDesc(int matId){
        return jd.queryForObject("select vc_material_short_description from t_adm_material where nu_material_id=?", String.class, matId);
    }
    
}
