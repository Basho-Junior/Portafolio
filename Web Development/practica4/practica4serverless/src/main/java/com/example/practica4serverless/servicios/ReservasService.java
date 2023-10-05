package com.example.practica4serverless.servicios;

import com.example.practica4serverless.entidades.Laboratorio;
import com.example.practica4serverless.entidades.Reserva;

import java.util.Date;
import java.util.List;

public interface ReservasService {
    public boolean agregarReserva(Reserva reserva);
    public void eliminarReserva(Reserva reserva);
    public boolean existeLaboratorio(String nombre);
    public boolean puedeReservar(String idMatricula, String nombreLab);
    public void agregarLaboratorio(Laboratorio laboratorio);
    public boolean eliminarLaboratorio(Laboratorio laboratorio);
    // Retornar datos.
    public List<Reserva> reservasActuales();
    public List<Reserva> reservasAntes();
    public List<Reserva> reservasTimed(Date inicio, Date fin);
    public List<Laboratorio> misLaboratorios();
    // Buscar cosas.
    public Reserva buscarReserva(int id);
    public Laboratorio buscarLaboratorio(int id);
}
