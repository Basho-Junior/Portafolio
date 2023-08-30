//Conecta 4: Por Junior Hernandez 2018-0999
#include <stdio.h>
#include <stdlib.h>
#include <conio.c>
#include <time.h>


#define MAXFIL 7
#define MAXCOL 7
#define ESP    3
#define ENLACE "C:\\Users\\Junior\\Downloads\\Usuarios.txt"


#define ESC   27
#define ENTER 13

#define DERECHA   77
#define IZQUIERDA 75

#define CT     BLUE
#define CF     LIGHTGRAY

#define CTS    LIGHTGRAY
#define CFS    BLUE

#define CTM    RED
#define CFM    YELLOW

#define CANTUSER 20;


void genmat(char [][MAXCOL],int,int);
void putmatxy(char [][MAXCOL],int,int,int,int,int,int);
void movimiento(char [][MAXCOL],int,int,int,int, char[]);
void pass (int);

void setcolor(int,int);
void colordefault();
int randrango(int,int);


typedef struct
{
    char nombre [50];
    char password [50];
    double record;
} USUARIO;


void agregar(char[], char[]);
void getuser(USUARIO *);
void log(char [],char []);
void juego(char[]);
void agregarrecord(char[], double);

int main()
{
    int ind = 0, resp;
    int total = CANTUSER;
    char nom[50], contra[50];
    USUARIO *user;

    srand(time(NULL));

    user = (USUARIO *) malloc(total * sizeof(USUARIO));

    //BUCLE PARA QUE REPITA EL JUEGO E INICIE DESDE CERO SI ASI LO QUIERE EL USUARIO

    //do
    //{
    printf("\n\n\t       BIENVENIDO AL CONECTA 4 \n");
    printf("\t          Que desea hacer?: \n");
    printf("\n\n\t          1 = NUEVO JUEGO \n");
    printf("\t          2 = CONTINUAR \n");
    printf("\t          3 = RECORDS \n");
    printf("\t       %c ", 62);
    scanf("%d", &resp);
    system ("cls");
    if(resp == 1)
    {
        printf("\n\n\t       BIENVENIDO AL CONECTA 4 \n");
        getuser(user+ind);
        agregar(user[ind].nombre, user[ind].password);
    }
    else if (resp == 2)
    {
        printf("\n\n\t       BIENVENIDO AL CONECTA 4 \n");
        printf("Usuario          ");
        printf("\t %c ", 62);
        fflush(stdin);
        gets(nom);
        printf("Contraseña        ");
        printf("\t %c ", 62);
        fflush(stdin);
        gets(contra);
        log(nom, contra);

    }
    else if (resp == 3)
    {
        rec();
    }
}


/* Función: randrango.
   Argumento: (int)numero a (int)numero b. Números para para generar numeros de forma random entre estos dos numeros.
   Objetivo: Generar numeros de forma random dentro de un rango.
   Retorno: Numero random entre (int a) e (int b).
*/

void juego (char u[50])
{
    char veces;
    int ind = 0;
    char mat[MAXFIL][MAXCOL];
    do
    {
        printf("\n\n\t       CONECTA 4: \n");
        printf(" Jugador: %s (Amarrillo) Maquina: (Rojo) \n",u);
        genmat(mat,MAXFIL,MAXCOL);
        movimiento(mat,MAXFIL,MAXCOL,10,5, u);

        printf("\n\n\n\n\t Desea volver a jugar S/N?\n");
        printf("\t %c", 62);
        scanf("%s", &veces);
        system("cls");
    }
    while (veces == 'S' || veces == 's');
    return 0;
}


int randrango(int a,int b)
{
    return rand() % (b-a+1) + a;
}

/* Función: genmat.
   Argumento: (int)matriz[][], (int)fila y (int)columna.
   Objetivo: Generar una matriz.
*/

void genmat(char mat[][MAXCOL],int fila,int column)
{
    int indfil, indcol;

    for ( indfil = 0; indfil < fila; indfil ++ )
        for ( indcol = 0; indcol < column; indcol ++ )
            mat[indfil][indcol] = ' ';
}

/* Función: putmatxy.
   Argumento: (int)matriz[][], (int)fila, (int)columna, (int)px, (int)py, (int)fs y (int)cs.
   Objetivo: Establecer los colores de la matriz.
*/

void putmatxy(char mat[][MAXCOL],int fila,int column,int px, int py,int fs, int cs)
{
    int indfil, indcol;

    for ( indfil = 0; indfil < fila; indfil ++ )
    {
        for ( indcol = 0; indcol < column; indcol ++ )
        {
            setcolor(CT,CF);
            if ( indfil == fs && indcol == cs )
                setcolor(CTS,CFS);
            if (mat[indfil][indcol]=='O')
            {
                setcolor(CTM,CFM);
            }
            if (mat[indfil][indcol]=='X')
            {
                setcolor(CFM,CTM);
            }
            gotoxy(px+indcol*ESP,py+indfil);
            printf(" %c ",mat[indfil][indcol]);
        }
    }
    colordefault();
}

/* Función: movimiento.
   Argumento: (int)matriz[][], (int)fila, (int)columna, (int)px y (int)py,.
   Objetivo: Realizar los movimientos y condiciones para el juego.
*/

void movimiento(char mat[][MAXCOL],int fila,int column,int px, int py, char u[50])
{
    int filasel = 0, columnasel = 0, fichas = 0, win = 0, lose = 0, i, j, p, c, col;
    char tecla;
    char jug = 'O', comp = 'X';
    double seconds = 0;
    double minutes = 0;
    double hours = 0;
    clock_t t;
    t = clock();
    _setcursortype(0);
    do
    {
        putmatxy(mat,MAXFIL,MAXCOL,10,5,filasel,columnasel);
        tecla = getch();
        //BUCLE PARA VALIDAR LAS FORMAS DE GANAR DEL JUGADOR Y LA MAQUINA
        for(i=0; i<fila; i++)
        {
            for(j=0; j<column; j++)
            {
                //GANAR DE FORMA HORIZONTAL
                if (mat[i][j]== comp && mat[i][j+1]== comp && mat[i][j+2]== comp && mat[i][j+3]==comp)
                    lose=1;
                else if (mat[i][j]==jug && mat[i][j+1]== jug && mat[i][j+2]==jug && mat[i][j+3]==jug)
                    win=1;
                //GANAR DE FORMA VERTICAL
                else if (mat[i][j]==comp && mat[i+1][j]==comp && mat[i+2][j]==comp && mat[i+3][j]==comp)
                    lose=1;
                else if (mat[i][j]==jug && mat[i+1][j]==jug && mat[i+2][j]==jug && mat[i+3][j]==jug)
                    win=1;
                //GANAR DE FORMA DIAGONAL
                else if (mat[i][j]==comp && mat[i+1][j+1]==comp && mat[i+2][j+2]==comp && mat[i+3][j+3]==comp)
                    lose=1;
                else if (mat[i][j]==jug && mat[i+1][j+1]==jug && mat[i+2][j+2]==jug && mat[i+3][j+3]==jug)
                    win=1;
                //CUANDO EL JUGADOR O LA MAQUINA TIENE MAS POSIBILIDAD
                else if ((mat[i][j]==jug && mat[i+1][j+1]==jug && mat[i+2][j+2]==jug && mat[i+3][j+3]==' ') &&
                         (mat[i][j]==jug && mat[i][j+1]==jug && mat[i][j+2]==jug && mat[i][j+3]==' ') &&
                         (mat[i][j]==jug && mat[i+1][j]==jug && mat[i+2][j]==jug&& mat[i+3][j]==' '))
                    win=1;
                else if ((mat[i][j]==comp && mat[i+1][j+1]==comp && mat[i+2][j+2]== comp && mat[i+3][j+3]==' ') &&
                         (mat[i][j]==comp && mat[i][j+1]==comp && mat[i][j+2]==comp && mat[i][j+3]==' ') &&
                         (mat[i][j]==comp && mat[i+1][j]==comp && mat[i+2][j]==comp && mat[i+3][j]==' '))
                    lose=1;
            }
        }
        //MOVIMIENTOS DE LA TECLAS HACIA LA DERECHA Y HACIA LA IZQUIERDA
        if ( tecla == DERECHA )
        {
            columnasel ++;
            if ( columnasel == MAXFIL )
                columnasel = 0;
        }
        if ( tecla == IZQUIERDA )
        {
            columnasel --;
            if ( columnasel < 0 )
                columnasel = MAXFIL - 1;
        }
        //TECLA ENTER PARA QUE EL JUGADOR JUEGUE
        if ( tecla == ENTER )
        {
            p=MAXFIL-1;
            c=MAXFIL-1;
            col = randrango(0,(columnasel+1));
            //BUCLE PARA CUANDO EL JUGADOR O LA MAQUINA PRESIONE ENTER SE POSICIONE EN LA ULTIMA FILA Y LA COLUMNA SELECCIONADA
            while (mat[p][columnasel] != ' ' )
                p--;
            mat[p][columnasel]=jug;

            while (mat[c][col] != ' ')
                c--;
            mat[c][col]=comp;
            fichas++;
            t = 0;
            t = clock() - t;
            seconds = ((double)t)/CLOCKS_PER_SEC;
            /*minutes = ((((double)t)/CLOCKS_PER_SEC)/60);
            hours = ((((double)t)/CLOCKS_PER_SEC)/3600);*/
            printf("\nTiempo: %.0f h : %.0f m : %.0f s \n",hours, minutes, seconds);
        }
    }
    while ( tecla != ESC && fichas != 21 && win != 1 && lose != 1);
    //DECISIONES PARA CUANDO ACABE EL JUEGO
    if (fichas == 21)
    {
        printf("\n Se le acabaron las fichas \n");
        printf("Tiempo Total: %.0f : %.0f : %.0f s \n",hours, minutes, seconds);
        system("pause");
        system("cls");
    }
    else if (win == 1 && lose == 0)
    {
        printf("\nUsted ha ganado! \n");
        printf("Tiempo Total: %.0f h : %.0f m : %.0f s \n",hours, minutes, seconds);
        agregarrecord(u,seconds);
        system("pause");
        system("cls");
    }
    else if (win == 0 && lose == 1)
    {
        printf("\nUsted ha perdido! \n");
        printf("Tiempo Total: %.0f h : %.0f m : %.0f s \n",hours, minutes, seconds);
        system("pause");
        system("cls");
    }
    else if (win == 1 && lose == 1)
    {
        printf("\nEmpate! \n");
        printf("Tiempo Total: %.0f h : %.0f m : %.0f s \n",hours, minutes, seconds);
        system("pause");
        system("cls");
    }
    else
    {
        system("cls");
    }

}

/* Función: setcolor.
   Argumento: (int)color del texto e (int)color del fondo.
   Objetivo: Poner el color de texto y de fondo deseado.
*/

void setcolor(int ct, int cf)
{
    textcolor(ct);
    textbackground(cf);
}

/* Función: colordefault.
   Objetivo: Poner el color por defecto.
*/

void colordefault()
{
    setcolor(LIGHTGRAY,BLACK);
}

void getuser(USUARIO *e)
{
    /*char c;
    int pos = 0;
    char strPASSW[50]="\0";*/
    printf("Usuario          ");
    printf("\t %c ", 62);
    fflush(stdin);
    gets(e->nombre);
    printf("Contraseña        ");
    printf("\t %c ", 62);
    fflush(stdin);
    gets(e->password);
    /*do
    {
        c =
        if(isprint(c))
        {
            strPASSW[pos++] = c;
            printf("%c", '*');
        }
        else if( c == 9 && pos )
        {
            strPASSW[pos--] = '\0';
            printf("%s", "\b \b");
        }
    }
    while( c != 13 );*/
}

void agregar(char m[50], char p[50])
{
    FILE *archivo;
    FILE *file;
    char user2[30], line[128];
    int d = 0, h = 0, ind = 0;
    archivo=fopen(ENLACE,"a+");
    file = fopen(ENLACE, "r");
    if (file)
    {
        while(fgets(line, sizeof line, file))
        {
            if(sscanf(line, "%29s", user2) == 1)
                // ^  (!)
            {
                if(!strcmp(m,user2))
                {
                    d=1;
                }
                else
                {
                    h=1;
                }

            }
            else
            {

            }
        }
        if (d == 1)
        {
            printf("\n>>>El Usuario Ya Existe!<<<\n");
            system("pause");
            system("cls");
            main();
        }
        else if(h == 1)
        {
            fprintf(archivo,"%s ",m);
            fprintf(archivo,"%s\n",p);
            printf("\n>>>Usuario Registrado<<<\n");
            system("pause");
            system("cls");
            juego(m);
        }
        fclose(file);
        fclose(archivo);
    }
    else
    {
        printf("No se pudo encontrar el documento!");
        fclose(file);
        fclose(archivo);
        system("pause");
    }

    fclose(file);
    fclose(archivo);
}

void agregarrecord(char m[50], double p)
{
    FILE *archivo;
    archivo=fopen("Records.txt","a+");

    fprintf(archivo,"%s ",m);
    fprintf(archivo,"%.0f\n", p);
    printf("\n>>>Record Registrado<<<\n");
    system("pause");
    system("cls");

    fclose(archivo);
}


void log(char id[50],char pass[50])
{
    FILE *file;
    char user2[30], pass2[30], line[128];
    file = fopen(ENLACE, "r");
    int d = 0, h = 0;
    if (file)
    {
        while(fgets(line, sizeof line, file))
        {
            if(sscanf(line, "%29s %29s", user2, pass2) == 2)
                // ^  (!)
            {
                if(!strcmp(id,user2)&&!strcmp(pass,pass2))
                {
                    d=1;
                }
                else
                {
                    h=1;
                }

            }
            else
            {

            }
        }
        if (d == 1)
        {
            printf("\n>>>Usuario Correcto!<<<\n");
            system("pause");
            system("cls");
            juego(id);
        }
        else if(h == 1)
        {
            printf("\n>>>Nombre o Contraseña Incorrectas<<<\n");
            system("pause");
            system("cls");
            main();
        }
        fclose(file);
    }
    else
    {
        printf("No se pudo encontrar el documento!\n");
        fclose(file);
        system("pause");
    }
}

void rec()
{
    FILE *file;
    char user2[30], pass2[30], line[128];
    file = fopen("Records.txt", "r");
    int i;
    if (file)
    {
        while(fgets(line, sizeof line, file))
        {
            if(sscanf(line, "%29s %29s", user2, pass2) == 2)
                // ^  (!)
            {
               i = atoi(pass2);
            }
            else
            {

            }
        }
    }
    else
    {
        printf("No se pudo encontrar el documento!\n");
        fclose(file);
        system("pause");
    }
}

