#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

float suma(float [],int);
float promedio(float [],int);

int main()
{
   float datos[] = {12.54,18.46,20,40};
   int n = sizeof(datos) / sizeof(float);

   printf("total memoria: %ld\n",sizeof(datos));
   printf("total elementos: %d\n",n);

   printf("Suma de los valores: %.2f\n",suma(datos,n));
   printf("Promedio de los valores: %.2f\n",promedio(datos,n));

   return 0;
}


float suma(float vals[],int n)
{
   float suma = 0;
   int ind;

   for ( ind = 0; ind < n; ind ++ )
      suma += vals[ind];

   return suma;
}


float promedio(float vals[],int n)
{
   return suma(vals,n) / n ;
}
