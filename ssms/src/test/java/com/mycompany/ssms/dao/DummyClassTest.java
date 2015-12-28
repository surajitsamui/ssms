package com.mycompany.ssms.dao;

import com.mycompany.ssms.testConfig.TestDataSourceConfig;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author srini
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDataSourceConfig.class})

public class DummyClassTest {
    
    
    @Autowired
    VendorRepository vr ;
    
    public DummyClassTest() {
    }


    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getDataBaseTime method, of class SampleDao.
     */
    @Test
    public void testGetDataBaseTime() {
        //System.out.println(vr.findOne(500).getName());
        for(Vendor v: vr.findByCity("chennai")){
            System.out.println(v.getCode());
        }
    }
}
