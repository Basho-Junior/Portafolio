#include <stdio.h>
#include <stdlib.h>


int main()
{
   char frase[] = "Una primavera para el mundo.";
   char *pchar;

   pchar = frase+4;

   puts(frase);
   puts(&frase[0]);
   puts(&frase[4]);
   puts(frase+4);

   puts(pchar);
   pchar--;
   puts(pchar);
   pchar+=3;
   puts(pchar);


   return 0;
}

