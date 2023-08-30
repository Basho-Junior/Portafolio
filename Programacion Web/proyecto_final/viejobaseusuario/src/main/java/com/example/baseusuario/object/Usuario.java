package com.example.baseusuario.object;

import com.example.baseusuario.type.Rol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String usuario;
    private String clave;
    private String tipo;

    public Usuario(String correo, String usuario, String clave, String tipo) {
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String apellido, String correo, String usuario, String clave, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo = tipo;
    }

    public Usuario() {

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
