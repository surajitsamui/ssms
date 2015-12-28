package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author surajit
 */
@Repository
public interface TenderRepo extends JpaRepository<Tender, Integer> {

    public Page<Tender> findByDescriptionOrShortDescIgnoreCaseLike(String description, String shortDesc, Pageable p);

    public Page<Tender> findByDescriptionOrShortDescIgnoreCaseNotLike(String description, String shortDesc, Pageable p);

    @Query("select l from Tender l where tenderId=?")
    public List<Tender> findByTenderId(int tenderId);
}
