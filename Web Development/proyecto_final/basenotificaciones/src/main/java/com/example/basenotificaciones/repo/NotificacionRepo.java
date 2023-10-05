package com.example.basenotificaciones.repo;

import com.example.basenotificaciones.objects.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepo extends JpaRepository<Notificacion, Long> {
    Notificacion findByNombre(String nombre);
}
