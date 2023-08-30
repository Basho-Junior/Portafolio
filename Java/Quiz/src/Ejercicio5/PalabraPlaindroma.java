/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio5;

import java.util.Scanner;

/**
 *
 * @author Junior
 */
public class PalabraPlaindroma {

    public static void main(String[] args) {
        String cadena;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese palabra:");
        cadena = sc.next();
        Palindrome(cadena);
    }

    public static void Palindrome(String cadena) {
        //Declaro las variables a utilizar 
        //Donde ind hace el papel de indice, descomp la longitud de la cadena menos el null 
        //Y un valor booleano para confirmar su igualdad
        int ind = 0;
        int descom = cadena.length() - 1;
        boolean b = false;
        
        for (ind = 0; (ind < descom) && (b != true); ind++) {

            if (cadena.charAt(ind) == cadena.charAt(descom)) {
                descom--;
            } else {
                b = true;
            }
        }
        if (b != true) {
            System.out.println(cadena + " es un PALINDROMO");
        } else {
            System.out.println(cadena + " NO es un palindromo");
        }
    }
}
