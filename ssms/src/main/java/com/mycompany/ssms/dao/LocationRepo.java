package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Deogharia
 */
public interface LocationRepo extends JpaRepository<Location, Integer> {

    public Page<Location> findByDescriptionOrShortDescIgnoreCaseLike(String description, String shortDesc, Pageable p);

    public Page<Location> findByDescriptionOrShortDescIgnoreCaseNotLike(String description, String shortDesc, Pageable p);

    @Query("select l from Location l where l.unit.id=?")
    public List<Location> findByUnitId(int unitId);
}
