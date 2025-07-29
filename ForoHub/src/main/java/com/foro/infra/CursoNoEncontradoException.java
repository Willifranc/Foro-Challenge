package com.foro.infra;

public class CursoNoEncontradoException extends RuntimeException{
    public CursoNoEncontradoException(Long id) {
        super("Curso con ID " + id + " no fue encontrado");
    }
}
