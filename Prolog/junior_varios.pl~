%a)
sum([], 0).
sum([H|T], S) :- sum(T, S1), S is H + S1.

% Profe opte por separar la lista en dos listas una de números y la
% segunda de los que no
dividir([], [], 0).
dividir([H|T], [H|N], L) :- number(H), dividir(T, N, L).
dividir([_|T], N, L) :- dividir(T, N, L).

suma(L, [Sum | Letters]) :- dividir(L, Numbers, Letters), sum(Numbers, Sum).

%b)
quitar(Lista, N, Resultado) :- length(Tail, N), append(Resultado, Tail, Lista).

%c)
traduccion('nombre','name').
traduccion('Juan','John').
traduccion('mi','my').
traduccion('es','is').
traduccion('hola','hi').
traduccion('idiota','idiot').
traduccion('un','an').
traduccion('casa','house').
traduccion('gato','cat').
traduccion('perro','dog').
traduccion('azul','blue').
traduccion('red','rojo').
traduccion('color','color').
traduccion('soy','im').
traduccion('aburrido','bored').
traduccion('tengo','have').
traduccion('bien','well').
traduccion('bueno','good').
traduccion('chico','boy').
traduccion('chica','girl').

traduce([],[]).
traduce([Hin|Tin], [Hout|Tout]):- traduccion(Hin, Hout), traduce(Tin,Tout).

