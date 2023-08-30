tresElementos([_,_,_]).
tresElmentos1(X):-length(X,N), N = 3.
tresElmentos2(X):-length(X,3).


f(1,a).
f(2,b).
f(3,c).

fa(a, 1).
fa(b, 2).
fa(c, 3).


TR: test1:- write(hola), nl, test1.
condicio´(1): test1 :- test1, write(hola), nl.
condicio´n(2):test1:-write(hola),nl,test1.
test1:-write(adios).
condicio´(3):
test1:-predicado,write(hola),nl,test1.
predicado:-write(adios1).
predicado:-write(adios2).

