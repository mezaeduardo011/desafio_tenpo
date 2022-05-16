package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.dto.SumDTO;
import com.tenpo.desafio_tenpo.services.SumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/suma")
public class SumController {

    private final SumService sumService;

    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping
    public ResponseEntity<Object> sum(@RequestBody SumDTO sum, @RequestHeader(value="Authorization") String tokenRequest)  {
            return ResponseEntity.status(HttpStatus.FOUND).body( this.sumService.suma(tokenRequest,sum));
    }
}


