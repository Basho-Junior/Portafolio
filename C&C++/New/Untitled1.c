#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <string.h>
#define ENLACE "C:\\Users\\Junior\\Downloads\\Usuarios.txt"
int main()
{
    char login[30], pass[30];
    int select3;

    printf("\n|---------Login:");
    scanf("%s", login);
    printf("|---------Password:");
    scanf("%s", pass);

    sign_In(login, pass);
    _getch();
    system("PAUSE");
    return 0;
}

int sign_In(char login[30], char pass[30])
{
    FILE *file;
    char user2[30], pass2[30], fc;
    file = fopen("Usuarios.txt", "r");
    char arra[128][128];

    if (file != NULL)
    {
        char line[128];
        while(fgets(line, sizeof line, file))
    {
        if(scanf(line, "%29s %29s", user2, pass2) == 2)
            {
                if ((strcmp(login, user2) == 0) && (strcmp(pass, pass2) == 0))
                {
                    printf("\n>>>User and password correct!<<<\n");
                }
                else
                {
                    printf("\n>>>User or password incorrect!<<<\n");
                    system("PAUSE");
                    fc = sign_In(login, pass);
                }
            }
           else
            {
               printf("\n>>>Linea Invalida!<<<\n");
            }
        }
        fclose(file);

    }
    else
        printf("File was not founded");
    fclose(file);
    system("PAUSE");
    return 0;
}

