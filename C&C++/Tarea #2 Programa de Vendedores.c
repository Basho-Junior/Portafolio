#include <stdio.h>
#include <stdlib.h>
#include <conio.c>

//----------------------------------------------------------------------------------------------------------------------
// Módulo SimboloCarta: Dado un valor retorna
// 		0: Corazón
// 		1: Diamante
// 		2: Trébol
// 		3: Espada
//----------------------------------------------------------------------------------------------------------------------
int SimboloCarta(int Valor)
{
	int Simbolo;

	switch (Valor)
	{
		case 0: case 4: case 8: case 12: case 16: case 20: case 24: case 28: case 32: case 36: case 40: case 44: case 48:
			Simbolo = 0;
			break;
		case 1: case 5: case 9: case 13: case 17 : case 21: case 25: case 29: case 33: case 37: case 41: case 45: case 49:
			Simbolo = 1;
			break;
		case 2: case 6: case 10: case 14: case 18: case 22: case 26: case 30: case 34: case 38: case 42: case 46: case 50:
			Simbolo = 2;
			break;
		case 3: case 7: case 11: case 15: case 19: case 23: case 27: case 31: case 35: case 39: case 43: case 47: case 51:
			Simbolo = 3;
			break;
	}
	return Simbolo;
}

                              // ♥       ♥         ♥
// Módulo ValorCarta: Retorna el valor de la carta de acuerdo al valor del indice

int ValorCarta(int Indice)
{
	int Valor;

	if (Indice>=0 && Indice<=3)   { Valor = 1; }
	if (Indice>=4 && Indice<=7)   { Valor = 2; }
	if (Indice>=8 && Indice<=11)  { Valor = 3; }
	if (Indice>=12 && Indice<=15) { Valor = 4; }
	if (Indice>=16 && Indice<=19) { Valor = 5; }
	if (Indice>=20 && Indice<=23) { Valor = 6; }
	if (Indice>=24 && Indice<=27) { Valor = 7; }
	if (Indice>=28 && Indice<=31) { Valor = 8; }
	if (Indice>=32 && Indice<=35) { Valor = 9; }
	if (Indice>=36 && Indice<=39) { Valor = 10; }
	if (Indice>=40 && Indice<=43) { Valor = 11; }
	if (Indice>=44 && Indice<=47) { Valor = 12; }
	if (Indice>=48 && Indice<=51) { Valor = 13; }
	return Valor;
}

//----------------------------------------------------------------------------------------------------------------------
// Módulo TomarCarta: Retorna de forma aleatoria, el índice de una carta disponible, asignando a la misma el valor de 1
//----------------------------------------------------------------------------------------------------------------------
int TomarCarta(int mazo[])
{
	int NoEncontrado = 1; // Variable que es igual a 1 cuando aún no se encontrado una carta disponible e igual a cero mientras no encuentra uno disponible
	int IndiceCarta = 0; // Indice de la carta elegida dentro del mazo (0 a 51)

	while (NoEncontrado == 1)
	{
		IndiceCarta = rand() % 52; // Generar el índice de la carta a sacar del mazo
		if (mazo[IndiceCarta]==0)
		{ //Está disponible la carta que está en dicho índice, está disponible para tomar
			NoEncontrado = 0;
			mazo[IndiceCarta] = 1;
		}
	}
	return IndiceCarta;
}

//----------------------------------------------------------------------------------------------------------------------
// Módulo ShowCart_XY: Imprime en forma gráfica, en la posición indicada por px y py, la cara que se encuentre el índica
//----------------------------------------------------------------------------------------------------------------------
void ShowCart(int Cartas[], int N)
{
	int i;
	int Simbolo;
	char Valor;
	int Indice;

	//printf("(Posicion:%d) %d%c\n", Indice, ValorCarta(Indice), Simbolo);

	// Dibujar las cartas según la cantidad que tenga (línea por línea)
	for (i=0; i < N; i++)
	{
		printf("%c%c%c%c%c%c%c%c%c  ",201,205,205,205,205,205,205,205,187);
	}
	printf("\n");

	for (i=0; i < N; i++)
	{
		Indice = Cartas[i];

		// Convertir el valor número en letras
		switch (ValorCarta(Indice))
		{
			case 1: Valor = 'A';  break;
			case 2: Valor = '2';  break;
			case 3: Valor = '3';  break;
			case 4: Valor = '4';  break;
			case 5: Valor = '5';  break;
			case 6: Valor = '6';  break;
			case 7: Valor = '7';  break;
			case 8: Valor = '8';  break;
			case 9: Valor = '9';  break;
			case 11: Valor = 'J';  break;
			case 12: Valor = 'Q';  break;
			case 13: Valor = 'K';  break;
		}

		if (ValorCarta(Indice)==10)
			printf("%c%d     %c  ",186, ValorCarta(Indice), 186);
		else
			printf("%c%c      %c  ",186, Valor, 186);
	}
	printf("\n");

	for (i=0; i < N; i++)
	{
		Indice = Cartas[i];
		switch (SimboloCarta(Indice))
		{
			case 0: Simbolo = 3;
					break;
			case 1: Simbolo = 4;
					break;
			case 2: Simbolo = 5;
					break;
			case 3: Simbolo = 6;
					break;
		}
		printf("%c%c      %c  ",186,Simbolo, 186);
	}
	printf("\n");

	for (i=0; i < N; i++)
	{
		Indice = Cartas[i];
		switch (SimboloCarta(Indice))
		{
			case 0: Simbolo = 3;
					break;
			case 1: Simbolo = 4;
					break;
			case 2: Simbolo = 5;
					break;
			case 3: Simbolo = 6;
					break;
		}
		printf("%c   %c   %c  ",186,Simbolo, 186);
	}
	printf("\n");

	for (i=0; i < N; i++)
	{
		Indice = Cartas[i];
		switch (SimboloCarta(Indice))
		{
			case 0: Simbolo = 3;
					break;
			case 1: Simbolo = 4;
					break;
			case 2: Simbolo = 5;
					break;
			case 3: Simbolo = 6;
					break;
		}
		printf("%c      %c%c  ",186,Simbolo, 186);

	}
	printf("\n");


	for (i=0; i < N; i++)
	{
		Indice = Cartas[i];

		// Convertir el valor número en letras
		switch (ValorCarta(Indice))
		{
			case 1: Valor = 'A';  break;
			case 2: Valor = '2';  break;
			case 3: Valor = '3';  break;
			case 4: Valor = '4';  break;
			case 5: Valor = '5';  break;
			case 6: Valor = '6';  break;
			case 7: Valor = '7';  break;
			case 8: Valor = '8';  break;
			case 9: Valor = '9';  break;
			case 11: Valor = 'J';  break;
			case 12: Valor = 'Q';  break;
			case 13: Valor = 'K';  break;
		}

		if (ValorCarta(Indice)==10)
			printf("%c     %d%c  ",186, ValorCarta(Indice), 186);
		else
			printf("%c      %c%c  ",186, Valor, 186);
	}
	printf("\n");

	for (i=0; i < N; i++)
	{
		printf("%c%c%c%c%c%c%c%c%c  ",200,205,205,205,205,205,205,205,188);
	}
	printf("\n");
}

//----------------------------------------------------------------------------------------------------------------------
// Módulo SumaCarta: Retorna la suma de las "n" cartas en el arreglo "cartas"
//----------------------------------------------------------------------------------------------------------------------
int SumaCarta(int Cartas[], int n)
{
	int i, ExisteUno, Suma = 0;
	/*
	for(i=0; i<n; i++)
	{
		Suma = Suma + ValorCarta(Cartas[i]);
	}
	*/

	for(i=0; i<n; i++)
	{
		if (ValorCarta(Cartas[i])==1)
		{ // El valor de la carta es 1, guardar ese valor para luego verificar si valdrá 1 u 11
			ExisteUno = 1;
		}
		else
		{
			Suma = Suma + ValorCarta(Cartas[i]);
		}
	}

	// Analizar si se incrementa 1 u 11
	if (ExisteUno==1)
	{
		if ((Suma + 11) <= 21)
		{
			Suma = Suma + 11;
		}
		else
		{
			Suma = Suma + 1;
		}
	}

	return Suma;
}

//---------------------------------------------------------------------
// Módulo main: Módulo principal
//---------------------------------------------------------------------
int main()
{
	 int i;

	#define MAXCARTAS 51
	int Mazo[MAXCARTAS] = {0}; // Declaración del total de cartas a repartir

	#define MAXCARTAREP 51
	int Jugador[MAXCARTAREP];
	int Computadora[MAXCARTAREP];

	int CantidadCartasJugador = 0;
	int CantidadCartasComputadora = 0;

	int PuntajeJugador = 0;
	int PuntajeComputadora = 0;

	int ContinuarJuego = 1;

	int JuegosJugados = 0;
	int JuegosGanados = 0;
	int JuegosPerdidos = 0;

	int PedirCarta = 1;

	int IndiceCarta = 0;

	int ExisteGanador = 0;

	srand (time(NULL));

	// Continuar jugando mientras el usuario así lo decida
	while (ContinuarJuego == 1)
	{
		int Mazo[MAXCARTAS] = {0}; // Declaración del total de cartas a repartir

		int Jugador[MAXCARTAREP];
		int Computadora[MAXCARTAREP];

		CantidadCartasJugador = 0;
		CantidadCartasComputadora = 0;

		PuntajeJugador = 0;
		PuntajeComputadora = 0;

		PedirCarta = 1;

		IndiceCarta = 0;

		ExisteGanador = 0;

		srand (time(NULL));

		// Pantalla de Bienvenida
		printf("\n-----------------------------------------\n");
		printf("   Bienvenidos al juego del BLACKJACK\n");
		printf("-----------------------------------------\n");

		// Se reparte las primeras cartas para el jugador y el computador (Primera Rueda)
		IndiceCarta = TomarCarta(Mazo);
		Jugador[CantidadCartasJugador] = IndiceCarta;
		CantidadCartasJugador = CantidadCartasJugador + 1;

		IndiceCarta = TomarCarta(Mazo);
		Computadora[CantidadCartasComputadora] = IndiceCarta;
		CantidadCartasComputadora = CantidadCartasComputadora + 1;

		// Se reparte las segundas cartas para el jugador y el computador (Segunda Rueda)
		IndiceCarta = TomarCarta(Mazo);
		Jugador[CantidadCartasJugador] = IndiceCarta;
		CantidadCartasJugador = CantidadCartasJugador + 1;

		IndiceCarta = TomarCarta(Mazo);
		Computadora[CantidadCartasComputadora] = IndiceCarta;
		CantidadCartasComputadora = CantidadCartasComputadora + 1;


		// Mostrar las cartas del jugador y del computador
		printf("Cantidad de Cartas JUGADOR: %d\n", CantidadCartasJugador);
		ShowCart(Jugador, CantidadCartasJugador);
		PuntajeJugador = SumaCarta(Jugador, CantidadCartasJugador);
		printf("PUNTAJE ACTUAL: %d\n\n", PuntajeJugador);

		printf("Cantidad de Cartas COMPUTADORA: %d\n", CantidadCartasComputadora);
		ShowCart(Computadora, CantidadCartasComputadora);
		PuntajeComputadora = SumaCarta(Computadora, CantidadCartasComputadora);
		printf("PUNTAJE ACTUAL: %d\n\n", PuntajeComputadora);


		// Verificar resultados de las 2 primeras reparticiones
		if (PuntajeJugador == 21) // Gano el jugador
		{
			printf("\nMensaje: EL JUGADOR GANO ESTE JUEGO\n");
			ExisteGanador = 1;
			JuegosJugados = JuegosJugados + 1;
			JuegosGanados = JuegosGanados + 1;
		}

		if (PuntajeComputadora == 21) // Gano la computadora
		{
			printf("\nMensaje: LA COMPUTADORA GANO ESTE JUEGO\n");
			ExisteGanador = 1;
			JuegosJugados = JuegosJugados + 1;
			JuegosPerdidos = JuegosPerdidos + 1;
		}

		if (PuntajeJugador > 21) // Gano el computadora
		{
			printf("\nMensaje: LA COMPUTADORA GANO ESTE JUEGO\n");
			ExisteGanador = 1;
			JuegosJugados = JuegosJugados + 1;
			JuegosPerdidos = JuegosPerdidos + 1;
		}

		if (PuntajeComputadora > 21) // Gano el jugador
		{
			ExisteGanador = 1;
			printf("\nMensaje: EL JUGADOR GANO ESTE JUEGO\n");
			JuegosJugados = JuegosJugados + 1;
			JuegosGanados = JuegosGanados + 1;
		}

		if ((PuntajeJugador < 21) && (PuntajeComputadora < 21) && (ExisteGanador == 0)) // El juego puede continuar
		{
			//Preguntar si desea pedir carta
			printf("Desea Pedir Carta? Si = 1 / No = 0 : ");
			scanf("%d",&PedirCarta);

			while (PedirCarta == 1)
			{
				// Se reparte una carta al usuario
				IndiceCarta = TomarCarta(Mazo);
				Jugador[CantidadCartasJugador] = IndiceCarta;
				CantidadCartasJugador = CantidadCartasJugador + 1;

				// la computadora si saca una carta mas
				if (PuntajeComputadora < PuntajeJugador)
				{
					IndiceCarta = TomarCarta(Mazo);
					Computadora[CantidadCartasComputadora] = IndiceCarta;
					CantidadCartasComputadora = CantidadCartasComputadora + 1;
					printf("\nEl computador también pidio una carta...\n");
				}


				// Mostrar las cartas del jugador y del computador
				printf("Cantidad de Cartas JUGADOR: %d\n", CantidadCartasJugador);
				ShowCart(Jugador, CantidadCartasJugador);
				PuntajeJugador = SumaCarta(Jugador, CantidadCartasJugador);
				printf("PUNTAJE ACTUAL: %d\n\n", PuntajeJugador);


				printf("Cantidad de Cartas COMPUTADORA: %d\n", CantidadCartasComputadora);
				ShowCart(Computadora, CantidadCartasComputadora);
				PuntajeComputadora = SumaCarta(Computadora, CantidadCartasComputadora);
				printf("PUNTAJE ACTUAL: %d\n\n", PuntajeComputadora);

				// Verificar resultados
				if (PuntajeJugador == 21) // Gano el jugador
				{
					printf("\nMensaje: EL JUGADOR GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosGanados = JuegosGanados + 1;
				}

				if (PuntajeComputadora == 21) // Gano la computadora
				{
					printf("\nMensaje: LA COMPUTADORA GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosPerdidos = JuegosPerdidos + 1;
				}

				if (PuntajeJugador > 21) // Gano el computadora
				{
					printf("\nMensaje: LA COMPUTADORA GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosPerdidos = JuegosPerdidos + 1;
				}

				if (PuntajeComputadora > 21) // Gano el jugador
				{
					printf("\nMensaje: EL JUGADOR GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosGanados = JuegosGanados + 1;
				}


				// Si no existe ganador preguntar al cliente si desea sacar una carta
				if (ExisteGanador == 0)
				{
					//Preguntar si desea pedir carta
					printf("Desea Pedir Carta? Si = 1 / No = 0 : ");
					scanf("%d",&PedirCarta);
				}
				else
				{
					PedirCarta = 0;
				}
			}

			if (ExisteGanador == 0)
			{
				if (((21 - PuntajeJugador) < (21 - PuntajeComputadora)))
				{ // El jugador está más cerca
					printf("\nMensaje: EL JUGADOR GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosGanados = JuegosGanados + 1;
				}
				else
				{ // La computadora está mas cerca
					printf("\nMensaje: LA COMPUTADORA GANO ESTE JUEGO\n");
					ExisteGanador = 1;
					JuegosJugados = JuegosJugados + 1;
					JuegosPerdidos = JuegosPerdidos + 1;
				}
			}

		}

		//Preguntar la continuidad del juego

		printf("\nDesea seguir jugando? Si = 1 / No = 0 : ");
		scanf("%d",&ContinuarJuego);
	}

	// Mostrar Resultados
	printf("\n-----------------------------------------\n");
	printf("   Resultados del juego del BLACKJACK\n");
	printf("-----------------------------------------\n");
	printf("Juegos Jugados: %d\n",JuegosJugados);
	printf("Juegos Ganados: %d\n",JuegosGanados);
	printf("Juegos Perdidos: %d\n",JuegosPerdidos);

	return 0;
}
