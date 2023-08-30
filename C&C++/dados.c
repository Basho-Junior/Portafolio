#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <ctype.h>
#include <string.h>
#include <conio.c>

#define LINEA 80
#define CANTFRASES 2
#define CANTCHAR 5
#define ESC 27


#define LV  179
#define LH  196
#define ESI 218
#define EID 217
#define ESD 191
#define EII 192
#define PD  254

void impdadosxy(int,int,int);


int main()
{
   srand(time(NULL));
   int cont = 0, termino = rand() %50 + 10;

   _setcursortype(0);
   do
   {
      impdadosxy(rand() % 6 + 1,10,5);
      impdadosxy(rand() % 6 + 1,18,5);
      Sleep(200);
      cont++;
   }while (cont != termino);

   return 0;
}


void impdadosxy(int n,int x, int y)
{
   gotoxy(x,y);  printf("%c%c%c%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,LH,LH,LH,ESD);
   gotoxy(x,y+1);printf("%c%c%c%c%c%c%c%c%c%c%c",LV,' ',' ',(n>=2?PD:' '),' ',' ',' ',(n>=4?PD:' '),' ',' ',LV);
   gotoxy(x,y+2);printf("%c%c%c%c%c%c%c%c%c%c%c",LV,' ',' ',(n==6?PD:' '),' ',(n%2?PD:' '),' ',(n==6?PD:' '),' ',' ',LV);
   gotoxy(x,y+3);printf("%c%c%c%c%c%c%c%c%c%c%c",LV,' ',' ',(n>=4?PD:' '),' ',' ',' ',(n>=2?PD:' '),' ',' ',LV);
   gotoxy(x,y+4);printf("%c%c%c%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,LH,LH,LH,EID);
}
