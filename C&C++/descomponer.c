#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void factprim(int);

int main()
{

   int numero;

   do{
      printf("Ingrese un valor: ");
      scanf("%d",&numero);

      if ( numero != 0 )
      {
         printf("%d = ",numero);
         factprim(numero);
         printf("\n");
      }
   }while ( numero != 0);



   return 0;
}

void factprim( int num )
{
   int cont = 0, fact = 2, signo = 1;

   if (num < 0 )
   {
      num *= -1;
      signo = -1;
   }

   while ( num > 1 )
   {
      cont = 0;
      while ( num % fact == 0 )
      {
         num /= fact;
         cont ++;
      }


      if ( cont >= 1 )
         printf(" %d ",fact*signo);

      if ( cont > 1 )
         printf ("^ %d ",cont);

      if ( num > 1 && cont >= 1)
         printf("* ");

      fact++;
   }
}
