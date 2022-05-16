package com.tenpo.desafio_tenpo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="history")
@Getter @Setter
public class RequestHistoryUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "date_at")
    private String dateAt;

    @Column(name = "endpoint")
    private String endpoint;

    @Column(name = "data")
    private String data;

}
