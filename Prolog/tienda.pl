precio(lapicero,80).
precio(papel,220.5).
precio(computadora,12000).
precio(carro,300000).
precio(tomates,15).

% En el programa de consulta de precios que aparece en las diapositivas
% 1.4 cree una regla buenprecio(Producto) que devuelve los productos de
% buen precio. Un producto tiene buen precio si su precio es un 20 o
% menos que el precio de una computadora o si su precio esta entre 10 y
% 15 por encima del de los tomates.

buenprecio(Producto):-precio(Producto,Precio),precio(computadora,PrecioComp),Precio =< PrecioComp*20/100.

buenprecio(Producto):-precio(Producto,Precio),precio(tomates,PrecioTo),Precio >= PrecioTo*10/100, Precio =< PrecioTo*15/100.

% En el mismo programa agregue una regla compro(Produto,ValorBooleano),
% en el que se deben devolver todos los productos acompaņado de un
% valor booleano, que indica si lo compra o no. Se compra un producto
% si tiene el caracter m en su nombre. No se compra en caso contrario.

compro(Producto,true):- precio(Producto,_),sub_string(Producto, _, _, _, "m").

compro(Producto,false):- precio(Producto,_),not(sub_string(Producto, _, _, _, "m")).
