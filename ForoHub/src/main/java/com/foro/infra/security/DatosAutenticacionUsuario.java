package com.foro.infra.security;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(
        String nombre,
        @NotBlank String correoElectronico,
        @NotBlank String contrasena
    ) {}
