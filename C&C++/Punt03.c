#include <stdio.h>
#include <stdlib.h>


int main()
{
   char matricula[8],nombre[15],apellido[15];

   printf("Matricula:");
   fflush(stdin);
   gets(matricula);
   printf("Matr%ccula: %s\n",161,matricula);
   printf("Nombre:");
   fflush(stdin);
   gets(nombre);
   printf("Nombre: %s\n",nombre);
   printf("Apellido: ");
   fflush(stdin);
   gets(apellido);

   printf("Matr%ccula: %s\n",161,matricula);
   printf("Nombre: %s\n",nombre);
   printf("Apellido: %s\n",apellido);



   return 0;
}

