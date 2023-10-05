package com.example.practica11.controller;

import com.example.practica11.entidades.MockEndpoint;
import com.example.practica11.entidades.Usuario;
import com.example.practica11.entidades.composite.MockEndpointPK;
import com.example.practica11.entidades.repositorios.MockEndpointRepo;
import com.example.practica11.entidades.repositorios.UsuarioRepo;
import com.example.practica11.utilidades.MockEndpointMethods;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Endpoint;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Controller()
@RequestMapping("/mock")
public class MockController {

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Autowired
    private MockEndpointRepo mockEndpointRepo;

    @Autowired
    UsuarioRepo usuarioRepository;

    @RequestMapping("/{proyectoID}/{*path}")
    public ResponseEntity<Object> getMock(HttpServletRequest request, @PathVariable("proyectoID") String proyectoID, @PathVariable("path") String path) {
        Optional<MockEndpoint> optional = mockEndpointRepo.findById(new MockEndpointPK(proyectoID, MockEndpointMethods.valueOf(request.getMethod().toUpperCase()), path));
        if (optional.isPresent() /*&& optional.*/) {
            MockEndpoint endpoint = optional.get();
            if (!endpoint.getJwtRequired()) { // si no es requerido jwt. Funcionar normal.
                if (endpoint.getExpiration().after(Timestamp.from(Instant.now()))) { // y no se requiere jwt
                    //encabezados
                    HttpHeaders headers = new HttpHeaders();
                    //tipo del documento, se puedo añadir el charset luego mediante un + ";charset={value}".
                    for (Map.Entry<String, String> header : endpoint.getHeaders().entrySet()) {
                        headers.add(header.getKey(), header.getValue());
                    }
                    headers.add(HttpHeaders.CONTENT_TYPE, endpoint.getContentType());
                    //creando la respuesta y el status de este
                    if (endpoint.getSendTime() > 0) {
                        // Espera.
                        try {
                            // Esperar tiempo de envío
                            Thread.sleep(endpoint.getSendTime() * 1000);
                        } catch (InterruptedException ie) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    ResponseEntity<Object> respuesta = ResponseEntity.status(endpoint.getHttpCode()).headers(headers).body(endpoint.getBody());
                    return respuesta;
                } else {
                    mockEndpointRepo.delete(endpoint);
                }
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Endpoint no encontrado."
        );
    }

    // Esto ya tiene su filtro en la clase JWTAuthFilter
    @RequestMapping("/jwt/{proyectoID}/{*path}")
    public ResponseEntity<Object> getMockJwt(HttpServletRequest request, @PathVariable("proyectoID") String proyectoID, @PathVariable("path") String path) {
        Optional<MockEndpoint> optional = mockEndpointRepo.findById(new MockEndpointPK(proyectoID, MockEndpointMethods.valueOf(request.getMethod().toUpperCase()), path));
        if (optional.isPresent() /*&& optional.*/) {
            MockEndpoint endpoint = optional.get();
            if (endpoint.getExpiration().after(Timestamp.from(Instant.now()))) { // y no se requiere jwt
                //encabezados
                HttpHeaders headers = new HttpHeaders();
                //tipo del documento, se puedo añadir el charset luego mediante un + ";charset={value}".
                for (Map.Entry<String, String> header : endpoint.getHeaders().entrySet()) {
                    headers.add(header.getKey(), header.getValue());
                }

                headers.add(HttpHeaders.CONTENT_TYPE, endpoint.getContentType());
                if (endpoint.getSendTime() > 0) {
                    // Espera.
                    try {
                        // Esperar tiempo de envío
                        Thread.sleep(endpoint.getSendTime() * 1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                }
                //creando la respuesta y el status de este
                ResponseEntity<Object> respuesta = ResponseEntity.status(endpoint.getHttpCode()).headers(headers).body(endpoint.getBody());
                return respuesta;
            } else {
                mockEndpointRepo.delete(endpoint);
            }
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Endpoint no encontrado."
        );
    }
}
