% 3.1 Recuerde la representaci�n de n�meros naturales que usamos en
% clase, que estaba en funci�n de lossiguientes del cero. �C�mo
% completar�a usted la siguiente regla recursiva que dice si dos n�meros
% naturales son iguales?

iguales(0,0).
% iguales(s(X),s(Y)) :-
% Entonces usamos la regla de igualdes por segunda vez porque no nos
% garantiza que el numero de s que tiene uno de los parametros sea igual
% al otro, por eso lo hacemos crear independientemente, como se ve
% acontinuacion.
iguales(s(X),s(Y)) :- iguales(X,_), iguales(_,Y).

% 3.2 La regla recursiva compress/2 elimina los elementos
% consecutivos duplicados en una lista �Podr�a explicar en detalle como
% lo logra?
compress([],[]).
compress([X],[X]).
compress([X,X|Xs],Zs) :- compress([X|Xs],Zs).
compress([X,Y|Ys],[X|Zs]) :- X \= Y, compress([Y|Ys],Zs).
% La regla recursiva va dando paso a todos los datos de una lista, es
% decir que la lista sea ingresada y entonces revisa si el elemento
% siguiente de la cabeza es diferente al actual y entonces si este no lo
% es, continua llamando de manera recursiva. Por lo que como pasa estos
% datos de verificacion de si los primeros 2 elementos de su camino, son
% consecutivos, entonces, no los agrega a la segunda lista o sea una
% lista vacia. Cuando se llega a una lista vac�a, sale de la
% recursividad y mantiene la nueva lista sin duplicados en la segunda
% variable a la que se llama, al final teniendo �xito y lograndolo.

% 3.3 Se busca que la siguiente regla divida una lista en dos partes.
% Complete el objetivo faltante y tome en cuenta que el segundo t�rmino
% representa la cantidad de elementos que tendr� la primera lista
% producida:
split(L,0,[],L).
% split([X|Xs],N,[X|Ys],Zs) :- N > 0, N1 is N - 1,
% Para poder realizar esto solo se debe aplicar la recursividad de la
% siguiente forma:
split([X|Xs],N,[X|Ys],Zs) :- N > 0, N1 is N - 1, split(Xs, N1, Ys, Zs).

% 3.4 �Qu� hace la siguiente regla?
surprise(I,I,[I]).
surprise(I,K,[I|L]) :- I < K, I1 is I + 1, surprise(I1,K,L).

% Lo que hace esta regla es crea una lista que va entre dos puntos desde
% I hasta K. En si devuelve una lista de elementos que se encuentre
% dentro de I hasta K de de manera continua. Si por ejemplo lo
% usamos surprise(1,6,L). el resultado seria L seria [1, 2, 3, 4, 5, 6].

