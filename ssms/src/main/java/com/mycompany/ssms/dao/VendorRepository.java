
package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author srini
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    
    List<Vendor> findByCity(String city);
    
}
