#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

#define MAXCHARS 80

int elimchar(char *,char);
int espalindromo(char *);
void invstr(char *);

int main()
{
   char frase[MAXCHARS], frcomp[MAXCHARS];

   printf("Ingrese una frase:\n");
   gets(frase);

   strcpy(frcomp,frase);

   elimchar(frcomp,' ');

   if ( espalindromo(frcomp))
      printf("[%s] es palindromo.\n",frase);
   else
      printf("[%s] NO es palindromo.\n",frase);

   invstr(frase);

   printf("Invertido es: [%s]\n",frase);

}

int elimchar(char *str, char caract)
{
   int ind, celim = 0;

   for ( ind = 0; *(str+ind); ind ++ )
      if ( *(str+ind) == caract )
      {
         strcpy(str+ind,str+ind+1);
         celim++;
      }

   return celim;
}

int espalindromo(char *str)
{
   int indasc, inddesc;

   for (indasc = 0, inddesc = strlen(str)-1; indasc < inddesc; indasc ++, inddesc -- )
      if ( tolower(*(str+indasc)) != tolower(str[inddesc]) )
         return 0;

   return 1;
}


void invstr(char *str)
{
   int indasc, inddesc;

   for (indasc = 0, inddesc = strlen(str)-1; indasc < inddesc; indasc ++, inddesc -- )
      swap(str+indasc,str+inddesc);

}

/*
      1. swap(&str[indasc],&str[inddesc]);

      2.
      temp = str[indasc];
      str[indasc] = str[inddesc];
      str[inddesc] = temp;

      3.
      swap(str+indasc,str+inddesc);

      4.
      temp = *(str+indasc);
      *(str+indasc) =  *(str+inddesc);
      *(str+inddesc) = temp;
*/

void swap(char *a, char *b )
{
   char temp;

   temp = *a;
   *a = *b;
   *b = temp;

   return;
}
