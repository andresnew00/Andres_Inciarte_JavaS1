package com.company.HelloWebService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String displayName(@PathVariable String name) {
        return "Hello! and Welcome " + name;
    }

}
