package com.foro.entities.topico;

import com.foro.entities.curso.Curso;
import com.foro.entities.curso.CursoRepository;
import com.foro.entities.usuario.Usuario;
import com.foro.entities.usuario.UsuarioRepository;
import com.foro.infra.CursoNoEncontradoException;
import com.foro.infra.GestorDeErrores;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Topico registrar(DatosRegistroTopico datos){
        Usuario autor = usuarioRepository.findById(datos.autorId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Curso curso = cursoRepository.findById(datos.cursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Topico topico = new Topico(datos.titulo(), datos.mensaje(), autor, curso);
        return topicoRepository.save(topico);
    }

    public List<DatosRespuestaTopico> listar() {
        return topicoRepository.findAll()
                .stream()
                .map(DatosRespuestaTopico::new)
                .collect(Collectors.toList());
    }

    public DatosDetalleTopico obtenerDetalle(Long id) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new GestorDeErrores(id));
        return new DatosDetalleTopico(topico);
    }

    @Transactional
    public Topico actualizar(Long id, @Valid DatosActualizarTopico datos) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new GestorDeErrores(id));

        if (datos.titulo() != null && !datos.titulo().isBlank()) {
            topico.setTitulo(datos.titulo());
        }

        if (datos.mensaje() != null && !datos.mensaje().isBlank()) {
            topico.setMensaje(datos.mensaje());
        }

        if (datos.cursoId() != null) {
            Curso curso = cursoRepository.findById(datos.cursoId())
                    .orElseThrow(() -> new CursoNoEncontradoException(datos.cursoId()));
            topico.setCurso(curso);
        }
        return topico;

    }

    @Transactional
    public void eliminar(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if (topico.isPresent()) {
            topicoRepository.deleteById(id);
        } else {
            throw new GestorDeErrores(id);
        }
    }
}

