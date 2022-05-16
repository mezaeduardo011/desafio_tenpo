package com.tenpo.desafio_tenpo.services;

import com.tenpo.desafio_tenpo.models.RequestHistoryUser;
import com.tenpo.desafio_tenpo.repository.RequestHistoryUserRepository;
import com.tenpo.desafio_tenpo.utils.JWTUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RequestHistoryUserService {


    private final RequestHistoryUserRepository requestHistoryUserRepository;
    private final JWTUtil jwtUtil;

    public RequestHistoryUserService(RequestHistoryUserRepository requestHistoryUserRepository, JWTUtil jwtUtil) {
        this.requestHistoryUserRepository = requestHistoryUserRepository;
        this.jwtUtil = jwtUtil;
    }

    @Transactional(readOnly = true)
    public Page<RequestHistoryUser> findAll(Integer page, Integer size) {
        Pageable pageObj = PageRequest.of(page, size);
        return requestHistoryUserRepository.findAll(pageObj);
    }


    public RequestHistoryUser save(String token, WebRequest request) {

        RequestHistoryUser requestHistoryUser = new RequestHistoryUser();


        String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());

        Long userId = Long.parseLong(this.jwtUtil.getKey(token));
        requestHistoryUser.setUserId(userId);
        requestHistoryUser.setUserEmail(this.jwtUtil.getValue(token));
        requestHistoryUser.setEndpoint(request.toString());
        requestHistoryUser.setDateAt(date);

        return requestHistoryUserRepository.save(requestHistoryUser);
    }



}
