<?php
    include_once 'conexion.php';
    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
    $codigo = $_POST['code'];
    $nombre = $_POST['name'];
    $cantidad = $_POST['quan'];
    $precio = $_POST['pri'];
    $cat= $_POST['cat'];
    $sql2 = $conn->query("SELECT id_categoria FROM categorias where nombre = '$cat'");
    $datos=mysqli_fetch_array($sql2);
    $sql = "UPDATE productos SET cod_product = '$codigo', nombre_producto = '$nombre', cantidad = '$cantidad', precio = '$precio', id_categoria = '".$datos['id_categoria']."' where cod_product = '$codigo'";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Product updated!');window.location='../Admin/Admin.php';</script>";
    }
    else{
        print "<script>alert('Cheack and try again!');window.location='../Admin/Admin.php';</script>";
    }

?>