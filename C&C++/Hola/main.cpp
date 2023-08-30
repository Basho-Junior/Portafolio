#include "mpi.h"
#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    MPI_Status estado;
    int rank, size,contador;
    //cout<<"Hola Mundo soy proceso unico"<<endl;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD,&rank);
    if(rank == 0)
    {
       cout<<"Ingrese un numero: ";
       cin>>contador;
       contador = contador*contador;
       MPI_Send(&contador, 1, MPI_INT,rank+1, 0, MPI_COMM_WORLD);
    } else {
       MPI_Recv(&contador,1,MPI_INT, rank-1,0,MPI_COMM_WORLD, &estado);
       /*cout<<"Soy el proceso "<<rank<<" y he recibido "<<contador<<endl;*/
       contador = contador*contador;
       if(rank != size-1){
         MPI_Send(&contador,1,MPI_INT,rank+1,0,MPI_COMM_WORLD);
       } else{
            cout<<"Soy el proceso "<<rank<<" y el ultimo numero: "<<contador<<endl;
       }
    }

    MPI_Finalize();


    return 0;
}
