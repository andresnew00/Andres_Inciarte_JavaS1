package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Invoice;

import java.util.List;

public interface InvoiceDao {

    /**
     * add a new invoice to the db
     * @param invoice
     * @return
     */
    Invoice addInvoice(Invoice invoice);

    /**
     * get an invoice from my db
     * @param invoiceId
     * @return
     */
    Invoice getInvoice(int invoiceId);

    /**
     * get all the invoices from the db
     * @return
     */
    List<Invoice> getAllInvoices();

    /**
     * deletes invoice by id
     * @param id
     */
    void deleteInvoice(int id);
}
