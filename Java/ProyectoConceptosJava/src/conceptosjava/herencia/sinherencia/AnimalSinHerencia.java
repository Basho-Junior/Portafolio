/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.sinherencia;

/**
 *
 * @author vacax
 */
public class AnimalSinHerencia {
    
    boolean vivo = true;
    boolean tienePelo;
    String especie;
    ///....
    
    
    public void alimertarse(){
        System.out.println("alimentarse - clase: "+this.getClass().getName());   
    }
    
    public void reproducirse(){
        System.out.println("reproducir");
    }
    
    public void crecer(){
        System.out.println("crecer");
    }
    
}
