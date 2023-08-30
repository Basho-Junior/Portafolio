#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

int sumadiv(int);

int main()
{
   int num1, num2, sdivnum1,
       sdivnum2;

   do{
      clrscr();
      printf("Ingrese primer n%cmero: ",163);
      scanf("%d",&num1);

      if ( num1 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         system("pause");
      }

   }while ( num1 <= 0 );

   do{
      system("cls");
      printf("Ingrese segundo n%cmero: ",163);
      scanf("%d",&num2);

      if ( num2 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         getch();
      }

   }while ( num2 <= 0 );

   sdivnum1 = sumadiv(num1);
   sdivnum2 = sumadiv(num2);

   printf("%d y %d: ",num1,num2);

   // Verificando si num1 y num2 son amigos
   if ( sdivnum1 == num2 &&
        sdivnum2 == num1 )
   {
      printf("Son amigos...\n");
   }
   else
   {
      printf("No son amigos...\n");
   }

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
