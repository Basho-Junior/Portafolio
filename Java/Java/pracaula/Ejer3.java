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
public class Ejer3 {
    public static int TestMetodo(int a, int b){
       int sumar = a +b;
       System.out.println(sumar);
       int restar = a -b;
       System.out.println(restar);
       int multiplicar = a *b;
       double dividir = a/b;
       System.out.println(dividir);
     return multiplicar;   
    }
 public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese primer numero: ");
    int c = sc.nextInt();
    System.out.println("Ingrese segundo numero: ");
    int d = sc.nextInt();
    int resultado = TestMetodo(c, d);
    System.out.println(resultado);

  }

}
    

