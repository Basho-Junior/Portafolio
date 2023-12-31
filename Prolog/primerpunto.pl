%continente, area (km2) y poblacion total aproximada (al a�o 2008)

continente(africa,30370000,922011000).
continente(europa,10180000,731000000).
continente(asia,43810000,3879000000).
continente(america,42330000,910000000).
continente(oceania,9008500,32000000).
continente(antartida,13720000,1000).

% Franjas que delimitan los territorios entre continentes vecinos

limite(africa,europa,estrecho_gibraltar).
limite(asia,africa,itsmo_suez).
limite(asia,america,estrecho_bering).
limite(oceania,asia,linea_wallace).
limite(asia,europa,depresion_kuma_manych).

% Composici�n de las franjas delimitadoras

mar(estrecho_gibraltar).
mar(estrecho_bering).
mar(depresion_kuma_manych).
mar(linea_wallace).
tierra(depresion_kuma_manych).
tierra(itsmo_suez).

%cantidad paises reconocidos por continente

paises_reconocidos(africa,55).
paises_reconocidos(europa,50).
paises_reconocidos(asia,49).
paises_reconocidos(america,35).
paises_reconocidos(oceania,14).
paises_reconocidos(antartida,0).


%cantidad de territorios dependientes por continente

dependencias(africa,2).
dependencias(europa,3).
dependencias(asia,6).
dependencias(america,25).
dependencias(oceania,16).
dependencias(antartida,0).

%cantidad de paises no reconocidos por continente

paises_no_reconocidos(africa,2).
paises_no_reconocidos(europa,7).
paises_no_reconocidos(asia,6).
paises_no_reconocidos(america,0).
paises_no_reconocidos(oceania,0).
paises_no_reconocidos(antartida,0).

existeElementoLista(X,[X|_]).
existeElementoLista(X,[_|Cola]):-existeElementoLista(X,Cola).

insertaElemento(X, Lista, [X|Lista]).


% Se desea saber cu�les continentes tienen una densidad poblacional por
% km2 que supera una cantidad de personas dada
densidad:- continente(Continente,Area,Poblacion),Area>Poblacion,write(Continente).

%Se desea obtener una lista de los continentes que tienen l�mites mar�timos con otros continentes.
continente_limite_maritimo(ContinentesNuevos):- Continentes=[],limite(Continente1,Continente2,Limite),mar(Limite),not(existeElementoLista(Continente1,Continentes)),insertaElemento(Continente1,Continentes,ContinentesNuevo),not(existeElementoLista(Continente2,ContinentesNuevo)),insertaElemento(Continente2,ContinentesNuevo,ContinentesNuevos).

%Una dependencia es un territorio que por diversas razones no goza de los privilegios de total independencia o soberan�a, ni hace parte integral del estado que lo gobierna. Se desea saber cu�les continentes tienen una tasa de dependencias mayor al 70%. Tome en cuenta que para Ant�rtida esta consulta debe devolver falso.

dependencias:-paises_reconocidos(Pais,Cantidad),dependencias(Pais,CantidadDepen),Pais \= antartida, Test is (CantidadDepen/(Cantidad+cantidadDepen))*100,write(Pais),write(' test '),write(Test).

%Se desea saber cu�ntos son los continentes que tienen en su territorio al menos un 0.5% de pa�ses no reconocidos.

continente_noreonocidos:-paises_reconocidos(Pais,Cantidad),paises_no_reconocidos(Pais,CantidadDepen),Pais \= antartida, Test is (100*CantidadDepen)/Cantidad, Test>0.5,write(Pais),write(' el total fue '),write(Test).




