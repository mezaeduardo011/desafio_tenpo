package com.tenpo.desafio_tenpo.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
public class ErrorAdvice {
    @Getter
    @Setter
    private String code;

    @Getter @Setter
    private String message;
}
