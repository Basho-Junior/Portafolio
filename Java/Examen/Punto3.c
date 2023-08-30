#include <stdio.h>
#define MAXCOL 2
#define MAXFIL 2

int indmin(int *, int);
int indmax(int *, int);
void swap(int *, int *);
void ordenar(int *, int, int);


int main()
{
    int indfil, indcol, mat[MAXFIL][MAXCOL];

    for ( indfil = 0; indfil < MAXFIL; indfil ++ )
        for ( indcol = 0; indcol < MAXCOL; indcol ++ )
        {
            printf("Mat[%d][%d]: ",indfil,indcol);
            scanf("%d",&mat[indfil][indcol]);
        }
    OrdenarMat(mat,MAXFIL,MAXCOL);
}

int indmin(int *ptr, int n)
{
    int indMin=0, t;

    for (int indfil = 0; indfil < n; indfil ++ )
    {
        for (int indcol = 0; indcol < n; indcol ++ )
        {
            if(*(ptr + indcol) < *(ptr + indfil))
            {
                t = *(ptr + indfil);
                *(ptr + indfil) = *(ptr + indcol);
                *(ptr + indcol) = t;
                indMin = indfil;
            }
        }
    }
    return indMin;
}

int indmax(int *ptr, int n)
{
    int indMaxfil=0, indMaxcol=0, t;

    for (int indfil = 0; indfil < n; indfil ++ )
    {
        for (int indcol = 0; indcol < n; indcol ++ )
        {
            if(*(ptr + indcol) > *(ptr + indfil))
            {
                t = *(ptr + indfil);
                *(ptr + indfil) = *(ptr + indcol);
                *(ptr + indcol) = t;
                indMaxcol = indcol;
                indMaxfil = indfil;
            }
        }
    }
    return indMaxfil;

}

void ordenar(int *ptr, int n, int tipo)
{
    int indfil, indcol, datos, k, l, i, j;

    /* organizando arreglo */
    for (indfil = 0; indfil < n; indfil++)
    {
        for (indcol = 0; indcol < n; indcol++)
        {
            datos = *(ptr + indfil);
            l = indcol + 1;
            for (k = i; k < n; k++)
            {
                while (l < n)
                {
                    swap(datos, *(ptr + indcol));
                    l++;
                }
                l = 0;
            }
        }
    }
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j++)
        {
            printf("%d ", *(ptr + indfil));
        }
        printf("\n");


    }
}

    void OrdenarMat(int mat[ ][MAXCOL], int filas, int columnas)
    {
        int deci = 0;
        for (int indfil= 0; indfil < filas; indfil ++ )
        {
            for ( int indcol = 0; indcol < columnas; indcol ++ )
            {
                if ( indcol == 0 )
                {
                    if ( indfil > 0 )
                    {
                        if ( mat[indfil][indcol] > mat[indfil-1][indfil-1] )
                            deci = 0;
                    }
                }
                else if ( mat[indfil][indcol] > mat[indfil][indcol-1] )
                    deci = 0;
                else
                {
                    deci = 1;
                }
            }
        }
        ordenar(&mat[0][0],filas*columnas,deci);
    }

    void swap(int *val1, int *val2)
    {
        int temp;

        temp = *val1;
        *val1 = *val2;
        *val2 = temp;

    }
