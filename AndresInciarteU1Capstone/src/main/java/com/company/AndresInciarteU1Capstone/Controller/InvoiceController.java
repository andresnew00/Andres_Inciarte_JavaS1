package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Game;
import com.company.AndresInciarteU1Capstone.Dto.Invoice;
import com.company.AndresInciarteU1Capstone.Dto.UserPurchaseInfo;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping(value = "/addinvoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice addinvoice(@RequestBody @Valid UserPurchaseInfo info) {
        Invoice invoice = serviceLayer.findAddInvoice(info);

        return invoice;
    }

    @GetMapping(value = "/invoices")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Invoice> getAllInvoices() {
        if (serviceLayer.getAllInvoices().size() > 0) {
            return serviceLayer.getAllInvoices();
        } else {
            throw new IllegalArgumentException("Invoices not found.");
        }
    }
}
