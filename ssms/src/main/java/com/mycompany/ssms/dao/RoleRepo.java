package com.mycompany.ssms.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author ratul
 */
public interface RoleRepo extends JpaRepository<Role, Long> {

    @Modifying
    @Query("update Role as r set r.description=?1 where r.roleId=?2")
    void updateDesc(String description, long roleId);
    @Query("select r from Role r order by r.roleId asc")
    List<Role> getAllRoleOrderByRoleId();
    @Query("select max(r.roleId) from Role r")
    public long maxListCount();
}
