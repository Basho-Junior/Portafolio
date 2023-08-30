<?php
/*
* Agrega el producto a la variable de sesion de productos.
*/
session_start();
include "../../../php/conexion.php";
$sql = $cn->query("SELECT * FROM Productos where cod_product = '".$_POST["cod_product"]."'");
$dato=mysqli_fetch_array($sql);
if(!empty($_POST)){
    if($_POST["q"]>$dato["cantidad"]){
        print "<script>alert('We dont have that quantity!');window.location='../products.php';</script>";
    }else{
	if(isset($_POST["cod_product"]) && isset($_POST["q"])){
		// si es el primer producto simplemente lo agregamos
		if(empty($_SESSION["carro"])){
			$_SESSION["carro"]=array( array("cod_product"=>$_POST["cod_product"],"q"=> $_POST["q"]));
		}else{
			// apartie del segundo producto:
			$cart = $_SESSION["carro"];
			$repeated = false;
			// recorremos el carrito en busqueda de producto repetido
			foreach ($cart as $c) {
				// si el producto esta repetido rompemos el ciclo
				if($c["cod_product"]==$_POST["cod_product"]){
					$repeated=true;
					break;
				}
			}
			// si el producto es repetido no hacemos nada, simplemente redirigimos
			if($repeated){
				print "<script>alert('Error: Cant double product!');</script>";
			}else{
				// si el producto no esta repetido entonces lo agregamos a la variable cart y despues asignamos la variable cart a la variable de sesion
				array_push($cart, array("cod_product"=>$_POST["cod_product"],"q"=> $_POST["q"]));
				$_SESSION["carro"] = $cart;
			}
		}
		print "<script>window.location='../products.php';</script>";
	}
}
}
?>

