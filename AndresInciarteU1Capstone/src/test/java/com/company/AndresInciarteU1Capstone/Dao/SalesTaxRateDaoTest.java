package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.SalesTaxRate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTest {

    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Test
    public void getTaxByState() {
        SalesTaxRate Georgia = salesTaxRateDao.getTaxByState("GA");

        assertEquals(Georgia,salesTaxRateDao.getTaxByState("GA"));
    }
}