package com.company.U1M4SummativeInciarteAndres.controller;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<VndErrors.VndError> stringFormatExceptionHandler(IllegalArgumentException exception, WebRequest request){
        VndErrors.VndError stringError = new VndErrors.VndError(exception.toString(), "Invalid string");
        return new ResponseEntity<>(stringError, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
