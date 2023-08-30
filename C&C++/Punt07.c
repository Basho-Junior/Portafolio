#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLEN 80

int bstr(char *,char *);

int main()
{
   char frase[MAXLEN],patron[MAXLEN];
   char caract;
   int cant;

   printf("Ingrese una frase:");
   gets(frase);

   printf("Ingrese patr%cn a buscar:");
   gets(patron);

   puts(frase);
   cant = bstr(frase,patron);
   if ( cant > 0 )
      printf("El patron[%s] se encuentra %d veces en:\n[%s]\n",patron,cant,frase);

   return 0;
}

int bstr(char *str, char *strb)
{
   int ind, lstrb = strlen(strb), cont = 0 ;

   for ( ind = 0; *(str+ind); ind ++ )
      if ( strnicmp(str+ind,strb,lstrb) == 0 )
         cont++;

   return cont;
}
