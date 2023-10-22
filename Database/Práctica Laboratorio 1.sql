/*
----Práctica Laboratorio 1: Consultas simples a la liga de baseball
----Junior Hernández
----20180999
----10135069
*/

/*1) Obtener el nombre de todos los equipos que participan en la liga.*/
SELECT nombre_equipos as Equipos FROM Equipos

/*2) Lo mismo que en la consulta anterior, pero ordenando los resultados por el nombre del equipo ascendentemente.*/
SELECT nombre_equipos as Equipos_ordenados FROM Equipos ORDER BY nombre_equipos Asc

/*3) Obtener el nombre y apellido de todos los jugadores de un equipo en particular.*/
SELECT nombre, apellido FROM Persona, Persona_equipo, Jugador WHERE Persona.codigo_persona = Persona_equipo.codigo_persona AND Persona.codigo_persona = Jugador.codigo_persona AND Persona_equipo.codigo_equipos = 'ED1'

/*4) Obtener el nombre de los dos equipos (local y visitante) que participaron en cada partido de una temporada, conjuntamente con la fecha de dicho partido y ordenando los datos por dicha fecha desde el más reciente al más antiguo.*/
SELECT ELocal.nombre_equipos as Equipo_Local, EVisitante.nombre_equipos as Equipo_Visitante, Temporada.nombre_temporada, Partido.fecha_partido  
FROM Equipos as ELocal, Equipos as EVisitante, Temporada, Partido 
WHERE Elocal.codigo_equipo = Partido.equipo_local AND EVisitante.codigo_equipo = Partido.equipo_visitante AND Temporada.codigo_temporada = Partido.codigo_temporada AND Temporada.codigo_temporada = 'TEMP1' ORDER BY fecha_partido Desc

/*5) Obtener el nombre de cada jugador que haya dado 3 o más hits en un partido.*/
SELECT Persona.nombre, Estadisticas.puntos as cantidad_de_hits 
FROM Persona, Estadisticas, Jugador
WHERE Estadisticas.codigo_partido = 'PD1' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador AND Jugador.codigo_persona = Persona.codigo_persona AND Estadisticas.codigo_tipo_est = 'H-BAT' AND Estadisticas.puntos >= 3

/*6) Obtener la localidad de los estadios en los que se jugaron partidos en la última temporada, siempre y cuando ese estadio tenga en un su nombre la silaba ¨ba¨.*/
SELECT Localidad.nombre as Locacion, Estadio.nombre_lugar as Estadio
FROM Localidad, Estadio, Partido, Temporada 
WHERE Partido.codigo_temporada = 'TEMP1' AND Partido.codigo_estadio = Estadio.codigo_estadio AND Estadio.codigo_localidad = Localidad.codigo_localidad AND Estadio.nombre_lugar LIKE '%ba%' AND Temporada.codigo_temporada = Partido.codigo_temporada GROUP BY Estadio.nombre_lugar, Localidad.nombre, Temporada.fecha_final 

/*7) Obtener las distintas fechas en que se jugaron partidos en la temporada pasada.*/
SELECT Partido.fecha_partido, Temporada.nombre_temporada
FROM Partido, Temporada 
WHERE Partido.codigo_temporada = 'TEMP2'  AND Temporada.codigo_temporada = Partido.codigo_temporada 

/*8) Obtener el apellido y número de camiseta de los pitchers que han ponchado a más de 3 jugadores en un partido.*/
SELECT Persona.nombre, Persona.apellido, Jugador.numero_jugador, Estadisticas.puntos as cantidad_de_ponches 
FROM Persona, Estadisticas, Jugador, Jugador_posicion
WHERE Estadisticas.codigo_partido = 'PD1' AND Jugador_posicion.codigo_jugador = Jugador.codigo_jugador AND Jugador_posicion.codigo_posicion = 'POS1' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador AND Jugador.codigo_persona = Persona.codigo_persona AND Estadisticas.codigo_tipo_est = 'SO-PITCH' AND Estadisticas.puntos > 3

/*9) Lo mismo que el anterior, pero saque también información del partido en donde eso sucedió y el equipo al que pertenecen dicho pitcher.*/
SELECT Persona.nombre, Persona.apellido, Partido.fecha_partido as Fecha_Partido, Equipos.nombre_equipos as Equipo, Jugador.numero_jugador, Estadisticas.puntos as cantidad_de_ponches 
FROM Persona, Estadisticas, Jugador, Jugador_posicion, Partido, Equipos, Persona_equipo
WHERE Jugador_posicion.codigo_jugador = Jugador.codigo_jugador AND Partido.codigo_partido = Estadisticas.codigo_partido AND Equipos.codigo_equipo = Persona_equipo.codigo_equipos 
AND Jugador_posicion.codigo_posicion = 'POS1' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador AND Persona_equipo.codigo_persona = Persona.codigo_persona
AND Jugador.codigo_persona = Persona.codigo_persona AND Estadisticas.codigo_tipo_est = 'SO-PITCH' AND Estadisticas.puntos > 3

/*10) Lo mismo que el anterior, pero ordene la información obtenida por fecha ascendentemente y por la cantidad de ponches ascendentemente.*/
SELECT Persona.nombre, Persona.apellido, Partido.fecha_partido as Fecha_Partido, Equipos.nombre_equipos as Equipo, Jugador.numero_jugador, Estadisticas.puntos as cantidad_de_ponches 
FROM Persona, Estadisticas, Jugador, Jugador_posicion, Partido, Equipos, Persona_equipo
WHERE Jugador_posicion.codigo_jugador = Jugador.codigo_jugador AND Partido.codigo_partido = Estadisticas.codigo_partido AND Equipos.codigo_equipo = Persona_equipo.codigo_equipos 
AND Jugador_posicion.codigo_posicion = 'POS1' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador AND Persona_equipo.codigo_persona = Persona.codigo_persona
AND Jugador.codigo_persona = Persona.codigo_persona AND Estadisticas.codigo_tipo_est = 'SO-PITCH' AND Estadisticas.puntos > 3 ORDER BY Fecha_Partido ASC, cantidad_de_ponches 