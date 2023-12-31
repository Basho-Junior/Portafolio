//Bono P1: Numeros Exitosos por Junior Hernandez 2018-0999
#include <stdio.h>
#include <stdlib.h>
int abundante(int);
int exitoso(int);
int main()
{
   int num1, num2, sexitosos = 0, cexitosos = 0, exit;
   double promedio;

   do
   {
      printf("Ingrese limite inferior: ",163);
      scanf("%d",&num1);

      if ( num1 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         system("pause");
      }

   }
   while ( num1 <= 0 );

   do
   {
      system("cls");
      printf("Ingrese limite superior: ",163);
      scanf("%d",&num2);

      if ( num2 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         getch();
      }
      if ( num2 <= num1 )
      {
         printf("El valor debe ser mayor que que el limite inferior.\n");
         getch();
      }

   }
   while ( num2 <= 0 || num1 >= num2);
   printf("Rango [%d, %d]\n", num1,num2);
   do
   {
    exit = exitoso(num1);
    if(exit == 1)
      {
         sexitosos += num1;
         cexitosos ++;
         printf("%d: Es exitoso dentro del rango \n", num1);
      }
      num1+=1;
    }
    while(num1 < num2+1);
    if(cexitosos > 0)
         {
            promedio=sexitosos/cexitosos;
            printf("El promedio de numero exitosos es %.2f \n", promedio);
         }
      else
         {
            printf("No hay numeros exitosos suficiente dentro del rango para poder promediarlos \n");
         }
   return 0;
}
/* Funci�n: Abundante.
   Argumento: (int)numero. N�mero para determinar si es abundante.
   Objetivo: Determinar si el numero es abundante o no.
   Retorno: 1 si el la sumatoria de los divisores del numero es mayor que el mismo (es abundante) y 0 si no.
*/
int abundante (int num)
{
   int div = 1, topediv = num/2, sdiv = 0;
   while ( div <= topediv )
      {
      if ( num % div == 0 )
      {
         sdiv += div;
      }
      div ++;
      }
   if(sdiv > num)
   {
      return 1;
   }
   return 0;
}
/* Funci�n: Exitoso.
   Argumento: (int)numero. N�mero para determinar si es exitoso.
   Objetivo: Determinar si el numero es exitoso o no.
   Retorno: 1 si el numero tiene mayor cantidad de divisores/numeros abundante que los que no lo son (es exitoso)
   en caso contrario, menor cantidad de divisores/numeros abundantes que los que no cumplen con la decisi�n, entonces
   retornar� 0.
   Notas: Se llama la funcion abundante para saber si los divisores son abundantes.
*/
int exitoso (int num)
{
   int div = 1, topediv = num/2, cdiv = 0, cdivabun = 0;
   while ( div <= topediv )
      {
      if ( num % div == 0 )
      {
         cdiv ++;
         cdivabun += abundante(div);
      }
      div ++;
      }
   if(cdivabun > cdiv/2)
   {
      return 1;
   }
   return 0;
}
