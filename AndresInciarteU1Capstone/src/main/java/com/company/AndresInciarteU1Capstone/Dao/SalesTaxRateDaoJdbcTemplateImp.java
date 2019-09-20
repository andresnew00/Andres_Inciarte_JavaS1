package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SalesTaxRateDaoJdbcTemplateImp implements SalesTaxRateDao {
    private static final String SELECT_TAX_BY_STATE_SQL =
            "SELECT * FROM sales_tax_rate WHERE state = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesTaxRateDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * get tax by state
     *
     * @param state
     * @return
     */
    @Override
    public SalesTaxRate getTaxByState(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TAX_BY_STATE_SQL,this::rowMapperToTax,state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private SalesTaxRate rowMapperToTax(ResultSet rs, int numRow) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(rs.getString("state"));
        salesTaxRate.setRate(rs.getBigDecimal("rate"));

        return salesTaxRate;
    }
}
