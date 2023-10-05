package com.example.practica1.entidades;

import javax.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int matricula;
    private String nombre;
    private String telefono;

    public Estudiante() {
    }

    public Estudiante(int matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public Estudiante(int matricula, String nombre, String telefono) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
