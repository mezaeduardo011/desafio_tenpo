package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.models.ErrorAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ErrorAdvice> illegalArgumentHandler(IllegalArgumentException ex){
        ErrorAdvice error = ErrorAdvice.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResponseEntity<ErrorAdvice> missingRequestHeaderExceptionHandler(MissingRequestHeaderException ex){
        ErrorAdvice error = ErrorAdvice.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorAdvice> runtimeExceptionHandler(ConstraintViolationException ex){

        List<String> listError = new ArrayList<>();
        ex.getConstraintViolations().forEach(error ->listError.add(error.getMessage()) );

        ErrorAdvice errorResponse = ErrorAdvice.builder().code("400").message(listError.toString()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpClientErrorException.Unauthorized.class)
    public ResponseEntity<ErrorAdvice> runtimeExceptionHandler(HttpClientErrorException.Unauthorized ex){
        ErrorAdvice errorResponse = ErrorAdvice.builder().code("401").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorAdvice> runtimeExceptionHandler(SQLIntegrityConstraintViolationException ex){
        ErrorAdvice errorResponse = ErrorAdvice.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }






}