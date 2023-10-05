package com.example.practica4serverless.servicios.implementaciones;

import com.example.practica4serverless.entidades.Laboratorio;
import com.example.practica4serverless.entidades.Reserva;
import com.example.practica4serverless.repositorios.LabRepo;
import com.example.practica4serverless.repositorios.ReservaRepo;
import com.example.practica4serverless.servicios.ReservasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ReservasImpl implements ReservasService {

    @Autowired
    LabRepo labRepo;
    @Autowired
    ReservaRepo reservaRepo;

    public boolean agregarReserva(Reserva reserva) {
        if (puedeReservar(reserva.getIdEstudiante(), reserva.getLaboratorio())) {
            reservaRepo.save(reserva);
            return true;
        }
        return false;
    }

    public void eliminarReserva(Reserva reserva) {
        reservaRepo.delete(reserva);
        return;
    }

    public boolean existeLaboratorio(String nombre) {
        if (labRepo.findLaboratorioByNombre(nombre) != null) {
            return true;
        }
        return false;
    }

    public boolean puedeReservar(String idMatricula, String nombreLab) {
        // Verificar si el estudiante ya tiene una reserva.
        if (existeLaboratorio(nombreLab)) {
            // Buscar reservas que coincidan con este laboratorio. Luego de la fecha actual con IdEstudiante
            List<Reserva> reservasLab = reservaRepo
                    .findAllByLaboratorioAndFechaGreaterThanAndIdEstudiante
                            (nombreLab, Calendar.getInstance().getTime(), idMatricula);

            // Si no tiene reservas, puede hacerlo.
            if (reservasLab.size() == 0) {
                Laboratorio lab = labRepo.findLaboratorioByNombre(nombreLab);
                // Luego revisar si el laboratorio no excede sus reservas máximas.
                if ((reservaRepo.findAllByLaboratorioAndFechaGreaterThan(nombreLab, Calendar.getInstance().getTime())
                .size() <= lab.getCantidadMaxima())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void agregarLaboratorio(Laboratorio laboratorio) {
        if (!existeLaboratorio(laboratorio.getNombre())) {
            labRepo.save(laboratorio);
        }
        return;
    }

    public boolean eliminarLaboratorio(Laboratorio laboratorio) {
        // verificar si existe.
        Laboratorio eliminar = labRepo.findLaboratorioByNombre(laboratorio.getNombre());
        if (eliminar != null) {
            // Eliminar todas sus reservas tambien
            List<Reserva> reservasLab = reservaRepo.findAllByLaboratorio(eliminar.getNombre());
            for (Reserva reserva:
                 reservasLab) {
                reservaRepo.delete(reserva);
            }
            // Eliminar laboratorio
            labRepo.delete(eliminar);
            return true;
        }
        return false;
    }

    public List<Reserva> reservasActuales() {
        return reservaRepo.findAllByFechaGreaterThan(Calendar.getInstance().getTime());
    }
    public List<Reserva> reservasTimed(Date inicio, Date fin) {
        return reservaRepo.findAllByFechaGreaterThanAndFechaLessThan(inicio, fin);
    }
    public List<Reserva> reservasAntes() {
        return reservaRepo.findAllByFechaLessThan(Calendar.getInstance().getTime());
    }
    public List<Laboratorio> misLaboratorios() {
        return labRepo.findAll();
    }

    public Reserva buscarReserva(int id) {
        return reservaRepo.findById(id);
    }
    public Laboratorio buscarLaboratorio(int id) {
        return labRepo.findById(id);
    }

}
