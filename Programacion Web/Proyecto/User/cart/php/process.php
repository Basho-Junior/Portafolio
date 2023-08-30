<?php 
session_start();
include "../../../php/conexion.php";
$user=$_SESSION['username'];
$esta="Processing";
if(!empty($_POST)){
$q1 = $cn->query("insert into carro(client_email,creado,estado,username,subtotal) value(\"$_POST[email]\",NOW(),'$esta','$user')");
if($q1){
$cart_id = $cn->insert_id;
foreach($_SESSION["carro"] as $c){
    $products = $cn->query("select * from productos where cod_product=$c[cod_product]");
    $r = $products->fetch_object();
    $t=$c["q"]*$r->precio;
$q1 = $cn->query("insert into carro_product(product_id,q,cart_id,total) value($c[cod_product],$c[q],$cart_id,'$t')");
}
unset($_SESSION["carro"]);
}
}
print "<script>alert('Thanks For Bought!');window.location='../products.php';</script>";

?>