package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Sudipta
 */
public interface DocumentsRepo extends JpaRepository<Documents, Integer>{
    @Query("select d from Documents d order by d.docId asc ")
    List<Documents> getAllDocumentOrderByDocId();
}
