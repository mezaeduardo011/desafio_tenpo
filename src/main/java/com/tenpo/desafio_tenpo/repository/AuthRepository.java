package com.tenpo.desafio_tenpo.repository;

import com.tenpo.desafio_tenpo.models.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {
    Auth findAuthByTokenAndExpirationAfterAndSessionActiveIsTrue(String token, Date now);

}
