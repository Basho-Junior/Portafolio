:- dynamic value/1.

suspect('Person 1') :- eyes(blue) , age(old) , gender(male).

suspect('Person 2') :- eyes(green) , age(young) , gender(male).

suspect('Person 3') :- eyes(brown) , age(young) , gender(male).


fetch(Criterion, Value) :-
    retractall(value(_)),
    assert(value([])),
    forall(clause(suspect(_), Body),
    check(Body, Criterion)),
    retract(value(Value)).

check((F, T), Criterion) :-
    F =..[Criterion, V1],
    retract(value(V2)),
    (   member(V1, V2) -> V3 = V2; V3 = [V1 | V2]),
    assert(value(V3)),
    check(T, Criterion).


check((_F, T), Criterion) :-
    check(T, Criterion).

check((F), Criterion) :-
    F =..[Criterion, V1],
    retract(value(V2)),
    (   member(V1, V2) -> V3 = V2; V3 = [V1 | V2]),
    assert(value(V3)).

check((_F), _Criterion).
