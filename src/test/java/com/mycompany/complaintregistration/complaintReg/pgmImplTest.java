/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complaintregistration.complaintReg;

import com.mycompany.complaintregistration.complaintReg.repoDAO.pgmRepo;
import com.mycompany.complaintregistration.testConfig.TestDataSourceConfig;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mmc-pc1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDataSourceConfig.class})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class pgmImplTest {
    
    @Autowired
    pgmRepo pgr;
    
    public pgmImplTest() {
    }
    
  
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAll(){
        //UserRegistration ureg = new UserRegistration();
        ProgrammerAnalystDetail ff= new ProgrammerAnalystDetail();
                ff.setProgrammerName("Siran");
                ff.setProgrammerEmailId("@.");
                pgr.save(ff, true);
        /*ureg.setUserId(101);
        ureg.setName("Test");
        ureg.setDesiredPassWord("aaa");
        uregRepo.save(ureg, true);*/
        ProgrammerAnalystDetail ff1=  pgr.read("Siran");
        assertEquals(ff1.getProgrammerName(), ff.getProgrammerName());
        /*UserRegistration uregn = uregRepo.read(101);
        assertEquals(uregn.getName(), ureg.getName());*/
        ff1.setProgrammerName("Sudi");
        //uregn.setName("change");
        pgr.save(ff1, false);
        ff1=pgr.read("Siran");
        assertEquals(ff1.getProgrammerName(), "Sudi");
        /*uregRepo.save(uregn, false);
        uregn = uregRepo.read(101);
        assertEquals(uregn.getName(), "change");*/
        
    }
}