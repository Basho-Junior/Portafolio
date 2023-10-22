#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define TAM 1000


void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
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

void merge(int arr[], int p, int q, int r, int *cont) {

    int n1 = q - p + 1;
    int n2 = r - q;

    int *L = (int *) malloc(n1*sizeof(int));
    int *M = (int *) malloc(n2*sizeof(int));


    for (int i = 0; i < n1; i++){
        L[i] = arr[p + i];
    }
    for (int j = 0; j < n2; j++){
        M[j] = arr[q + 1 + j];
    }

    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    while (i < n1 && j < n2) {
        if (L[i] <= M[j]) {
            arr[k] = L[i];
            i++;
            cont[1]++;
        } else {
            arr[k] = M[j];
            j++;
            cont[1]++;
        }
        k++;
        cont[0]++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = M[j];
        j++;
        k++;
    }

}

void mergeSort(int arr[], int l, int r, int *cont) {
    if (l < r) {

        int m = l + (r - l) / 2;

        mergeSort(arr, l, m,cont);
        mergeSort(arr, m + 1, r,cont);

        merge(arr, l, m, r,cont);
    }
}

int partition (int arr[], int low, int high, int *cont)
{
    int pivot = arr[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++)
    {
        cont[0]++;
        if (arr[j] < pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
            cont[1]++;
        }
    }
    swap(&arr[i + 1], &arr[high]);
    cont[1]++;
    return (i + 1);
}

int partition_r_(int *arr, int low, int high,int *cont)
{
    srand(time(NULL));
    int random[3],media;
    for(int i = 0;i < 3;i++)
    {
        random[i] = low + rand() % (high - low);
    }

    media = (random[0] + random[1] +random[2]) / 3;
    swap(&arr[media], &arr[high]);
    cont[1] = cont[1]+1;
    return partition(arr, low, high, cont);
}

int partition_r(int *arr, int low, int high, int *cont)
{
    srand(time(NULL));
    int random = low + rand() % (high - low);
    swap(&arr[random], &arr[high]);
    cont[1] = cont[1]+1;
    return partition(arr, low, high,cont);
}


void quickSort(int *arr, int low, int high,int *cont)
{
    if (low < high) {

        int pi = partition_r(arr, low, high,cont);
        quickSort(arr, low, pi - 1,cont);
        quickSort(arr, pi + 1, high,cont);
    }
}

void Quicksort(int *arr, int low, int high, int *cont)
{
    if (low < high) {

        int pi = partition_r_(arr, low, high,cont);

        Quicksort(arr, low, pi - 1,cont);
        Quicksort(arr, pi + 1, high,cont);
    }
}

void QuickSort(int arr[], int low, int high,int *cont)
{
    if (low < high)
    {
        int pi = partition(arr, low, high,cont);

        QuickSort(arr, low, pi - 1,cont);
        QuickSort(arr, pi + 1, high,cont);
    }
}

int getMax(int array[], int n) {
    int max = array[0];
    for (int i = 1; i < n; i++)
        if (array[i] > max)
            max = array[i];
    return max;
}

void countingSort(int array[], int size, int place, int *cont) {
    int *output;
    output = (int *) malloc((size+1)*sizeof(int));
    int count[10] = { 0 };

    int max = (array[0] / place) % 10;

    for (int i = 1; i < size; i++) {
        cont[0]++;
        if (((array[i] / place) % 10) > max) {
            max = array[i];
            cont[1]++;
        }
    }

    count[max + 1];

    //for (int i = 0; i < max; ++i)
      //  count[i] = 0;

    for (int i = 0; i < size; i++)
        count[(array[i] / place) % 10]++;

    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];

    for (int i = size - 1; i >= 0; i--) {
        output[count[(array[i] / place) % 10] - 1] = array[i];
        cont[1]++;
        count[(array[i] / place) % 10]--;
    }

    for (int i = 0; i < size; i++){
        array[i] = output[i];
        cont[1]++;
    }

}


void radixsort(int array[], int size, int * cont) {
    int max = getMax(array, size);

    for (int place = 1; max / place > 0; place *= 10)
        countingSort(array, size, place, cont);
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
    vector = (int *) malloc(n*sizeof(int));
    while (cant < 9)
    {
        int i;
        int * cont;
        cont = (int *) malloc(2*sizeof(int)), cont[0] = 0,cont[1]=0;
        int try = 0;
        printf("No.Elementos: %d \n", n);
        for (i = 0; i < n; i++)/*for(i = n, baja = 0; i > 0; i--)*/{
            vector[i] = i + 1;
            //vector[baja] = i - 1;
            //baja++;
        }
        permutation(vector,n);
        //Printa("Arreglo antes",vector,n);

            clock_t start = clock();

            switch (function)
            {
                case 1:
                    mergeSort(vector, 0, n-1, cont);
                    //Printa("Merge despues",vector,n);
                    break;
                case 2:
                    QuickSort(vector, 0, n,cont);
                    //quickSort(vector, 0, n-1,cont);
                    //Quicksort(vector, 0, n-1,cont);
                    //Printa("Quick despues",vector,n);
                    break;
                case 3:
                    radixsort(vector, n-1,cont);
                    //Printa("Radix despues",vector,n-1);
                    break;
                default:
                    printf("");
            }
            clock_t stop = clock();
            double elapsed = (double) (stop - start) / CLOCKS_PER_SEC;
            printf("Tiempo s: %.10f \n", elapsed);

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
        printf("Numero de Intercambios: %d \n", cont[1]);
        printf("Numero de Comparaciones: %d \n", cont[0]);
        cant ++;
    }
}

int main()
{
    printf("MergeSort \n");
    Print(1);
    //printf("\n\n");
    //printf("Quicksort \n");
    //Print(2);
    //printf("\n\n");
    //printf("Radixsort \n");
    //Print(3);

}
