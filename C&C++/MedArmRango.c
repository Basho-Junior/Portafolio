#include <stdio.h>
#include <stdlib.h>

float mediaArm(float,float);

int main()
{
   float num1, num2, medarm;

   printf("Ingrese primer valor: ");
   scanf("%f",&num1);

   printf("Ingrese segundo valor: ");
   scanf("%f",&num2);

   printf("Valores capturados:\n");
   printf("Num1 = %f y Num2 = %f\n",num1,num2);

   medarm =  mediaArm(num1,num2);

   printf("La media arm%cnica de %.2f y %.2f es: %.2f\n",
          162,num1,num2,medarm);
   return 0;
}




/*
   Función: mediaArm
   Objetivo: Hallar la media armónica de dos valores.
      Que es el resultado obtenido al calcular los inversos
      de los números, promediarlos y calcular el inverso
      del resultado.
   Argumentos: Flotantes val1 y val2.
   Retorno:  Flotante. Resultado de la media armónica de val1 y val2.
*/
float mediaArm( float val1, float val2 )
{
   return 1.0 / ((1.0/val1 + 1.0 / val2)/2);
}
