//Practica 4: Rango de primos por Junior Hernandez 20180999 y Raineris Adames 20181497
#include <stdio.h>
#include <stdlib.h>
#include <conio.c>
int esprimo(int);
//double promedio(int, int);
int main()
{
    int num1, num2, primo, cantprimo=0, val, cont, sumatotal=0;
    double promedio;
    char deci;
do{

   do{ //Se ingresa el valor del rango ingresiado por el usuario cumpliendo con la condicion de no ser negativo o igual a 0 por medio de un bucle
      printf("Ingrese l%cmite inferior: ", 161);
      scanf("%d",&num1);

      if ( num1 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         system("pause");
      }

   }while ( num1 <= 0 );

   do{
      system("cls");
      printf("Ingrese l%cmite superior: ", 161);
      scanf("%d",&num2);
      if ( num2 <= 0 )
      {
         printf("El valor debe ser mayor que cero.\n");
         getch();
      }
      if ( num2 <= num1 )
      {
         printf("El valor debe ser mayor que que el l%cmite inferior.\n", 161);
         getch();
      }

   }while ( num2 <= 0 || num1 >= num2); //  es para restrigir que el rango superior ingresado no sea menor al valor inferior
   printf("Rango [%d, %d]\n", num1,num2);
    for(val = 2, cont=0; cont < num2; val++){ // este bucle se uiliza para imprimir los numeros primos del rango ingresado y su posicion correspondiente
    if (esprimo(val)){
    cont++;
    }
    if(num1 == cont){
      printf("%3d - %3d \n", cont,val);
      num1++;
      sumatotal+=val; // sumatoria total de los numeros primos de rango
      cantprimo++; // cantidad de numeros primos que existen en el rango
    }
    }
    promedio = sumatotal/cantprimo;
    printf("Cantidad de n%cmeros primos es: %d \n", 163, cantprimo);
    printf("La sumator%ca total de los n%cmeros primos es: %d \n",161, 163, sumatotal);
    printf("El promedio total de los n%cmeros primos es: %.2f \n",163, promedio);
    printf("Presione C si desea continuar. De lo contrario presione cualquier tecla \n");
    scanf(" %c",&deci); // dont forget type &
    system("cls");
    // se iniciariloza en 0 las variables para elimnar los resutados anteriores
    cantprimo = 0;
    sumatotal = 0;
}
while(deci == 'c' || deci == 'C');

return 0;
}
/* Función: esprimo
   Argumento: (int)numero. Número para determinar si es primo
   Objetivo: Determinar si el numero es primo o no
   Retorno: 1 si el numero es primo y 0 si el numero no es primo
*/
int esprimo(int numero)
{
int fact, topefact = (int)sqrt(numero);
    for (fact = 2; fact <= topefact; fact ++)
        if(numero % fact == 0){
        return 0;
        }
    //si el numero no tiene factores en el rango [2, topefact].
    return 1;
}


