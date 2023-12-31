% En el sistema de seguridad social, los contribuyentes normales son
% aquellos que: No son extranjeros, si esta�n casados su pareja no gana
% ma�s de 20,000 pesos y, en cualquier otro caso, sus ingresos propios
% esta�n entre 7,000 y 20,000. Escriba en Prolog las reglas necesarias
% para determinar si un contribuyente es normal o no utilizando para
% ello la combinacio�n corte- afllo.


% el extranjero
extranjero(junior).

% los salarios de cada uno
salario(anya, 14000).
salario(amber, 38000).
salario(julian, 32000).
salario(roberto, 18000).
salario(yor, 11000).
salario(loid, 8000).

% parejas.
casados(loid, yor).
casados(yor, loid).
casados(amber, julian).
casados(julian, amber).

% Corte cuando encuentra el extranjero.
es_contribuyente(Persona):-extranjero(Persona),!,fail.

% Corte al evaluar las parejas y su salario, si tiene mas de 20k.
es_contribuyente(Persona):-casados(Persona,Conyugue), salario(Conyugue,Sueldo), Sueldo>20000,!,fail.

% Finalmente se evaluan las personas como contribuyentes que si
% cumplieron las condiciones del encabezado.
es_contribuyente(Persona):-salario(Persona,Sueldo), Sueldo>=7000, Sueldo=<20000.
