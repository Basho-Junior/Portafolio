/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esquemelegislativo;

import java.util.Date;

/**
 *
 * @author Junior
 */
public abstract class Persona {
    private String nombre;
    private String cedula;
    private int edad;
    private String genero;

    public Persona(String nombre,String cedula, int edad, String genero) {
        super();
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String Genero) {
        this.genero = Genero;
    }
}