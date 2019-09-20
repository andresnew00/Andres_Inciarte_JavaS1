package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Game;
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
    public TShirt addTshirt(@RequestBody @Valid TShirt tShirt){
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

    @GetMapping(value = "/{TshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTshirt(@PathVariable int tshirtId) {
        return serviceLayer.getTshirt(tshirtId);
    }


    @PutMapping(value = "/{tshirtId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateTshirt(@PathVariable int id,@RequestBody @Valid TShirt tShirt) {
        tShirt.settShirtId(id);
        serviceLayer.updateTshirt(tShirt);
    }

    @DeleteMapping(value = "/{tshirtId}")
    @ResponseStatus(value = HttpStatus.GONE)
    public void deleteTshirt(@PathVariable int tshirtId) {
        serviceLayer.deleteTshirt(tshirtId);
    }

    @GetMapping(value = "/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTshirtsByColor(@PathVariable String color) {
        if (serviceLayer.getTShirtsByColor(color).size() > 0) {
            return serviceLayer.getTShirtsByColor(color);
        } else {
            throw new IllegalArgumentException("T-shirts not found on that color.");
        }
    }

    @GetMapping(value = "/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTshirtBySize(@PathVariable String size) {
        if (serviceLayer.getTShirtsBySize(size).size() > 0) {
            return serviceLayer.getTShirtsBySize(size);
        } else {
            throw new IllegalArgumentException("T-Shirts not found on that size.");
        }
    }
}
