partebasica(llanta).
partebasica(radio).
partebasica(cuadro_trasero).
partebasica(manillar).
partebasica(engranaje).
partebasica(perno).
partebasica(tuerca).
partebasica(horquilla).

ensambladas(bicicleta,[rueda,rueda,cuadro]).
ensambladas(rueda,[radio,llanta,cubo]).
ensambladas(cuadro,[cuadro_trasero,cuadro_delantero]).
ensambladas(cuadro_delantero,[horquilla,manillar]).
ensambladas(cubo,[engranaje,eje]).
ensambladas(eje,[perno,tuerca]).

%Encabezado a)
ensamblaje(Parte):-ensambladas(Parte,L),length(L,4).

%Encabezado b)
regla(Partes):-ensambladas(_,[Partes|T]),T = [Segundo,_],partebasica(Segundo).

%Encabezado c)
parte_ensamblada(Parte):-ensambladas(Parte,L),write(L),!.
