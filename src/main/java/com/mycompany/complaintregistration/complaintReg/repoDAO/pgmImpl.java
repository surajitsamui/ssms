package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.ProgrammerAnalystDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sintu Pal
 */
@Repository
public class pgmImpl implements pgmRepo {

    @Autowired
    JdbcTemplate jd;
class readProgrammerDB implements RowMapper<ProgrammerAnalystDetail>{

        @Override
        public ProgrammerAnalystDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
             ProgrammerAnalystDetail detail = new ProgrammerAnalystDetail();
                detail.setProgrammerName(rs.getString("PROGRAMMER_NAME"));
                detail.setProgrammerSpecl(rs.getString("PROGRAMMER_SPCL"));
                detail.setProgrammerExperience(rs.getInt("PROGRAMMER_EXPR"));
                detail.setProgrammerMobileNo(rs.getString("PROGRAMMER_MOBILE"));
                detail.setProgrammerEmailId(rs.getString("PROGRAMMER_EMAIL"));
                return detail;
        }
    
}
    @Override
    public ProgrammerAnalystDetail read(String Pgmname) {
        String sql = "SELECT PROGRAMMER_NAME,PROGRAMMER_SPCL,PROGRAMMER_EXPR,PROGRAMMER_MOBILE,PROGRAMMER_EMAIL FROM SSR_PROGRAMMER_DETAIL WHERE PROGRAMMER_NAME=?";
        return jd.queryForObject(sql, new readProgrammerDB(), Pgmname);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(ProgrammerAnalystDetail detail, boolean add) {
        try {
            read(detail.getProgrammerName());
            String sql = "update SSR_PROGRAMMER_DETAIL set PROGRAMMER_SPCL=?,PROGRAMMER_EXPR=?,PROGRAMMER_MOBILE=?,PROGRAMMER_EMAIL=? where PROGRAMMER_NAME=?";
            jd.update(sql, detail.getProgrammerSpecl(), detail.getProgrammerExperience(), detail.getProgrammerMobileNo(), detail.getProgrammerEmailId(), detail.getProgrammerName());

        } catch (EmptyResultDataAccessException e) {

            String sql = " insert into SSR_PROGRAMMER_DETAIL values (?,?,?,?,?)";
            jd.update(sql, detail.getProgrammerName(), detail.getProgrammerSpecl(), detail.getProgrammerExperience(), detail.getProgrammerMobileNo(), detail.getProgrammerEmailId());
        }
    }

    @Override
    public List<ProgrammerAnalystDetail> getAllDetails() {
        String sql = "SELECT PROGRAMMER_NAME,PROGRAMMER_SPCL,PROGRAMMER_EXPR,PROGRAMMER_MOBILE,PROGRAMMER_EMAIL FROM SSR_PROGRAMMER_DETAIL";
        return jd.query(sql,new readProgrammerDB());

    }
}
