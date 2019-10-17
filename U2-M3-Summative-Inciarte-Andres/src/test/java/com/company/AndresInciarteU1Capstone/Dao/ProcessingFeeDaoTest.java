package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.ProcessingFee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoTest {

    @Autowired
    private ProcessingFeeDao processingFeeDao;

    @Test
    public void getProcessingFeeByItem() {
        ProcessingFee gamefee = processingFeeDao.getProcessingFeeByItem("Games");

        assertEquals(gamefee, processingFeeDao.getProcessingFeeByItem("Games"));
    }
}