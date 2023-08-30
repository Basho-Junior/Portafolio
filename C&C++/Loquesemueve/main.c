/*
	Twitter @albertobsd
 */
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
	Maso basico de Cartas para su salida en pantalla.
	el 0 vale representa a la carta 10
 */
typedef struct jugador_struct	{
	int continuar;
	int valor;
	int offset;
	char mano[6];
}jugador;

char *mazo = "A234567890JQK";

char *crear_baraja(int n);
char *barajar(char *baraja);
int juego(char *bajara,int *offset,int m);
void evaluar_jugador(jugador *j);
int evaluar_carta(char c);
void debug(char *p,int l);

int main()	{
	char *baraja;
	int offset = 0;
	printf("Juego de BlackJack\n");
	printf("Creando bajara...\n");
	baraja = crear_baraja(2);
	printf("Baraja:\n%s\n",baraja);
	printf("Revolver bajara...\n");
	baraja = barajar(baraja);
	printf("Baraja:\n%s\n",baraja);
	juego(baraja,&offset,6); // La casa juega contra 6 Jugadores Solo una ronda, si queremos mas rondas tendremos que agregarlo en un ciclo y controlar el numero de cartas restantes en la baraja
	free(baraja);
}

char *crear_baraja(int n)	{
	int i = 0,j;
	int offset = 0;
	char *cartas;
	cartas = calloc(sizeof(char)*52+1,n);
	while(i < n)	{
		j = 0;
		while(j < 4)	{
			memcpy(cartas+offset,mazo,13);
			offset+=13;
			j++;
		}
		i++;
	}
	cartas[offset] = '\0'; //Esta instruccion es incesaria debido a la funcion calloc
	return cartas;
}

char *barajar(char *baraja)	{
	int len = strlen(baraja);
	char *temp = calloc(len+1,1);
	int r;
	int i = 0;
	/*
		Poner su propia funcion random disponible en su sistema
		En freeBSD prefiero usar arc4random_uniform
	 */
	while(i < len)	{
		r = arc4random_uniform(len);
		if(baraja[r] != 0)	{
			temp[i] = baraja[r];
			baraja[r] = 0;
			i++;
		}
	}
	free(baraja);
	return temp;
}

int juego(char *bajara,int *offset,int m)	{
	int len = strlen(bajara);
	int i = offset[0],j = 0,k = 0, n = m+1;
	jugador **jugadores;
	jugadores = calloc(sizeof(jugador*),n);
	//memset(jugadores,0,sizeof(jugador)*2);
	/* Generamos n jugadores (m jugadores elegidos por el usuario + la casa jugador 0) */
	/* Repartimos Cartas a todos los jugadores*/
	while(k < n)	{
		jugadores[k] = calloc(sizeof(jugador),1);
		printf("Memoria asignada para el jugador %i @ 0x%X [%i bytes]\n",k,jugadores[k],sizeof(jugador));
		k++;
	}
	while( j < 2 )	{
		k = 0;
		while(k < n)	{
			jugadores[k]->mano[j] = bajara[i];
			jugadores[k]->offset++;
			i++;
			k++;
		}
		j++;
	}
	/*	Funcion de depuracion
	debug(jugadores[0],16);
	debug(jugadores[1],16);
	*/
	/*
		Aqui se ve la mano de cada jugador en el proximo printf dentro del ciclo solo es para fines didacticos
		posteriormente solo se evaluan las manos;
	*/
	j = 0;
	while( j < n )	{
		printf("Jugador: %i\ncartas %s\n",j,jugadores[j]->mano);
		evaluar_jugador(jugadores[j]);
		printf("Valor actual: %i\n",jugadores[j]->valor);
		j++;
	}
	/*
		Despues de repartir las cartas los jugadores juegan y la casa se destapa al final
	*/
	j = 1;
	while( j < n )	{
		while(jugadores[j]->continuar)	{
			jugadores[j]->mano[jugadores[j]->offset] = bajara[i];
			//printf("Jugador: %i\ncartas %s\n",j,jugadores[j]->mano);
			jugadores[j]->offset++;
			evaluar_jugador(jugadores[j]);
			i++;
		}
		j++;
	}
	/*
		Ahora juega la casa.
	*/
	while(jugadores[0]->continuar)	{
		jugadores[0]->mano[jugadores[0]->offset] = bajara[i];
		jugadores[0]->offset++;
		evaluar_jugador(jugadores[0]);
		i++;
	}
	/* Mostramos a todos los resultados*/
	j = 1;
	while( j < n )	{
		printf("Jugador: %i\ncartas %s\n",j,jugadores[j]->mano);
		printf("Valor actual: %i\n",jugadores[j]->valor);
		if(jugadores[j]->valor > 21)	{
			printf("Perdio\n");
		}
		else	{
			if(jugadores[j]->valor == 21)	{
				printf("Gano BlackJack\n");
			}
			else	{
				if(jugadores[0]->valor > 21)	{
					printf("Gano\n");
				}
				else	{
					if(jugadores[j]->valor > jugadores[0]->valor)	{
						printf("Gano\n");
					}
					else	{
						printf("Perdio\n");
					}
				}
			}
		}
		j++;
	}

	/*
		Liberamos memoria de los jugadores
	*/
	while( j < n )	{
		free(jugadores[j]);
		j++;
	}
	/*
		Retornamos el valor actaul del offset mediante la direccion de memoria del argumento.
		y Retornamos el jugador ganador;
	*/
	offset[0] = i;
	return 1;
}

void evaluar_jugador(jugador *j)	{
	int i = 0;
	char v;
	j->valor = 0;
	while(j->mano[i] != 0)	{
		v = evaluar_carta(j->mano[i]);
		if(v == 1)	{
			if((j->valor + 11) <= 21 )	{
				j->valor += 11;
			}
			else	{
				j->valor += v;
			}
		}
		else	{
			j->valor += v;
		}
		if(j->valor <= 16)	{
			j->continuar = 1;
		}
		else	{
			j->continuar = 0;
		}
		i++;
	}
}

int evaluar_carta(char c)	{
	int r = 0;
	switch(c)	{
		case 'A':
			r = 1;
		break;
		case 'K':
		case 'Q':
		case 'J':
		case '0':
			r = 10;
		break;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			r = c - '0';
		break;
	}
	return r;
}

void debug(char *p,int l)	{
	int i = 0;
	printf("0x%x\n",p);
	while(i < l)	{
		printf("%.2x",p[i]);
		i++;
	}
	printf("\n");
}
