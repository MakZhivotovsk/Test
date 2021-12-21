package com.example.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CostNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String pricesNotFoundHandler(CostNotFoundException ex) {
        return ex.getMessage();
    }
}
