package com.company.CityListDesign.controller;

import com.company.CityListDesign.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CityController {

    ArrayList<City> citiesList = new ArrayList<>();

    // Post: adding new city to arrayList
    @PostMapping(value = "/city")
    @ResponseStatus(value = HttpStatus.OK)
    public City addCity(@RequestBody @Valid City city) {
        citiesList.add(city);
        return city;
    }

    // Get: displaying all items from ArrayList
    @GetMapping(value = "/city")
    @ResponseStatus(value = HttpStatus.OK)
    public ArrayList<City> allCities(@RequestBody City city) {
        return citiesList;
    }

    // Delete: Deleting chosen city
    @DeleteMapping(value = "/city/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCity(@PathVariable String name) {

        citiesList.removeIf(c -> c.getName().contains(name));
    }

    //Search cities by name
    @GetMapping(value = "/city/{name}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<City> getCity(@PathVariable String name) {
        return citiesList.stream()
                .filter(c -> c.getName().contains(name))
                .collect(Collectors.toList());
    }
}
