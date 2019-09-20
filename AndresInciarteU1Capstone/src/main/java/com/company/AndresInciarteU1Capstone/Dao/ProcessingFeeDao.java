package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.ProcessingFee;

public interface ProcessingFeeDao {

    /**
     * returns the processing fee corresponding an product type
     * @param productType
     * @return
     */
    ProcessingFee getProcessingFeeByItem(String productType);

}
