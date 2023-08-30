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
public class Verificar {

    public static void main(String[] args) {
        System.out.println("Fundacion Codigo Libre");
        int a = 10;
        int b = 3;
        System.out.println("Datos a operar: a=" + a + " y b=" + b);
        System.out.println("La multiplicacion vale " + (a * b));
        int c = a + b;
        System.out.println("La suma es " + (a + b));
        System.out.println((a + b) + " tambien es la suma");
        System.out.println("O lo que es lo mismo " + c);
        c = a - b;
        System.out.println("La resta es " + c);
        System.out.println("La resta es tambien " + (a - b));
    }
}
