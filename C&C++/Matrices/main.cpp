#include <iostream>
#include <cstdlib>
#include <ctime>
#include <mpi.h>



using namespace std;



int main(int argc, char * argv[]) {



    int numeroProcesadores,idProceso;
    int **A, *x, *y, *miFila, *comprueba;



    double tInicio, // Tiempo en el que comienza la ejecucion
            tFin; // Tiempo en el que acaba la ejecucion



    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numeroProcesadores);
    MPI_Comm_rank(MPI_COMM_WORLD, &idProceso);



    A = new int *[numeroProcesadores];
    x = new int [numeroProcesadores];




    // Solo el proceso 0 ejecuta el siguiente bloque
    if (idProceso == 0) {
        A[0] = new int [numeroProcesadores * numeroProcesadores];
        for (int i = 1; i < numeroProcesadores; i++) {
            A[i] = A[i - 1] + numeroProcesadores;
        }



        y = new int [numeroProcesadores];



        // Rellenamos 'A' y 'x' con valores aleatorios
        srand(time(0));
        cout << "La matriz y el vector generados son " << endl;
        for ( int i = 0; i < numeroProcesadores; i++) {
            for ( int j = 0; j < numeroProcesadores; j++) {
                if (j == 0) cout << "[";
                A[i][j] = rand() % 10;
                cout << A[i][j];
                if (j == numeroProcesadores - 1) cout << "]";
                else cout << "  ";
            }
            x[i] = rand() % 10;
            cout << "\t  [" << x[i] << "]" << endl;
        }
        cout << "\n";



        comprueba = new int [numeroProcesadores];
        for ( int i = 0; i < numeroProcesadores; i++) {
            comprueba[i] = 0;
            for ( int j = 0; j < numeroProcesadores; j++) {
                comprueba[i] += A[i][j] * x[j];
            }
        }
    }



    // Reservamos espacio para la fila local de cada proceso
    miFila = new int [numeroProcesadores];



    // Repartimos una fila por cada proceso, es posible hacer la reparticion de esta
    MPI_Scatter(A[0],numeroProcesadores,MPI_INT,miFila,numeroProcesadores,MPI_INT,0,MPI_COMM_WORLD);



    // Compartimos el vector entre todas los procesos
    MPI_Bcast(x,numeroProcesadores,MPI_INT,0,MPI_COMM_WORLD);



    MPI_Barrier(MPI_COMM_WORLD);
    // Inicio de medicion de tiempo
    tInicio = MPI_Wtime();



    long subFinal = 0;
    for ( int i = 0; i < numeroProcesadores; i++) {
        subFinal += miFila[i] * x[i];
    }



    MPI_Barrier(MPI_COMM_WORLD);
    // fin de medicion de tiempo
    tFin = MPI_Wtime();




    MPI_Gather(&subFinal, 1, MPI_INT, y, 1, MPI_INT, 0, MPI_COMM_WORLD);



    MPI_Finalize();



    if (idProceso == 0) {



        int errores = 0;



        cout << "El resultado obtenido y el esperado son:" << endl;
        for (int i = 0; i < numeroProcesadores; i++) {
            cout << "\t" << y[i] << "\t|\t" << comprueba[i] << endl;
            if (comprueba[i] != y[i])
                errores++;
        }



        delete [] y;
        delete [] comprueba;
        delete [] A[0];



        if (errores) {
            cout << "Hubo " << errores << " errores." << endl;
        } else {
            cout << "No hubo errores" << endl;
            cout << "El tiempo tardado ha sido " << tFin - tInicio << " segundos." << endl;
        }



    }



    delete [] x;
    delete [] A;
    delete [] miFila;



}
