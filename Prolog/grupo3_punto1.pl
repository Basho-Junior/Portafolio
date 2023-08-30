% Dado el siguiente conjunto de hechos, desarrolle una regla regla/0,
% que devuelva la cantidad de monedas representadas en los hechos
% monedas, solo hasta el tercer hecho (25%)
monedas([x]).
monedas([x,x]).
monedas([x,x,x,x]).
monedas([x,x,x,x,x]).
monedas([x,x,x]).
monedas([]).

% Para este ejercicio, encontrará las tres primeras listas de los tres
% primeros hecho.Por lo tanto, X se detiene primero, Y se detiene
% primero diferente de X y Z se detiene primero diferente de X. Y. Esto
% le permite hacerlo de forma fiable o en findall hasta el tercer hecho.

cantidad([], 0).
cantidad([_ | T], C) :- cantidad(T, C2), C is C2 + 1.
regla:- monedas(X), !,
    monedas(Y), Y\=X, !,
    monedas(Z), Z\=X, Z\=Y, !,
    cantidad(X,C1), cantidad(Y,C2), cantidad(Z,C3),
    write(C1), nl, write(C2), nl, write(C3),!.

