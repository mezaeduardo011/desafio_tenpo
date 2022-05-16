package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface RequestHistoryUserService {

    public Page<RequestHistoryUser> findAll(Pageable pageable);

    public RequestHistoryUser save(RequestHistoryUser requestHistoryUser);
}
