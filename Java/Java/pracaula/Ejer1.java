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
public class Ejer1 {
    public static void main(String[] args){
   

  int cantidad = 0; // inicializar una variable entera
  int cantidadMax = 100; // inicializar otra variable de tipo entero

   // Dos instrucciones de asignación
   cantidad = 10; // cantidad es ahora de 10
   cantidad  = cantidadMax; // cantidad es ahora 100

  System.out.println("cantidad: "+cantidad);
  System.out.println("cantidadMax: "+cantidadMax);

  //Expresiones aritméticas enteras
  int x = 14;
  int y = 8;
  int result1 = x + y; // result1 = 22
  System.out.println("result1 : "+result1);
  
  int result2 = x - y; // result2 = 6
  System.out.println("result2 : "+result2);
  
  int result3 = x * y; // result3 = 112
  System.out.println("result3 : "+result3);

  int result4 = x / y; // result4 = 1
  System.out.println("result4 : "+result4);

  //Expresiones aritméticas con valores de coma flotantes (double)
  double a = 8.5;
  double b = 3.4;
  
  double result5 = a + b; // result5 = 11.9
  System.out.println("result5 : "+result5);

  double result6 = a - b; // result6 = 5.1
  System.out.println("result6 : "+result6);

  double result7= a * b; // result7 = 28.9
  System.out.println("result7 : "+result7);

  double result8 = a / b; // result8 = 2.5
  System.out.println("result7 : "+result7);

  //Ejercicios: Realizar operaciones que involucren números enteros (int) y de coma flotante(double)
  int c = 10;
  double d = 10.2;
  double resultado = c * d;
  System.out.println("Resultado " + resultado);
  

 }

}
