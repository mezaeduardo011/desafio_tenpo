package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.dto.SumDTO;
import com.tenpo.desafio_tenpo.services.SumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
@RequestMapping("api/suma")
public class SumController {

    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping
    public ResponseEntity<Object> sum(@RequestBody SumDTO sum, @RequestHeader(value="Authorization") String tokenRequest, WebRequest request)  {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body( this.sumService.suma(tokenRequest,request,sum));
    }
}


