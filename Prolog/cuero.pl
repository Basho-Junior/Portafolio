/*Variables dinamicas para guardar los aciertos y los no*/
:-dynamic cierto/1.
:-dynamic falso/1.
/*Variables dinamicas para guadar los puntos del jugador y la maquina*/
:-dynamic maquina/1.
:-dynamic jugador/1.

/*Importamos la libreria para utilizar varias herramientas de XPCE*/
:-use_module(library(pce)).

/*Inicializamos los puntos de la maquina y del usuario*/
maquina(0).
jugador(0).

/*Funciones de suma de puntos de la maquina y el jugador que finaliza cuando gana 3 veces,
   llama una pantalla para indicar esto y reinicia el puntaje*/

assertz_maquina:-
   maquina(I),/*Creamos I para almacenar un valor*/
   retract(maquina(I)),/*recibimos el valor que teng actualmente*/
   ((I == 2)/*Si I es igual a 2*/
       ->
       perdedor,borrar_puntaje;/*Muestre el mensaje de que gano y reinicia la puntuacion*/
   (I < 2) /*En el caso contrario*/
   ->
       I1 is I+1,/*Se suma un punto*/
       assertz(maquina(I1))/*Y ese resultado se le establece como nuevo valor a maquina*/
   ).

assertz_jugador:-
   jugador(I),
   retract(jugador(I)),
   ((I == 2)
       ->
       ganador,borrar_puntaje;
   (I < 2)
   ->
       I1 is I+1,
       assertz(jugador(I1))
   ).

/*Funciones para mostrar las imagenes de la carta*/
imag1:-
    new(P,picture('Duende')),/*Declaramos una ventada para la imagen*/
    new(I,image('4.jpg')),/*Llamamos la imagen a utilizar*/
    new(B,bitmap(I)),/*Creamos un mapa en bit de la imagen*/
    send(P,display,B),/*Mostramos el resultado de lo anterior*/
    send(P,width(540)),/*Establecemos ancho de la ventana*/
    send(P,height(1500)),/*Establecemos alto de la ventana*/
    send(P,open). /*Abrimos la ventana*/

imag2:-
    new(P,picture('Minotauro')),
    new(I,image('1.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag3:-
    new(P,picture('Dragon')),
    new(I,image('2.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag3:-
    new(P,picture('Dragon')),
    new(I,image('2.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag4:-
    new(P,picture('Centauro')),
    new(I,image('3.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag5:-
    new(P,picture('Sirena')),
    new(I,image('5.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag6:-
    new(P,picture('Cecaelia')),
    new(I,image('6.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag7:-
    new(P,picture('Gorgona')),
    new(I,image('7.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag8:-
    new(P,picture('Fauno')),
    new(I,image('8.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag9:-
    new(P,picture('Hada')),
    new(I,image('9.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag10:-
    new(P,picture('Ciclope')),
    new(I,image('10.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag11:-
    new(P,picture('Grifo')),
    new(I,image('11.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag12:-
    new(P,picture('Pegaso')),
    new(I,image('12.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag13:-
    new(P,picture('Fenix')),
    new(I,image('13.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

imag14:-
    new(P,picture('No lo encuentro')),
    new(I,image('14.jpg')),
    new(B,bitmap(I)),
    send(P,width(540)),
    send(P,height(1500)),
    send(P,display,B),
    send(P,open).

/*
  Adivinador de criaturas mitologicas.

    Para empezar: ?- start.

    aqui mostrarmos elmenu con una imagen y 3 botones */

start:-
    new(Menu, dialog('Adivinador')),/*Creamos una ventana tipo dialog*/
    new(I,image('15.jpg')),
    new(B,bitmap(I)),
    send(Menu,width(730)),
    send(Menu,height(440)),
    send(Menu,display,B),
    send(Menu, append,button(instrucciones,message(@prolog, ruler))),/*Agregamos un boton a la ventana con un procedimiento tipo prolog*/
    send(Menu, append,button(jugar,message(@prolog, play))),
    send(Menu, append,button(informacion,message(@prolog, information))),
    get(Menu, confirm_centered, PosB),/*Centralizamos la ventana*/
    send(Menu, open, PosB).

/*Funcion para mostrar las reglas del juego al presionar*/
ruler:-
    new(Menu, dialog('Instrucciones', size(900,900))),
    send(Menu, append, label(label,
'Bienvenido >.<
En esta traves�a intentar�s ganarle al mejor de nuestros guerreros, y as� llevarte el triunfo.
Para ello deber�s ser el primero en obtener 3 puntos, adivinando criaturas mitol�gicas.
Recuerda no hacer trampas, porque las maldiciones caen sobre aquellos que se atreven a enga�ar a los cielos.
Si no sabes de criaturas mitol�gicas no te preocupes, revisa la secci�n de informaci�n y aseg�rate de ser sabio para la batalla.
Al final te pregunta si es tu criatura y si dices que si es punto para la maquina.
Buena suerte y adelante!')),/*Establecemos un label con texto dentro de la ventana*/
    send(Menu, open).


/*Funcion para mostrar todas las criaturas con botones abajo que al presionar muestra una ventana con informacion*/
information:-
    new(Menu, dialog('Informaci�n')),
    new(H1, dialog_group(' ')),/*Creamos una subdivision dentro del dialog*/
    new(H2, dialog_group(' ')),
    new(H3, dialog_group(' ')),
    new(H4, dialog_group(' ')),
    new(H5, dialog_group(' ')),
    new(H6, dialog_group(' ')),
    new(H7, dialog_group(' ')),
    new(H8, dialog_group(' ')),
    new(H9, dialog_group(' ')),
    new(H10, dialog_group(' ')),
    new(H11, dialog_group(' ')),
    new(H12, dialog_group(' ')),
    new(H13, dialog_group(' ')),
    send(Menu, append, H1),
    send(Menu, append, H2, right),/*Posicionamos a la derecha lo que queremos colocar para esa subdivision*/
    send(Menu, append, H3, right),
    send(Menu, append, H4, right),
    send(Menu, append, H5, right),
    send(Menu, append, H6, right),
    send(Menu, append, H7, right),
    send(Menu, append, H8),
    send(H8, alignment, left),/*Posicionamos a la izquierda*/
    send(Menu, append, H9, right),
    send(Menu, append, H10, right),
    send(Menu, append, H11, right),
    send(Menu, append, H12, right),
    send(Menu, append, H13, right),


    new(I1,image('1.1.jpg')),
    new(B1,bitmap(I1)),
    send(H1,display,B1),
    send(H1, append,button(minitauro,message(@prolog, minotaur))),

    new(I2,image('2.1.jpg')),
    new(B2,bitmap(I2)),
    send(H2,display,B2),
    send(H2, append,button(dragon,message(@prolog, dragone))),

    new(I3,image('3.1.jpg')),
    new(B3,bitmap(I3)),
    send(H3,display,B3),
    send(H3, append,button(centauro,message(@prolog, centaur))),

    new(I4,image('goblin.jpg')),
    new(B4,bitmap(I4)),
    send(H4,display,B4),
    send(H4, append,button(duende,message(@prolog, goblin))),

    new(I5,image('5.1.jpg')),
    new(B5,bitmap(I5)),
    send(H5,display,B5),
    send(H5, append,button(sirena,message(@prolog, mermaid))),

    new(I6,image('6.1.jpg')),
    new(B6,bitmap(I6)),
    send(H6,display,B6),
    send(H6, append,button(cecaelia,message(@prolog, ceca))),

    new(I7,image('7.1.jpg')),
    new(B7,bitmap(I7)),
    send(H7,display,B7),
    send(H7, append,button(gorgona,message(@prolog, gorgon))),

    new(I8,image('8.1.jpg')),
    new(B8,bitmap(I8)),
    send(H8,display,B8),
    send(H8, append,button(fauno,message(@prolog, faun))),

    new(I9,image('9.1.jpg')),
    new(B9,bitmap(I9)),
    send(H9,display,B9),
    send(H9, append,button(hada,message(@prolog, fairy))),

    new(I10,image('10.1.jpg')),
    new(B10,bitmap(I10)),
    send(H10,display,B10),
    send(H10, append,button(ciclope,message(@prolog, cyclop))),

    new(I11,image('11.1.jpg')),
    new(B11,bitmap(I11)),
    send(H11,display,B11),
    send(H11, append,button(grifo,message(@prolog, grypho))),

    new(I12,image('12.1.jpg')),
    new(B12,bitmap(I12)),
    send(H12,display,B12),
    send(H12, append,button(pegaso,message(@prolog, pegasus))),

    new(I13,image('13.1.jpg')),
    new(B13,bitmap(I13)),
    send(H13,display,B13),
    send(H13, append,button(fenix,message(@prolog, bird))),

    send(Menu, open).

/*Funciones para mostrar informacion sobre las criaturas*/
minotaur:-
    new(Menu, dialog('Minotauro', size(900,900))),
    send(Menu, append, label(label,'Un minotauro es un monstruo mitol�gico mitad toro y mitad humano que fue encerrado por su violencia y esp�ritu de contienda en un laberinto, alimentandose de humanos sacrificados y del cesped del laberinto. ')),
    send(Menu, open).

dragone:-
    new(Menu, dialog('Dragon', size(900,900))),
    send(Menu, append, label(label,'Un drag�n en una enorme y feroz criatura que habita en cuevas y monta�as,con alas, cuatro patas, y la habilidad de lanzar fuego por la boca.')),
    send(Menu, open).

centaur:-
    new(Menu, dialog('Centauro', size(900,900))),
    send(Menu, append, label(label,'Un centauro es una combinaci�n entre la parte inferior de un caballo y la parte superior de un humano. Le gustan los vegetales y cazar animales. Suelen tomar mucha cerveza, y buscar problemas con otras especies,
    sin miedo a una guerra.')),
    send(Menu, open).

goblin:-
    new(Menu, dialog('Duende', size(900,900))),
    send(Menu, append, label(label,'Un duende es una criatura peque�a, grotesca y traviesa que habita en los bosques con otros de su especie, y que posee una anatom�a parecida a la de un humano, caminando en dos piernas, y alimentandose de frutos
    y animales m�s peque�os.')),
    send(Menu, open).

mermaid:-
    new(Menu, dialog('Sirena', size(900,900))),
    send(Menu, append, label(label,'Una sirena es una criatura de apariencia hermosa que vive en el mar -siendo pez de cintura hacia abajo y humana de cintura hacia arriba- y atrae a los marineros con su canto celestial,
    rodeadea siempre de m�s de dos sirenas, come peces, algas y quiz�s uno que otro hombre desprevenido.')),
    send(Menu, open).

ceca:-
    new(Menu, dialog('Cecaelia', size(900,900))),
    send(Menu, append, label(label,'Una cecaelia es una hermosa criatura mar�tima con el cuerpo de un pulpo y el torso y rostro de mujer. Come algas y otras especies del mar, y suele separase de su familia a edad temprana para vivir en soledad. ')),
    send(Menu, open).

gorgon:-
    new(Menu, dialog('Gorgona', size(900,900))),
    send(Menu, append, label(label,'Una gorgona es una criatura mitol�gica temible conocida por ser una mujer con cabellos de serpientes, por lo que es venenosa.')),
    send(Menu, open).

faun:-
    new(Menu, dialog('Fauno', size(900,900))),
    send(Menu, append, label(label,'Un fauno es una criatura mitad animal y mitad humano, que se sostiene en dos patas de cabra y posee cuernos. Es conocido por vivir en bosques, evitar enfrentamientos o problemas y cazar peque�os animales,
    y as� preparar alimentos junto con los frutos del bosque.')),
    send(Menu, open).

fairy:-
    new(Menu, dialog('Hada', size(900,900))),
    send(Menu, append, label(label,'Un hada es una criatura m�gica peque�a y de forma humana, que vive en bosques rodeada de su especie, conocida por ser hermosa, volar y comer miel y frutas.')),
    send(Menu, open).

cyclop:-
    new(Menu, dialog('Ciclope', size(900,900))),
    send(Menu, append, label(label,'Un ciclope es una criatura con dos pierna que se asemeja a los humanos en forma, aunque grotesco y con un solo ojo, y siendo de un tama�o grande, como el de un monta�a. Se alimenta de humanos y animales,
    y le gusta causar pelea y discordia.')),
    send(Menu, open).

grypho:-
    new(Menu, dialog('Grifo', size(900,900))),
    send(Menu, append, label(label,'Un grifo es una criatura con la cabeza y las alas de un �guila y el cuerpo de un le�n,se alimenta de semillas y animales peque�os, y son feroces animales que sirven como guardianes de grandes riquezas y fortunas,
    por lo que est�n listos para defender y luchar por su due�o.')),
    send(Menu, open).

pegasus:-
    new(Menu, dialog('Pegaso', size(900,900))),
    send(Menu, append, label(label,'Un pegaso es una criatura hermosa,un caballo blanco alado que se encarga de transpportar al mism�simo Zeus, se alimenta del cesped del monte Olimpo.')),
    send(Menu, open).

bird:-
    new(Menu, dialog('Fenix', size(900,900))),
    send(Menu, append, label(label,'Un fenix es un ave de fuego que revive a partir de sus cenizas, se alimenta de semillas, frutos y peque�as alima�as.')),
    send(Menu, open).


/*Funciones de perdedor y ganador para mostrar un mensaje de si gano el jugador o la maquina*/
ganador:-
    new(Menu, dialog('Ganador', size(900,900))),
    new(I,image('ending.jpg')),
    new(B,bitmap(I)),
    send(Menu,width(795)),
    send(Menu,height(470)),
    send(Menu,display,B),
    send(Menu, append, label(label,'GANO EL JUGADOR')),
    send(Menu, open).

perdedor:-
    new(Menu, dialog('Perdedor', size(900,900))),
    new(I,image('ending.jpg')),
    new(B,bitmap(I)),
    send(Menu,width(795)),
    send(Menu,height(470)),
    send(Menu,display,B),

    send(Menu, append, label(label,'GANO LA MAQUINA')),
    send(Menu, open).


/*Funcion para ya jugar el juego en donde dependiendo el resultado de las preguntas se mostrara la carta de la misma y preguntara al jugador si esta es la criatura que esperaba */
play :-borrar,criatura(Criatura),
      write('Tu criatura es: '),
      write(Criatura),
      ((Criatura == duende) /*Decesion de que si la criatura es un duende haga algo*/
       ->
       imag1,ask_trampa; /*Aqui llamamos para mostrar la imagen y preguntarle al jugador si es su criatura*/
      (Criatura == minotauro)
       ->
       imag2,ask_trampa;
      (Criatura == dragon)
       ->
       imag3,ask_trampa;
      (Criatura == centauro)
       ->
       imag4,ask_trampa;
      (Criatura == sirena)
       ->
       imag5,ask_trampa;
      (Criatura == cecaelia)
       ->
       imag6,ask_trampa;
      (Criatura == gorgona)
       ->
       imag7,ask_trampa;
      (Criatura == fauno)
       ->
       imag8,ask_trampa;
      (Criatura == hada)
       ->
       imag9,ask_trampa;
      (Criatura == ciclope)
       ->
       imag10,ask_trampa;
      (Criatura == grifo)
       ->
       imag11,ask_trampa;
      (Criatura == pegaso)
       ->
       imag12,ask_trampa;
      (Criatura == fenix)
       ->
       imag13,ask_trampa;
      (Criatura == unknown)
       ->
       imag14,assertz_jugador
      ).

/* Criaturas para probar */
criatura(duende)    :- duende, !.
criatura(ciclope)   :- ciclope, !.
criatura(minotauro) :- minotauro, !.

criatura(hada)      :- hada, !.
criatura(fauno)     :- fauno, !.
criatura(centauro)  :- centauro, !.
criatura(gorgona)   :- gorgona, !.
criatura(sirena)    :- sirena, !.
criatura(cecaelia)  :- cecaelia, !.
criatura(fenix)     :- fenix, !.
criatura(dragon)    :- dragon, !.
criatura(grifo)     :- grifo, !.
criatura(pegaso)    :- pegaso, !.
criatura(unknown).             /* no hay */

/* Criatura reglas de identificacion */
duende :-  bipeda,
           humanoide,
	   grotesca,
           es(es_pequenia),
           omnivora,
	   es(vive_en_grupo),
	   es(habita_bosques),
           es(hace_travesuras).


minotauro :- bipeda,
             humanoide,animal,
             grotesca,
             es(es_mediana),
             omnivora,
             es(tiene_cuernos),
             es(es_guerrera).

ciclope   :- bipeda,
             humanoide,
	     grotesca,
             es(es_grande),
             carnivora,
	     es(es_guerrera).

hada   :-  bipeda,
           humanoide,
	   hermosa,
           es(es_pequenia),
           herbivora,
	   es(vive_en_grupo),
	   es(habita_bosques),
           vuela.


fauno  :-  bipeda,
           humanoide,animal,
           es(es_mediana),
           omnivora,
	   es(habita_bosques),
           es(tiene_cuernos),
           es(es_pacifica).

gorgona    :- bipeda,
              humanoide,animal,
	      es(es_mediana),
              omnivora,
	      es(es_venenosa).

centauro :-  cuadrupeda,
             humanoide,animal,
             es(es_mediana),
             omnivora,
	     es(es_guerrera),
             es(tiene_pezunias).


pegaso   :-  cuadrupeda,
             animal,
             hermosa,
             es(es_mediana),
             herbivora,
	     vuela,
             es(tiene_pezunias).


grifo :-     cuadrupeda,
             animal,
             es(es_feroz),
             es(es_mediana),
             omnivora,
	     es(es_guerrera),
	     vuela,
             es(tiene_garras).

sirena :-    humanoide,animal,
	     hermosa,
             es(es_mediana),
             omnivora,
	     es(vive_en_grupo),
	     es(habita_mares),
             es(tiene_escamas),
             es(puede_cantar).


cecaelia :-  humanoide,animal,
	     hermosa,
             es(es_mediana),
             omnivora,
             es(habita_mares),
	     es(vive_en_soledad),
             es(tiene_ventosas).

dragon :-    cuadrupeda,
             es(es_feroz),
             es(es_grande),
	     carnivora,
	     vuela,
             es(usa_fuego).


fenix :-     bipeda,
             es(es_mediana),
	     omnivora,
	     vuela,
             es(usa_fuego).


/* Reglas de clasificacion */

bipeda :- es(se_sostiene_en_dos_patas),!.
bipeda :- es(se_sostiene_en_dos_pies),!.

cuadrupeda:- es(se_sostiene_en_cuatro_patas),!.

humanoide:- es(es_antropomorfo),!.

animal:- es(tiene_parte_animal),!.

vuela    :- es(tiene_alas), !.
vuela    :- es(es_magico).

carnivora:- es(come_humanos),!.
carnivora:- es(come_carne),!.

omnivora:- es(come_de_todo),!.
omnivora:- es(no_tiene_dieta_definida).

herbivora:- es(no_come_carne),!.
herbivora:- es(come_verduras),
            es(come_frutas),
            es(come_trigo),
            es(come_miel).

hermosa:- es(tiene_linda_apariencia),!.
hermosa:- es(es_majestuosa),!.

grotesca:- es(es_fea),!.
grotesca:- es(tiene_extrania_apariencia),!.


/* Funciones generadoras de preguntas */

ask(Pregunta) :-
        new(D, dialog('Veamos..')),
        /*get(D, confirm_centered, PosB),
        send(D, open, PosB),*/
        send(D, append(new(NameItem, text_item(Pregunta)))),/*Creamos un campo para que el usuario ingrese una respuesta*/
        send(D, append(button(ok, message(D, return,
                                          NameItem?selection)))),/*El boton ok recibe la respuesta escrita*/
        send(D, append(button(cancel, message(D, return, @nil)))),
        send(D, default_button(ok)),
        get(D, confirm_centered, Respuesta),
        free(D),/*Cerramos la ventana*/
        Respuesta \== @nil,
       ((Respuesta == 'si' ; Respuesta == 's')
       ->
       assert(cierto(Pregunta)) ;
       assert(falso(Pregunta)), fail).

ask_trampa  :-
        new(M, dialog('Veamos..')),
        send(M, append, label(label,'Esta es su criatura?')),
        send(M, append,button(si,message(M, return, 'si'))),
        send(M, append,button(no,message(M, return, 'no'))),
        send(M, default_button(si)),
        get(M, confirm_centered, PosB),
        free(M),
        PosB \== @nil,
        ((PosB == 'si')
       ->
       assertz_maquina,
        (PosB == 'no')
       ->
       assertz_jugador).

/*
ask(Pregunta) :-
    write('Tu criatura tiene la caracteristica de '),
    write(Pregunta),
    write('?(si/no) '),
    read(Respuesta),
    nl,
    ((Respuesta == si ; Respuesta == s)
      ->
       assert(cierto(Pregunta)) ;
       assert(falso(Pregunta)), fail).
*/

/* Verificar alguna caracteristica */
es(S) :-
   (cierto(S)
    ->
    true ;
    (falso(S)
     ->
     fail ;
     ask(S))).

/* Borrar todo si/no assertions */
borrar :- retract(cierto(_)),fail.
borrar :- retract(falso(_)),fail.
borrar.

/* Borra los puntajes */
borrar_puntaje :- retract(maquina(_)),fail.
borrar_puntaje :- retract(jugador(_)),fail.
borrar_puntaje.



















