package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ProcessingFeeDaoJdbcTemplateImp implements ProcessingFeeDao {
    // prepared statements:
    private static final String SELECT_PROCESSINGFEE_BYITEM_SQL =
            "SELECT * FROM processing_fee WHERE product_type = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProcessingFeeDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * returns the processing fee corresponding an product type
     *
     * @param productType
     * @return
     */
    @Override
    public ProcessingFee getProcessingFeeByItem(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSINGFEE_BYITEM_SQL, this::rowMapperToFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    private ProcessingFee rowMapperToFee(ResultSet rs, int numRow) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(rs.getString("product_type"));
        processingFee.setFee(rs.getBigDecimal("fee"));

        return processingFee;
    }
}
