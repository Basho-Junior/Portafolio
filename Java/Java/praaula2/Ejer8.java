/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praaula2;

import java.util.Scanner;

/**
 *
 * @author junio
 */

public class Ejer8 {
public static double Compradeunapersonaendiadedescuento(double compra) {
double total = compra + 250;
return total;

}
public static void dis(double descuento) {
System.out.println("Ingrese los precios de los tres productos para el descuento");
int i = 0;
double total1 = 0;
while(i < 3){    	
System.out.println("Ingrese el precio del producto: ");
Scanner sm = new Scanner(System.in);
double N = sm.nextDouble();
total1 = total1 + N;
i++;
}
System.out.println("Sus compras hacen un total de: " + total1);
double total2 = Compradeunapersonaendiadedescuento(total1);
double total3 = total2 * descuento; 
System.out.println("Su total con el descuento es: " + total3);
}



public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("inserte descuento: ");
double es = sc.nextDouble();
double des = es/100;
dis(des);
    
}
}
