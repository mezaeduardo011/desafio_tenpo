package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.dto.ErrorAdviceDTO;
import org.postgresql.util.PSQLException;
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
    public ResponseEntity<ErrorAdviceDTO> IllegalArgumentExceptionHandler(IllegalArgumentException ex){
        ErrorAdviceDTO error = ErrorAdviceDTO.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResponseEntity<ErrorAdviceDTO> MissingRequestHeaderExceptionHandler(MissingRequestHeaderException ex){
        ErrorAdviceDTO error = ErrorAdviceDTO.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorAdviceDTO> ConstraintViolationExceptionHandler(ConstraintViolationException ex){

        List<String> listError = new ArrayList<>();
        ex.getConstraintViolations().forEach(error ->listError.add(error.getMessage()) );

        ErrorAdviceDTO errorResponse = ErrorAdviceDTO.builder().code("400").message(listError.toString()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<ErrorAdviceDTO> HttpClientErrorExceptionHandler(HttpClientErrorException ex){
        ErrorAdviceDTO errorResponse = ErrorAdviceDTO.builder().code("401").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorAdviceDTO> SQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException ex){
        ErrorAdviceDTO errorResponse = ErrorAdviceDTO.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<ErrorAdviceDTO> PSQLExceptionHandler(PSQLException ex){
        ErrorAdviceDTO errorResponse = ErrorAdviceDTO.builder().code("400").message(ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


}