package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.SalesTaxRate;

public interface SalesTaxRateDao {

    /**
     * get tax by state
     * @param state
     * @return
     */
    SalesTaxRate getTaxByState(String state);
}
