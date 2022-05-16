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
    public ResponseEntity<Integer> sum(@RequestBody SumDTO sum, @RequestHeader(value="Authorization") String tokenRequest)  {
            String token = tokenRequest.split(" ")[1];
            return ResponseEntity.status(HttpStatus.CREATED).body( this.sumService.suma(token,sum));
    }
}


