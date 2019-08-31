package com.company.CityListDesign.controller;

import org.springframework.beans.MethodInvocationException;
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
    VndErrors.VndError stringError = new VndErrors.VndError(exception.toString(), "Invalid name for city");
    return new ResponseEntity<>(stringError, HttpStatus.UNPROCESSABLE_ENTITY);
}

@ExceptionHandler(value = {NumberFormatException.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
public ResponseEntity<VndErrors.VndError> numberFormatExceptionHandler
            (NumberFormatException exception , WebRequest request){
        VndErrors.VndError clientErr = new VndErrors.VndError
                (exception.toString() ,
                        "Invalid population entered");
        return new ResponseEntity<>(clientErr , HttpStatus.BAD_REQUEST);

    }

@ExceptionHandler(value = {MethodInvocationException.class})
@ResponseStatus(HttpStatus.CONFLICT)
public ResponseEntity<VndErrors.VndError> methodFormatExceptionHandler
            (NumberFormatException exception , WebRequest request){
        VndErrors.VndError clientErr = new VndErrors.VndError
                (exception.toString() ,
                        "Invalid method");
        return new ResponseEntity<>(clientErr , HttpStatus.BAD_REQUEST);

    }
}
