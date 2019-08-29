package com.company.WeatherWebService.controller;

import com.company.WeatherWebService.model.Conditions;
import com.company.WeatherWebService.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Temperature currentTemperature(@PathVariable Temperature temperature) {
        return temperature;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Conditions currentConditions(@PathVariable Conditions conditions) {
        return conditions;
    }

}
