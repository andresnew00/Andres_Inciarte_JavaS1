package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImp implements InvoiceDao {

    private static final String INSERT_INVOICE_SQL =
            "INSERT INTO invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_INVOICE_SQL =
            "SELECT * FROM invoice WHERE invoice_id = ?";
    private static final String SELECT_ALL_INVOICE_SQL =
            "SELECT * FROM invoice";
    private static final String DELETE_INVOICE_SQL =
            "DELETE FROM invoice WHERE invoice_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * add a new invoice to the db
     *
     * @param invoice
     * @return
     */
    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal());

        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",Integer.class);

        invoice.setInvoiceId(id);
        return invoice;
    }

    /**
     * get an invoice from my db
     *
     * @param invoiceId
     * @return
     */
    @Override
    public Invoice getInvoice(int invoiceId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL,this::mapRowToInvoice,invoiceId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * get all the invoices from the db
     *
     * @return
     */
    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_SQL, this::mapRowToInvoice);
    }

    /**
     * deletes invoice by id
     *
     * @param id
     */
    @Override
    @Transactional
    public void deleteInvoice(int id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL,id);
    }

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setName(rs.getString("name"));
        invoice.setStreet(rs.getString("street"));
        invoice.setCity(rs.getString("city"));
        invoice.setState(rs.getString("state"));
        invoice.setZipcode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setSubtotal(rs.getBigDecimal("subtotal"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setTotal(rs.getBigDecimal("total"));

        return invoice;
    }
}
