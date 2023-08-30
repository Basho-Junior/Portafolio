#include <stdio.h>

void main(){

int vector[10];
int i;

for (i=0; i<10; i++){
   printf( "ingrese 10 numeros enteros. Numero %d\n", i+1);
   scanf("%d", &vector[i]);
}

int mayor, menor;
mayor = vector[0]; //Le asignamos el primer elemento del array
menor = vector[0]; //Así empezamos a comparar

for (i=0; i<10; i++){
    if (vector[i]> mayor){
    mayor=vector[i];
    }
    if (vector[i]< menor){
    menor=vector[i];
    }
}
printf("El mayor es %d\n", mayor);
printf("El menor es %d\n", menor);
}
