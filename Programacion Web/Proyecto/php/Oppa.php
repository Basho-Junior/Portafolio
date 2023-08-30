<?php
require 'conexion.php';
if ($_GET['cart_id']==0){
    print "<script>alert('Sorry but the product is already sent!');window.location='../User/Pedidos.php';</script>";
}else{
if (isset($_GET['cart_id'])) {
    $sql = "SELECT * FROM carro_product where cart_id='{$_GET['cart_id']}'";
    $sql2 = $cn->query($sql);
    $usuario = mysqli_fetch_assoc($sql2);
}
}
?>
<?php
    include_once 'conexion.php';
    $no= $usuario['cart_id'];
    $y="Cancelled";
    $sql = "UPDATE carro SET creado = NOW(), estado = '$y' where id = '$no'";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Ok!');window.location='../User/Pedidos.php';</script>";
    }
    else{
        print "<script>alert('Sorry a problem ocurried!');window.location='../User/Pedidos.php';</script>";
    }
?>