package com.tenpo.desafio_tenpo.repository;

import com.tenpo.desafio_tenpo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
