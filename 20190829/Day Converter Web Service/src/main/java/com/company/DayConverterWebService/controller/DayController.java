package com.company.DayConverterWebService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayController {

    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String displayDay(@PathVariable int dayNumber) {
        switch (dayNumber){
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
                default:
                    throw new IllegalArgumentException("Input must be between 1 and 7.");
        }
    }
}
