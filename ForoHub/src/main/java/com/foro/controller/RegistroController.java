package com.foro.controller;

import com.foro.entities.Perfil;
import com.foro.entities.usuario.Usuario;
import com.foro.entities.usuario.UsuarioRepository;

import com.foro.infra.security.DatosAutenticacionUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private PerfilRepository perfilRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<String> registrarUsuario(@RequestBody DatosAutenticacionUsuario datos) {
        String contrasenaEncriptada = passwordEncoder.encode(datos.contrasena());

        Perfil perfilUsuario = perfilRepository.findByNombre("ROLE_USUARIO")
                .orElseGet(() -> {
                    Perfil nuevoPerfil = new Perfil("ROLE_USUARIO");
                    return perfilRepository.save(nuevoPerfil);
                });

        Usuario nuevoUsuario = new Usuario(
                datos.nombre(),
                datos.correoElectronico(),
                contrasenaEncriptada
        );

        nuevoUsuario.getPerfiles().add(perfilUsuario);

        usuarioRepository.save(nuevoUsuario);

        return ResponseEntity.ok("Usuario registrado con éxito");
    }
}
