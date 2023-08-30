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
public class Soldado extends Ciudadano{
   
    String rango;
    
    public void pelear(){
        System.out.println("Peleando...");
    }
    
    public void entrenar(){
        System.out.println("Entrenar...");
    }
}
