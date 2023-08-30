<?php
    include_once 'conexion.php';
    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
    $db_selected = mysql_select_db('id5792533_shop_monster', $conn);
    $nombre = $_POST['name'];
    $cantidad = $_POST['quan'];
    $precio = $_POST['pri'];
    $cat= $_POST['cat'];
    $sql2 = $conn->query("SELECT id_categoria FROM categorias where nombre = '$cat'");
    $datos= mysqli_fetch_array($sql2);
    $sql = "INSERT into productos(nombre_producto, cantidad, precio, id_categoria) values ('$nombre', '$cantidad', '$precio', '".$datos['id_categoria']."')";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Product added!');window.location='../Admin/Admin.php';</script>";
    }
    else{
        print "<script>alert('Cheack and try again!');window.location='../Admin/Admin.php';</script>";
    }

?>