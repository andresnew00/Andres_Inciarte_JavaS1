package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.TShirt;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tshirt")
public class TShirtController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt addTshirt(@RequestBody @Valid TShirt tShirt) {
        return serviceLayer.addTshirt(tShirt);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTshirts() {
        if (serviceLayer.getAllTshirts().size() > 0) {
            return serviceLayer.getAllTshirts();
        } else {
            throw new IllegalArgumentException("T-Shirts not found.");
        }
    }

    @GetMapping(value = "/find/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTshirt(@PathVariable int tshirtId) {
        if(serviceLayer.getTshirt(tshirtId) == null) {
            throw new IllegalArgumentException("Console not found.");
        } else {
            return serviceLayer.getTshirt(tshirtId);
        }
    }


    @PutMapping(value = "/update/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTshirt(@PathVariable int tshirtId, @RequestBody @Valid TShirt tShirt) {
        tShirt.settShirtId(tshirtId);
        serviceLayer.updateTshirt(tShirt);
    }

    @DeleteMapping(value = "/delete/{tshirtId}")
    @ResponseStatus(value = HttpStatus.GONE)
    public void deleteTshirt(@PathVariable int tshirtId) {
        serviceLayer.deleteTshirt(tshirtId);
    }

    @GetMapping(value = "/findbycolor/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTshirtsByColor(@PathVariable String color) {
        if (serviceLayer.getTShirtsByColor(color).size() > 0) {
            return serviceLayer.getTShirtsByColor(color);
        } else {
            throw new IllegalArgumentException("T-shirts not found on that color.");
        }
    }

    @GetMapping(value = "/findbysize/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTshirtBySize(@PathVariable String size) {
        if (serviceLayer.getTShirtsBySize(size).size() > 0) {
            return serviceLayer.getTShirtsBySize(size);
        } else {
            throw new IllegalArgumentException("T-Shirts not found on that size.");
        }
    }
}
