%Dado el siguiente programa en Prolog, y habiendo probado los ejemplos
% que se le proponen, modif�quelo para que funcione correctamente, si
% usted cree que no lo hace.

% Como no funcionaba correctamente. Para poder solucionar esto, era
% principalmente necesario configurar n�meros predicados met�licos para
% que pudi�ramos verificar si la regla conten�a n�meros. Las dos partes
% de la regla ten�an entradas diferentes y deb�an usarse. La primera
% parte se usa solo cuando el primer n�mero es el primero y el tercero,
% y la segunda parte se usa solo cuando el segundo n�mero est� de pie.
% Debido a que est� en la segunda y tercera posici�n, las dos partes se
% usan por separado y no hay recurrencia, por lo que los datos solo
% pueden entrar en una de las partes.

min(N1, N2, N1):- number(N1),number(N2),N1 =< N2,!.
min(N1, N2, N2):- number(N1),number(N2).



