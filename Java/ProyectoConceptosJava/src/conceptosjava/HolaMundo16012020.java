/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava;

import conceptosjava.modificadores.clases.ModificardorPublico;
import conceptosjava.modificadores.constructores.ModificarConstructores;
import conceptosjava.modificadores.metodos.ModificadoresMetodos;
import conceptosjava.modificadores.propiedades.ModificadoresPropiedades;
import java.util.Random;
//no funciona por el modificar de acceso prederterminado.
//import holamundo16012020.modificadores.clases.ModificardoPredeterminado;

/**
 *
 * @author vacax
 */
public class HolaMundo16012020 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola Mundo en Java :-D"); 
        //puedo llamar la clase donde sea...
        ModificardorPublico mp = new ModificardorPublico();
        //
        //no funciona por el modificar de acceso prederterminado
        //ModificardoPredeterminado mpp = new ModificardoPredeterminado();
        
        //prueba de modificadores.
        ModificadoresPropiedades mpro = new ModificadoresPropiedades();
        mpro.propiedadPublica = "acceso directo";
        
        //
        ModificarConstructores mc = new ModificarConstructores();
        
        //
        ModificadoresMetodos mm = new ModificadoresMetodos();
        mm.publico();
        
        System.out.println("Random: "+new Random().nextInt(5));        
    }
    
    
}
