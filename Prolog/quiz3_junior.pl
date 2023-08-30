%Explique el por qu�  de la salida de la consulta realizada al siguiente programa (25%):
%a:-b,!,p.
%a:-r.
%b:-q.
%b:-e.
%p.
%q.
%r.
%e.

% Para este programa se nota como la variable como a toma el valor en b
% y hace un corte antes de p,observamos como luego de que a siendo b
% toma el valor de q siendo salida q y b despues de esto continua con la
% siguiente letra que es p y la misma debido a que a puede ser a o p
% esta retornara true se nota que lo que hace es que a pesar de tomar el
% corte en el momento de b al colocar una regla p esto es como si fuera
% un backtracking y evalua a siendo p.

%Dado el siguiente programa, desarrolle una regla que permita determinar si una hamburguesa le gusta a juan. A juan le gustan todas las hamburguesas menos las hamburguesas de marchena (25%):
big_mac(a).

big_mac(c).

hamburger_marchena(b).

whopper(d).

hamburger(X):-big_mac(X).

hamburger(X):-hamburger_marchena(X).

hamburger(X):-whopper(X).

le_gusta(juan,X) :- hamburger_marchena(X),!,fail.
le_gusta(juan,X) :- hamburger(X).

%�Recuerda el programa que hicimos que nos devolv�a barquillas de 3 bolas? Modif�quelo para que no permita barquillas con sabores de bolas que no sean constantes simb�licas y para que no genere barquillas con dos sabores iguales. Las de 3 sabores iguales sin son permitidas. Estos son los hechos bolas que puede usar para probar (50%):

bola(chocolate).
bola(1).
bola(fresa).
bola(vainilla).
bola(pistacho).
bola([ron,pasas]).
bola(bola(fresa)).

comprobar(A,B,_):- A \= B,fail.
comprobar(A,_,C):- A \= C,fail.
comprobar(_,B,C):- B \= C,fail.
comprobar(A,B,C):- A = B,B = C, A = C.
barquilla(T,M,B):-atom(T),atom(M),atom(B),bola(T),bola(M),bola(B),comprobar(T,M,B).


