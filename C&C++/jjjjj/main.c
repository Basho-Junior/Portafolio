#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int validar(char []);
int main()
{
   int cont = 0;
   char a[10];
   printf("Ingrese su cadena bbcitoooooo = ");
   scanf("%s", a);
   if(validar(a) == 1)
      {
         printf("Esta compuesta solo de valores numericos");
      }
   if (validar(a) == 0)
      {
         printf("No esta compuesta solo de valores numericos");
      }
   return 0;
}

int validar(char num[]){
   int cont = 0, p=0, q=0;
   for (int i = 0; i < num[i]; i++)
   {
         if (num[i] == '.')
         {
            cont ++;
         }

      if (num[i] >= '0' && num[i]<= '9')
      {
         p=1;
      }
      else if(num[i] >= 'a' && num[i]<= 'z' || num[i] >= 'A' && num[i]<= 'Z')
      {
         q=1;
      }
   }
   if (p == 1 && cont<=1 && q == 0)
   {
      return 1;
   }
   if (q == 1 || cont > 1 && p == 0)
   {
      return 0;
   }
}
