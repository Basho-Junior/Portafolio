package com.example.basenotificaciones.api;

import com.example.basenotificaciones.objects.Notificacion;
import com.example.basenotificaciones.services.NotificacionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/notificacion")
@RequiredArgsConstructor
@Slf4j
public class NotificacionResource {
    private final NotificacionService notificacionService;

    @GetMapping("/")
    public ResponseEntity<List<Notificacion>> getNotificaciones() {
        return ResponseEntity.ok().body(notificacionService.getNotificaciones());
    }

    @PostMapping("/guardar")
    public ResponseEntity<Notificacion> guardarNotificacion(@RequestBody Notificacion notificacion) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/notificacion/guardar").toUriString());
        return ResponseEntity.created(uri).body(notificacionService.guardarNotificacion(notificacion));
    }

    @PutMapping("/modificar")
    public ResponseEntity<Notificacion> modificarNotificacion(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok().body(notificacionService.modificarNotificacion(notificacion));
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<?> eliminarNotificacion(@RequestBody Notificacion notificacion) {
        return ResponseEntity.ok().body(notificacionService.eliminarNotificacion(notificacion));
    }
}
