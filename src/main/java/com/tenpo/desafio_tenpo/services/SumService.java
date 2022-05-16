package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.dto.SumDTO;
import com.tenpo.desafio_tenpo.repository.AuthRepository;
import com.tenpo.desafio_tenpo.utils.JWTUtil;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

@Service
public class SumService {
    private final JWTUtil jwtUtil;

    private final AuthRepository authRepository;

    private final AuthService authService;
    public SumService(JWTUtil jwtUtil, AuthRepository authRepository, AuthService authService) {
        this.jwtUtil = jwtUtil;
        this.authRepository = authRepository;
        this.authService = authService;
    }


    public Map suma(String tokenRequest, SumDTO sum){


        try{

            Map<String, Object> response = new HashMap<String, Object>();

            if(this.authService.validateToken(tokenRequest)){
                Integer result =  sum.getNum1() + sum.getNum2();
                response.put("result", result);
            }else{
                response.put("result", "Invalid Token");
            }

            return response;

        }catch (NullPointerException e){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }catch (SignatureException e){
            throw new SignatureException("Unknown token");
        }


    }

}

