package com.company.WeatherWebService.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<VndErrors.VndError> numberFormatExceptionHandler
            (NumberFormatException exception , WebRequest webReq){
        VndErrors.VndError clientErr = new VndErrors.VndError
                (exception.toString() ,
                        "Invalid zipcode entered ");
        return new ResponseEntity<VndErrors.VndError>(clientErr , HttpStatus.BAD_REQUEST);

    }

}