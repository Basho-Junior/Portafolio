/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.usopaquetes;

import conceptosjava.paquetes.MiClaseEnPaquete;
//import holamundo16012020.paquetes.*; los mismo.
//import holamundo16012020.otropaquete.MiClaseEnPaquete; //no puedo utilizar el import.

/**
 *
 * @author vacax
 */
public class MainPaquetes {
    
    public static void main(String[] args) {
        //llamando una de las clases...
        MiClaseEnPaquete p1 = new MiClaseEnPaquete(); 
        
        //llamar la otra clase con mismo nombre...
        conceptosjava.otropaquete.MiClaseEnPaquete p2 =new conceptosjava.otropaquete.MiClaseEnPaquete();
        
        //
        p1.prueba();
        p2.prueba();
    }
}
