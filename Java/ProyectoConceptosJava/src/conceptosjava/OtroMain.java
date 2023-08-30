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
public class OtroMain {
   
    public static void main(String[] args) {
        System.out.println("Otro Main...");
        int x = 1;
        String cadena = "Hola";
        System.out.println(String.format("Valor X = %d, Cadena = %s", x, cadena));
        
        //Creando un Objeto del tipo Monitor.
        Monitor m1 = new Monitor();
        m1.serial = "A123123";
        m1.encender();
        
        Monitor m2 =new Monitor();
        m2.serial = "B123123";
        m2.encender();
        
        System.out.println("m1 == m2 ? "+ (m1 == m2));  
        System.out.println("m1 es una instancia de Monitor: "+(m1 instanceof Monitor));
        
        Monitor m3 = m1;
        System.out.println("m1 == m3 ? "+ (m1 == m3));
        
        Monitor m4; //asignación null.
        //m4.serial = "sadasd";
        //m4.encender();
        
        //
        m1 = null;
        m2 = null;
    }
}
