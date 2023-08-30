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
public class PerroSinHerencia {
    //
    public enum Genero{
        MACHO,
        HEMBRA
    }
    //
    String raza;
    String color;
    double peso;    
    Genero genero;
    // gran etc....
    
    // propiedes.
   public void ladrar(){
       System.out.println(".....");
   }
   
   //copiar..
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
