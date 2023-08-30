<?php
require 'conexion.php';

if (isset($_GET['cod_product'])) {
    $sql = "SELECT * FROM productos where cod_product='{$_GET['cod_product']}'";
    $sql2 = $cn->query($sql);
    $usuario = mysqli_fetch_assoc($sql2);
}
?>
<?php
    include_once 'conexion.php';
    $no= $usuario['cod_product'];
    $sql = "Delete from productos where cod_product = '$no'";
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Product deleted!');window.location='../Admin/Admin.php';</script>";
    }
    else{
        print "<script>alert('Cheack and try again!');window.location='../Admin/Admin.php';</script>";
    }

?>