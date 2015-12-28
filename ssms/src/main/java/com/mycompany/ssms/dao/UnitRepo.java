package com.mycompany.ssms.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepo extends JpaRepository<Unit, Integer>{
    public Page<Unit> findByUnitNameIgnoreCaseLike(String unitName,Pageable pageable);
    public Page<Unit> findByUnitNameIgnoreCaseNotLike(String unitName,Pageable pageable);
}
