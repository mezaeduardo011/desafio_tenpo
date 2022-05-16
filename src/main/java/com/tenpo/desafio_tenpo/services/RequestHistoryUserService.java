package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import com.tenpo.desafio_tenpo.repository.RequestHistoryUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestHistoryUserService {


    private final RequestHistoryUserRepository requestHistoryUserRepository;

    public RequestHistoryUserService(RequestHistoryUserRepository requestHistoryUserRepository) {
        this.requestHistoryUserRepository = requestHistoryUserRepository;
    }

    @Transactional(readOnly = true)
    public Page<RequestHistoryUser> findAll(Integer page, Integer size) {
        Pageable pageObj = PageRequest.of(page, size);
        return requestHistoryUserRepository.findAll(pageObj);
    }


    public RequestHistoryUser save(RequestHistoryUser requestHistoryUser) {
        return requestHistoryUserRepository.save(requestHistoryUser);
    }



}
