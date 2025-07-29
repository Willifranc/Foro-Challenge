package com.foro.entities;

import com.foro.entities.topico.Topico;
import com.foro.entities.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "respuestas")

public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private Boolean solucion = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private Topico topico;

    public Respuesta(String mensaje, Usuario autor, Topico topico) {
        this.mensaje = mensaje;
        this.autor = autor;
        this.topico = topico;
    }

}
