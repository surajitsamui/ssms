package com.mycompany.ssms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountCenterRepo extends JpaRepository<AccountCenter, Integer>{
    public AccountCenter findByUnit_Id(int id);
}
