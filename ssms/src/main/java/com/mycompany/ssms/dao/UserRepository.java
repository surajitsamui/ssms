package com.mycompany.ssms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mmc-pc1
 */
@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer> {

}
