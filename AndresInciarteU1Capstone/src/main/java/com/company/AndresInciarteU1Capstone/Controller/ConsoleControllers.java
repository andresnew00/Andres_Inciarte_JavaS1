package com.company.AndresInciarteU1Capstone.Controller;

import com.company.AndresInciarteU1Capstone.Dto.Console;
import com.company.AndresInciarteU1Capstone.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/console")
public class ConsoleControllers {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Console addConsole(@RequestBody @Valid Console console) {
        return serviceLayer.addConsole(console);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        if (serviceLayer.getAllConsoles().size() > 0) {
            return serviceLayer.getAllConsoles();
        } else {
            throw new IllegalArgumentException("Consoles not found.");
        }
    }

    @GetMapping(value = "/find/{consoleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsole(@PathVariable int consoleId) {
        return serviceLayer.getConsole(consoleId);
    }


    @PutMapping(value = "/update/{consoleId}")
    @ResponseStatus(value = HttpStatus.OK)
    public void updateConsole(@PathVariable int consoleId, @RequestBody @Valid Console console) {
        console.setConsoleId(consoleId);
        serviceLayer.updateConsole(console);
    }

    @DeleteMapping(value = "/delete/{consoleId}")
    @ResponseStatus(value = HttpStatus.GONE)
    public void deleteConsole(@PathVariable int consoleId) {
        serviceLayer.deleteConsole(consoleId);
    }


    @GetMapping(value = "findbymanufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        if (serviceLayer.getAllConsoles().size() > 0) {
            return serviceLayer.getByManufacturer(manufacturer);
        } else {
            throw new IllegalArgumentException("Consoles not found with that Manufacturer.");
        }
    }
}
