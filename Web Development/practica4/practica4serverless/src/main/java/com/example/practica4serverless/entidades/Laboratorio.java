package com.example.practica4serverless.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Laboratorio {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private int cantidadMaxima;

    public Laboratorio() {
    }

    public Laboratorio(String nombre, int cantidadMaxima) {
        this.nombre = nombre;
        this.cantidadMaxima = cantidadMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }
}
