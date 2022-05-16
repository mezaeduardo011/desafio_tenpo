package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
         return ResponseEntity.status(HttpStatus.CREATED).body( this.userService.save(user));
    }

    @GetMapping("/{page}/{size}")
    public List<User> readAll(@PathVariable(value = "page") Integer page,@PathVariable(value = "size") Integer size){

        Pageable sortedByName =
                PageRequest.of(page, size);

        return StreamSupport
                .stream(this.userService.findAll(sortedByName).spliterator(),false )
                .collect(Collectors.toList());
    }


}
