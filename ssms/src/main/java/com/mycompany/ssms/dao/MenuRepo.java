package com.mycompany.ssms.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m where m.url is null or m.url='javascript:void'")
    public List<Menu> getAllParentId();

    @Query("SELECT m FROM Menu m where m.parentId=?")
    public List<Menu> findByNullUrl();

    @Query("SELECT m FROM Menu m where m.url<>''")
    public List<Menu> findByUrl();

//this is for options tag
    @Query("SELECT m FROM Menu m where m.parentId<>0 or m.url is null")
    public List<Menu> getAllPId();

    @Query("SELECT m FROM Menu m where m.parentId=?")
    public List<Menu> getAllChild(int id);

    @Query("SELECT m FROM Menu m where m.parentId=? order by m.parentId desc")
    public List<Menu> getChildren(int id);

    @Query("select m from Menu m order by m.parentId,serialNo ")
    public List<Menu> getAllSorted();

    public Menu findByUrl(String url);

    @Query("select m from Menu m where m.parentId=? order by m.parentId, name ")
    public List<Menu> getPathByURI(int parentId);

    public Page<Menu> findByNameIgnoreCaseLike(String name, Pageable p);

    public Page<Menu> findByNameIgnoreCaseNotLike(String name, Pageable p);

}
