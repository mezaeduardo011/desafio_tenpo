package com.tenpo.desafio_tenpo.controllers;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }




    @PostMapping("/login")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body( authService.login(user));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout( @RequestHeader(value="Authorization") String token){
        return ResponseEntity.status(HttpStatus.CREATED).body( authService.logout(token) );
    }


}
