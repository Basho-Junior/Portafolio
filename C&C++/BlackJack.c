//Juego de BlackJack Por Junior Hernandez 2018-0999
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
#include <conio.c>
#include <string.h>

#define ESC   27

#define MAXCARTAS 52
#define MAXCARTASREP 11

#define LV  179
#define LH  196
#define ESI 218
#define EID 217
#define ESD 191
#define EII 192

#define espadas 6
#define trevoles 5
#define diamantes 4
#define corazones 3

int simbolocarta(int);
int valorcarta(int);
int tomarcarta(int []);
void showcart_xy(int [], int, int, int);
int sumacarta(int [], int);

int main()
{
    int mazo[MAXCARTAS] = {0}, cartas[MAXCARTAS] = {0};
    int jugador[MAXCARTASREP], computadora[MAXCARTASREP];
    int ind, indv = 0, j = 2, i = 1, cont = 0,R = 1, Rc = 1, n = 2, nc = 2, cant, cantc, pedir = 1, winner = 0;
    int indc = 0, cantju = 0, cantcomp = 0, puntjug = 0, puntcomp = 0;
    int juegosjug = 0, juegosgan = 0, juegosper = 0;
    char veces;
    int juego = 1;

    printf("Observe el mazo:");
    //Un bucle para imprimir el mazo.
    for (ind = 0; ind < MAXCARTAS; ind ++)
    {
        cartas[indv] = ind;
        indv = indv + 1;
        cont++;
        if (mazo[ind]==0)
        {
            if(cont == 21)
            {
                j = 5;
                i = 1;
            }
            else if (cont == 40)
            {
                j = 8;
                i = 1;
            }
            showcart_xy(cartas,i,j, indv);
            i= i + 5;
        }
    }
    printf("\nDesea repartir las cartas? s/n\n");
    printf("%c", 62);
    do
    {
        veces = getchar();
    }
    while (veces!='s' && veces!='n');

    if (veces == 's')
    {
        while(juego == 1)
        {
            int mazo[MAXCARTAS] = {0};
            int jugador[MAXCARTASREP], computadora[MAXCARTASREP];
            int R = 1, Rc = 1, n = 2, nc = 2, cant, cantc, pedir = 1, winner = 0;
            int indc = 0, cantju = 0, cantcomp = 0, puntjug = 0, puntcomp = 0;
            //Imprimir las cartas de los jugadores
            srand (time(NULL));
            printf("\nCartas del jugador: ");
            for (cant = 0; cant < n; cant++)
            {
                indc = tomarcarta(mazo);
                jugador[cantju] = indc;
                cantju = cantju + 1;

                showcart_xy(jugador, R, 17, cantju);
                R = R + 5;

                puntjug = sumacarta(jugador, cantju);
                printf("\nPuntaje del jugador: %d\n\n", puntjug);
            }

            printf("\nCartas del computador:");
            for (cantc = 0; cantc < nc; cantc++)
            {

                indc = tomarcarta(mazo);
                computadora[cantcomp] = indc;
                cantcomp = cantcomp + 1;

                showcart_xy(computadora, Rc, 26, cantcomp);
                Rc = Rc + 5;

                puntcomp = sumacarta(computadora, cantcomp);
                printf("\nPuntaje de la computadora: %d\n\n", puntcomp);
            }
            //Decesiones para que gane o pierda.
            if (puntjug == 21)
            {
                printf("\nUsted ha ganado!");
                winner = 1;
                juegosgan = juegosgan + 1;
                juegosjug = juegosjug + 1;
            }
            else if (puntcomp == 21)
            {
                printf("\nUsted ha perdido!");
                winner = 1;
                juegosper = juegosper + 1;
                juegosjug = juegosjug + 1;
            }
            else if (puntjug > 21)
            {
                printf("\nUsted ha perdido!");
                winner = 1;
                juegosper = juegosper + 1;
                juegosjug = juegosjug + 1;
            }
            else if (puntcomp > 21)
            {
                printf("\nUsted ha ganado!");
                winner = 1;
                juegosgan = juegosgan + 1;
                juegosjug = juegosjug + 1;
            }
            if ((puntjug < 21) && (puntcomp < 21) && (winner == 0))
            {
                printf("Desea pedir otra carta? Si = 1 /No = 2: ");
                scanf("%d",&pedir);

                while(pedir == 1)
                {
                    indc = tomarcarta(mazo);
                    jugador[cantju] = indc;
                    cantju = cantju + 1;
                    n = 1;
                    if(puntcomp < puntjug)
                    {
                        //printf("\nLa computadora tambien escogio otra carta.");
                        indc = tomarcarta(mazo);
                        computadora[cantcomp] = indc;
                        cantcomp = cantcomp + 1;
                        nc = 1;
                    }
                    for (cant = 0; cant < n; cant++)
                    {
                        indc = tomarcarta(mazo);
                        jugador[cantju] = indc;
                        cantju = cantju + 1;

                        showcart_xy(jugador, R, 17, cantju);
                        R = R + 5;

                        puntjug = sumacarta(jugador, cantju);
                        printf("\nPuntaje del jugador: %d\n\n", puntjug);
                    }

                    for (cantc = 0; cantc < nc; cantc++)
                    {

                        indc = tomarcarta(mazo);
                        computadora[cantcomp] = indc;
                        cantcomp = cantcomp + 1;

                        showcart_xy(computadora, Rc, 26, cantcomp);
                        Rc = Rc + 5;

                        puntcomp = sumacarta(computadora, cantcomp);
                        printf("\nPuntaje de la computadora: %d\n\n", puntcomp);
                    }
                    if (puntjug == 21)
                    {
                        printf("\nUsted ha ganado!");
                        winner = 1;
                        juegosgan = juegosgan + 1;
                        juegosjug = juegosjug + 1;
                    }
                    else if (puntcomp == 21)
                    {
                        printf("\nUsted ha perdido!");
                        winner = 1;
                        juegosper = juegosper + 1;
                        juegosjug = juegosjug + 1;
                    }
                    else if (puntjug > 21)
                    {
                        printf("\nUsted ha perdido!");
                        winner = 1;
                        juegosper = juegosper + 1;
                        juegosjug = juegosjug + 1;
                    }
                    else if (puntcomp > 21)
                    {
                        printf("\nUsted ha ganado!");
                        winner = 1;
                        juegosgan = juegosgan + 1;
                        juegosjug = juegosjug + 1;
                    }

                    if (winner == 0)
                    {
                        printf("Desea pedir otra carta? Si = 1 /No = 2: ");
                        scanf("%d",&pedir);
                    }
                    else
                    {
                        pedir = 0;
                    }
                }
                if (winner == 0)
                {
                    if (((21 - puntjug) < (21 - puntcomp)))
                    {
                        printf("\nUsted ha ganado!");
                        winner = 1;
                        juegosgan = juegosgan + 1;
                        juegosjug = juegosjug + 1;
                    }
                    else
                    {
                        printf("\nUsted ha perdido!");
                        winner = 1;
                        juegosper = juegosper + 1;
                        juegosjug = juegosjug + 1;
                    }
                }
            }
            printf("\nQuiere volver a jugar? Si = 1 / No = 2: ");
            scanf("%d",&juego);
        }
        printf("Juegos Jugados: %d\n",juegosjug);
        printf("Juegos Ganados: %d\n",juegosgan);
        printf("Juegos Perdidos: %d\n",juegosper);

    }
    return 0;
}

/*
Función: simbolocarta.
Argumento: (int)valor. Valor para para retornar el simbolo de la carta.
Objetivo: Retornar el simbolo de la carta.
Retorno: 0 si el símbolo correspondiente según el índice
del arreglo es un corazón, 1 si el símbolo correspondiente según el índice del arreglo es un diamante, 2 si
el símbolo correspondiente según el índice del arreglo es un trébol y 3 si el símbolo correspondiente según
el índice del arreglo es una espada (o pique).
*/

int simbolocarta(int valor)
{
    int sim;
    switch (valor)
    {
    case 0:
    case 4:
    case 8:
    case 12:
    case 16:
    case 20:
    case 24:
    case 28:
    case 32:
    case 36:
    case 40:
    case 44:
    case 48:
        sim = 0;
        break;
    case 1:
    case 5:
    case 9:
    case 13:
    case 17 :
    case 21:
    case 25:
    case 29:
    case 33:
    case 37:
    case 41:
    case 45:
    case 49:
        sim = 1;
        break;
    case 2:
    case 6:
    case 10:
    case 14:
    case 18:
    case 22:
    case 26:
    case 30:
    case 34:
    case 38:
    case 42:
    case 46:
    case 50:
        sim = 2;
        break;
    case 3:
    case 7:
    case 11:
    case 15:
    case 19:
    case 23:
    case 27:
    case 31:
    case 35:
    case 39:
    case 43:
    case 47:
    case 51:
        sim = 3;
        break;
    }
    return sim;
}

/*
Función: valorcarta.
Argumento: (int)indice de la carta. Indice para generrar una serie de numeros consecutivos.
Objetivo: Cambiar los indices por una serie de numeros consecutivos.
Retorno:  los primeros 4 valores son los 1 o los ases (‘A’), los siguientes 4 son los 2’s, y así sucesivamente de tal forma
que los últimos 4 son los 13’s.
*/

int valorcarta(int indice)
{
    if (indice < 4)
    {
        return 1;
    }
    else if (indice >= 4 && indice < 8)
    {
        return 2;
    }
    else if (indice >= 8 && indice < 12)
    {
        return 3;
    }
    else if (indice >= 12 && indice < 16)
    {
        return 4;
    }
    else if (indice >= 16 && indice < 20)
    {
        return 5;
    }
    else if (indice >= 20 && indice < 24)
    {
        return 6;
    }
    else if (indice >= 24 && indice < 28)
    {
        return 7;
    }
    else if (indice >= 28 && indice < 32)
    {
        return 8;
    }
    else if (indice >= 32 && indice < 36)
    {
        return 9;
    }
    else if (indice >= 36 && indice < 40)
    {
        return 10;
    }
    else if (indice >= 40 && indice < 44)
    {
        return 11;
    }
    else if (indice >= 44 && indice < 48)
    {
        return 12;
    }
    else if (indice >= 48 && indice < 52)
    {
        return 13;
    }
}

/*
Función: tomarcarta.
Argumento: (int)mazo[]. Mazo para tomar una carta de este.
Objetivo: Tomar una de las 52 cartas del mazo.
Retorno:  El indice tomado de la carta dentro del mazo.
*/

int tomarcarta(int mazo [])
{
    int no = 1;
    int ind = 0;

    while (no == 1)
    {
        ind = rand() % 52;
        if (mazo[ind]==0)
        {
            no = 0;
            mazo[ind] = 1;
        }
    }
    return ind;
}

/*
Función: showcart_xy.
Argumento: (int)indice de la carta, (int)px, (int)px y (int)n. Indice posicion en x posicion en y e la cantidad de cartas.
Objetivo: Generar y posicionar la imagen de la carta.
*/

void showcart_xy(int indice [], int px, int py, int n)
{
    char fl;
    int po_ind, i;
    int ind;

    for (i = 0; i < n; i++)
    {
        po_ind = valorcarta(indice[i]) % 100;
        //Un switch case para los casos con sus respectivos numeros impriman su carta con ese mismo valor.

        ind = indice[i];
        switch (simbolocarta(ind))
        {
        case 0:
            fl = 3;
            break;
        case 1:
            fl = 4;
            break;
        case 2:
            fl = 5;
            break;
        case 3:
            fl = 6;
            break;
        }
        switch (po_ind)
        {
        case 1:
        {
            gotoxy(px,py);
            printf("%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,ESD);
            gotoxy(px,py+1);
            printf("%c%c%c%c%c%c%c%c",LV,fl,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+2);
            printf("%c%c%cA%c%c%c%c",LV,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+3);
            printf("%c%c%c%c%c%c%c%c",LV,' ',' ',' ',' ',' ',fl,LV);
            gotoxy(px,py+4);
            printf("%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,EID);

            break;
        }
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        {
            gotoxy(px,py);
            printf("%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,ESD);
            gotoxy(px,py+1);
            printf("%c%c%c%c%c%c%c%c",LV,fl,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+2);
            printf("%c%c%c%2d%c%c%c",LV,' ',' ',po_ind,' ',' ',LV);
            gotoxy(px,py+3);
            printf("%c%c%c%c%c%c%c%c",LV,' ',' ',' ',' ',' ',fl,LV);
            gotoxy(px,py+4);
            printf("%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,EID);

            break;
        }
        case 11:
        {
            gotoxy(px,py);
            printf("%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,ESD);
            gotoxy(px,py+1);
            printf("%c%c%c%c%c%c%c%c",LV,fl,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+2);
            printf("%c%c%cJ%c%c%c%c",LV,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+3);
            printf("%c%c%c%c%c%c%c%c",LV,' ',' ',' ',' ',' ',fl,LV);
            gotoxy(px,py+4);
            printf("%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,EID);

            break;
        }
        case 12:
        {
            gotoxy(px,py);
            printf("%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,ESD);
            gotoxy(px,py+1);
            printf("%c%c%c%c%c%c%c%c",LV,fl,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+2);
            printf("%c%c%cQ%c%c%c%c",LV,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+3);
            printf("%c%c%c%c%c%c%c%c",LV,' ',' ',' ',' ',' ',fl,LV);
            gotoxy(px,py+4);
            printf("%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,EID);

            break;
        }
        case 13:
        {
            gotoxy(px,py);
            printf("%c%c%c%c%c%c%c%c",ESI,LH,LH,LH,LH,LH,LH,ESD);
            gotoxy(px,py+1);
            printf("%c%c%c%c%c%c%c%c",LV,fl,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+2);
            printf("%c%c%cK%c%c%c%c",LV,' ',' ',' ',' ',' ',LV);
            gotoxy(px,py+3);
            printf("%c%c%c%c%c%c%c%c",LV,' ',' ',' ',' ',' ',fl,LV);
            gotoxy(px,py+4);
            printf("%c%c%c%c%c%c%c%c",EII,LH,LH,LH,LH,LH,LH,EID);

            break;
        }

        }
    }
}

/*
Función: sumacarta.
Argumento: (int)cartas[] y (int)n. Cartas y cantidad de cartas para sumarlas.
Objetivo: Sumar los valores de las cartas.
Retorno:  La suma total de las cartas.
*/

int sumacarta(int cartas[], int n)
{
    int i, e, suma = 0;

    //Suma el valor de las cartas.

    for(i=0; i<n; i++)
    {
        if (valorcarta(cartas[i])==1)
        {
            e = 1;
        }
        else
        {
            suma = suma + valorcarta(cartas[i]);
        }
    }
    //En el caso de que exista un A.

    if (e == 1)
    {
        if ((suma + 11) <= 21)
        {
            suma = suma + 11;
        }
        else
        {
            suma = suma + 1;
        }
    }

    return suma;
}

