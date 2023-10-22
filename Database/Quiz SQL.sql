
/* Quiz Sql Server*/

/* Matrícula: 20180999   */



/*Antes de comenzar, familiarícese con la estructura de la BD gestion_paquetes*/



/* Consulta 1: Obtenga informacion legible de todos los paquetes con destino a Santiago*/
SELECT Paquete.* FROM paquete WHERE paquete.id_destino = 3

/* Consulta 2: Obtenga el peso promedio de los paquetes con destino a La Altagracia, asegurandose que solo salgan 
si el mismo es mayor o igual que 20*/
SELECT AVG(Paquete.peso) as Peso_promedio 
FROM Paquete 
WHERE Paquete.id_destino = 9 HAVING AVG(Paquete.peso) >= 20

/* Consulta 3: Obtenga todos los centros de distribucion y el paquete de mayor anchura que ha recibido y ordene los datos
por el nombre del centro de distribucion descendentemente*/
SELECT centro_distribucion.nombre_centro, Paquete.id_paquete, MAX(Paquete.ancho) as paquete_mayorancho
FROM centro_distribucion, Paquete 
WHERE Paquete.id_centro = centro_distribucion.id_centro 
GROUP BY centro_distribucion.nombre_centro, Paquete.id_paquete ORDER BY centro_distribucion.nombre_centro DESC

/* Consulta 4: Obtenga todos los eventos de transporte y calcule el tiempo que tarda cada uno en hacer su ruta*/
SELECT  evento_transporte.* ,DATEDIFF(MINUTE,evento_transporte.fecha_hora_inicio_ruta,evento_transporte.fecha_hora_fin_ruta) AS tiempo_transcurrido
FROM evento_transporte

/* Consulta 5: Obtenga la informacion de los paquetes que llegaron a su destino e indique el numero de eventos 
de transporte en que lo hicieron*/
SELECT Paquete.*, COUNT(CASE WHEN paquete_evento_transporte.id_paquete = paquete.id_paquete THEN 1 END) as numero_eventos
FROM paquete, paquete_evento_transporte, evento_transporte 
WHERE Paquete.id_paquete = paquete_evento_transporte.id_paquete AND paquete_evento_transporte.id_evento_transporte = evento_transporte.id_evento_transporte
AND evento_transporte.id_fin_ruta = paquete.id_destino
GROUP BY Paquete.id_paquete, Paquete.peso, paquete.largo, Paquete.ancho, paquete.fecha_envio, paquete.id_centro, paquete.id_destino

