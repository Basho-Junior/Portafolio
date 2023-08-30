<?php
require 'conexion.php';

if (isset($_GET['cart_id'])) {
    $sql = "SELECT * FROM carro_product where cart_id='{$_GET['cart_id']}'";
    $sql2 = $cn->query($sql);
    $usuario = mysqli_fetch_assoc($sql2);
}
?>
<?php
    include_once 'conexion.php';
    $no= $usuario['cart_id'];
    $y="Received";
    $sql = "UPDATE carro SET creado = NOW(), estado = '$y' where id = '$no'";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Thanks for let us know!');window.location='../User/Pedidos.php';</script>";
    }
    else{
        print "<script>alert('Sorry a problem ocurried!');window.location='../User/Pedidos.php';</script>";
    }
?>