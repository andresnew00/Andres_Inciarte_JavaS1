package com.company.AndresInciarteU1Capstone.Dao;

import com.company.AndresInciarteU1Capstone.Dto.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {

    @Autowired
    InvoiceDao invoiceDao;

    private Invoice invoice, invoice2;

    @Before
    public void setUp() throws Exception {
        invoiceDao.getAllInvoices().forEach(invoice -> {invoiceDao.deleteInvoice(invoice.getInvoiceId());});

        invoice = new Invoice();
        invoice.setName("Customer Invoice 1");
        invoice.setStreet("2323 colewild");
        invoice.setCity("city");
        invoice.setState("GA");
        invoice.setZipcode("99900");
        invoice.setItemType("Console");
        invoice.setItemId(22);
        invoice.setUnitPrice(BigDecimal.valueOf(100, 2));
        invoice.setQuantity(20);
        invoice.setSubtotal(BigDecimal.valueOf(200,2));
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(1,2));
        invoice.setTotal(BigDecimal.valueOf(100,2));

        invoice2 = new Invoice();
        invoice2.setName("Customer Invoice 2");
        invoice2.setStreet("2323 notnot");
        invoice2.setCity("cool");
        invoice2.setState("GA");
        invoice2.setZipcode("23333");
        invoice2.setItemType("consooolla");
        invoice2.setItemId(22);
        invoice2.setUnitPrice(BigDecimal.valueOf(200, 2));
        invoice2.setQuantity(20);
        invoice2.setSubtotal(BigDecimal.valueOf(500,2));
        invoice2.setTax(BigDecimal.valueOf(3,2));
        invoice2.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice2.setTotal(BigDecimal.valueOf(200,2));

    }

    @Test
    public void addInvoice() {
        invoice = invoiceDao.addInvoice(invoice);

        assertEquals(1,invoiceDao.getAllInvoices().size());
    }

    @Test
    public void getInvoice() {
        invoice = invoiceDao.addInvoice(invoice);

        Invoice getInvoice = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(getInvoice,invoice);
    }

    @Test
    public void getAllInvoices() {
        invoice = invoiceDao.addInvoice(invoice);
        invoice2 = invoiceDao.addInvoice(invoice2);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        assertEquals(2, invoiceList.size());
    }

    @Test
    public void deleteInvoice() {
        invoice = invoiceDao.addInvoice(invoice);
        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        Invoice deletedInvoice = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertNull(deletedInvoice);
    }
}
