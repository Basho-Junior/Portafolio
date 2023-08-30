#include <ctime>
#include <mpi.h>
#include <iostream>
#include <cstdlib>




using namespace std;





int main(int argc, char * argv[])
{





    int p=2,rank, size;
    int rev, A[p][p], B[p][p], AB[p][p], ma[p],mb[p];
    double tiempoFinal,tiempoInicial;





    srand(time(0));





    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);





//llenando matrices
    for (int i = 0; i < p; i++)
    {





        for (int j = 0; j < p; j++)
        {
            A[i][j] = rand() % 10;
            B[i][j] = rand() % 10;
        }
    }






    tiempoInicial = MPI_Wtime();





    MPI_Scatter(A, p*p/size, MPI_INT, ma, p*p/size, MPI_INT,0,MPI_COMM_WORLD);





    MPI_Bcast(B, p*p, MPI_INT, 0, MPI_COMM_WORLD);





    MPI_Barrier(MPI_COMM_WORLD);





    rev = 0;





    for (int i = 0; i < p; i++)
    {
        for (int j = 0; j < p; j++)
        {
            rev = rev + ma[j] * B[j][i];
        }
        mb[i] = rev;
        rev = 0;
    }





    MPI_Gather(mb, p*p/size, MPI_INT, AB, p*p/size, MPI_INT, 0, MPI_COMM_WORLD);





    MPI_Barrier(MPI_COMM_WORLD);





    tiempoFinal = MPI_Wtime();
    double tiempoTotal = (tiempoFinal - tiempoInicial);






    if (rank == 0)
    {



//imprimiendo matriz 1
        cout << "Primera Matriz" << "\n";



        for (int i = 0; i < p; i++)
        {
            cout<<endl<<"[";
            for (int j = 0; j < p; j++)
            {
                cout << A[i][j] << " ";
            }
            cout<<"]"<<endl;
            cout << "\n";



        }





//imprimiendo matriz 2
        cout << "Segunda Matriz" << "\n";



        for (int i = 0; i < p; i++)
        {
            cout<<endl<<"[";
            for (int j = 0; j < p; j++)
            {
                cout << B[i][j] << " ";
            }
            cout<<"]"<<endl;
            cout << "\n";



        }



        cout << "\n";






//imprimiendo resultado
        cout << "Resultado" << "\n";



        for (int i = 0; i < p; i++)
        {
            cout<<endl<<"[";
            for (int j = 0; j < p; j++)
            {
                cout << AB[i][j] << " ";
            }
            cout<<"]"<<endl;
            cout << "\n";



        }
        cout << "\n";



        cout << "El tiempo de duracion ha sido: " << tiempoTotal << " segundos" << endl;




    }



    MPI_Finalize();




}
