#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TAM 1000

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}

void permutation(int array[], long size)
{
    srand(time(NULL));
    int i, j;
    for (i = size - 1; i > 0; i--)
    {
        j = rand() % (i + 1);
        swap( &array[i], &array[j]);
    }
}

double promedioDeArreglo(const double arreglo[], int cantidadDeElementos)
{
    double suma = 0;
    for (int x = 0; x < cantidadDeElementos; x++)
    {
        suma = suma + arreglo[x];
    }
    return suma / cantidadDeElementos;
}

void SelectionSort(int *array, int n, double *arreglo, double *arreglo2)
{
    int i, j, position;
    double inter = 0, comp = 0, key;
    for(i = 0; i < (n - 1); i++)
    {
        position=i;
        for(j = i + 1; j < n; j++)
        {
            if(array[position]>array[j]){
                position=j;
                comp ++;
            }
        }
        if(position != i)
        {
            /*key=array[i];
            array[i]=array[position];
            array[position]=key;*/
            swap(&array[i], &array[position]);
            inter ++;
        }
    }
    *arreglo = inter;
    *arreglo2 = comp;
}

void IDirecta(int *array, int n, double *arreglo, double *arreglo2)
{
    int i, key, j;
    double inter = 0, comp = 0;
    for (i = 1; i < n; i++)
    {
        key = array[i];
        j = i - 1;

        while (j >= 0 && array[j] > key)
        {
            array[j + 1] = array[j];
            j = j - 1;
            comp ++;
            inter ++;
        }
        array[j + 1] = key;
        comp ++;
    }
    *arreglo = inter;
    *arreglo2 = comp;
}

void Bubblesort(int arreglo[], int tamano,double *arreglo1, double *arreglo2)
{
    long int i,j,flag = 0;
    double inter = 0, comp = 0;

    for(i = 0;i < tamano;i++)
    {
        for(j = 0;j < (tamano-i-1);j++)
        {
            if(arreglo[j] > arreglo[j+1])
            {
                swap(&arreglo[j],&arreglo[j+1]);
                comp++;
                inter++;
                flag = 1;
            }
            comp++;
        }

        if(flag ==0)
        {
            break;
        }
    }
    *arreglo1 = inter;
    *arreglo2 = comp;
}

void Printa(char *function,int *array, int n) {
    int x;
    printf("%s:",function);
    for(x = 0; x < n; x++) {
        printf(" %i",array[x]);
    }
    printf("\n");
}

void Print(int function)
{
    int cant = 1;
    int n = 1000;
    int *vector, baja = 0;
    vector = (int *) malloc(TAM*sizeof(int));
    while (cant < 9)
    {
        int i;
        double arreglo[5] = {0};
        double intercambios[5];
        double comparaciones[5];
        int try = 0;
        printf("No.Elementos: %d \n", n);
        for (i = 0; i < n; i++)/*for(i = n, baja = 0; i > 0; i--)*/ {
            vector[i] = i + 1;
            /*vector[baja] = i - 1;
            baja++;*/
        }
        permutation(vector,n);

        while (try < 5)
        {

            clock_t start = clock();

            switch (function)
            {
                case 1:
                    SelectionSort(vector, n, &intercambios[try],&comparaciones[try]);
                    break;
                case 2:
                    IDirecta(vector, n, &intercambios[try],&comparaciones[try]);
                    break;
                case 3:
                    Bubblesort(vector, n, &intercambios[try],&comparaciones[try]);
                    break;
                default:
                    printf("");
            }
            clock_t stop = clock();
            double elapsed = (double) (stop - start) / CLOCKS_PER_SEC;
            //printf("Time elapsed in s: %f \n", elapsed);
            arreglo[try] = elapsed;
            try ++;
        }

        if (cant == 1)
        {
            n = 5000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 5));
        }
        if (cant == 2)
        {
            n = 10000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 10));
        }
        if (cant == 3)
        {
            n = 25000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 25));
        }
        if (cant == 4)
        {
            n = 50000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 50));
        }
        if (cant == 5)
        {
            n = 100000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 100));
        }
        if (cant == 6)
        {
            n = 500000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * 500));
        }
        if (cant == 7)
        {
            n = 1000000;
            vector = (int *) realloc(vector, sizeof(int) * (TAM * TAM));
        }
        printf("Tiempo Promedio: %f \n", promedioDeArreglo(arreglo,try));
        printf("Numero de Intercambios: %f \n", promedioDeArreglo(intercambios,try));
        printf("Numero de Comparaciones: %f \n", promedioDeArreglo(comparaciones,try));
        cant ++;

    }
}

int main()
{
    printf("Selection Sort \n");
    Print(1);
    //printf("\n\n");
    //printf("Insertion Sort \n");
    //Print(2);
    //printf("\n\n");
    //printf("Bubble Sort \n");
    //Print(3);

}

