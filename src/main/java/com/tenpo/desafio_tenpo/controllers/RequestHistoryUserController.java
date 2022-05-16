package com.tenpo.desafio_tenpo.controllers;


import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import com.tenpo.desafio_tenpo.services.RequestHistoryUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/history")
public class RequestHistoryUserController {

    private final RequestHistoryUserService requestHistoryUserService;

    public RequestHistoryUserController(RequestHistoryUserService requestHistoryUserService) {
        this.requestHistoryUserService = requestHistoryUserService;
    }


    @GetMapping("/{page}/{size}")
    public List<RequestHistoryUser> readAll(@PathVariable(value = "page") Integer page, @PathVariable(value = "size") Integer size){
        return StreamSupport
                .stream(this.requestHistoryUserService.findAll(page,size).spliterator(),false )
                .collect(Collectors.toList());
    }
}
