%Dado el siguiente programa en Prolog, y habiendo probado los ejemplos
% que se le proponen, modifíquelo para que funcione correctamente, si
% usted cree que no lo hace.

% Como no funcionaba correctamente. Para poder solucionar esto, era
% principalmente necesario configurar números predicados metálicos para
% que pudiéramos verificar si la regla contenía números. Las dos partes
% de la regla tenían entradas diferentes y debían usarse. La primera
% parte se usa solo cuando el primer número es el primero y el tercero,
% y la segunda parte se usa solo cuando el segundo número está de pie.
% Debido a que está en la segunda y tercera posición, las dos partes se
% usan por separado y no hay recurrencia, por lo que los datos solo
% pueden entrar en una de las partes.

min(N1, N2, N1):- number(N1),number(N2),N1 =< N2,!.
min(N1, N2, N2):- number(N1),number(N2).



