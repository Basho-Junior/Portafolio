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
public class Estudiante {

    //Propiedades.
    int matricula;
    String nombre;
    String carrera;

    //Constructor Vacio.
    //moficador de acceso + nombre de clase + [argumentos]
    public Estudiante() { // el constructor por defecto.. no es necesario agregarlo.
        // siempre y cuando no tenga otro constructor. 
        System.out.println("Inicializando Estudiante...");
    }
    
    /**
     * Otro constructor donde debo pasar un entero.
     * @param matricula 
     */
    Estudiante(int matricula){
        this.matricula=matricula;
    }
    
    /**
     * 
     * @param nombre 
     */
    public Estudiante(String nombre){
        this.nombre = nombre;
    }
    
    public Estudiante(int matricula, String nombre, String carrera){
        this.matricula = matricula;
        this.nombre = nombre;
        this.carrera = carrera;
    }
    
    public Estudiante(int matricula, String nombre){
        this.matricula = matricula;
        this.nombre = nombre;
    }
    
    public Estudiante(String carrera, String nombre){
        this.carrera = carrera;
        this.nombre = nombre;
    }
    
    public Estudiante(String n, String c, int m){
        nombre = n;
        carrera = c;
        matricula = m;
    }

    //Metodos.
    void hacerPrematricula() {

    }

}
