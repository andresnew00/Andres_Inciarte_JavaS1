package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Invoice;
import com.company.AndresInciarteU1Capstone.Dto.UserPurchaseInfo;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class InvoiceController {
    @Autowired
    ServiceLayer serviceLayer;

    //TODO you are here all the controllers are done exept for this one : need to finish serv layer test and routes test
    @PostMapping(value = "/addinvoice")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice addinvoice(@RequestBody @Valid UserPurchaseInfo info) {
        Invoice newInvoice = serviceLayer.addInvoice(info);

        return newInvoice;
    }
}
