% Implemente un predicado multiplicar/3, el cual reciba dos fracciones y
% devuelva su producto.
multiplicar(Fraccion1,Fraccion2,Resultado):-Fraccion1 = div(Numerador1,Denominador1),Fraccion2 = div(Numerador2,Denominador2),Numerador is Numerador1 * Numerador2, Denominador is Denominador1*Denominador2,Resultado = div(Numerador,Denominador).
