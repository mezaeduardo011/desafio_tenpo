package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.User;
import com.tenpo.desafio_tenpo.repository.UserRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Map save(User user) {
        try {
            String password = user.getPassword();

            if(password != null && !password.trim().isEmpty()){
                Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                String hash = argon2.hash(1, 1024, 1, user.getPassword());
                user.setPassword(hash);
            }

            User userResponse = userRepository.save(user);

            Map<String, Object> response = new HashMap<String, Object>();

            if(userResponse != null){
                response.put("result", "Create successfully");
            }else {
                response.put("result", "Create unsuccessful");
            }

            return response;

        }catch (Exception e){
            throw e;
        }

    }

}
