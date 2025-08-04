package com.foro.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


@Data
@NoArgsConstructor
@Entity
@Table(name = "perfiles")

public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Perfil(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public String getAuthority() {

        return nombre;
    }
}
