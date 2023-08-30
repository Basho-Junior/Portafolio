#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

#define MAXFIL 10
#define MAXCOL 10
#define ESP    3
#define MAXVECES 20

#define ESC   27
#define ENTER 13

#define DERECHA   77
#define IZQUIERDA 75
#define ABAJO     80
#define ARRIBA    72

#define CT     YELLOW
#define CF     BLUE
#define CTS     BLUE
#define CFS     YELLOW
#define CTM    RED
#define CFM    LIGHTGRAY


void genmat(int [][MAXCOL],int,int,int,int);
void putmatxy(int [][MAXCOL],int,int,int,int,int,int,int,int);
void movimiento(int [][MAXCOL],int,int,int,int);

void setcolor(int,int);
void colordefault();
int randrango(int,int);

int main()
{
    int mat[MAXFIL][MAXCOL];
    int veces;
    srand(time(NULL));

    genmat(mat,MAXFIL,MAXCOL,20,40);
    movimiento(mat,MAXFIL,MAXCOL,10,5);

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
            mat[indfil][indcol] = 0;

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
            else if ( indfil == fs && indcol == cs )
                setcolor(CTS,CFS);
            gotoxy(px+indcol*ESP,py+indfil);
            printf(" %d ",mat[indfil][indcol]);
        }
    }
    colordefault();
}


void movimiento(int mat[][MAXCOL],int fila,int column,int px, int py)
{
    int filasel = 0, columnasel = 0, barcosjugador = 0, barcoscomputadora = 0, barcojugador = 1, barcocomputadora = 2;
    int fmarc = -1, cmarc = -1, temp, barcohundidojugador = 3, barcohundidocomputadora = 4;
    char tecla;
    _setcursortype(0);
    do
    {
        putmatxy(mat,MAXFIL,MAXCOL,10,5,filasel,columnasel,fmarc,cmarc);
        tecla = getch();

        if ( tecla == DERECHA )
        {
            columnasel ++;
            if ( columnasel == MAXFIL )
                columnasel = 0;
        }

        if ( tecla == IZQUIERDA )
        {
            columnasel --;
            if ( columnasel < 0 )
                columnasel = MAXFIL - 1;
        }

        if ( tecla == ABAJO )
            filasel ++;
        if ( tecla == ARRIBA )
            filasel --;


        if ( tecla == ENTER )
        {
            if (mat[filasel][columnasel] == 0 && barcosjugador < 5)
            {
                mat[filasel][columnasel] = barcojugador;
                barcosjugador += 1;
            }
            else if (mat[filasel][columnasel] == barcocomputadora)
            {
                mat[filasel][columnasel] = barcohundidocomputadora;
                barcoscomputadora -= 1;
            }
            else if (mat[filasel][columnasel] == barcojugador && barcoscomputadora <= 5 && barcoscomputadora > 0)
            {
                mat[filasel][columnasel] = barcohundidojugador;
                barcosjugador -= 1;
            }
            else if ( fmarc != -1 && cmarc != -1 && mat[filasel][columnasel] == 0 && barcoscomputadora == 0)
            {
                temp = mat[filasel][columnasel];
                mat[filasel][columnasel] = mat[fmarc][cmarc];
                mat[fmarc][cmarc] = temp;
                fmarc = -1, cmarc = -1;
            }
            else
                fmarc = filasel, cmarc = columnasel;
            if (mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] == barcojugador)
            {
                mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] = barcohundidojugador;
                barcosjugador -= 1;
            }
            else if (mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] == barcocomputadora)
            {
                mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] = barcohundidocomputadora;
                barcoscomputadora -= 1;
            }
        }

        if (barcosjugador == 5 && tecla == ESC)
        {
            while (barcoscomputadora < 5)
            {
                if(mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] == 0 && mat[randrango(0,MAXFIL)][randrango(0,MAXCOL)] != 1)
                {
                    Sleep(500);
                    printf("\n Barco %d desplegado", barcoscomputadora);
                    mat[randrango(0,MAXFIL-1)][randrango(0,MAXCOL-1)] = barcocomputadora;
                    barcoscomputadora += 1;
                }

            }
        }
    }
    while ( tecla != 112 );
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
