palabrasde(X,[X]) :- palabra(X).
palabrasde(X,P) :- gramatica(X,Subpartes), palabrasdelista(Subpartes,P).

palabrasdelista([],[]).
palabrasdelista([P | Cola], Alista) :-
palabrasde(P,Palabrascabeza), palabrasdelista(Cola,Palabrascola),
append(Palabrascabeza, Palabrascola, Alista).

gramatica(oracion,[sintagma_nominal,sintagma_verbal]).
gramatica(sintagma_nominal,[determinante, sustantivo]).
gramatica(sintagma_nominal,[juan]).
gramatica(sintagma_verbal,[verbo_transitivo, objeto]).
gramatica(sintagma_verbal,[verbo_intransitivo]).
gramatica(determinante,[una]).
gramatica(sustantivo,[muchacho]).
gramatica(sustantivo,[piedra]).
gramatica(verbo_transitivo,[lanza]).
gramatica(verbo_intransitivo,[canta]).
gramatica(objeto, [sintagma_nominal]).


palabra(juan).
palabra(una).
palabra(muchacho).
palabra(piedra).
palabra(lanza).
palabra(canta).

