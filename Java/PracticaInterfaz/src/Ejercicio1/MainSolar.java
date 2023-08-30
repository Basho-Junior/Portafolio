/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

/**
 *
 * @author Junior
 */
public class MainSolar {
    public static void main(String[] args) {
        Planetas p1 = new Planetas(12.5,1.5,15.4,36.0,12.5);
        Planetas s1 = new Planetas(13.5,2.5,16.4,37.0,13.5);
        
        p1.mostrar_informacion();
        s1.mostrar_informacion();
        
    }
}
