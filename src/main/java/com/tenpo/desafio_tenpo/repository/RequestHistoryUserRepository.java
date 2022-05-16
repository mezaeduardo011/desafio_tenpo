package com.tenpo.desafio_tenpo.repository;

import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestHistoryUserRepository extends JpaRepository<RequestHistoryUser,Long>  {

}
