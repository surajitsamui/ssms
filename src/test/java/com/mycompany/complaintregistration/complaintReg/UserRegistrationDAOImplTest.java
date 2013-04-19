package com.mycompany.complaintregistration.complaintReg;

import com.mycompany.complaintregistration.complaintReg.repoDAO.UserRegistrationRepo;
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
public class UserRegistrationDAOImplTest {
    
    @Autowired
    UserRegistrationRepo uregRepo;
    
    public UserRegistrationDAOImplTest() {
    }
    
  
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAll(){
        UserRegistration ureg = new UserRegistration();
        ureg.setUserId(101);
        ureg.setName("Test");
        ureg.setDesiredPassWord("aaa");
        uregRepo.save(ureg);
        
        UserRegistration uregn = uregRepo.read(101);
        assertEquals(uregn.getName(), ureg.getName());
        
        uregn.setName("change");
        
        uregRepo.save(uregn);
        uregn = uregRepo.read(101);
        assertEquals(uregn.getName(), "change");
        
    }
}