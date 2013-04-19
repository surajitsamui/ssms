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

    void save(UserRegistration uComp);

    List<UserRegistration> getUserDetal();

    int login(UserRegistration uuu, int uId, String pass, int cat);

    int logCheck(int uId);

    List<Integer> getProgrammer(int id);

    public int userCount();
    void updatePassword(UserRegistration uComp);
}
