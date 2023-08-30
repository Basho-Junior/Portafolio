<!DOCTYPE html>
<html>
<head>
	<title>La Sirena: Mas de una Emocion</title>
    <?php
    require 'conexion.php';
    $sql="Select * from usuario";
    $consulta=$con->query($sql);
    ?>
</head>
<body>
    <table border=1px>
        <thead>
            <th>Id</th>
            <th>Nombre</th>
            <th>Correo</th>
        </thead>
        <tbody>
            <?php while($Usuario = mysqli_fetch_array($consulta)){ ?>
            <tr>
                <td><?php echo $Usuario ['id']; ?></td>
                <td><?php echo $Usuario ['Nombre']; ?></td>
                <td><?php echo $Usuario ['Correo']; ?></td>
            </tr>
            <?php } ?>
        </tbody>
        </table>
</body>
</html>