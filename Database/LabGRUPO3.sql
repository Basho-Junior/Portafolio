

                                                          --GRUPOR 3 (JUNIOR HERNANDEZ, NICOL UREÑA, BRYAN VARGAS)

USE baseball_grupo3

/*1) Obtener la cantidad de partidos que se han jugado en una temporada específica.*/
SELECT Temporada.nombre_temporada, COUNT(Partido.codigo_partido) AS Cantidad_partidos
FROM Partido, Temporada
WHERE Partido.codigo_temporada = Temporada.codigo_temporada AND Temporada.codigo_temporada = 'TEMP1' GROUP BY Temporada.nombre_temporada

 

/*2) Para cada temporada existente diga la cantidad de partidos que se han jugado y organice los datos por la fecha de inicio de la temporada de forma descendente.*/
SELECT Temporada.nombre_temporada, Temporada.fecha_inicio, COUNT(Partido.codigo_partido) as Cantidad_partidos
FROM Partido, Temporada
WHERE Partido.codigo_temporada = Temporada.codigo_temporada GROUP BY Temporada.fecha_inicio, Temporada.nombre_temporada ORDER BY Temporada.fecha_inicio DESC

 

/*3) Obtener el promedio de carreras que se anotaron en cada estadio en una temporada dada.*/
SELECT Temporada.nombre_temporada, Estadio.nombre_lugar, AVG(Estadisticas.puntos) as Promedio_Carreras
FROM Estadio, Estadisticas, Partido, Temporada
WHERE Estadisticas.codigo_tipo_est = 'R-BAT' AND Partido.codigo_temporada = Temporada.codigo_temporada AND Estadisticas.codigo_partido = Partido.codigo_partido
AND Temporada.codigo_temporada = 'TEMP1' AND Partido.codigo_estadio = Estadio.codigo_estadio GROUP BY Temporada.nombre_temporada, Estadio.nombre_lugar

 

/*4) Lo mismo que la anterior, pero que solo traiga aquellos estadios cuyo promedio supere las 2 carreras*/
SELECT Temporada.nombre_temporada, Estadio.nombre_lugar, AVG(Estadisticas.puntos) as Promedio_Carreras
FROM Estadio, Estadisticas, Partido, Temporada
WHERE Estadisticas.codigo_tipo_est = 'R-BAT' AND Partido.codigo_temporada = Temporada.codigo_temporada AND Estadisticas.codigo_partido = Partido.codigo_partido
AND Temporada.codigo_temporada = 'TEMP1' AND Partido.codigo_estadio = Estadio.codigo_estadio GROUP BY Temporada.nombre_temporada, Estadio.nombre_lugar HAVING AVG(Estadisticas.puntos) > 2


 /*5) Obtener los pitchers con más ponches conseguidos para cada temporada, conjuntamente con información del equipo en el que jugó esa temporada*/

SELECT  Temporada.nombre_temporada,Estadisticas.codigo_jugador, Equipos.nombre_equipos, sum(EstadisticaS.puntos) AS ponches_temprada
FROM Estadisticas,Temporada, Partido, Persona_equipo, Equipos, Jugador
WHERE Estadisticas.codigo_partido = Partido.codigo_partido AND
          Partido.codigo_temporada = Temporada.codigo_temporada AND
		  Equipos.codigo_equipo = Persona_equipo.codigo_equipos AND
		  Persona_equipo.codigo_persona = Jugador.codigo_persona AND Jugador.codigo_jugador = Estadisticas.codigo_jugador AND
        Estadisticas.puntos = (SELECT MAX(Estadisticas.puntos) FROM Estadisticas WHERE Estadisticas.codigo_tipo_est = 'SO-PITCH')
GROUP BY Temporada.nombre_temporada,Estadisticas.codigo_jugador, Equipos.nombre_equipos
ORDER BY Temporada.nombre_temporada ASC, Estadisticas.codigo_jugador ASC

/*6) Obtener el total de homeruns anotados en cada partido jugado entre dos fechas especificadas.*/
SELECT Partido.codigo_partido, Partido.fecha_partido, SUM(Estadisticas.puntos) as Total_Homeruns
FROM Estadisticas, Partido
WHERE convert(date, Partido.fecha_partido) BETWEEN '2021-10-10' AND '2021-11-29' 
AND Estadisticas.codigo_partido = Partido.codigo_partido
AND Estadisticas.codigo_tipo_est = 'HR-BAT' GROUP BY Partido.codigo_partido, Partido.fecha_partido 



/*7) Obtener información del partido en donde se anotó la menor cantidad de carreras en una temporada dada.*/
SELECT Partido.codigo_partido, Partido.fecha_partido, Temporada.nombre_temporada
FROM Partido, Temporada, Estadisticas
WHERE Estadisticas.codigo_tipo_est = 'R-BAT' AND Partido.codigo_partido = Estadisticas.codigo_partido 
AND Partido.codigo_temporada = Temporada.codigo_temporada
AND Temporada.codigo_temporada = 'TEMP1' AND Estadisticas.puntos = (SELECT MIN(Estadisticas.puntos) FROM Estadisticas WHERE Estadisticas.codigo_tipo_est = 'R-BAT') GROUP BY Partido.codigo_partido, Temporada.nombre_temporada, Partido.fecha_partido


/*8) Traer los datos más relevantes de los jugadores que pueden jugar en más de una posición. */
SELECT Persona.nombre as 'Nombre', Persona.apellido as 'Apellido', Persona.Edad as 'Edad', Jugador.numero_jugador as 'Numero de Jugador',Equipos.nombre_equipos as 'Nombre de Equipo',COUNT(Jugador_posicion.codigo_posicion) as 'Posiciones jugadas'
	FROM Persona, Jugador, Equipos, Persona_equipo, Jugador_posicion
	WHERE Persona.codigo_persona = Jugador.codigo_persona
	AND Persona.codigo_persona = Persona_equipo.codigo_persona
	AND Persona_equipo.codigo_equipos = Equipos.codigo_equipo
	AND Jugador.codigo_jugador = Jugador_posicion.codigo_jugador 
	Group by Persona.nombre, Persona.apellido, Persona.Edad, Jugador.numero_jugador,Equipos.nombre_equipos,Jugador_posicion.codigo_jugador
	HAVING COUNT(Jugador_posicion.codigo_posicion) > 1

/*9)Indicar cuales equipos tienen jugadores que han pertenecido a más equipos que el suyo.*/
SELECT DISTINCT Equipos.nombre_equipos
FROM Persona_equipo JOIN 
(SELECT Persona_equipo.codigo_persona, COUNT(Persona_equipo.codigo_persona) AS cant_personas 
FROM Persona_equipo GROUP BY Persona_equipo.codigo_persona
HAVING COUNT(Persona_equipo.codigo_persona) > 1) s 
on Persona_equipo.codigo_persona = s.codigo_persona, 
Equipos 
WHERE Equipos.codigo_equipo = Persona_equipo.codigo_equipos




/*10) Obtener la cantidad de jugadores lesiones por equipo y fecha, organizando la información por equipo, fecha y cantidad de lesionados ascendentemente.*/
SELECT Equipos.nombre_equipos, Lesiones.fecha, COUNT(Lesiones.codigo_lesion) as 'Jugadores Lesionados'
	FROM Equipos,Lesiones,Persona_equipo, Jugador
	WHERE Equipos.codigo_equipo = Persona_equipo.codigo_equipos
	AND	Persona_equipo.codigo_persona = Jugador.codigo_persona
	AND Jugador.codigo_jugador = Lesiones.codigo_jugador
	Group by Equipos.nombre_equipos, Lesiones.fecha, Lesiones.codigo_jugador
	Order by Equipos.nombre_equipos, Lesiones.codigo_jugador,Lesiones.fecha asc