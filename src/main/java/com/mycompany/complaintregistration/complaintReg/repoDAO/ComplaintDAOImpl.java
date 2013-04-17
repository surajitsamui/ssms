package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.Complaint;
import com.mycompany.complaintregistration.complaintReg.repoDAO.ComplaintRepo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @Override
    public Complaint read(int complaintNo) {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT where COMPL_NO=?";
        return jdbct.queryForObject(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));

                return complaint;
            }
         ;
        },complaintNo);
    }

    @Override
    public void save(Complaint complaintSave) {

        //read(complaintSave.getComplaintNo());
        String sql = "insert into SSR_COMPLAINT values(?,?,?,?,?,?,?,?,?)";
        jdbct.update(sql, complaintSave.getComplaintNo(), complaintSave.getComplaintDesc(), complaintSave.getComplaintUserId(), complaintSave.getComplaintType(), complaintSave.getComplaintDate(), complaintSave.getComplaintSolved(), complaintSave.getAdminStatus(), complaintSave.getUserFeedback(), complaintSave.getAdminAsign());

    }

    @Override
    public List<Complaint> getAllComplaint() {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint;
            }
        ;
    }

    );
    }
    @Override
    public int complaintCount() {
        return jdbct.queryForInt("select count(*) from SSR_complaint");
    }

    @Override
    public void statusUpdate(Complaint com) {
        String sqlUpdate = "update ssr_complaint set admin_status=? where compl_no=?";
        jdbct.update(sqlUpdate, com.getAdminStatus(), com.getComplaintNo());
    }

    @Override
    public void assingUpdate(Complaint comp) {
        String sqlUpdate = "update ssr_complaint set ADMIN_ASSIGN=? where compl_no=?";
        jdbct.update(sqlUpdate, comp.getAdminAsign(), comp.getComplaintNo());
    }

    @Override
    public List<Complaint> getAllComplaintAgainstProgrammer(int pId) {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT where ADMIN_ASSIGN=? order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint;
            }
         ;
    },pId);
    }

    @Override
    public List<Complaint> getAllComplaintPending() {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT where ADMIN_STATUS=? order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint;
            }
         ;
    },"Pending");
    }

    @Override
    public List<Complaint> getAllComplaintSolved() {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT where ADMIN_STATUS=? order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint;
            }
         ;
    },"Solved");
    }

    @Override
    public List<Complaint> getAllComplaintUnSolved() {
        String sqlstmt = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK,ADMIN_ASSIGN from SSR_COMPLAINT where ADMIN_STATUS=? order by COMPL_NO desc ";
        return jdbct.query(sqlstmt, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int i) throws SQLException {
                Complaint complaint = new Complaint();
                complaint.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint.setUserFeedback(rs.getString("USER_FEEDBACK"));
                complaint.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint;
            }
         ;
    },"Unsolved");
    }

    @Override
    public List<Complaint> statusPendingUnsolvedProgToUser(int complaintUserId) {
        String sql = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK from SSR_COMPLAINT WHERE COMPL_USERID=? and ADMIN_STATUS=? or ADMIN_STATUS=? ORDER BY compl_no DESC";
        return jdbct.query(sql, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int rownum) throws SQLException {
                Complaint complaint1 = new Complaint();
                complaint1.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint1.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint1.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint1.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint1.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint1.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint1.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint1.setUserFeedback(rs.getString("USER_FEEDBACK"));
                //complaint1.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint1;
            }
         ;
    },complaintUserId,"Pending","Unsolved");
    }
    @Override
    public List<Complaint> statusSolvedProgToUser(int complaintUserId) {
        String sql = "Select COMPL_NO,COMPL_DESC,COMPL_USERID,COMPL_TYPE,COMPL_DATE,COMPL_SOLVED,ADMIN_STATUS,USER_FEEDBACK from SSR_COMPLAINT WHERE COMPL_USERID=? and ADMIN_STATUS=? ORDER BY compl_no DESC";
        return jdbct.query(sql, new RowMapper<Complaint>() {
            @Override
            public Complaint mapRow(ResultSet rs, int rownum) throws SQLException {
                Complaint complaint1 = new Complaint();
                complaint1.setComplaintNo(rs.getInt("COMPL_NO"));
                complaint1.setComplaintDesc(rs.getString("COMPL_DESC"));
                complaint1.setComplaintUserId(rs.getInt("COMPL_USERID"));
                complaint1.setComplaintType(rs.getString("COMPL_TYPE"));
                complaint1.setComplaintDate(rs.getDate("COMPL_DATE"));
                complaint1.setComplaintSolved(rs.getDate("COMPL_SOLVED"));
                complaint1.setAdminStatus(rs.getString("ADMIN_STATUS"));
                complaint1.setUserFeedback(rs.getString("USER_FEEDBACK"));
                //complaint1.setAdminAsign(rs.getInt("ADMIN_ASSIGN"));
                return complaint1;
            }
         ;
    },complaintUserId,"Solved");
    }
    @Override
    public void feedbackUpdate(Complaint com) {
        String sqlUpdate = "update ssr_complaint set USER_FEEDBACK=? where compl_no=?";
        jdbct.update(sqlUpdate, com.getUserFeedback(), com.getComplaintNo());
    }
}
