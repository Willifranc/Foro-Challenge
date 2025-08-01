package com.foro.entities.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String nombreAutor,
        String nombreCurso
) {
    public DatosRespuestaTopico(Topico topico) {
        this(
           topico.getId(),
           topico.getTitulo(),
           topico.getMensaje(),
           topico.getFechaCreacion(),
           topico.getAutor().getNombre(),
           topico.getCurso().getNombre()
        );
    }
}
