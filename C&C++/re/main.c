#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, sfacnum1;
    printf("Ingrese limite inferior: ",163);
    scanf("%d",&n);
    sfacnum1 = sumafac(n);

}
int sumafac(int num)
{
   int suma = 0, div = 1, topediv = num/2, cont=0;

   while ( div <= topediv )
   {
      if ( num % div == 0 )
      {
         suma += div;
      }
      div ++;
   }printf("%d ", suma);
   if(suma<num){
   for  (int i=1;i<suma;i++)
       {
         if (suma%i==0)
            {
              cont=cont+i;
             }

       }printf("%d ", cont);
       if(cont>suma){
       printf("El numero %d es abundante \n", num);

       }
   }

   return suma;
}
