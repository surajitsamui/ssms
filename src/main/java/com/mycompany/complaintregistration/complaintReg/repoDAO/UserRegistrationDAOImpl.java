package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mmc-pc1
 */
@Repository
public class UserRegistrationDAOImpl implements UserRegistrationRepo {

    @Autowired
    JdbcTemplate jdbcTemp;

    @Override
    public UserRegistration read(int uId) {
        String sqlUserRead = "select USER_ID,INAME,USER_NAME,USER_ADDRESS,USER_MOBILE,USER_EMAIL,USER_PASS_D,USER_PASS_T,ADMIN from SSR_USER_REGISTRATION where USER_ID=?";
        return jdbcTemp.queryForObject(sqlUserRead, new RowMapper<UserRegistration>() {
            @Override
            public UserRegistration mapRow(ResultSet rs, int i) throws SQLException {
                UserRegistration ureg = new UserRegistration();
                ureg.setUserId(rs.getInt("USER_ID"));
                ureg.setInitial(rs.getString("INAME"));
                ureg.setName(rs.getString("USER_NAME"));
                ureg.setAdd(rs.getString("USER_ADDRESS"));
                ureg.setMobile(rs.getString("USER_MOBILE"));
                ureg.seteMail(rs.getString("USER_EMAIL"));
                ureg.setDesiredPassWord(rs.getString("USER_PASS_D"));
                ureg.setTempPassWord(rs.getString("USER_PASS_T"));
                ureg.setAdminUser(rs.getInt("ADMIN"));
                return ureg;
            }
        }, uId);
    }
    // @Transactional(rollbackFor = Exception.class)

    @Override
    public void save(UserRegistration uComp) {

        try {
            read(uComp.getUserId());
            String sqlUpdateUser = "update  SSR_USER_REGISTRATION set INAME=?,USER_NAME=?,USER_ADDRESS=?,USER_MOBILE=?,USER_EMAIL=?,USER_PASS_D=?,USER_PASS_T=?,ADMIN=? where USER_ID=?";
            jdbcTemp.update(sqlUpdateUser, uComp.getInitial(), uComp.getName(), uComp.getAdd(), uComp.getMobile(), uComp.geteMail(), uComp.getDesiredPassWord(), uComp.getTempPassWord(), uComp.getAdminUser(), uComp.getUserId());

        } catch (EmptyResultDataAccessException ee) {
            String sqlSave = "insert into SSR_USER_REGISTRATION values (?,?,?,?,?,?,?,?,?)";
            jdbcTemp.update(sqlSave, uComp.getUserId(), uComp.getInitial(), uComp.getName(), uComp.getAdd(), uComp.getMobile(), uComp.geteMail(), uComp.getDesiredPassWord(), uComp.getTempPassWord(), uComp.getAdminUser());
        }

    }

    @Override
    public List<UserRegistration> getUserDetal() {
        String sqlUserRead = "select USER_ID,INAME,USER_NAME,USER_ADDRESS,USER_MOBILE,USER_EMAIL,USER_PASS_D,USER_PASS_T,ADMIN from SSR_USER_REGISTRATION";
        return jdbcTemp.query(sqlUserRead, new RowMapper<UserRegistration>() {
            @Override
            public UserRegistration mapRow(ResultSet rs, int i) throws SQLException {
                UserRegistration uregL = new UserRegistration();
                uregL.setUserId(rs.getInt("USER_ID"));
                uregL.setInitial(rs.getString("INAME"));
                uregL.setName(rs.getString("USER_NAME"));
                uregL.setAdd(rs.getString("USER_ADDRESS"));
                uregL.setMobile(rs.getString("USER_MOBILE"));
                uregL.seteMail(rs.getString("USER_EMAIL"));
                uregL.setDesiredPassWord(rs.getString("USER_PASS_D"));
                uregL.setTempPassWord(rs.getString("USER_PASS_T"));
                uregL.setAdminUser(rs.getInt("ADMIN"));
                return uregL;
            }
        });
    }

    @Override
    public int login(UserRegistration uuu, int uId, String pass, int cat) {

        return jdbcTemp.queryForInt("select count(*) from SSR_USER_REGISTRATION where USER_id=? and USER_PASS_D=? and ADMIN=?", uuu.getUserId(), uuu.getDesiredPassWord(), uuu.getAdminUser());
    }

    @Override
    public int logCheck(int uId) {
        return jdbcTemp.queryForInt("select admin from SSR_USER_REGISTRATION where  user_id=?", uId);
    }

    @Override
    public List<Integer> getProgrammer(int id) {
        String sqlProg = "select user_id from SSR_USER_REGISTRATION where admin =?";
        return jdbcTemp.queryForList(sqlProg, Integer.class, 1);
    }

    @Override
    public int userCount() {
        return jdbcTemp.queryForInt("select count(*) from SSR_USER_REGISTRATION");
    }

    @Override
    public void updatePassword(UserRegistration uComp, int id) {
      String sqlUpdateUser = "update SSR_USER_REGISTRATION set USER_PASS_D=?,USER_PASS_T=? where USER_ID=?";
      jdbcTemp.update(sqlUpdateUser, uComp.getDesiredPassWord(),uComp.getDesiredPassWord(),id);
    }

    @Override
    public String checkPass(int id) {
        return jdbcTemp.queryForObject("select USER_PASS_T from SSR_USER_REGISTRATION where USER_ID=?",new RowMapper<String>() {

            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String sc= new String();
                sc=rs.getString("USER_PASS_T");
                return sc;
            }
        },id);
    }
    
}
