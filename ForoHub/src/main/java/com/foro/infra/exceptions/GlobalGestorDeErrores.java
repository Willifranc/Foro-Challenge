package com.foro.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalGestorDeErrores {

    @ExceptionHandler(GestorDeErrores.class)
    public ResponseEntity<?> manejarTopicoNoEncontrado(GestorDeErrores ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "mensaje", ex.getMessage(),
                        "fecha", LocalDateTime.now()
                )
        );
    }
    @ExceptionHandler(CursoNoEncontradoException.class)
    public ResponseEntity<?>manejarCursoNoEncontrado(CursoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of(
                        "mensaje", ex.getMessage(),
                        "fecha", LocalDateTime.now()
                )
        );
    }

}
