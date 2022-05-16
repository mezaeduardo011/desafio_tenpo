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

@Service
public class SumService {
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthRepository authRepository;


    public Integer suma(String token, SumDTO sum){

            jwtUtil.getKey(token);

            long now = (new Date()).getTime();
            Date date = new Date(now);

            Auth authEncontrado = authRepository.findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(token,date);

            if (authEncontrado.getUserId() != null){
                return sum.getNum1() + sum.getNum2();
            }else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
            }

    }
}

