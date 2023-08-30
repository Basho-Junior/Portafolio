position("Moronta","Profesor").
position("Rosario","Director").
position("Estevez","Manager").
position("Correa","Supervisor").

posicion:- write('De quien desea saber su posicion? '),read(Nombre),nl,string_lower(Nombre,LNombre),string_chars(LNombre,[PrimerCh|LLNombre]),string_chars(PrimerCh,[LChar]),string_upper(LChar,UppLChar),string_chars(UppLChar,[NUppLChar]),string_chars(String,[NUppLChar|LLNombre]),write('La posicion de '),write(String),write(' es '),position(String,Posicion), write(Posicion).


escribir:- open('prueba.txt',write,ID),tell(ID),call((position(Persona, Posicion), Posicion \= "Manager")),writeln(Persona); told.


recibir(Caracter,Numero):- open('prueba.txt',read,ID),see(ID), Numero>0, skip(Caracter), get(X), put(X), M is Numero-1,recibir(X,M),close(ID).


