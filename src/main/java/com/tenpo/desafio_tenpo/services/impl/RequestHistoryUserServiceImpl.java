package com.tenpo.desafio_tenpo.services.impl;

import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import com.tenpo.desafio_tenpo.repository.RequestHistoryUserRepository;
import com.tenpo.desafio_tenpo.services.RequestHistoryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestHistoryUserServiceImpl implements RequestHistoryUserService {

    @Autowired
    private RequestHistoryUserRepository requestHistoryUserRepository;


    @Override
    @Transactional(readOnly = true)
    public Page<RequestHistoryUser> findAll(Pageable pageable) {
        return requestHistoryUserRepository.findAll(pageable);
    }

    @Override
    public RequestHistoryUser save(RequestHistoryUser requestHistoryUser) {
      return requestHistoryUserRepository.save(requestHistoryUser);
    }



}
