%Encabezado a)

bola(chocolate).
bola(fresa).
bola(vainilla).

barquilla(T,M,B):-atom(T),atom(M),atom(B),bola(T),bola(M),bola(B),T \= M, M \= B, T \= B.

%Encabezado b)
impar(_).
aserta_impares(Inf,Sup):-numlist(Inf,Sup,L),findall(N,(member(N,L),N mod 2 =\= 0),L2),write(L2).

%Encabezado c)
orden(1).
orden(2):-!.
orden(3).

regla(X,Y):- orden(Y),orden(X), !.
