/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.herencia.conherencia;

/**
 *
 * @author vacax
 */
public class SerVivo {
 
    String nombre;
    
    public void nacer(){
        System.out.println("Nace: "+nombre+" - clase:"+this.getClass().getSimpleName());
    }
    
    public void crece(){
        System.out.println("Crece: "+this.getClass().getSimpleName());
    }
    
    public void reproduce(){
        System.out.println("Reproduce: "+this.getClass().getSimpleName());
    }
    
    public void muere(){
        System.out.println("Muere: "+this.getClass().getSimpleName());
    }
}
