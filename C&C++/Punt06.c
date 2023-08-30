#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLEN 80

int elimchar(char *,char);
int exists(char *, char);

int main()
{
   char frase[MAXLEN];
   char caract;
   int cant;

   printf("Ingrese una frase:");
   gets(frase);

   printf("Ingrese un caracter a eliminar: ");
   do{
      caract = getch();
   }while ( !exists(frase,caract) );

   puts(frase);
   cant = elimchar(frase,caract);
   printf("%d [%c] eliminados\n",cant,caract);
   puts(frase);

   return 0;
}

int elimchar(char *str, char caract)
{
   int ind, celim = 0;

   for ( ind = 0; *(str+ind); ind ++ )
      if ( tolower(*(str+ind)) == tolower(caract) )
      {
         strcpy(str+ind,str+ind+1);
         celim++;
         ind--;
      }

   return celim;
}

int exists(char *str, char chr)
{
   int ind;

   for ( ind = 0; *(str+ind); ind ++ )
      if ( tolower(*(str+ind)) == tolower(chr) )
         return 1;
   return 0;
}

