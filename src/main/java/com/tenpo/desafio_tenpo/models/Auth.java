package com.tenpo.desafio_tenpo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "auth")
public class Auth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Getter @Setter
    @Column(name = "user_id")
    private Long userId;

    @Getter @Setter
    @Column(name = "token")
    private String token;

    @Getter @Setter
    @Column(name = "session_active")
    private Boolean sessionActive;

    @Getter @Setter
    @Column(name = "expiration")
    private Date expiration;


}
