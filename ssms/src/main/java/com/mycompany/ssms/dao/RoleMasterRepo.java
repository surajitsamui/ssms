package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Deogharia,Budha
 */
public interface RoleMasterRepo extends JpaRepository<RoleMaster, Integer> {

    public Page<RoleMaster> findByRoleDescrIgnoreCaseLike(String roleDescr, Pageable pageable);

    @Query("select r from RoleMaster r where r.docId !=0 ")//and r.preDefinedRole=false
    List getAllDocumentedRoles();

    public Page<RoleMaster> findByRoleDescrIgnoreCaseNotLike(String roleDescr, Pageable pageable);

    @Query("select r.id from RoleMaster r where r.docId=?")
    public int findIdByDocId(int docId);
}
