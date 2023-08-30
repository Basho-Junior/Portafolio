/* Por Junior Hernández y Nicol Ureña
3. Modificar el programa solución del cálculo del producto escalar de dos vectores (4.1 Producto Escalar) para que cada proceso inicialice
por su cuenta su parte correspondiente del vector B de forma local, de tal forma que no haya necesidad de inicializar todo el vector B en el proceso 0
y repartir sus bloques entre los procesos.
*/

#include <vector>
#include <cstdlib>
#include <iostream>
#include "mpi.h"

using namespace std;

int main(int argc, char *argv[])
{
    int tam, rank, size;

    MPI_Init(&argc, &argv);//iniciamos el entorno paralelo
    MPI_Comm_size(MPI_COMM_WORLD, &size);//obtenemos el numero de procesos
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);//obtenemos el identificador

    if (argc < 2)
    {
        if (rank == 0)//el primer proceso imprimira este mensaje
        {
            cout << "Como no se ha especificado un numero de elementos, por defecto sera " << size * 100;
            cout << "\nUso: <ejecutable> <cantidad>" << endl;
        }
        tam = size * 100;
    }
    else
    {
        tam = atoi(argv[1]);
        if (tam < size) tam = size;
        else
        {
            int contador = 1, num = size;
            while (tam > num)
            {
                contador++;
                num = size*contador;
            }
            if (tam != num)
            {
                if (rank == 0)
                    cout << "Se ha cambiado la cantidad a " << num << endl;
                tam = num;
            }
        }
    }

//declarando y rellenando los vectores
    vector<long> VectorA, VectorLocalA, VectorLocalB;//VectorB se elimina
    VectorA.resize(tam, 0);//vectores que inicializan en 0
    VectorLocalA.resize(tam/size, 0);
    VectorLocalB.resize(tam/size, 0);

    if (rank == 0)
    {
        for (long i = 0; i < tam; ++i)  //ciclo por el cual asignamos valores al vector A
        {
            VectorA[i] = i + 1;
        }
    }

    long i = 0;
    long ilocal = (tam/size)*rank;
    long flocal = (tam/size) + ilocal;
    while(ilocal < flocal)  //llenando el vector B de maneraLocal
    {
        VectorLocalB[i] = (ilocal+1) * 10;
        ilocal++;
        i++;
    }

// Uso del MPI_Scatter para repartir los valores en el vactor A
    MPI_Scatter(&VectorA[0], // valor a compartir del vector
                tam / size, // cada procesos recibira esta cantidad
                MPI_LONG, // Como usamos long en los vectores, es el tipo de dato a enviar
                &VectorLocalA[0], // Se reciben los datos en el vectorALocal
                tam / size, // cada procesos recibira esta cantidad
                MPI_LONG,//tipo de dato a enviar
                0, //se reparten datos con el proceso principal
                MPI_COMM_WORLD); // comunicador global

    long mult = 0; //
    for (long i = 0; i < tam / size; i++)
    {
        mult += VectorLocalA[i] * VectorLocalB[i];//multiplicaion entre los vecores
    }
    long resultado;

    MPI_Reduce(&mult, //reunimos los valores en un solo proceso
               &resultado, //aqui estan los datos
               1, // resultado de datos que se van a reunir
               MPI_LONG, // tipo de dato
               MPI_SUM, //en este caso utilizaremos la suma para obtener el total
               0, // Proceso que recibira los datos
               MPI_COMM_WORLD); // Comunicador

    if (rank == 0)
        cout << "El resultado es de " << resultado << endl;

    MPI_Finalize();
    return 0;
}
