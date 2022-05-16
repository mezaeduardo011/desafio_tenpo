package com.tenpo.desafio_tenpo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "invalid email")
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    @NotBlank(message = "Password required")
    @Size(min = 8, max = 200, message
            = "Password must have at least 20 characters")
    private String password;

}
