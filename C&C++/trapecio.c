#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

float trapecio(float [], int, int);
void getfx(float [], int);

int main()
{
   int cant, h = 3;

   do{
      printf("Ingrese cantidad de Fx: ");
      scanf("%d",&cant);

      if ( cant <= 0 )
      {
         printf("Cantidad de Fx debe ser mayor que cero.\n");
         getch();
         clrscr();
      }
   }while ( cant <= 0 );

   float fx[cant];

   printf("Ingrese los valores de los Fx's:\n");
   getfx(fx,cant);

   printf("El valor resultante es: %.2f\n",trapecio(fx,h,cant));

   return 0;
}


void getfx(float fx[], int n)
{
   int ind;

   for ( ind = 0; ind < n; ind ++ )
   {
      printf("Fx[%d]: ",ind);
      scanf("%f",&fx[ind]);
   }

   return;
}


float trapecio(float fx[], int h, int n)
{
   int ind;
   float total = 0;

   for ( ind = 1; ind < n-1; ind ++ )
      total += fx[ind];

   return (float)h/2 *(fx[0] + 2 *total + fx[n-1]);
}
