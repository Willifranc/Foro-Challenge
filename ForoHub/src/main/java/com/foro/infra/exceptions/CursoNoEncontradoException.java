package com.foro.infra.exceptions;

public class CursoNoEncontradoException extends RuntimeException{
    public CursoNoEncontradoException(Long id) {
        super("Curso con ID " + id + " no fue encontrado");
    }
}
