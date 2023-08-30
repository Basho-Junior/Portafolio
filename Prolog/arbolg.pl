% ¿Recuerda el programa del Árbol Genealógico? Se quiere que,
% adicionalmente, usted defina en este programa las siguientes reglas.
% (Puede utilizar otras reglas que ya estén definidas en el programa en
% el cuerpo de las nuevas reglas que se le pide definir, Ej.: usar la
% regla hermano para definir la regla tío).

progenitor(juan,luis).
progenitor(juan,maria).
progenitor(luis,carlos).
progenitor(luis,laura).


hermano(H1,H2):-progenitor(Padre,H1),progenitor(Padre,H2),H1 \= H2.

tio(Tio,Sobrino):- progenitor(Padre,Sobrino), hermano(Tio,Padre).

primo(Persona1,Persona2):- tio(Tio,Persona1), progenitor(Tio,Persona2).

pareja(Persona1,Persona2):- progenitor(Persona1,Hijo), progenitor(Persona2,Hijo).

suegro(Suegro,Yerno):- pareja(Yerno,Persona), progenitor(Suegro,Persona).

cunado(Persona1,Persona2):- pareja(Persona1,Persona), hermano(Persona, Persona2).

antepasado(X,Y):-progenitor(X,Y).
antepasado(X,Y):- progenitor(X,Z),antepasado(Z,Y).
