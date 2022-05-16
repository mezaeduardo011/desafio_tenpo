package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.Auth;
import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.repository.AuthRepository;
import com.tenpo.desafio_tenpo.repository.UserRepository;
import com.tenpo.desafio_tenpo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {
    private final UserRepository userRepository;

    private final AuthRepository authRepository;

    private final JWTUtil jwtUtil;

    public AuthService(UserRepository userRepository, AuthRepository authRepository, JWTUtil jwtUtil) {
        this.userRepository = userRepository;
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
    }

    public Map login(User user) {
        try{
            User userData = userRepository.findUserByEmail(user.getEmail());

            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

            if(argon2.verify(userData.getPassword(),user.getPassword())){

                String token = jwtUtil.create(String.valueOf(userData.getId()), userData.getEmail());

                long now = (new Date()).getTime();

                Date expiration;
                expiration = new Date(now + 50000);

                Auth auth = new Auth();
                auth.setToken(token);
                auth.setSessionActive(true);
                auth.setUserId(userData.getId());
                auth.setExpiration(expiration);
                authRepository.save(auth);


                Map<String, Object> response = new HashMap<String, Object>();
                response.put("token", token);

                return response;

            }else {
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED,"Incorrect user or password2");
            }
        }catch (NullPointerException e){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED,"Incorrect user or password");
        }



    }


    public Map logout(String tokenRequest) {


        long now = (new Date()).getTime();
        Date date = new Date(now);
        String token = tokenRequest.split(" ")[1];

        Auth authEncontrado = authRepository.findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(token,date);
        Map<String,String> response = new HashMap<String,String>();
        if (authEncontrado != null){
            authEncontrado.setSessionActive(true);
            authRepository.save(authEncontrado);
            response.put("message","Logout successfully");
            return response;

        }else {
            response.put("message","Logout  unsuccessful. ");
            return response;
        }


    }

    public Boolean validateToken(String tokenRequest){
        try{
            jwtUtil.getKey(tokenRequest);

            long now = (new Date()).getTime();
            Date date = new Date(now);
            String token = tokenRequest.split(" ")[1];
            Auth authEncontrado = authRepository.findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(token,date);

            if (authEncontrado.getUserId() != null){
                return true;
            }else {
                return false;
            }
        }catch (NullPointerException e){
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }catch (SignatureException e){
            throw new SignatureException("Unknown token");
        }

    }
}
