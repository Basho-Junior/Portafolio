<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
    <link
        rel = "shortcut icon" href = "../../img/la_sirena_r.png">
	    <title>Shop Monster: Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>

            <?php
            $cn = new mysqli("localhost", "root", "", 'Shop_monster');//Aqui establecemos la conexion colocando el host el usuario la contraseña y la base datos a utilizar en una variable
            if ($cn->connect_errno) {//si da error que mande un mensaje
                echo 'No se conocento a mysql';
            } else {

            }
            ?>
            

        </div>
    </body>
</html>

