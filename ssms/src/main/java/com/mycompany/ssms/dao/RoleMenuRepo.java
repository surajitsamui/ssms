package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author asu
 */
public interface RoleMenuRepo extends JpaRepository<RoleMenu, Integer> {
    public List<RoleMenu> findByRoleId(int roleId);
    @Modifying
    @Transactional
    @Query("delete from RoleMenu r where r.roleId = ?")
    public void deleteRoleMenus(int roleId);
}
