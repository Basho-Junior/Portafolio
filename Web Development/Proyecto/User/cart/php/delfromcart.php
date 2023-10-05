<?php
/*
* Eliminar un producto del carrito
*/
session_start();
if(!empty($_SESSION["carro"])){
	$cart  = $_SESSION["carro"];
	if(count($cart)==1){ unset($_SESSION["carro"]); }
	else{
		$newcart = array();
		foreach($cart as $c){
			if($c["cod_product"]!=$_GET["id"]){
				$newcart[] = $c;
			}
		}
		$_SESSION["carro"] = $newcart;
	}
}
print "<script>window.location='../cart.php';</script>";

?>

