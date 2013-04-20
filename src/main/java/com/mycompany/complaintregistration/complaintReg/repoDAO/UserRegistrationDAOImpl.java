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
 * @author Ratul
 */
@Repository
public class UserRegistrationDAOImpl implements UserRegistrationRepo {

    @Autowired
    JdbcTemplate jdbcTemp;

    class readUserRow implements RowMapper<UserRegistration> {

        @Override
        public UserRegistration mapRow(ResultSet rs, int rowNum) throws SQLException {

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
    }

    @Override
    public UserRegistration read(int uId) {
        String sqlUserRead = "select USER_ID,INAME,USER_NAME,USER_ADDRESS,USER_MOBILE,USER_EMAIL,USER_PASS_D,USER_PASS_T,ADMIN "
                + "from SSR_USER_REGISTRATION where USER_ID=?";
        return jdbcTemp.queryForObject(sqlUserRead, new readUserRow(), uId);
    }

    @Override
    public void saveInsert(UserRegistration uComp) {
        String sqlSave = "insert into SSR_USER_REGISTRATION values (?,?,?,?,?,?,?,?,?)";
        uComp.setUserId(userCount() + 1);
        jdbcTemp.update(sqlSave, uComp.getUserId(), uComp.getInitial(), uComp.getName(), uComp.getAdd(), uComp.getMobile(), uComp.geteMail(), uComp.getDesiredPassWord(), uComp.getTempPassWord(), uComp.getAdminUser());

    }

    @Override
    public void saveUpdate(UserRegistration uComp) {
        read(uComp.getUserId());
        String sqlUpdateUser = "update  SSR_USER_REGISTRATION set INAME=?,USER_NAME=?,USER_ADDRESS=?,USER_MOBILE=?,"
                + "USER_EMAIL=?,USER_PASS_D=?,USER_PASS_T=?,ADMIN=? "
                + "where USER_ID=?";
        jdbcTemp.update(sqlUpdateUser, uComp.getInitial(), uComp.getName(), uComp.getAdd(), uComp.getMobile(), uComp.geteMail(), uComp.getDesiredPassWord(),
                uComp.getTempPassWord(), uComp.getAdminUser(), uComp.getUserId());
    }

    @Override
    public List<UserRegistration> getUserDetal() {
        String sqlUserRead = "select USER_ID,INAME,USER_NAME,USER_ADDRESS,USER_MOBILE,USER_EMAIL,USER_PASS_D,USER_PASS_T,ADMIN "
                + "from SSR_USER_REGISTRATION";
        return jdbcTemp.query(sqlUserRead, new readUserRow());
    }

//Login Checking
    @Override
    public int logCheck(int uId) {
        return jdbcTemp.queryForInt("select admin from SSR_USER_REGISTRATION where  user_id=?", uId);
    }
//Programmer ID Lists from DB

    @Override
    public List<Integer> getProgrammer(int id) {
        String sqlProg = "select user_id from SSR_USER_REGISTRATION where admin =?";
        return jdbcTemp.queryForList(sqlProg, Integer.class, 1);
    }
//user count in DB

    @Override
    public int userCount() {
        return jdbcTemp.queryForInt("select count(*) from SSR_USER_REGISTRATION");
    }
//password Change update

    @Override
    public void updatePassword(UserRegistration uComp, int id) {
        String sqlUpdateUser = "update SSR_USER_REGISTRATION set USER_PASS_D=?,USER_PASS_T=? where USER_ID=?";
        jdbcTemp.update(sqlUpdateUser, uComp.getDesiredPassWord(), uComp.getDesiredPassWord(), id);
    }
//password Change

    @Override
    public String checkPass(int id) {
        return jdbcTemp.queryForObject("select USER_PASS_T from SSR_USER_REGISTRATION where USER_ID=?", new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                String sc = new String();
                sc = rs.getString("USER_PASS_T");
                return sc;
            }
        }, id);
    }
}
