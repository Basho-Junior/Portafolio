package com.example.practica4serverless.repositorios;

import com.example.practica4serverless.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservaRepo extends JpaRepository<Reserva, Integer> {
    public List<Reserva> findAllByLaboratorioAndFechaGreaterThanAndIdEstudiante(String laboratorio,
                                                                                    Date fecha,
                                                                                    String idEstudiante);
    public List<Reserva> findAllByLaboratorioAndFechaGreaterThan(String laboratorio, Date fecha);
    public List<Reserva> findAllByLaboratorio(String laboratorio);
    public List<Reserva> findAllByFechaGreaterThanAndFechaLessThan(Date inicio, Date fin);
    public List<Reserva> findAllByFechaGreaterThan(Date actual);
    public List<Reserva> findAllByFechaLessThan(Date actual);
    public Reserva findById(int id);
}
