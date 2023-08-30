/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holamundo1;

/**
 *
 * @author Junior
 */
public class Monitor {
    //Propiedades
    //Modificador acceso + tipo de variable + nombre [= asignacion]
    String color;
    String marca;
    String tamanio;
    double ancho, largo;
    String tipoPantalla;
    String serial;
    //Funcionalidad cosas que hace esa clase
    //Modificador de acceso + tipo de retorno + nombre + [argumentos]
    void encender()
    {
        System.out.println("Prendido: "+serial);
    }
}
