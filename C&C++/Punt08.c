#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXLEN 80

int elimstr(char *,char *);

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
   cant = elimstr(frase,patron);
   if ( cant > 0 )
      printf("El patron[%s] se elimin%c %d veces en:\n[%s]\n",patron,130,cant,frase);

   return 0;
}

int elimstr(char *str, char *strb)
{
   int ind, lstrb = strlen(strb), cont = 0 ;

   for ( ind = 0; *(str+ind); ind ++ )
      if ( strnicmp(str+ind,strb,lstrb) == 0 )
      {
         strcpy(str+ind,str+ind+lstrb);
         cont++;
         ind--;
      }

   return cont;
}


