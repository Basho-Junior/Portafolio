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
public class Ejer1{
    // mostrar el numero de puntuacion, la puntuacion total, y la puntuacion media
    public static void E(double scoreTotal, double scoreCount){
	double averageScore = scoreTotal / scoreCount;
        	String message = String.format("Su puntuacion total fue: %f, y su puntuacion media %f", averageScore, scoreTotal);
                System.out.println(message);}
                
    

    public static void main(String[] args) {
       
        System.out.println("Por favor, introduzca resultados de las pruebas que van desde 0 a 100.");
        System.out.println("Para finalizar el programa ingresar un valor mayor a 100 .");
        System.out.println();  

        double scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        Scanner sc = new Scanner(System.in);

        while (testScore <= 100) {
            
            System.out.print("Registre la puntuacion: ");
            testScore = sc.nextInt();

            if (testScore <= 100) {
                scoreCount = scoreCount + 1;
                scoreTotal = scoreTotal + testScore;
            }
      
    }
        E(scoreTotal, scoreCount);
        String output = String.format("Su Cantidad de muestra fue: %d", scoreCount);
        System.out.println(output);
}
}