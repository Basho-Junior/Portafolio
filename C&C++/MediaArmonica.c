#include <stdio.h>
#include <stdlib.h>

int main()
{
   float num1, num2, medarm;

   printf("Ingrese primer valor: ");
   scanf("%f",&num1);

   printf("Ingrese segundo valor: ");
   scanf("%f",&num2);

   printf("Valores capturados:\n");
   printf("Num1 = %f y Num2 = %f\n",num1,num2);

   medarm = 1.0 / ((1.0/num1 + 1.0 / num2)/2) ;

   printf("La media arm%cnica de %.2f y %.2f es: %.2f\n",
          162,num1,num2,medarm);
   return 0;
}
