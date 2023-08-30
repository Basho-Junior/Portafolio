/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.modificadores.propiedades;

/**
 *
 * @author vacax
 */
public class ModificadoresPropiedades {
    
    //propiedades.
    public String propiedadPublica; // tiene acceso para todas las instancias.
    private String propiedadPrivada; // tiene acceso unicamente dentro de la clase o instancia.
    String propiedadPredeterminada; // acceso dentro del paquete y herencia.
    protected String propiedadProtegida; // acceso dentro del paquete y no permite herencia.

    public ModificadoresPropiedades() {
        propiedadPrivada = "asignando la propiedad privada";
    }
    
    
}
