package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody User user) {
         return ResponseEntity.status(HttpStatus.CREATED).body( this.userService.save(user));
    }




}
