/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.instanciasClases;

/**
 *
 * @author vacax
 */
public class Estudiante {
    //propiedades de instancia..
    int matricula;
    String nombre;
    //otras propiedades...
    //propieda de clase.
    public static int valor;
    
    //metodos de instancia...
    public void prematricula(){
        System.out.println("prema...: "+toString());
    }
    
    //metodos de clase.
    public static void metodoClase(){
        System.out.println("Metodo de clase...");
        // no es posible.no puedo utilizar un metodo o propieda de
        // instancia dentro de un metodo de clase.
        //toString(); 
        //nombre = "asdasd";
    }

    @Override
    public String toString() {
        metodoClase(); // si puedo llamar un metodo de clase en uno de instancia.
        return "Estudiante{" + "matricula=" + matricula + ", nombre=" + nombre + '}';
    }
    
    
}
