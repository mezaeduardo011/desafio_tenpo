package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.dto.SumDTO;
import com.tenpo.desafio_tenpo.models.Auth;
import com.tenpo.desafio_tenpo.repository.AuthRepository;
import com.tenpo.desafio_tenpo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SumService {
    private final JWTUtil jwtUtil;

    private final AuthRepository authRepository;

    public SumService(JWTUtil jwtUtil, AuthRepository authRepository) {
        this.jwtUtil = jwtUtil;
        this.authRepository = authRepository;
    }


    public Map suma(String tokenRequest, SumDTO sum){
        try{
            String token = tokenRequest.split(" ")[1];
            jwtUtil.getKey(token);

            long now = (new Date()).getTime();
            Date date = new Date(now);

            Auth authEncontrado = authRepository.findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(token,date);

            if (authEncontrado.getUserId() != null){
                Integer result =  sum.getNum1() + sum.getNum2();
                Map<String, Object> response = new HashMap<String, Object>();
                response.put("result", result);
                return response;
            }else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            }
        }catch (NullPointerException e){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }
}

