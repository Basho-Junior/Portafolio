#include <stdio.h>
#include <stdlib.h>

int cambiarelorden (int);
int main()
{
   int num1, numvolt;
   char deci;
   do
    {
      printf("Ingrese n%cmero: \n", 163);
      scanf("%d",&num1);
      if(num1 < 0)
      {
         printf("El valor debe ser mayor que 0.\n");
         printf("Presione C si desea continuar. De lo contrario presione cualquier tecla. \n");
         scanf(" %c",&deci);
         system("cls");
      }
      else
      {
         if ( num1 < 10 && num1 > 0)
         {
            printf("El valor debe ser mayor que 10.\n");
            printf("Presione C si desea continuar. De lo contrario presione cualquier tecla. \n");
            scanf(" %c",&deci);
            system("cls");
         }
         else
         {
            numvolt = cambiarelorden(num1);
            if (numvolt == num1)
            {
               printf("%d: es pal%cndromo \n", num1, 161);
            }
            else
            {
               printf("%d: no es pal%cndromo \n", num1, 161);
            }
            printf("Presione C si desea continuar. De lo contrario presione cualquier tecla. \n");
            scanf(" %c",&deci);
            system("cls");
         }
      }
   }
   while(deci == 'c' || deci == 'C');
}

int cambiarelorden(int num)
{
    int digi, numvolte=0;
    while(num != 0)
    {
        digi=num%10;
        numvolte=numvolte*10+digi;
        num/=10;
    }
    return numvolte;
}
