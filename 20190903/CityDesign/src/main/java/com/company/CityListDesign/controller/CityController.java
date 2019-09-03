package com.company.CityListDesign.controller;

import com.company.CityListDesign.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CityController {

    //static arraylist would allow you to add information before been run
    // you must also have a constructor in your model
    static ArrayList<City> citiesList = new ArrayList<>();
    static {
        citiesList.add(new City(("hello", "state", 100, true));
    }

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
    public Optional<City> getCity(@PathVariable String name) {
        return citiesList.stream()
                .filter(c -> c.getName().contains(name))
                .findFirst(); // this method will return the first element of the stream search
    }
}
