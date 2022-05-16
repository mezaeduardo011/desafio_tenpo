package com.tenpo.desafio_tenpo.services.impl;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.repository.UserRepository;
import com.tenpo.desafio_tenpo.services.UserService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User save(User user) {
        try {
            String password = user.getPassword();

            if(password != null && !password.trim().isEmpty()){
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                String hash = argon2.hash(1, 1024, 1, user.getPassword());
                user.setPassword(hash);
            }

            return userRepository.save(user);
        }catch (Exception e){
            throw e;
        }

    }


}
