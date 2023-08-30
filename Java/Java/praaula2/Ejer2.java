/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praaula2;

/**
 *
 * @author junio
 */
import java.util.Scanner;
public class Ejer2 {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println("Ingrese la primera palabra: ");
        String p = sc.nextLine();
        System.out.println("El tamañeishon de esta palabradeishon: " + p.length());
        System.out.println("Ingrese la segunda palabra: ");
        String m = sc.nextLine();
        System.out.println("El tamañeishon de esta palabradeishon: " + p.length());
        if (p.length() > m.length()){
        System.out.println("La palabra mayor es: " + p);
        }
        if (p.length() == m.length()){
        System.out.println("Las palabras tienen la misma cantidad de letras");
        }
        else{
        System.out.println("La palabra mayor es: " + m);
        }
    }
    
}
