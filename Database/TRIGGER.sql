/*Pone el equipo ganador en Partidos tras cada insert en estadistica evaluando la suma de los puntos de cada equipo y el tipo de la misma*/

CREATE TRIGGER TR_ganador
on Estadisticas for insert
AS
set nocount on
declare @cod_equipo varchar(100), @cod_part varchar(100)
SELECT @cod_equipo = CASE
    WHEN SUM(CASE WHEN Persona_equipo.codigo_equipos = Partido.equipo_local THEN Estadisticas.puntos END) > SUM(CASE WHEN Persona_equipo.codigo_equipos = Partido.equipo_visitante THEN Estadisticas.puntos END) THEN Partido.equipo_local
    ELSE Partido.equipo_visitante
END 
FROM Partido, Estadisticas, Tipo_estadistica, Persona_equipo, Jugador
WHERE Estadisticas.codigo_tipo_est = 'R-BAT' AND Tipo_estadistica.codigo_tipo_est = Estadisticas.codigo_tipo_est 
AND Partido.codigo_partido = Estadisticas.codigo_partido AND Estadisticas.codigo_jugador = Jugador.codigo_jugador 
AND Jugador.codigo_persona = Persona_equipo.codigo_persona
GROUP BY Partido.equipo_local, Partido.equipo_visitante
SELECT @cod_part = codigo_partido FROM INSERTED
UPDATE Partido set Partido.equipo_ganador = @cod_equipo WHERE Partido.codigo_partido = @cod_part
GO

SELECT * FROM Partido
GO

/*
JUG19 - ED4
JUG10 - ED2
*/

INSERT INTO Estadisticas VALUES ('EST23', 'R-BAT', 'JUG19', 'POS10', 'PD2', 5)
GO

SELECT * FROM Partido
GO

/*Realemente fue interesante realizar mi primer trigger en sql aunque con anterioridad lo habia hecho pero en Mysql fue interesante volver verlos 
esta vez, para fue facil hacerlo, lo unico que podria decir que se hizo complicado fue intentar dar logica para que el trigger no tenga ningun fallo
al momento de ejecutarse de manera automatica*/