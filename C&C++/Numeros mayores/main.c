#include <stdio.h>
#include <stdlib.h>
int abundante(int);
int exitoso(int);

int main()
{
     int liminf,limsup,num,sexitosos=0,cexitosos=0;
     float prom;

   do{
      do{
         printf("Ingrese l%cmite inferior: ",161);
         scanf("%d",&liminf);

         if ( liminf <= 0 )
         {
            printf("El valor debe ser mayor que cero.\n");
            system("pause");
         }

      }while ( liminf <= 0 );

      do{
         printf("Ingrese l%cmite superior: ",161);
         scanf("%d",&limsup);

         if ( limsup <= 0 )
         {
            printf("El valor debe ser mayor que cero.\n");
            system("pause");
         }

      }while ( limsup <= 0 );

      // Validando el rango
      if ( liminf >= limsup )
      {
         printf("Rango incorrecto. Por favor ingr%cselo nueva vez.\n",130);
         system("pause");
         system("cls");
      }

   }while ( liminf >= limsup);

 printf("Su rango es: [%d,%d]\n",liminf,limsup);

 for(num=liminf; num <= limsup; num++)
 {
    if (exitoso(num)==1)
    {
       sexitosos+=num;
       cexitosos++;
    }
 }

 if(cexitosos>0)
    {
       prom=sexitosos/cexitosos;
       printf("El promedio de exitosos es %f \n",prom);
    }else{
       printf("No hay exitosos en el rango");
    }
    return 0;
}

int abundante(int num)
{
   int div=1,topediv=num/2,sdiv=0;

   do{
      if(num%div==0)
      {
         sdiv+=div;
      }
      div++;
   }while(div<=topediv);

   if(sdiv>num)
      return 1;

   return 0;
}
int exitoso(int num)
{
   int div=1,topediv=num/2,cdiv=0,cdivabund=0;

   do
   {
      if (num%div==0)
         {
         cdiv++;
         cdivabund+=abundante(div);
      }
      div++;

   }while(div<=topediv);

   if(cdivabund>cdiv/2){
      return 1;
   }
 return 0;
}
