package com.example.practica4serverless.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reserva {
    @Id
    @GeneratedValue
    private int id;

    private String idEstudiante;
    private String nombre;
    private String carrera;
    private String laboratorio;
    private Date fecha;

    public Reserva() {
    }

    public Reserva(String idEstudiante, String nombre, String carrera, String laboratorio, Date fecha) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.carrera = carrera;
        this.laboratorio = laboratorio;
        this.fecha = fecha;
    }

    public Reserva(String idEstudiante, String nombre, String laboratorio, Date fecha) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
