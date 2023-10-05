<?php
    include_once 'conexion.php';
    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
    $codigo = $_POST['code'];
    $nombre = $_POST['name'];
    $cantidad = $_POST['quan'];
    $total = $_POST['tot'];
    $datos=mysqli_fetch_array($sql2);
    $sql = "UPDATE carro_producto SET id = '$codigo', nombre_producto = '$nombre', cantidad = '$cantidad', total = '$total' where id = '$codigo'";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Cart Product updated!');window.location='../Admin/Admin.php';</script>";
    }
    else{
        print "<script>alert('Cheack and try again!');window.location='../Admin/Admin.php';</script>";
    }

?>