/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;
import java.util.Scanner;

/**
 *
 * @author junio
 */
public class Mayor {
    public static void main(String[] args) {
        int[] numero = new int[10];
        int contador, p;
        int max = 0;
        int totalnumero = 4;
       Scanner sc = new Scanner(System.in);

        for(contador = 0; contador < totalnumero; contador++){
                    System.out.println("Puedes introducir hasta "+ totalnumero+" números " );
                    p = sc.nextInt();
                    numero[contador] = p;
           
            if((contador == 0)||(numero[contador] > max))
                max = numero[contador];
        }
       

        System.out.println("El numero mayor es: " + max);
    }
}
