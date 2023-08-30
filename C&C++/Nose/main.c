#include<stdio.h>
#include<string.h>

int main()
{
   char matnom[100][100],nombre[50];
   int i,n,c=0,p=0,m=0,f=0;
   float matsuel[100], matven[100], matcom[100], matsueln[100], sumasuel=0, sumaven=0, sumacom=0, sumasueln=0;
   float mayorcom=matcom[0], menorcom=matcom[0], promedio, mayorsueln=matsueln[0], menorsueln=matsueln[0];

   do
   {
      printf("Ingrese cantidad de vendedores: \n");
      scanf("%d",&n);
      if ( n <= 1 )
      {
         printf("El valor debe ser mayor que 1.\n");
      }
   }
   while ( n <= 1 );

   for(i=0;i<n;i++)
   {
      printf("Ingrese el nombre del vendedor - %d = ",i+1);
      scanf("%s",matnom[i]);
      printf("Ingrese el sueldo del vendedor - %d = ",i+1);
      scanf("%f", &matsuel[i]);
      printf("Ingrese la venta del mes del vendedor - %d = ",i+1);
      scanf("%f", &matven[i]);
      system("cls");
      if(matven[i] <= 1000)
      {
         matcom[i] = (3.5/100)*matven[i];
      }
      if(matven[i] > 1000 && matven[i] <= 2000)
      {
         matcom[i] = (4.5/100)*matven[i];
      }
      if(matven[i] > 2000)
      {
         matcom[i] = (5.4/100)*matven[i];
      }
      matsueln[i]= matsuel[i]+ matcom[i];
      sumasuel += matsuel[i];
      sumaven += matven[i];
      sumacom += matcom[i];
      sumasueln += matsueln[i];
   }

   printf("\nNombre:");
   printf("\t\tSueldo:");
   printf("\t \tVenta del mes:");
   printf("\t\tComisi%cn:", 162);
   printf("\tSueldo Neto:\n");
   printf("---------------------------------------------------------------------------------------------------\n");

   for(i=0;i<n;i++)
   {
      printf("\t%s\t\t%.2f\t\t%.2f\t\t\t%.2f\t\t%.2f\n",matnom[i], matsuel[i], matven[i],matcom[i],matsueln[i]);
   }

   printf("\tTotal:\t\t%.2f\t\t%.2f\t\t\t%.2f\t\t%.2f\n",sumasuel,sumaven,sumacom,sumasueln);

    for (i=0; i < n; i++)
   {
         menorcom=matcom[0];
         if (matcom[i] > mayorcom){
               mayorcom = matcom[i];
               c=i;
         }
         if (matcom[i] < menorcom){
               menorcom = matcom[i];
               p=i;
         }
    }

    printf("\nLa comisi%cn mayor fue de %s con %.2f\n", 162, matnom[c], mayorcom);
    printf("La comisi%cn menor fue de %s con %.2f\n", 162, matnom[p], menorcom);

    for (i=0; i < n; i++)
    {
       menorsueln=matsueln[0];
       if (matsueln[i] > mayorsueln)
       {
          mayorsueln = matsueln[i];
          m=i;
       }
       if (matsueln[i] < menorsueln)
       {
          menorsueln = matsueln[i];
          f=i;
       }
    }

    printf("El sueldo neto mayor fue de %s con %.2f\n", matnom[m], mayorsueln);
    printf("El sueldo neto menor fue de %s con %.2f\n", matnom[f], menorsueln);

    for (i=0; i < n; i++)
    {
       promedio = sumaven/n;
    }

    printf("\nEmpleados con Ventas Mayores al Promedio: %.2f\n", promedio);
    printf("\nNombre:");
    printf("\t\tSueldo:");
    printf("\t \tVenta del mes:");
    printf("\t\tComisi%cn:", 162);
    printf("\tSueldo Neto:\n");
    printf("---------------------------------------------------------------------------------------------------\n");

    for (i=0; i < n; i++)
    {
       if(matven[i] > promedio)
       {
          printf("\t%s\t\t%.2f\t\t%.2f\t\t\t%.2f\t\t%.2f\n",matnom[i], matsuel[i], matven[i],matcom[i],matsueln[i]);
       }
    }
    return 0;
}


