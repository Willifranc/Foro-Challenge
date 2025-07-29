package com.foro.entities.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.foro.entities.topico.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);
}
