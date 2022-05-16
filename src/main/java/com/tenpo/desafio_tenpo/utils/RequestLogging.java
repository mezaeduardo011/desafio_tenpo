package com.tenpo.desafio_tenpo.utils;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

public class RequestLogging  extends AbstractRequestLoggingFilter {
    @Override
    protected void beforeRequest(HttpServletRequest httpServletRequest, String message) {
        System.out.println("LOOGGSSS");
        System.out.println(message);
    }

    @Override
    protected void afterRequest(HttpServletRequest httpServletRequest, String message) {

    }
}
