/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracaula;

/**
 *
 * @author junio
 */
import java.util.Scanner;

public class Ejer7 {
    public static double TestMetodo(double a){
         double porcientodescuento = 0.0;
            if (a >= 200) {
                porcientodescuento = .2;
            } else if (a >= 100) {
                porcientodescuento = .1;
            } else {
                porcientodescuento = 0.0;
            }
            if (a > 100){
            System.out.println("Desea continuar o salir? c/s: ");
            Scanner pc = new Scanner(System.in);
            String preg = pc.nextLine();
            if (preg.equals("s")){
            System.exit(0);
            }
            }
            double montodescuento = a * porcientodescuento;
            String message = "Porcentaje de descuento: " + porcientodescuento + "\n"
                              + "Importe de descuento :  " + montodescuento + "\n";
            System.out.println(message);
            return montodescuento;
    }
    
    public static void calcular(){
    System.out.println("Bienvenido a la calculadora de la factura total");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String decision = "y";
        while (decision.equalsIgnoreCase("y")) {
            System.out.print("Escriba el subtotal:   ");
            double subtotal = sc.nextDouble();
            double a = TestMetodo(subtotal);
            double total = subtotal - a;
            String message = "Total de la factura:    " + total + "\n";
            System.out.println(message);
            System.out.print("Continuar ? (y/n): ");
            decision = sc.next();
            System.out.println();
    }
 }
    public static void main ( String [] args ) {
    Ejer7 te = new Ejer7 ();
    te.calcular();
   }
}