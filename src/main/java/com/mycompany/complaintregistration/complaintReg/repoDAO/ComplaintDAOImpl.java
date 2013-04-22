package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Samim
 */
@Repository
public class ComplaintDAOImpl implements ComplaintRepo {

    @Autowired
    JdbcTemplate jdbct;

    class readComplaintRow implements RowMapper<Complaint> {

        @Override
        public Complaint mapRow(ResultSet rs, int rowNum) throws SQLException {
            Complaint complaint = new Complaint();
            complaint.setComplaintNo(rs.getInt("COMPL_NO"));
            complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
            complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
            complaint.setComplaintType(rs.getString("COMPL_TYPE"));
            complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
            complaint.setProgrammerAssignDate(rs.getDate("assign_prog_dt"));
            complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
            complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
            complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
            complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
            return complaint;
        }
    }

    class readComplaintRowUname extends readComplaintRow{

        @Override
        public Complaint mapRow(ResultSet rs, int rowNum) throws SQLException {
            Complaint c=super.mapRow(rs, rowNum); //To change body of generated methods, choose Tools | Templates.
            c.setName(rs.getString("USER_NAME"));
            return c;
        }
        
    }
   

    @Override
    public Complaint read(int complaintNo) {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,"
                + "COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN "
                + "from SSR_COMPLAINT where COMPL_NO=?";
        return jdbct.queryForObject(sqlstmt, new readComplaintRow(), complaintNo);
    }
//no of complaints in DB

    @Override
    public int complaintCount() {
        return jdbct.queryForInt("select count(*) from SSR_complaint");
    }

    @Override
    public void save(Complaint complaintSave) {
        complaintSave.setComplaintNo(complaintCount() + 1);
        String sql = "insert into SSR_COMPLAINT values(?,?,?,?,?,?,?,?,?,?)";
        jdbct.update(sql, complaintSave.getComplaintNo(), complaintSave.getComplaintDesc(), complaintSave.getComplaintUserId(),
                complaintSave.getComplaintType(), complaintSave.getComplaintDate(), complaintSave.getProgrammerAssignDate(),
                complaintSave.getComplaintSolved(), complaintSave.getAdminStatus(), complaintSave.getUserFeedback(),
                complaintSave.getAdminAsign());
    }

    @Override
    public List<Complaint> getAllComplaint() {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,COMPL_SOLVED,"
                + "ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT "
                + "order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new readComplaintRow());
    }

//programmer updating status
    @Override
    public void statusUpdate(Complaint com) {
        String sqlUpdate = "update ssr_complaint set admin_status=? , COMPL_SOLVED=? where compl_no=?";
        jdbct.update(sqlUpdate, com.getAdminStatus(), com.getComplaintSolved(), com.getComplaintNo());
    }
//Complaint assign to programmer by admin

    @Override
    public void assingUpdate(Complaint comp) {
        String sqlUpdate = "update ssr_complaint set ADMIN_ASSIGN=? ,ASSIGN_PROG_DT =? where compl_no=?";
        jdbct.update(sqlUpdate, comp.getAdminAsign(), comp.getProgrammerAssignDate(), comp.getComplaintNo());
    }
//Complaints assigned against Programmer

    @Override
    public List<Complaint> getAllComplaintAgainstProgrammer(int pId) {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN "
                + "from SSR_COMPLAINT "
                + "where ADMIN_ASSIGN=? order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new readComplaintRow(), pId);
    }
//Admin View

    @Override
    public List<Complaint> getAllComplaintPending(String type) {
        String sqlstmt = "Select USER_NAME,COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN "
                + "from SSR_COMPLAINT a, SSR_USER_REGISTRATION b "
                + "where ADMIN_STATUS=? and b.USER_ID=a.COMPL_USERID  order by COMPL_NO desc ";

        return jdbct.query(sqlstmt, new readComplaintRowUname(), type);
    }
//Admin View

    @Override
    public List<Complaint> statusPendingUnsolvedProgToUser(int complaintUserId) {
        String sql = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK ,ADMIN_ASSIGN "
                + "from SSR_COMPLAINT "
                + "WHERE COMPL_USERID=? and ADMIN_STATUS in (?,?) ORDER BY compl_no DESC";
        return jdbct.query(sql, new readComplaintRow(), complaintUserId, "P", "R");
    }

    @Override
    public List<Complaint> statusSolvedProgToUser(int complaintUserId) {//User Status
        String sql = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,assign_prog_dt,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK ,ADMIN_ASSIGN "
                + "from SSR_COMPLAINT "
                + "WHERE COMPL_USERID=? and ADMIN_STATUS=? ORDER BY compl_no DESC";
        return jdbct.query(sql, new readComplaintRow(), complaintUserId, "S");
    }
//User Feedback

    @Override
    public void feedbackUpdate(Complaint com) {
        String sqlUpdate = "update ssr_complaint set USER_FEEDBACK=? where compl_no=?";
        jdbct.update(sqlUpdate, com.getUserFeedback(), com.getComplaintNo());
    }
}
