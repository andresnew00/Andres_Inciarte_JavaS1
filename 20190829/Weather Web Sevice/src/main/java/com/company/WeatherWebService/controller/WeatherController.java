package com.company.WeatherWebService.controller;

import com.company.WeatherWebService.model.Conditions;
import com.company.WeatherWebService.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Temperature retTemperature(@PathVariable int zipcode) {
        Temperature currentTemperature = new Temperature();
        currentTemperature.setCelsius(80);
        currentTemperature.setFahrenheit(26);
        return currentTemperature;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Conditions retConditions(@PathVariable int zipcode) {

        Conditions currentWeather = new Conditions();

        Temperature currentTemperature = new Temperature();

        currentTemperature.setFahrenheit(100);
        currentTemperature.setCelsius(40);

        currentWeather.setTemp(currentTemperature);

        currentWeather.setPrecipitation("High");
        currentWeather.setSkies("Clear");
        currentWeather.setWindDirection("North");
        currentWeather.setWindSpeed(76);

        return currentWeather;
    }

}
