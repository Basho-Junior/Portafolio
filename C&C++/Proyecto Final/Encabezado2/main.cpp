/* Por Junior Hernández y Nicol Ureña
2.	Modificar el programa solución del cálculo paralelo del número π (3.3 Calculo de PI) para que los subintervalos de trabajo
sean distribuidos por bloques en lugar de cíclicamente entre los procesos. Por ejemplo, si tuviéramos 3 procesos y n = 11
(número de subintervalos), el proceso 0 debería aproximar las integrales numéricas en los primeros 4 subintervalos
consecutivos (1,2,3,4), el proceso 1 calcularía las integrales en los siguientes 4 subintervalos (5,6,7,8,) y el proceso 2
calcularía los últimos tres (9,10,11).  Se recomienda empezar derivando matemáticamente un método general para repartir por
bloques n subintervalos entre P procesos para cualquier n entero positivo.  Modificarlo también la solución para que la aproximación
a π se obtenga en todos los procesos.
*/

#include <math.h>
#include "mpi.h"   // Biblioteca de MPI
#include <cstdlib> // Incluido para el uso de atoi
#include <iostream>

using namespace std;

int main(int argc, char *argv[])
{
    int n, // Numero de iteraciones
        rank, // Identificador de proceso
        size; // Numero de procesos
    double PI25DT = 3.141592653589793238462643;
    double mypi, // Valor local de PI
           pi,   // Valor global de PI
           h,   // Aproximacion del area para el calculo de PI
           sum;  // Acumulador para la suma del area de PI
    bool valor_por_parametros = true; // Comprueba si hay valores por parametros


    MPI_Init(&argc, &argv); // Inicializamos los procesos
    MPI_Comm_size(MPI_COMM_WORLD, &size); // Obtenemos el numero total de procesos
    MPI_Comm_rank(MPI_COMM_WORLD, &rank); // Obtenemos el valor de nuestro identificador

    // Solo el proceso 0 va a conocer el numero de iteraciones que vamos a
    // ejecutar para la aproximacion de PI
    if (rank == 0)
    {
        cout<<"introduce la precision del calculo (n > 0): ";
        cin>>n;
    }

    // El proceso 0 reparte al resto de procesos el numero de iteraciones
    // que calcularemos para la aproximacion de PI
    MPI_Bcast(&n, // Puntero al dato que vamos a enviar
              1,  // Numero de datos a los que apunta el puntero
              MPI_INT, // Tipo del dato a enviar
              0, // Identificacion del proceso que envia el dato
              MPI_COMM_WORLD);
    if (n <= 0)
    {
        MPI_Finalize();
        exit(0);
    }
    else
    {
        //Modificacion
        // Calculo de PI
        h = 1.0 / (double) n;
        sum = 0.0;
        long temp = (rank) * (n/size); //Con esto se es posible dividir en subintervalos de trabajo.
        for (int i = temp + 1; i <= temp + (n / size); i++)
        {
            double x = h * ((double)i - 0.5);
            sum += (4.0 / (1.0 + x*x));
        }
        mypi = h * sum;

        // Todos los procesos ahora comparten su valor local de PI,
        // lo hacen reduciendo su valor local a un proceso
        // seleccionada a traves de una operacion aritmetica.
        MPI_Reduce(&mypi, // Valor local de PI
                   &pi,  // Dato sobre el que vamos a reducir el resto
                   1,	  // Numero de datos que vamos a reducir
                   MPI_DOUBLE,  // Tipo de dato que vamos a reducir
                   MPI_SUM,  // Operacion que aplicaremos
                   0, // proceso que va a recibir el dato reducido
                   MPI_COMM_WORLD);

        cout << "En el proceso " << rank << " el valor de pi es: " <<mypi<< " con una aproximacion local de " << fabs(mypi - PI25DT)<<endl;
        // Solo el proceso 0 imprime el mensaje, ya que es la unica que
        // conoce el valor de PI aproximado.
        if (rank == 0)
            cout << "El valor aproximado de PI es: " << pi
                 << ", con un error de " << fabs(pi - PI25DT)
                 << endl;
    }

    // Terminamos la ejecucion de los procesos, despues de esto solo existira
    // el proceso 0
    // ¡Ojo! Esto no significa que los demas procesos no ejecuten el resto
    // de codigo despues de "Finalize", es conveniente asegurarnos con una
    // condicion si vamos a ejecutar mas codigo (Por ejemplo, con "if(rank==0)".
    MPI_Finalize();
    return 0;
}
