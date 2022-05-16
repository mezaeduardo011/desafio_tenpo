package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public Page<User> findAll(Pageable pageable);

    public User save(User user);



}
