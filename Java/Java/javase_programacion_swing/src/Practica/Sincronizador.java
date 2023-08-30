/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica;

import java.util.Scanner;

/**
 *
 * @author Junior
 */
public class Sincronizador {
    public static void main(String[] args) {
        Metodos radio = new Metodos(80);
        Scanner sc = new Scanner(System.in);
        int p;
        
        System.out.println("1 - Down or 2 - Up: " );
        do{
        {
            p = sc.nextInt();
            if(p == 1)
            {
                radio.Down();
                radio.imprimirfrecuencia();
            }
            else if  (p == 2)
            {
                radio.Up();
                radio.imprimirfrecuencia();
            }
        } 
    }while(p == 1 || p == 2);
    
}
}
