#include "stdio.h"
#include "stdlib.h"
#include <math.h>

int esPrimo(int);
void sepdig(int);

int main()
{
    int inicio, fin, contador = 0, cant;
    char str[100], cad[100];
    printf("Inicio: \n");
    scanf("%d", &inicio);
    printf("Fin: \n");
    scanf("%d", &fin);
    cant = fin;
    for (int x = inicio; x <= fin; x++)
    {
        if (esPrimo(x))
        {
            sprintf(str, "%d", x);
            if (contador < cant)
            {
                printf("%s,", str);
            }
            else
            {
                printf(" y %s", str);
            }
            contador ++;
        }
        cant --;
    }
}

int esPrimo(int numero)
{
    if (numero == 0 || numero == 1)
        return 0;
    if (numero == 4)
        return 0;
    for (int x = 2; x < numero / 2; x++)
    {
        if (numero % x == 0)
            return 0;
    }
    return 1;
}

void tostring(char str[], int num)
{
    int i, rem, len = 0, n;

    n = num;
    while (n != 0)
    {
        len++;
        n /= 10;
    }
    for (i = 0; i < len; i++)
    {
        rem = num % 10;
        num = num / 10;
        str[len - (i + 1)] = rem + '0';
    }
    str[len] = '\0';
}

