#include <stdio.h>
#include <stdlib.h>
int divi(int);
int main()
{
 int  num, numeros;
  do{
    printf("Ingrese numero: \n",163);
    scanf("%d",&num);
    if (num > 0){
    numeros=divi(num);
    }if(num < 0){
      printf("El valor debe ser mayor que cero.\n");
      }
   }while ( num != 0 );
}
// Funcion para sacar los factores del numero
int divi(int num){//Aqui ingresames el numero
  int cont = 0;
  printf("%d = ", num);
  for(int i=2;num>1;i++){//Bucle que indica que como el factorizacion inicia en 2 entonces si el numero es mayour que uno:
    cont=0;
    while(num%i==0){//Y ademas su modulo con i que es el contador sea igual a 0
        num /= i;//lo divido uno por uno por ejemplo 60 lo divide entre 2 y asi susesivamente
        cont ++;
    }
        if (cont == 1){
            printf("%d ", i);
        }if (cont > 1){
            printf("%d ^ %d  ", i, cont);
        }

  }
    printf("\n");
}
