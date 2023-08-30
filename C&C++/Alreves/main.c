#include <stdio.h>
#include <math.h>


int main(void)
{
     int f,c,aux=0;
     int matriz[100][100];

     //lleno la matriz
     cout<<"\nIntroducir Tamaño De La Fila:    ";
     cin>>f;
     cout<<"\nIntroducir Tamaño De La Columna: ";
     cin>>c;
     cout<<endl;

    for(int i=0; i<f; i++)
    {
        for(int j=0; j<c; j++)
        {
             cout<<"Introducir Datos: ";
             cin>>matriz[i][j];
        }
    }

    //imprimo la matriz como se llena
    cout<<"\nLos Datos De La Matriz Fueron Introducidos Asi:"<<endl;
    for(int i=0; i<f; i++)
    {
        for(int j=0; j<c; j++)
        {
            cout<<matriz[i][j]<<" ";
        }
        cout<<endl;
    }

     //ordeno la matriz de menor a mayor
     for(int i=0; i<f; i++)
     {
        for(int j=0; j<c; j++)
        {
            for(int x=0; x<f;x++)
            {
                for(int y=0; y<c; y++)
                {
                    if(matriz[i][j]<matriz[x][y])
                    {
                        aux=matriz[i][j];
                        matriz[i][j]=matriz[x][y];
                        matriz[x][y]=aux;
                    }

                }
            }
         }
    }

    //imprimo la matriz ordenada de menor a mayor (pero me invierte las dimensiones)
    cout<<"\nLos Datos De La Matriz Fueron Ordenados de Menor a Mayor:"<<endl;
    for(int i=0; i<c; i++)
    {
        for(int j=0; j<f; j++)
        {
            cout<<matriz[j][i]<<" ";
        }
        cout<<endl;
    }

    cout<<endl;
    system("pause");

}
