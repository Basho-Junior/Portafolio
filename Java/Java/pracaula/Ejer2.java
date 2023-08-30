package pracaula;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author junio
 */
import java.util.Scanner;
public class Ejer2 {
        public static void main(String[] args){
 
    // crear un objeto de la clase Scanner
   Scanner sc = new Scanner(System.in);

   // Leer 3 valores enteros
   System.out.print("Digite 3 enteros: ");
   int a = sc.nextInt();
   int b = sc.nextInt();
   int c = sc.nextInt();
   double prom = a + b + c / 3;
   System.out.println(prom);
   
    
 }
}