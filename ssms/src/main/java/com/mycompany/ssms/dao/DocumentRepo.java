package com.mycompany.ssms.dao;

import com.itextpdf.text.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Asu
 */
public interface DocumentRepo extends JpaRepository<Document, Integer> {
    Page<Document> findByDocNameIgnoreCaseLike(String docName, Pageable p);
    Page<Document> findByDocNameIgnoreCaseNotLike(String docName, Pageable p);
}
