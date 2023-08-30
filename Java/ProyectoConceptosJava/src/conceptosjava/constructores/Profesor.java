/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.constructores;

/**
 *
 * @author vacax
 */
public class Profesor {
    
    String cedula;
    String nombre;
    String profesion;

    /**
     * Constructor con tres argumentos, no permite el constructor vacio.
     * @param cedula
     * @param nombre
     * @param profesion 
     */
    public Profesor(String cedula, String nombre, String profesion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.profesion = profesion;
    }
    
}
