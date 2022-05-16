package com.tenpo.desafio_tenpo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
public class ErrorAdviceDTO {
    @Getter
    @Setter
    private String code;

    @Getter @Setter
    private String message;
}
