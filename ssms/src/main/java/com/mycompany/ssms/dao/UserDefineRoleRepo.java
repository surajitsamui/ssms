package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Asu
 */
public interface UserDefineRoleRepo extends JpaRepository<UserDefineRole, Integer> {

    public List<UserDefineRole> findByUserId(int userId);

    List<UserDefineRole> findByRoleId(int roleId);

    @Modifying
    @Transactional
    @Query("delete from UserDefineRole u where u.userId = ?")
    public void deleteUserId(int userId);
}
