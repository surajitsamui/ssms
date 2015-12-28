package com.mycompany.ssms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sintu Pal
 */
@Repository
public interface pgmRepo  extends JpaRepository<ProgrammerAnalystDetail, Integer> {


}
