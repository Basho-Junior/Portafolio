/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;


/**
 *
 * @author Junior
 */
public class OrdenNumerico {

    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("Ingrese 3 numeros:");
            return;
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        int num3 = Integer.parseInt(args[2]);
        ordenado(num1, num2, num3);
    }

    public static void ordenado(int num1, int num2, int num3) {
        if (num1 < num2 && num2 < num3) {
            System.out.println("Las cantidades introducida están en orden numérico");
        } else {
            System.out.println("Las cantidades introducida no están en orden numérico");
            if (num1 > num2 && num2 < num3 && num1 > num3) {
                System.out.println("El orden que se debe ingresar los valores es " + num2 + " " + num3 + " " + num1);
            }
            if (num1 > num2 && num2 > num3) {
                System.out.println("El orden que se debe ingresar los valores es " + num3 + " " + num2 + " " + num1);
            } else if (num1 > num2 && num2 < num3 && num1 < num3) {
                System.out.println("El orden que se debe ingresar los valores es " + num2 + " " + num1 + " " + num3);
            } else if (num1 < num2 && num2 > num3) {
                System.out.println("El orden que se debe ingresar los valores es " + num1 + " " + num3 + " " + num2);
            }
        }
    }
}
