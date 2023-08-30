/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Colecciones;

/**
 *
 * @author junio
 */
public class Notas {
    public static void main(String[] args) {
    int[] notas ={75,60,50,100,75,90,80,85,70,95,88 };
    double suma = 0;
        for(double nota : notas){
            suma += nota;
        }
        
        double promedio = suma / notas.length;
        
        System.out.println("La cantidad de muestras es de: "+notas.length);
        
        System.out.println("La puntuacion total es de: "+suma);
        
        System.out.println("El promedio es de: "+promedio);
        
}
}
