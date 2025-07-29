package com.foro.infra;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GestorDeErrores extends RuntimeException{
    public GestorDeErrores(Long id) {
        super("Topico no encontrado con ID: " + id);
    }
}
