package com.company.RESTCalculatorWebService.controller;

import com.company.RESTCalculatorWebService.model.Calculator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int addNumbers(@RequestBody @Valid Calculator calculator) {
        return calculator.AddResult();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int subtractNumbers(@RequestBody @Valid Calculator calculator) {
        return calculator.SubtractResult();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int multNumbers(@RequestBody @Valid Calculator calculator) {
        return calculator.MultiplyResult();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public int divideNumbers(@RequestBody @Valid Calculator calculator) {
        return calculator.DivideResult();
    }

}
