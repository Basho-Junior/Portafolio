/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

/**
 *
 * @author Junior
 */
public class MainMiColeccion {
    public static void main(String[] args) {
        
        MiColeccion Coleccion1 = new MiColeccion();
        
        Coleccion1.add(15);
        Coleccion1.add(30);
        Coleccion1.add(45);
        System.out.println(Coleccion1.get(0)+" "+Coleccion1.get(1)+" "+Coleccion1.get(2));
        Coleccion1.remove(2);
        System.out.println(Coleccion1.get(2));
        Coleccion1.add(null);
        Coleccion1.add(60);
        System.out.println(Coleccion1.get(2));
        Coleccion1.clear();
        System.out.println(Coleccion1.get(0)+" "+Coleccion1.get(1)+" "+Coleccion1.get(2));
        System.out.println(Coleccion1.isEmpty());
        Coleccion1.add(75);
        Coleccion1.add(90);
        Coleccion1.add(105);
        System.out.println(Coleccion1.get(0)+" "+Coleccion1.get(1)+" "+Coleccion1.get(2));
        System.out.println(Coleccion1.isEmpty());
    }
}
