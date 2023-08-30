progenitor(juan,luis).
progenitor(juan,maria).
progenitor(luis,carlos) .
progenitor(luis,laura).

antepasado(X,Y) :- progenitor(X,Y).
antepasado(X,Y) :- progenitor(X,Z), antepasado(Z,Y).

descendiente(X,Y) :- progenitor(Y,X).
descendiente(X,Y) :- progenitor(Z,X), descendiente(Z,Y).
