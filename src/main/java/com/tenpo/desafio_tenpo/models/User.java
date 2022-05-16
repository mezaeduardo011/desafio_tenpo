package com.tenpo.desafio_tenpo.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
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
    @Email(message = "El email ingresado no es válido")
    private String email;

    @Getter
    @Setter
    @Column(name = "password", nullable = false)
    @NotBlank(message = "Debe ingresar una contraseña")
    @Size(min = 8, max = 200, message
            = "La contraseña debe tener entre 8 y 200 caracteres")
    private String password;

}
