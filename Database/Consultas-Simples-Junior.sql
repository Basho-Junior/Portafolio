use animales

/*Insertar dos nuevos habitats*/

INSERT INTO habitats (id_habitat, descripcion, lugar) VALUES (6, 'Montania', 'Pakistan')
INSERT INTO habitats (id_habitat, descripcion, lugar) VALUES (7, 'Lago', 'America del Norte')

/*Insertar 5 animales adicionales, algunos de los cuales sean de esos nuevos habitats insertados*/

INSERT INTO animal(id_animal, especie, tipo, id_habitat) VALUES (5, 'Oso Panda', 'Vertebrado', 6)
INSERT INTO animal(id_animal, especie, tipo, id_habitat) VALUES (6, 'Ganso', 'Vertebrado', 7)
INSERT INTO animal(id_animal, especie, tipo, id_habitat) VALUES (7, 'Zorro', 'Vertebrado', 2)
INSERT INTO animal(id_animal, especie, tipo, id_habitat) VALUES (8, 'Coyote', 'Vertebrado', 5)
INSERT INTO animal(id_animal, especie, tipo, id_habitat) VALUES (9, 'Mosca', 'Invertebrado', 7)

/*Eliminar un habitat que no se esté usando para ningún animal*/

DELETE FROM habitats WHERE id_habitat = 4

/*Cambiar el habitat de algún animal existente*/

UPDATE animal SET id_habitat = 5 WHERE id_animal = 2

/*Seleccionar la especie de todos los animales cuyo habitat sea el 3*/

SELECT especie FROM animal WHERE id_habitat = 3

/*Seleccionar el habitat de todos los animales cuya especie comience con la letra ¨m¨.*/

SELECT animal.especie, habitats.descripcion FROM animal, habitats WHERE animal.especie LIKE 'm%' AND animal.id_habitat = habitats.id_habitat

/*Lo mismo que el anterior, pero que los mismos salgan listados en el orden de su id_animal*/

SELECT animal.especie, habitats.descripcion FROM animal, habitats WHERE animal.id_habitat = habitats.id_habitat AND animal.especie LIKE 'm%' ORDER BY id_animal   

/*Mostrar cada animal con la cantidad de caracteres que tiene especificado en la especie*/

SELECT *, LEN(animal.especie) as cant_caracteres FROM animal 

/*Lo mismo que el anterior, pero ordenado por la cantidad de caracteres descendentemente*/

SELECT *, LEN(animal.especie) as cant_caracteres FROM animal ORDER BY cant_caracteres DESC

/*ESTE ES UN RETO: Contar la cantidad de animales que hay de cada habitat.*/

SELECT habitats.descripcion, SUM(CASE habitats.id_habitat WHEN animal.id_habitat THEN 1 END) as total FROM habitats, animal GROUP BY habitats.descripcion