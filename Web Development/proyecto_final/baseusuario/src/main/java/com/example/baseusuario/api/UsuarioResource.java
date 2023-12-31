package com.example.baseusuario.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.baseusuario.objects.Rol;
import com.example.baseusuario.objects.Usuario;
import com.example.baseusuario.services.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//@CrossOrigin//(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class UsuarioResource {
    private final UsuarioService usuarioService;
    //
    @GetMapping("/usuario")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok().body(usuarioService.getUsuarios());
    }
    @PostMapping("/usuario/obtener")
    public ResponseEntity<Usuario> getUsuario(@RequestParam String username) {
        return ResponseEntity.ok().body(usuarioService.getUsuario(username));
    }
    // Guardar nueva entidad
    @PostMapping("/usuario/guardar")
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/auth/usuario/guardar").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.guardarUsuario(usuario));
    }
    @PostMapping("/usuario/crear")
    public ResponseEntity<Usuario> crearUsuario(@RequestParam String username,
                                                @RequestParam String nombre, @RequestParam String apellido,
                                                @RequestParam String correo, @RequestParam String clave,
                                                @RequestParam String rol) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/auth/usuario/guardar").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.crearUsuario(username, nombre, apellido, correo, clave, rol));
    }
    @PutMapping("/usuario/cambiar")
    public ResponseEntity<Usuario> cambiarUsuario(@RequestParam String username,
                                                @RequestParam String nombre, @RequestParam String apellido,
                                                @RequestParam String correo, @RequestParam String clave,
                                                @RequestParam String rol) {
        return  ResponseEntity.ok().body(usuarioService.cambiarUsuario(username, nombre, apellido, correo, clave, rol));
    }
    // Update / Guardar entidad
    @PutMapping("/usuario/modificar")
    public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.modificarUsuario(usuario));
    }
    // Cambiar clave / admin
    @PutMapping("/usuario/cambiarclave")
    public ResponseEntity<Usuario> cambiarClaveUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.cambiarClave(usuario));
    }


    // Perfil modificar
    @PutMapping("/perfil/modificar")
    public ResponseEntity<Usuario> perfilUsuarioModificar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.perfilUsuarioModificar(usuario));
    }

    // Perfil
    @PutMapping("/perfil/cambiarclave")
    public ResponseEntity<Usuario> perfilUsuarioClave(@RequestParam String clave, @RequestParam String nueva) {
        return ResponseEntity.ok().body(usuarioService.perfilUsuarioClave(clave, nueva));
    }


    @GetMapping("/perfil/perfil")
    public ResponseEntity<Usuario> getMiPerfil() {
        return ResponseEntity.ok().body(usuarioService.obtenerMiPerfil());
    }
    // Eliminar entidad de usuario.
    @DeleteMapping("/usuario/eliminar")
    public ResponseEntity<?> eliminarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.eliminarUsuario(usuario));
    }
    @DeleteMapping("/usuario/remover")
    public ResponseEntity<?> eliminarUsuario(@RequestParam String username) {
        return ResponseEntity.ok().body(usuarioService.eliminarUsuario(usuarioService.getUsuario(username)));
    }
    @GetMapping("/rol")
    public ResponseEntity<List<Rol>> getRoles() {
        return ResponseEntity.ok().body(usuarioService.getRoles());
    }

    @PostMapping("/rol/guardar")
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/auth/rol/guardar").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.guardarRol(rol));
    }

    @PostMapping("/rol/addtousuario")
    public ResponseEntity<?> addRolAUsuario(@RequestBody RolAUsuarioForm form) {
        usuarioService.addRolAUsuario(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rol/deletefromusuario")
    public ResponseEntity<?> deleteRolDeUsuario(@RequestBody RolAUsuarioForm form) {
        usuarioService.deleteRolDeUsuario(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("potatomysecretkey_123".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);

                String username = decodedJWT.getSubject();
                Usuario usuario = usuarioService.getUsuario(username);
                // 24 horas
                String access_token = JWT.create()
                        .withSubject(usuario.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .withIssuer(request.getRequestURI().toString())
                        .withClaim("roles", usuario.getRoles().stream().map(Rol::getNombre)
                                .collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception e) {
                log.error("Error ingresando en: {}", e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    // Registro
//    @CrossOrigin
    @PostMapping("/registro/usuario")
    public ResponseEntity<?> registrarCliente(@RequestBody Usuario cliente) {
        return ResponseEntity.ok().body(usuarioService.registrarCliente(cliente));
    }

    // Validaciones.
    @PostMapping("/validate/userexist")
    public ResponseEntity<?> userExists(@RequestParam String username) {
        return ResponseEntity.ok().body(usuarioService.existeUsuario(username));
    }

    @PostMapping("/bot/orderReceived")
    public ResponseEntity<String> orderReceived(@RequestBody String usuario) {
        return ResponseEntity.ok().body(usuarioService.notificarEmpleados(usuario));
    }
}

@Data
class RolAUsuarioForm {
    private String username;
    private String rolename;
}