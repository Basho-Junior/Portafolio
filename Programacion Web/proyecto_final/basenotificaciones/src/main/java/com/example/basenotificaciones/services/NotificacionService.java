package com.example.basenotificaciones.services;

import com.example.basenotificaciones.objects.Notificacion;

import java.util.List;

public interface NotificacionService {
    // Guardar notificacion.
    Notificacion guardarNotificacion (Notificacion notificacion);
    Notificacion modificarNotificacion (Notificacion notificacion);
    boolean eliminarNotificacion (Notificacion notificacion);
    List<Notificacion> getNotificaciones();
}
