/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author Junior
 */
public class NumeroReversa {

    public static void main(String[] args) {
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese numero:");
        numero = sc.nextInt();

        System.out.println(+numero + " volteado es " + numrev(numero));

    }

    public static int numrev(int num) {
        int numnuevo = 0, dig;

        while (num != 0) {
            dig = num % 10;
            numnuevo = numnuevo * 10 + dig;
            num /= 10;
        }

        return numnuevo;
    }
}
