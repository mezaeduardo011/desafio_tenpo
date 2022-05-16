package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> createUser(@RequestBody User user, WebRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body( authService.login(user,request));
    }

    @PostMapping("/logout")
    public ResponseEntity<Object> logout( @RequestHeader(value="Authorization") String token,WebRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body( authService.logout(token,request) );
    }


}
