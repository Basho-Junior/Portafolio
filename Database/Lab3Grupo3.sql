                                                                     --GRUPOR 3 (JUNIOR HERNANDEZ, NICOL UREÑA, BRYAN VARGAS)


 

--1) Obtener el nombre cada localidad y el estadio que se encuentra en la misma.  Se quiere saber también donde hay localidades sin estadio. En estos casos el estadio saldría con valor de NULL.

SELECT Localidad.nombre as Nombre_localidad, Estadio.nombre_lugar AS Estadio_localidad
FROM Localidad LEFT JOIN Estadio
ON Localidad.codigo_localidad = Estadio.codigo_localidad

 
 

--2) Obtener el nombre y apellido de todos los jugadores y la fecha de la última lesión que ha sufrido. 
--Deben salir también los jugadores que no han sufrido lesiones, por lo que el valor de la fecha en estos casos debe ser NULL



SELECT DISTINCT Persona.nombre, Persona.apellido,
MAX(CASE WHEN Lesiones.codigo_jugador = Jugador.codigo_jugador THEN Lesiones.fecha Else NULL END) as Fecha_lesion
FROM Jugador, Persona, Lesiones
WHERE Persona.codigo_persona = Jugador.codigo_persona
GROUP BY Persona.nombre, Persona.apellido
 


--3) Obtener información de todos los jugadores con las posiciones que han jugado en un partido dado como equipo visitante. Deben salir todas las posiciones y todos los jugadores del equipo visitante. 
--Si hay jugadores del equipo visitante que no jugaron en el partido debe salir sin posición, y si hay alguna posición que no se desempeñó por un jugador, entonces el nombre del jugador de salir vacío para la posición.




 SELECT DISTINCT( Posicion.codigo_posicion),(case when Jugador_posicion.codigo_posicion=Posicion.codigo_posicion  then Jugador_posicion.codigo_jugador end) AS POS_EXP
FROM Jugador, Jugador_posicion, Equipos, Persona_equipo,Partido, Estadisticas,Posicion
WHERE (Jugador.codigo_jugador = Jugador_posicion.codigo_jugador) AND
Persona_equipo.codigo_equipos = Equipos.codigo_equipo AND
Persona_equipo.codigo_persona = Jugador.codigo_persona AND
Partido.equipo_visitante = Equipos.codigo_equipo AND
Partido.codigo_partido = 'PD1'



--4) Crear una vista que contenga todos la información de todos los managers que han ganado más de 2 partidos en la última temporada.

     CREATE VIEW inf_managers AS
        SELECT Persona.nombre,Persona.apellido,Equipos.nombre_equipos,COUNT(Partido.equipo_ganador) as 'Juegos Ganados'
        FROM Equipos,Persona,Entrenador,Partido
        WHERE Persona.codigo_persona = Entrenador.codigo_persona
        AND Equipos.codigo_entrenador = Entrenador.codigo_entrenador
        AND Equipos.codigo_equipo = Partido.equipo_ganador
        GROUP BY Persona.nombre,Persona.apellido,Equipos.nombre_equipos
        HAVING COUNT(Partido.equipo_ganador) > 2
 

--5) Crear una vista que contenga la siguiente información de los bateadores: nombre, apellido,  cantidad de sencillos, dobles, triples y jonrones que ha dado de por vida en la liga.

 

 
 CREATE VIEW BATEADORES AS
 SELECT DISTINCT Persona.nombre, Persona.apellido, Jugador_posicion.codigo_posicion,
   SUM(CASE WHEN  Estadisticas.codigo_tipo_est = '2B-BAT' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador THEN Estadisticas.puntos END)  AS dobles,
  SUM(CASE WHEN  Estadisticas.codigo_tipo_est = 'PA-BAT' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador THEN Estadisticas.puntos END)  AS triples,
  SUM(CASE WHEN  Estadisticas.codigo_tipo_est = 'H-BAT' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador THEN Estadisticas.puntos END)  AS sencillos,
   SUM(CASE WHEN  Estadisticas.codigo_tipo_est = 'HR-BAT' AND Estadisticas.codigo_jugador = Jugador.codigo_jugador THEN Estadisticas.puntos END)  AS jonrones
 FROM Persona,Estadisticas,Jugador, Jugador_posicion
 WHERE Persona.codigo_persona = Jugador.codigo_persona
 AND Jugador.codigo_jugador = Estadisticas.codigo_jugador
  AND Jugador.codigo_jugador = Jugador_posicion.codigo_jugador
 AND Jugador_posicion.codigo_posicion = 'POS10'
 GROUP BY Persona.nombre, Persona.apellido, Jugador_posicion.codigo_posicion

 

 

--6) Obtener la edad de cada jugador de la liga.

 
 

SELECT  Persona.Edad, Liga_beisbol.codigo_liga
FROM Persona, Equipos,Persona_equipo, Liga_beisbol, Jugador
WHERE Persona.codigo_persona = Persona_equipo.codigo_persona AND
        Equipos.codigo_liga = Liga_beisbol.codigo_liga AND
        Persona_equipo.codigo_equipos = Equipos.codigo_equipo AND
        Jugador.codigo_persona = Persona_equipo.codigo_persona
ORDER BY Persona.Edad ASC

 
 

--7) Obtener los días que han transcurrido desde que se fundó un equipo hasta que  jugó su primer partido.

 


SELECT DISTINCT DATEDIFF(DAY,(SELECT Equipos.fecha_fundacion FROM Equipos WHERE Equipos.codigo_equipo = 'ED1'),(SELECT MIN(Partido.fecha_partido) FROM Partido, Equipos WHERE Partido.equipo_local = 'ED1' or Partido.equipo_local = 'ED1')) AS dias_transcurridos
FROM Equipos, Partido

  

--8) Obtenga el nombre de todos los equipos, pero reemplace la vocal a del mismo por la letra x.

 

 SELECT TRANSLATE(Equipos.nombre_equipos,'aeiouAEIOU','xxxxxxxxxx') as nombres_reemplazados FROM Equipos

--9) Obtenga el nombre y apellido de todos los jugadores de un equipo dado y que todos salgan en letra mayúscula.

  

SELECT UPPER(Persona.nombre) AS Nombre, UPPER( Persona.apellido) AS Apellido
FROM Equipos, Persona,Jugador, Persona_equipo
WHERE Equipos.codigo_equipo = 'ED1' AND
    Persona.codigo_persona = Jugador.codigo_persona AND
    Persona_equipo.codigo_equipos = Equipos.codigo_equipo AND
    Persona_equipo.codigo_persona = Jugador.codigo_persona

 

 

--10) Que devuelva SI al lado de los datos de un partido, en caso de que en el mismo el equipo local haya anotado más carreras que el visitante. Debe devolver NO si esto no ha pasado. Puede llamar a esta columna LOCAL_GANO



 

SELECT Partido.codigo_partido, Partido.fecha_partido, 
CASE
    WHEN SUM(CASE WHEN Persona_equipo.codigo_equipos = Partido.equipo_local THEN Estadisticas.puntos END) > SUM(CASE WHEN Persona_equipo.codigo_equipos = Partido.equipo_visitante THEN Estadisticas.puntos END) THEN 'SI'
    ELSE 'NO'
END AS LOCAL_GANO
FROM Partido, Estadisticas, Tipo_estadistica, Persona_equipo, Jugador
WHERE Estadisticas.codigo_tipo_est = 'R-BAT' AND Tipo_estadistica.codigo_tipo_est = Estadisticas.codigo_tipo_est 
AND Partido.codigo_partido = Estadisticas.codigo_partido AND Estadisticas.codigo_jugador = Jugador.codigo_jugador 
AND Jugador.codigo_persona = Persona_equipo.codigo_persona
GROUP BY Partido.codigo_partido, Partido.fecha_partido
ORDER BY Partido.fecha_partido