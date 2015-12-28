package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Samim
 */
@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Integer> {

    @Query("select d from Documents d order by d.docId asc ")
    List<Complaint> getAllComplaOrderByDocId();
}
