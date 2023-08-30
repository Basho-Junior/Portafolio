#include <stdio.h>
#include <stdlib.h>
#include <conio.c>
#include <math.h>

float suma(float [],int);
float promedio(float [],int);
float stdev (float[], int);
int main()
{
   float datos[] = {10,15,18,20,30};
   int n = sizeof(datos) / sizeof(float);

   printf("total memoria: %ld\n",sizeof(datos));
   printf("total elementos: %d\n",n);

   printf("Suma de los valores: %.2f\n",suma(datos,n));
   printf("Promedio de los valores: %.2f\n",promedio(datos,n));
   printf("Desviacion de los valores: %.2f\n",stdev(datos,n));


   return 0;
}
float stdev (float vals[], int n)
{
   int ind;
   float dif, sumadif=0, prom, result, total;
   for (ind = 0; ind < n; ind ++)
   {
      dif=vals[ind]- promedio(vals,n);
      result = pow(dif, 2);
      /*if(promedio(vals,n) < vals[ind]){
            dif=vals[ind]- promedio(vals,n);
            result = pow(dif, 2);
      }else
      {
         dif=promedio(vals,n) - vals[ind];
         result = pow(dif, 2);
      }*/
      printf("%.2f\n", result);
      sumadif+=result;
   }
   prom=sumadif/(n-1);
   total = sqrt(prom);

   return total;
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
