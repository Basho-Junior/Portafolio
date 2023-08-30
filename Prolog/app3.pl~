
ask_name(Loco) :-
        new(D, dialog('Register')),
        send(D, append(new(NameItem, text_item(porno)))),
        send(D, append(button(ok, message(D, return,
                                          NameItem?selection)))),
        send(D, append(button(cancel, message(D, return, @nil)))),
        send(D, default_button(ok)),
        get(D, confirm, Rval),
        free(D),
        Rval \== @nil,
        Loco = Rval.

:- pce_autoload(file_item, library(file_item)).

main:-
    new(Menu, dialog('Diagnostico de medico', size(900,900))),
    send(Menu, append, label(label,'Bienvenido a su atencion medica')),
    send(Menu, open).

:-use_module(library(pce)).
imag:-
    new(P,picture('Hola')),
    new(I,image('4.jpg')),
    new(B,bitmap(I)),
    send(P,display,B),
    send(P,open).

ask_trampa  :-
% Crea el objeto dialogo en la variable D
        new(D, dialog('Adivinador')),
        send(D, append, label(label,'Esta es la criatura?')),
        new(B, button('si',message(@prolog, assertz_maquina, 'Punto para la maquina'),and(message(D, destroy),message(D,  free),message(D,  free),message(B,  free)))),
        % Inserta los botones en el diálogo
        send(D, append(B)),
        % Muestre la ventana.
        send(D, open).% Muestra un mensaje en la consola.mostrar_mensaje(P) :-write(‘La variable P vale ’), write(P), nl.
