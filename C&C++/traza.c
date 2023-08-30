#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

#define MAXFIL 3
#define MAXCOL 3
#define ESP    4
#define MAXVECES 20

#define ESC   27
#define ENTER 13

#define DERECHA   77
#define IZQUIERDA 75
#define ABAJO     80
#define ARRIBA    72

#define CT     BLUE
#define CF     LIGHTGRAY

#define CTS    LIGHTGRAY
#define CFS    BLUE

#define CTM    RED
#define CFM    YELLOW

void genmat(int [][MAXCOL],int,int,int,int);
void putmatxy(int [][MAXCOL],int,int,int,int,int,int,int,int);
void setcolor(int,int);
void colordefault();
int randrango(int,int);

int trazamat(int [][MAXCOL],int);

int sum_up_diagP(int [][MAXCOL],int);

int sum_dn_diagP(int [][MAXCOL],int);

int main()
{
   int mat[MAXFIL][MAXCOL];
   int arr[] = {10,12,15,18};
   int veces;
   srand(time(NULL));

   genmat(mat,MAXFIL,MAXCOL,20,40);
   putmatxy(mat,MAXFIL,MAXCOL,10,5,-1,-1,-1,-1);
   printf("\nLa traza es: %d\n",trazamat(mat,MAXFIL));

   printf("\nLa sumatoria por encima digonal principal es:\n%d\n",sum_up_diagP(mat,MAXFIL));
   printf("\nLa sumatoria por debajo digonal principal es:\n%d\n",sum_dn_diagP(mat,MAXFIL));


   genmattraza(mat,MAXFIL);
   putmatxy(mat,MAXFIL,MAXCOL,10,15,-1,-1,-1,-1);

   printf("\nLa traza es: %d\n",trazamat(mat,MAXFIL));

   printf("\nLa sumatoria por encima digonal principal es:\n%d\n",sum_up_diagP(mat,MAXFIL));
   printf("\nLa sumatoria por debajo digonal principal es:\n%d\n",sum_dn_diagP(mat,MAXFIL));

   printf("\nEl arreglo...\n");
   imparr(arr,sizeof(arr)/sizeof(int));

   printf("\nLa matriz...\n");
   imparr(&mat[0][0],MAXFIL * MAXCOL );

   return 0;
}


int randrango(int a,int b)
{
   return rand() % (b-a+1) + a;
}

void genmat(int mat[][MAXCOL],int fila,int column,int a,int b)
{
   int indfil, indcol;

   for ( indfil = 0; indfil < fila; indfil ++ )
      for ( indcol = 0; indcol < column; indcol ++ )
         mat[indfil][indcol] = randrango(a,b);

}


void putmatxy(int mat[][MAXCOL],int fila,int column,int px, int py,int fs, int cs, int fm, int cm)
{
   int indfil, indcol;

   for ( indfil = 0; indfil < fila; indfil ++ )
   {
      for ( indcol = 0; indcol < column; indcol ++ )
      {
         setcolor(CT,CF);
         if ( indfil == fm && indcol == cm )
            setcolor(CTM,CFM);
         else
            if ( indfil == fs && indcol == cs )
               setcolor(CTS,CFS);
         gotoxy(px+indcol*ESP,py+indfil);
         printf(" %2d ",mat[indfil][indcol]);
      }
   }
   colordefault();
}


void setcolor(int ct, int cf)
{
   textcolor(ct);
   textbackground(cf);
}

void colordefault()
{
   setcolor(LIGHTGRAY,BLACK);
}



int trazamat(int mat[][MAXCOL],int orden)
{
   int ind, suma;

   for ( suma = 0, ind = 0; ind < orden; ind ++ )
      suma += mat[ind][ind];

   return suma;
}


int sum_up_diagP(int mat[][MAXCOL],int orden)
{
   int indfil,indcol, suma;

   for ( suma = 0, indfil = 0; indfil < orden; indfil ++ )
      for ( indcol = 0; indcol < orden; indcol ++ )
         if ( indfil < indcol )
            suma += mat[indfil][indcol];

   return suma;
}

int sum_dn_diagP(int mat[][MAXCOL],int orden)
{
   int indfil,indcol, suma;

   for ( suma = 0, indfil = 0; indfil < orden; indfil ++ )
      for ( indcol = 0; indcol < orden; indcol ++ )
         if ( indfil > indcol )
            suma += mat[indfil][indcol];

   return suma;
}


void gendiagprin(int mat[][MAXCOL],int orden)
{
   int ind, suma;

   for ( suma = 0, ind = 0; ind < orden; ind ++ )
      mat[ind][ind] = randrango(0,orden*orden);

   return suma;
}


void genmattraza(int mat[][MAXCOL],int orden)
{
   int indfil,indcol, suma,traza;

   gendiagprin(mat,orden);

   traza = trazamat(mat,orden);

   for ( suma = 0, indfil = 0; indfil < orden; indfil ++ )
      for ( indcol = 0; indcol < orden; indcol ++ )
      {
         if ( indfil < indcol )
            mat[indfil][indcol] = randrango(2*traza,4*traza);
         if ( indfil > indcol )
            mat[indfil][indcol] = randrango(3*traza,6*traza);
      }

   return;
}

void imparr(int *ptr, int n)
{
   int ind;

   for ( ind = 0; ind < n; ind ++ )
      printf("[%d] ",*(ptr+ind));
}
