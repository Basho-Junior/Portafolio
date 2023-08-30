<!--Con esta funcion cambiamos el estado del pedido a enviado-->
<?php
require 'conexion.php';
if ($_GET['cart_id']==0){//Una decesicion para aclara que si el id es igual a 0 es porque el pedido esta recivido o cancelado
    print "<script>alert('Sorry but the product is already received or cancelled!');window.location='../Admin/Admin.php';</script>";
}else{
if (isset($_GET['cart_id'])) {
    $sql = "SELECT * FROM carro_product where cart_id='{$_GET['cart_id']}'";//declaramos la sentencia sql
    $sql2 = $cn->query($sql);//hacemos que se ejecute
    $usuario = mysqli_fetch_assoc($sql2);//declaramos una variable para el valor seleccionado
}
}
?>
<?php
    include_once 'conexion.php';
    $sql3 = "SELECT carro_product.cart_id, carro_product.id, usuarios.username,productos.nombre_producto,categorias.nombre,carro.creado,carro_product.q,carro_product.total,carro.estado  
    from productos, categorias, carro, carro_product, usuarios  where productos.id_categoria = categorias.id_categoria and carro_product.product_id = productos.cod_product and carro_product.cart_id = carro.id and usuarios.username = carro.username";
    $sql4 = $cn->query($sql3);
    $usuario2 = mysqli_fetch_assoc($sql4);
    $no= $usuario['cart_id'];
    $y="Sent";
    $sql = "UPDATE carro SET creado = NOW(), estado = '$y' where id = '$no'";//actualizamos el estado del pedido con lo que dice la variable y
    $resultado = $cn->query($sql);
    if($resultado){
        print "<script>alert('Thanks for let us know!');window.location='../Admin/Admin.php';</script>";  
    }
    else{
        print "<script>alert('Sorry a problem ocurried!');window.location='../Admin/Admin.php';</script>";
    }
?>