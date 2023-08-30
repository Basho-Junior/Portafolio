/* Por Junior Hernández y Nicol Ureña
1.	Modificar el programa solución del ejercicio 3.2 Send Receive del tutorial para que el proceso 0 difunda su identificador de
proceso (0) al resto de procesos con identificadores pares, siguiendo un anillo de procesos pares, y el proceso 1 haga lo mismo
con los procesos impares. Se deben tener en cuenta soluciones con cualquier número de procesos.
*/

#include "mpi.h"
#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    int rank, size, contador, parImpar;
    MPI_Status estado;

    MPI_Init(&argc, &argv);//iniciamos el entorno MPI
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);//obtenemos el identificador del proceso
    MPI_Comm_size(MPI_COMM_WORLD, &size);//obtenemos el numero de procesos


    if(rank == 0)
    {

        MPI_Send(&rank //referencia al vector de elementos a enviar
                 ,1 // tamaño del vector a enviar
                 ,MPI_INT // Tipo de dato que envias
                 ,rank+1 // pid del proceso destino
                 ,0 //etiqueta
                 ,MPI_COMM_WORLD); //Comunicador por el que se manda

    }
    else
    {

        MPI_Recv(&contador // Referencia al vector donde se almacenara lo recibido
                 ,1 // tamaño del vector a recibir
                 ,MPI_INT // Tipo de dato que recibe
                 ,rank-1 // pid del proceso origen de la que se recibe
                 ,0 // etiqueta
                 ,MPI_COMM_WORLD // Comunicador por el que se recibe
                 ,&estado); // estructura informativa del estado

        parImpar=rank%2;//Se guarda el resultado de la división entera entre dos operandos numéricos enteros, devolviendo el resto de la misma

        if(parImpar == 0)//En el caso de que el resto de la misma sea igual a 0, se presenta en pantalla los pares junto al resto guardado, osea 0
        {
            cout<<"Soy el proceso "<<rank<<" y he recibido "<<parImpar<<" de los pares" <<endl;//Mensaje a presentar
        }
        else //En caso contrario se presenta en pantalla los impares junto al resto guardado, o sea 1
        {
            cout<<"Soy el proceso "<<rank<<" y he recibido "<<parImpar<<" de los impares" <<endl;//Mensaje a presentar
        }
        contador++;
        if(rank != size-1)
            MPI_Send(&contador //referencia al vector de elementos a enviar
                     , 1 // tamaño del vector a enviar
                     ,MPI_INT // Tipo de dato que envias
                     ,rank+1
                     , 0 //etiqueta
                     ,MPI_COMM_WORLD);//Comunicador por el que se manda


    }

    // Terminamos la ejecucion de las hebras, despues de esto solo existira
    // la hebra 0
    // ¡Ojo! Esto no significa que las demas hebras no ejecuten el resto
    // de codigo despues de "Finalize", es conveniente asegurarnos con una
    // condicion si vamos a ejecutar mas codigo (Por ejemplo, con "if(rank==0)".

    MPI_Finalize();

    return 0;
}
