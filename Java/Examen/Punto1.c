#include <stdio.h>
#include <stdlib.h>
#include <conio.c>
#include <string.h>

#define MAXCOL 2
#define MAXFIL 2

void getmat(int [][MAXCOL],int,int);
void putmat(int [][MAXCOL],int,int);
void persistencia(int [][MAXCOL],int,int);
void mayor(int [][MAXCOL],int,int, int *, int *);

int main()
{
    int mat[MAXFIL][MAXCOL];

    printf("Ingrese una matriz %d X %d:\n",MAXFIL,MAXCOL);
    getmat(mat,MAXFIL,MAXCOL);

    printf("Matriz digitada:\n");
    putmat(mat,MAXFIL,MAXCOL);

    persistencia(mat,MAXFIL,MAXCOL);
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
    int indfil, indcol;

    for ( indfil = 0; indfil < fila; indfil ++ )
    {
        for ( indcol = 0; indcol < col; indcol ++ )
            printf(" %d ",mat[indfil][indcol]);
        printf("\n");
    }
}
void persistencia(int mat[][MAXCOL],int fila, int col)
{
    int indfil, indcol, multipli, unidad, persi[MAXFIL][MAXCOL];
    int num[MAXFIL][MAXCOL];
    int filamayor, columnmayor;
    for ( indfil = 0; indfil < fila; indfil ++ )
    {
        for ( indcol = 0; indcol < col; indcol ++ )
        {
            num[indfil][indcol] = mat[indfil][indcol];
            multipli = 0;
            persi[indfil][indcol] = 0;
            unidad = 0;
            while(mat[indfil][indcol] > 9)
            {
                multipli = 1;
                while(mat[indfil][indcol] != 0)
                {
                    unidad = mat[indfil][indcol] % 10;
                    multipli *= unidad;
                    mat[indfil][indcol] = (mat[indfil][indcol] - unidad)/10;
                }

                persi[indfil][indcol]++;
                mat[indfil][indcol] = multipli;
            }
        }
    }
    mayor(persi,MAXFIL,MAXCOL,&filamayor,&columnmayor);
    printf("El mayor es %3d y est%c en [%d,%d]\n",num[filamayor][columnmayor],160,filamayor,columnmayor);
}

void mayor(int arr[][MAXCOL], int fila, int col, int *indfilm, int *indcolm)
{
    int i, j;
    int mayor = arr[MAXFIL][MAXCOL];
    *indfilm = *indcolm = 0;
    for (i=0; i < fila; i++)
    {
        for(j = 0; j < col; j++)
        {
            if (arr[i][j] > mayor)
            {
                mayor = arr[i][j];
                *indfilm = i;
                *indcolm = j;
            }

        }
    }
    return;
}
