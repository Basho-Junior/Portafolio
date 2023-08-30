#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

#define MAXCOLUM 4

int sumadiv(int);

int main()
{
   int liminf, limsup, sdivnum, num,
       cantdef = 0, cantperf = 0, cantabun = 0,
       cantidad = 0 ;

   do{
      do{
         clrscr();
         printf("Ingrese l%cmite inferior: ",161);
         scanf("%d",&liminf);

         if ( liminf <= 0 )
         {
            printf("El valor debe ser mayor que cero.\n");
            system("pause");
         }

      }while ( liminf <= 0 );

      do{
         clrscr();
         printf("Ingrese l%cmite superior: ",161);
         scanf("%d",&limsup);

         if ( limsup <= 0 )
         {
            printf("El valor debe ser mayor que cero.\n");
            system("pause");
         }

      }while ( limsup <= 0 );

      // Validando el rango
      if ( liminf >= limsup )
      {
         printf("Rango incorrecto. Por favor ingr%cselo nueva vez.\n",130);
         getch();
      }

   }while ( liminf >= limsup);

   printf("Clasificaci%cn de n%cmeros del rango [%d,%d]:\n",162,163,liminf,limsup);
   for ( num = liminf; num <= limsup; num ++ )
   {
      sdivnum = sumadiv(num);
      cantidad ++;
      if ( sdivnum < num )
      {
         cantdef ++;
         printf("%5d D",num);
      }
      if ( sdivnum == num )
      {
         cantperf ++;
         printf("%5d P",num);
      }
      if ( sdivnum > num )
      {
         cantabun ++;
         printf("%5d A",num);
      }

      if ( cantidad % MAXCOLUM == 0 )
         printf("\n");
   }
   printf("Resumen:\n");
   printf("%3d Deficientes\n%3d Perfectos\n%3d Abundantes.\n",
            cantdef,cantperf,cantabun);

   return 0;
}

/*
   Función: sumadiv
   Objetivo: Determinar la suma de los divisores
             estrictos de "num".
   Argumento: entero num.
   Retorno: (int) suma de divisores.
*/
int sumadiv(int num)
{
   int suma = 0, div = 1, topediv = num/2;

   while ( div <= topediv )
   {
      if ( num % div == 0 )
      {
         suma += div;
      }
      div ++;
   }

   return suma;
}
