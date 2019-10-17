package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Invoice;
import com.company.AndresInciarteU1Capstone.Dto.UserPurchaseInfo;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServiceLayer serviceLayer;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void getAllInvoicesShouldReturnAListOfInvoices() throws Exception {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Andres");
        invoice.setStreet("Street");
        invoice.setCity("City");
        invoice.setState("GA");
        invoice.setZipcode("30027");
        invoice.setItemType("Console");
        invoice.setItemId(1);
        invoice.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice.setQuantity(20);
        invoice.setTax(BigDecimal.valueOf(1,2));
        invoice.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice.setTotal(BigDecimal.valueOf(202,2));

        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(1);
        invoice2.setName("Andres");
        invoice2.setStreet("Street");
        invoice2.setCity("City");
        invoice2.setState("GA");
        invoice2.setZipcode("30027");
        invoice2.setItemType("Console");
        invoice2.setItemId(1);
        invoice2.setUnitPrice(BigDecimal.valueOf(200,2));
        invoice2.setQuantity(20);
        invoice2.setTax(BigDecimal.valueOf(1,2));
        invoice2.setProcessingFee(BigDecimal.valueOf(2,2));
        invoice2.setTotal(BigDecimal.valueOf(202,2));

        List<Invoice>  invoiceList = new ArrayList<>();
        invoiceList.add(invoice);
        invoiceList.add(invoice2);

        //Object to JSON in String
        when(serviceLayer.getAllInvoices()).thenReturn(invoiceList);

        List<Invoice> invoiceListChecker = new ArrayList<>();
        invoiceListChecker.addAll(invoiceList);
        //To confirm the test is testing what we think it is... add another Rsvp.
        // Uncommenting the below line causes the test to fail. As expected!
        // listChecker.add(new Rsvp(10, "Donald Duck", 2));
        String outputJson = mapper.writeValueAsString(invoiceListChecker);

        this.mockMvc.perform(get("/invoices"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void createConsoleShouldReturnCreatedConsole() throws Exception {

        UserPurchaseInfo input = new UserPurchaseInfo();
        input.setName("Andres");
        input.setStreet("Street");
        input.setCity("City");
        input.setState("GA");
        input.setZipcode("30027");
        input.setItemType("Console");
        input.setItemId(1);
        input.setQuantity(10);

        String inputJson2 = mapper.writeValueAsString(input);

        Invoice outputInvoice = new Invoice();
        outputInvoice.setInvoiceId(1);
        outputInvoice.setName("Andres");
        outputInvoice.setStreet("Street");
        outputInvoice.setCity("City");
        outputInvoice.setState("GA");
        outputInvoice.setZipcode("30027");
        outputInvoice.setItemType("Console");
        outputInvoice.setItemId(1);
        outputInvoice.setUnitPrice(BigDecimal.valueOf(200,2));
        outputInvoice.setQuantity(20);
        outputInvoice.setSubtotal(BigDecimal.valueOf(199,2));
        outputInvoice.setTax(BigDecimal.valueOf(1,2));
        outputInvoice.setProcessingFee(BigDecimal.valueOf(2,2));
        outputInvoice.setTotal(BigDecimal.valueOf(202,2));

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputInvoice);

        when(serviceLayer.findAddInvoice(input)).thenReturn(outputInvoice);

        this.mockMvc.perform(post("/addinvoice")
                .content(inputJson2)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

}
