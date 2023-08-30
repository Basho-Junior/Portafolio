/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosjdbc;

import java.util.Date;

/**
 *
 * @author junio
 */
class Persona {
   private String nombre;
    private String apellido;
    private Genero genero;
    private int edad;
    private Date Fecha_nac;
    private Nacionalidad nacionalidad;

    public Persona(String nombre, String apellido, Genero genero, int edad, Date Fecha_nac, Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.edad = edad;
        this.Fecha_nac = Fecha_nac;
        this.nacionalidad = nacionalidad;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    

}