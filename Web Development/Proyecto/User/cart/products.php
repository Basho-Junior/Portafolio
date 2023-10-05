<?php
/*
* Este archio muestra los productos en una tabla.
*/
session_start();
include "../../php/conexion.php";
?>
<!DOCTYPE html>
<html>
<head>
<style>
			body{
    			background-image: url("Clothing Co..png");
    			background-repeat: no-repeat;
    			background-attachment: fixed;
    			font: message-box;
		    	font-size: 15px;
			}

            .table{
                font-family: sans-serif;
                border-collapse: collapse;
                width: 100%;

            }
            #sub{
              color: #fff;
            }

            .table td, .table th{
                border: 1px solid #ddd;
                padding: 8px;
            }
            .table tr {background-color: #f2f2f2;}

            .table tr:hover {background-color: #ddd;}

            .table th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #d14242;
                color: white;
            }

        </style>
	<link
        rel = "shortcut icon" href = "../../img/la_sirena_r.png">
	<title>Shop Monster: Products</title>
	<link
    rel = "stylesheet" href = "../css/estilos.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
</head>
<body>
<div class="container">
	<br>
	<a href="../Catalogo User.php" class="btn btn-warning"><img class="img-fluid" src="../../img/arrow_back_black_192x192.png" width="40" height="40" alt="Responsive image"/><br>Catalogue</a>
	<br>
	<br>
	<nav class="navbar navbar-light bg-light">
	<a class="navbar-brand">Name Your Product!</a>
	<form class="form-inline" action="php/Buscar.php" method="post">
	  <input class="form-control mr-sm-2" type="search" placeholder="Search" name="bus" aria-label="Search">
	  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
	</form>
  </nav>
	<div class="row">
		<div class="col-md-12">
			<h1>Products</h1>
			<a href="./cart.php" class="btn btn-warning float-right"><img class="img-fluid" src="../../img/Shopping-Cart-11.png" width="40" height="40" alt="Responsive image"/> My Cart</a>
			<br><br>
<?php
/*
* Esta es la consula para obtener todos los productos de la base de datos.
*/
$products = $cn->query("select * from productos");
?>
<table class="table table-bordered">
<thead>
	<th>Products</th>
	<th>Price</th>
	<th></th>
</thead>
<?php 
/*
* Apartir de aqui hacemos el recorrido de los productos obtenidos y los reflejamos en una tabla.
*/
while($r=$products->fetch_object()):?>
<tr>
	<td><?php echo $r->nombre_producto;?></td>
	<td>$ <?php echo $r->precio;?></td>
	<td style="width:260px;">
	<?php
	$found = false;

	if(isset($_SESSION['carro'])){ foreach ($_SESSION['carro'] as $c) { if($c["cod_product"]==$r->cod_product){ $found=true; break; }}}
	?>
	<?php if($found):?>
		<a href="cart.php" class="btn btn-info">Added</a>
	<?php else:?>
	<form class="form-inline" method="post" action="./php/addtocart.php">
	<input type="hidden" name="cod_product" value="<?php echo $r->cod_product; ?>">
	  <div class="form-group">
	    <input type="number" name="q" value="1" style="width:100px;" min="1" class="form-control" placeholder="Cantidad">
	  </div>
	  <button type="submit" class="btn btn-primary">Add to the cart</button>
	</form>	
	<?php endif; ?>
	</td>
</tr>
<?php endwhile; ?>
</table>

		</div>
	</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>