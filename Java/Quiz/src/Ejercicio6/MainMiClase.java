/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio6;

/**
 *
 * @author Junior
 */
public class MainMiClase {
    public static void main(String[] args) {
        MiClase cl1 = new MiClase(4);
        MiClase cl2 = new MiClase(2);
        System.out.println ("Valor de instancia de la clase 1: " + cl1.getInstancia());
        System.out.println ("Valor de instancia de la clase 2: " + cl2.getInstancia());
        System.out.println ("Cantidad actual: " + MiClase.getClase());
        
        System.out.println ("Se cambia los valores: ");
        cl1.setInstancia(5);
        cl2.setInstancia(6);
        System.out.println ("Valor nuevo de instancia de la clase 1: " + cl1.getInstancia());
        System.out.println ("Valor nuevo de instancia de la clase 2: " + cl2.getInstancia());
        
        System.out.println ("Se agrega otra clase: ");
        MiClase cl3 = new MiClase(2);
        System.out.println ("Valor de instancia de la clase 1: " + cl1.getInstancia());
        System.out.println ("Valor de instancia de la clase 2: " + cl2.getInstancia());
        System.out.println ("Valor de instancia de la clase 3: " + cl3.getInstancia());
        System.out.println ("Cantidad actual: " + MiClase.getClase());
    }
}
