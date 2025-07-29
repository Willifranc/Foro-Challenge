package com.foro.entities.topico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        Topico topico = topicoService.registrar(datos);
        DatosRespuestaTopico respuesta = new DatosRespuestaTopico(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @GetMapping
    public ResponseEntity<List<DatosRespuestaTopico>> listarTopicos() {
        List<DatosRespuestaTopico> lista = topicoService.listar();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosDetalleTopico> obtenerDetalleTopico(@PathVariable Long id) {
        DatosDetalleTopico detalle = topicoService.obtenerDetalle(id);
        return ResponseEntity.ok(detalle);
    }

    @PutMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizarTopico datos) {

        Topico topicoActualizado = topicoService.actualizar(id, datos);
        DatosRespuestaTopico respuesta = new DatosRespuestaTopico(topicoActualizado);
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<?> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
