package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.User;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {

    public String login(User user);

    public String logout(String token);

}
