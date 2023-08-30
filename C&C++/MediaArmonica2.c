#include <stdio.h>
#include <stdlib.h>

float mediaArm(float,float);

int main()
{
   float liminf, limsup,medarm;

   do{
      printf("Ingrese l%cmite inferior: ",161);
      scanf("%f",&liminf);

      printf("Ingrese l%cmite superior: ",161);
      scanf("%f",&limsup);

      if ( liminf >= limsup )
      {
         printf("Rango incorrecto. Verifique el mismo...\n");
         system("pause");
         system("cls");
      }


   }while ( liminf >= limsup);
   system("cls");
   printf("Media arm%cnica valores en [%.2f,%.2f]\n",162,liminf,limsup);
   for ( medarm = liminf; medarm <= limsup; medarm ++ )
   {
      printf("%6.2f - %6.2f = %6.2f\n",medarm,medarm+2,mediaArm(medarm,medarm+2));
   }

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
