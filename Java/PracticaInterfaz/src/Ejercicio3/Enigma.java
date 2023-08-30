/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author Junior
 */
public class Enigma {
    public static void main(String[] args) {
        Encriptador Algo_Multi = new Encriptador("Multiplicacion");
        Encriptador Algo_Dife = new Encriptador("Diferencia");
        
        System.out.println("El numero encriptado con el algoritmo de multiplicacion es: " + Algo_Multi.encriptar(123));
        System.out.println("El numero desencriptado: " + Algo_Multi.desencriptar(123));
        
        System.out.println("El numero encriptado con el algoritmo de diferencia es: " + Algo_Dife.encriptar(123));
        System.out.println("El numero desencriptado: " + Algo_Dife.desencriptar(123));
    }
}
