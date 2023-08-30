#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

int sumafac(int);

int main()
{
   int num1, num2, sfacnum1, defi;

   do{
      clrscr();
      printf("Ingrese limite inferior: ",163);
      scanf("%d",&num1);

      if ( num1 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         system("pause");
      }

   }while ( num1 <= 0 );

   do{
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

   }while ( num2 <= 0 || num1 >= num2);
   printf("Rango [%d, %d]\n", num1,num2);
   do{
    sfacnum1 = sumafac(num1);
    num1+=1;
    }
    while(num1 < num2+1);

   return 0;
}

int sumafac(int num)
{
   int suma = 0, div = 1, topediv = num/2, resuma=0;

   while ( div <= topediv )
   {
      if ( num % div == 0 )
      {
         suma += div;
      }
      div ++;
   }
   if(suma<num){
   for  (int i=1;i<suma;i++)
       {
         if (suma%i==0)
            {
              resuma=resuma+i;
             }

       }
       if(resuma>suma){
       printf("El numero %d es progresista. \n", num);

       }
   }

   return suma;
}

