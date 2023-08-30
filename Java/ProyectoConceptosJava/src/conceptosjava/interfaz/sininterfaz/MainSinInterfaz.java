/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.interfaz.sininterfaz;

/**
 *
 * @author vacax
 */
public class MainSinInterfaz {
 
    public static void main(String[] args) {
        Trabajador trabajador =new Trabajador();
        trabajador.setNombre("Nombre País");
        trabajador.setCedula("0111111");
        trabajador.setOcupacion("Obrero");
        // Cientifico y Soldado..
        Cientifico cientifico = new Cientifico();
        
        //da error.... no son tipos compatible...
        //Soldado s = cientifico;
        
        //
        Ciudadano ciudadano = trabajador;
    }
}
