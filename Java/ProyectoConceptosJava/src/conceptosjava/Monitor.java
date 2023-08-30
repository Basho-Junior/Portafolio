/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava;

/**
 *
 * @author vacax
 */
public class Monitor {
    //Propiedades.
    //modificador acceso + tipo de variable + nombre [= asignación]
    String color;
    String marca;
    double ancho;
    double largo;
    String tipoPantalla;
    String serial;
    
    //Funcionalidad.
    //modificador de acceso + tipo de retorno + nombre + [argumentos]
    void encender(){
        System.out.println("Enciendido el Monitor: "+serial);
    }
    
}
