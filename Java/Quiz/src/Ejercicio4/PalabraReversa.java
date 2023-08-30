/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author Junior
 */
public class PalabraReversa {

    public static void main(String[] args) {
        int vacio = args.length;
        if (vacio == 0)
        {
            System.out.println("Debe de escribir un argumento");
            return;
        }
            for (String cadena: args)
            {
                invertir(cadena);
            } 
            
    }

    public static void invertir(String cadena) {
        String CadenaInvertida = "";
        for (int x  = cadena.length()-1; x>=0; x--)
		CadenaInvertida = CadenaInvertida + cadena.charAt(x);
        System.out.println(CadenaInvertida);
    }
}
