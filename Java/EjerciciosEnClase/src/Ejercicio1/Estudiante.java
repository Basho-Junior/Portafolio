/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author Junior
 */
public class Estudiante {
    int matricula;
    String nombre;
    String apellido;
    String carrera;

public void ingreso_dato(int matricula, String nombre, String apellido, String carrera){
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }
}