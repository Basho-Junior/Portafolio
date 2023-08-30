/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

/**
 *
 * @author Junior
 */
public class Edificio {
    int cant_pisos;
    String nombre;
    int num_puerta;
    
    public Edificio(int cant_pisos, String nombre, int num_puerta){
        this.cant_pisos = cant_pisos;
        this.nombre = nombre;
        this.num_puerta = num_puerta;
    }
    
    public void cambiarpisos (int cant_pisos) {
        this.cant_pisos = cant_pisos;
    }
    public void cambiarnombre (String nombre) {
        this.nombre = nombre;
    }
    public void cambiarnumeropuerta (int num_puerta) {
        this.num_puerta = num_puerta;
    }
    
    void imprimir()
    {
        System.out.println("Cantidad de pisos: " +cant_pisos+ " Nombre: "+nombre+ " Numero de puerta: "+num_puerta);
    }
}
