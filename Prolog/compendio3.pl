monedas([x]).
monedas([x,x]).
monedas([x,x,x,x]).
monedas([x,x,x,x,x]).
monedas([x,x,x]).
monedas([]).

monedas_salida:-monedas(X),contar(X,Y),write(Y),write(" "),fail.
contar([],Y):-Y is 0.
contar([_|Z],Y):- contar(Z,W), Y is W + 1.

