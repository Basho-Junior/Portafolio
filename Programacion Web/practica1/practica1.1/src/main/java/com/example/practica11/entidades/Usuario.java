package com.example.practica11.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    String username;
    String password;
    String nombre;

    @OneToMany
    private List<MockProyecto> proyectos = new ArrayList<>();

    //relación
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private
    Set<Rol> roles;
    private boolean activo;
    private String rol;
    public Usuario() {
    }

    public Usuario(String username) {
        this.username = username;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(String username, String password, String nombre, Set<Rol> roles, boolean activo) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.roles = roles;
        this.activo = activo;
    }

    public Usuario(String username, String password, String nombre, Set<Rol> roles, boolean activo, String rol) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.roles = roles;
        this.activo = activo;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<MockProyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<MockProyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
