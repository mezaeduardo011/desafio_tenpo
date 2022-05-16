package com.tenpo.desafio_tenpo.services.impl;

import com.tenpo.desafio_tenpo.models.Auth;
import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.repository.AuthRepository;
import com.tenpo.desafio_tenpo.repository.UserRepository;
import com.tenpo.desafio_tenpo.services.AuthService;
import com.tenpo.desafio_tenpo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public String login(User user) {

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


            return token;

        }else {

            return "Incorrect user or password";

        }

    }

    @Override
    public String logout(String tokenRequest) {

        long now = (new Date()).getTime();
        Date date = new Date(now);
        String token = tokenRequest.split(" ")[1];

        Auth authEncontrado = authRepository.findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(token,date);
        authEncontrado.setSessionActive(false);
        authRepository.save(authEncontrado);
        return authEncontrado.getSessionActive().toString();
    }


}
