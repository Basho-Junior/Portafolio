showForm :-
    %new(W,  window('Test', size(800, 800))),
    new(D, dialog('Main window', size(800, 800))),
    new(H1, dialog_group(' ')),
    new(H2, dialog_group(' ')),
    send(D, append, H1),
    send(D, append, H2, right),

    /* 6) serach if country is in Europe */
    new(Etiq, text_item('1) Enter country here:')),
    send(H1, append, Etiq),
    new(Result, label),
    send(H1, append, Result),
    send(H1, append, button(search)),


    /* 7) Path form-to (serach in deep) */
    new(Path1, text('6) Path form-to (serach in deep)')),
    new(From1, text_item('Enter country FROM here:')),
    new(To1, text_item('Enter country TO here:')),
    send(H2, append, Path1),
    send(H2, append, From1),
    send(H2, append, To1),

    new(Path1Res, label),
    send(D, append, button(path)),
    send(D, append, Path1Res),

    send(D, open).
