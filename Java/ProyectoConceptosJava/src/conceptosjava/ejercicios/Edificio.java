/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.ejercicios;

/**
 *
 * @author vacax
 */
public class Edificio {
    
    //Propiedades.
    String nombre;
    int pisos;
    int puertas;
    
    /**
     * 
     * @param nombre
     * @param pisos
     * @param puertas 
     */
    public Edificio(String nombre, int pisos, int puertas){
        this.nombre = nombre;
        this.pisos = pisos;
        this.puertas = puertas;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    } /// lo repetimos para las demas.
    
    public void setPisos(int pisos){
        this.pisos = pisos;
    }
    
    public void setPuertos(int puertas){
        this.puertas = puertas;
    }
    
    public void imprimirEdificio(){
        System.out.println(String.format("El edificio %s tiene %d pisos y %d puertas", nombre, pisos, puertas));
    }
    
    public static void main(String[] args) {
        Edificio edificio = new Edificio("Camacho", 10, 30);
        edificio.imprimirEdificio();
        edificio.setNombre("Otro Nombre");
        edificio.imprimirEdificio();
    }
    
    
}
