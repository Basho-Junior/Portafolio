/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptosjava.leerEntrada;

import java.util.Scanner;

/**
 * Clase para leer la entrada estandar.
 *
 * @author vacax
 */
public class LeerEntradaEstandar {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //Para leer la entrada estandar, utilizar la clase Scanner.
        Scanner scanner = new Scanner(System.in); // utilizamos el uso flujo de datos.
        
        //leer....
        System.out.print("Digite su nombre: ");
        String nombre=scanner.nextLine();
        System.out.println("Su nombre digitado es: "+nombre);
        
        System.out.print("Digite su matrícula: ");
        while(scanner.hasNextInt() == false){ //validar que sea un entero
            System.out.println("no es un entero el valor...");
            System.out.println("Digite su matrícula: ");
            scanner.next();
        }       
        
        int matricula = scanner.nextInt();
        System.out.println("Matrícula Digitada: "+matricula);
        
        //ver los diferentes metodos que brinda clase Scanner.
    }
}
