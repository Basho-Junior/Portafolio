package com.example.basenotificaciones.services;

import com.example.basenotificaciones.objects.Notificacion;
import com.example.basenotificaciones.repo.NotificacionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {
    private final NotificacionRepo notificacionRepo;
    @Override
    public Notificacion guardarNotificacion(Notificacion notificacion) {
        return notificacionRepo.save(notificacion);
    }

    @Override
    public Notificacion modificarNotificacion(Notificacion notificacion) {
        Notificacion buscar = notificacionRepo.findByNombre(notificacion.getNombre());
        if (buscar != null) {
            buscar.setUsername(notificacion.getUsername());
            buscar.setPaquete(notificacion.getPaquete());
            buscar.setFecha(notificacion.getFecha());
            buscar.setMensaje(notificacion.getMensaje());
            buscar = notificacionRepo.save(buscar);
        }
        return buscar;
    }

    @Override
    public boolean eliminarNotificacion(Notificacion notificacion) {
        Notificacion eliminar = notificacionRepo.findByNombre(notificacion.getNombre());
        if (eliminar != null) {
            notificacionRepo.delete(eliminar);
            return true;
        }
        return false;
    }

    @Override
    public List<Notificacion> getNotificaciones() {
        return notificacionRepo.findAll();
    }
}
