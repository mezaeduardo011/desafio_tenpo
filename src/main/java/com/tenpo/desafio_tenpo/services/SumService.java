package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.dto.SumDTO;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Service
public class SumService {
    private final RequestHistoryUserService requestHistoryUserService;
    private final AuthService authService;
    public SumService(AuthService authService,RequestHistoryUserService requestHistoryUserService) {
        this.authService = authService;
        this.requestHistoryUserService = requestHistoryUserService;
    }



    public Map suma(String tokenRequest, WebRequest request, SumDTO sum){

        try{

            Map<String, Object> response = new HashMap<String, Object>();

            if(Boolean.TRUE.equals(this.authService.validateToken(tokenRequest))){
                this.requestHistoryUserService.save(tokenRequest,request);
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

