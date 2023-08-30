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
public class Ejer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Inserte su nombre porfavor: ");
        String a = sc.nextLine();
        System.out.println("Inserte su edad porfavor: ");
        String b = sc.nextLine();
        int d = Integer.parseInt(b);
        if (d < 40){
        System.out.println("Hola " + a + " todavía eres muy joven.");
        }
        if (d >= 60){
        System.out.println("Hola " + a + " eres de avanzada edad"); 
        }
        else{
        System.out.println("Estas bien");
        }
    }
    
}
