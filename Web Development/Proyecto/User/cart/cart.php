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
	<title>Shop Monster: Your Cart</title>
  <link
        rel = "shortcut icon" href = "../../img/la_sirena_r.png">
  <link
  rel = "stylesheet" href = "../css/estilos.css">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css">
</head>
<body>
<div class="container">
<br>
	<div class="row">
		<div class="col-md-12">
			<h1>Cart</h1>
			<a href="./products.php" class="btn btn-default">Products</a>
			<br><br>
<?php
/*
* Esta es la consula para obtener todos los productos de la base de datos.
*/
$products = $cn->query("select * from product");
if(isset($_SESSION['carro']) && !empty($_SESSION['carro'])):
?>
<table class="table table-bordered">
<thead>
	<th>Quantity</th>
	<th>Products</th>
	<th>Unit price</th>
	<th>Total</th>
	<th></th>
</thead>
<?php 
$O=0;
/*
* Apartir de aqui hacemos el recorrido de los productos obtenidos y los reflejamos en una tabla.
*/
foreach($_SESSION['carro'] as $c):
$products = $cn->query("select * from productos where cod_product=$c[cod_product]");
$r = $products->fetch_object();
	?>
<tr>
<th><?php echo $c["q"];?></th>
	<td><?php echo $r->nombre_producto;?></td>
	<td>$ <?php echo $r->precio; ?></td>
	<td>$ <?php echo $c["q"]*$r->precio; ?></td>
	<td style="width:260px;">
	<?php
	$found = false;
	foreach ($_SESSION['carro'] as $c) { if($c["cod_product"]==$r->cod_product){ $found=true; break; }}
	?>
		<a href="php/delfromcart.php?id=<?php echo $c["cod_product"];?>" class="btn btn-danger">Delete</a>
	</td>
</tr>
<?php 
$O += $r->precio;?>
<?php endforeach; ?>
<h2>Subtotal:$ <?php 
    echo $O;
   ?></h2>
</table>

<form class="form-horizontal" method="post" action="./php/process.php">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">Client´s E-mail:</label>
    <div class="col-sm-5">
      <input type="email" name="email" required class="form-control" id="inputEmail3" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['email'];
            }else{
                  
            }
            ?>" placeholder="Email del cliente">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-primary">Buy!</button>
    </div>
  </div>
</form>


<?php else:?>
	<p class="alert alert-warning">The cart is empty.</p>
<?php endif;?>

		</div>
	</div>
</div>
</body>

</html>