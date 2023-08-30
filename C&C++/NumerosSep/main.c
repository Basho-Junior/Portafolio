#include <stdio.h>
#include <stdlib.h>
#include<math.h>
void numeroinv(int);
void numerosep(int);

int main()
{
   int numero;

   do{
      printf("Ingrese un n%cmero mayor a 100 :",163);
      scanf("%d",&numero);

      if(numero<=100)
      {
         printf("El n%cmero debe ser mayor que 100\n",163);
      }
   }while(numero<=100 || numero<0 );

   numeroinv(numero);
   numerosep(numero);


   return 0;
}

void numeroinv(int num)
{
   int digit, nuevo=0;
   printf("\n");
   printf("Los digitos del %d de izquiera a derecha son: ",num);

   while(num !=0)
   {
      digit=num%10;
      nuevo=nuevo*10+digit;
      num/=10;
      printf("  %d,",digit);
   }
}

void numerosep(int num)
{
   int digito, nuevo=0, potencia, cont, auxiliar;
   float pot;
   printf("\n\nLos digitos del %d de derecha a izquierda son: ",num);

   pot = (int) log10(num);
   cont = pot+1;
   for(int i=0; i<=cont; i++)
   {
      cont = pot+i;
      auxiliar=pow(10.0,pot);
      printf("%d, ", num/auxiliar);
      num-=(num/auxiliar)*auxiliar;
      pot--;
   }

   printf("\n");

}
