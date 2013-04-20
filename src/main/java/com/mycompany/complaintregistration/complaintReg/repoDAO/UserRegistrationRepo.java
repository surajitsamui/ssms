/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg.repoDAO;

import com.mycompany.complaintregistration.complaintReg.UserRegistration;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mmc-pc1
 */
public interface UserRegistrationRepo {

    UserRegistration read(int uId);

    void saveInsert(UserRegistration uComp);

    void saveUpdate(UserRegistration uComp);

    List<UserRegistration> getUserDetal();

    int logCheck(int uId);

    List<Integer> getProgrammer(int id);

    public int userCount();

    void updatePassword(UserRegistration uComp, int id);

    String checkPass(int id);
}
