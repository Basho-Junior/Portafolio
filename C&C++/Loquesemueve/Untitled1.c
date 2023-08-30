#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

#define MAXFIL 3
#define MAXCOL 3

void getmat(int [][MAXCOL],int,int);
void putmat(int [][MAXCOL],int,int);
int diagonalprincipal(int [][MAXCOL],int,int);
int diagonalinversa(int [][MAXCOL],int,int);

int main()
{

   int mat[MAXFIL][MAXCOL];

   printf("Ingrese una matriz %d X %d:\n",MAXFIL,MAXCOL);
   getmat(mat,MAXFIL,MAXCOL);

   printf("Matriz digitada:\n");
   putmat(mat,MAXFIL,MAXCOL);

   printf("La traza de m es %d \n",diagonalprincipal(mat,MAXFIL,MAXCOL));
   printf("La traza inversa de m es %d\n",diagonalinversa(mat,MAXFIL,MAXCOL));

   return 0;
}

void getmat(int mat[][MAXCOL],int fila,int col)
{
   int indfil, indcol;

   for ( indfil = 0; indfil < fila; indfil ++ )
      for ( indcol = 0; indcol < col; indcol ++ )
      {
         printf("Mat[%d][%d]: ",indfil,indcol);
         scanf("%d",&mat[indfil][indcol]);
      }
   return;
}

void putmat(int mat[][MAXCOL],int fila,int col)
{
   int indfil, indcol, i,j, diagonalpri=0, diagonalin=0;

   for ( indfil = 0; indfil < fila; indfil ++ )
   {
      for ( indcol = 0; indcol < col; indcol ++ )
         printf(" %d ",mat[indfil][indcol]);
      printf("\n");
   }
}

int diagonalprincipal(int mat[][MAXCOL],int fila, int col)
{
   int i, j, diagonalpri=0;
   for(i=0, j=0; i<fila && j<col; i++, j++)
    {
            if(i==j)
                diagonalpri=diagonalpri+mat[i][j];
    }
    return diagonalpri;
}

int diagonalinversa(int mat[][MAXCOL],int fila, int col)
{
   int i, j, diagonalin=0;
   for(int i = fila - 1, j = 0; i >= 0 && j < col; i--, j++)
   {
      diagonalin += mat[i][j];
   }
   return diagonalin;
}
