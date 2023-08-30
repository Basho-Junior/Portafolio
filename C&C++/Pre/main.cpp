#include <iostream>
#include <cstdlib>
#include <ctime>
#include <mpi.h>

using namespace std;

#define N 4


void print_results(char *prompt, int matriz[N][N]);

int main(int argc, char * argv[])
{
    int rank, size, comprueba = 0, A[N][N], x[N][N], y[N][N], AA[N],yy[N];

    srand(time(0));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            A[i][j] = rand() % 10;
            x[i][j] = rand() % 10;
        }
    }

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    MPI_Scatter(A, N*N/size, MPI_INT, AA, N*N/size, MPI_INT,0,MPI_COMM_WORLD);

    MPI_Bcast(x, N*N, MPI_INT, 0, MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);

    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            comprueba = comprueba + AA[j] * x[j][i];
        }
        yy[i] = comprueba;
        comprueba = 0;
    }

    MPI_Gather(yy, N*N/size, MPI_INT, y, N*N/size, MPI_INT, 0, MPI_COMM_WORLD);

    MPI_Barrier(MPI_COMM_WORLD);
    MPI_Finalize();
    if (rank == 0)
    {
        print_results("Matriz A: ", A);
        print_results("Matriz B: ", x);
        print_results("Matriz C - AxB: ", y);
    }
}

void print_results(char *prompt, int matriz[N][N])
{
    cout << prompt << "\n";
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            cout << matriz[i][j] << "\t";
        }
        cout << "\n";
    }
    cout << "\n";
}
