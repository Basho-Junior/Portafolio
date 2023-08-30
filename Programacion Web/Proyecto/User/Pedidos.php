<!--Aqui el usuario puede ver sus pedidos-->
<?php
session_start();
include '../php/Funcion.php';
verificar_sesion();
?>
<html>
    <head>
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
            .tabla{/* cambiamos el font y los bordes y el ancho d ela tabla*/
                font-family: sans-serif;
                border-collapse: collapse;
                width: 100%;

            }
            #sub{/*colocamos el color*/
              color: #fff;
            }

            .tabla td, .tabla th{/*editamos los bordes de la tabla*/
                border: 1px solid #ddd;
                padding: 8px;
            }
            .tabla tr {background-color: #f2f2f2;}/*Ponemos el color de fondo*/

            .tabla tr:hover {background-color: #ddd;}/*Le ponemos un hover*/

            .tabla th {/*Editamos los  headers de la tabla*/
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #d14242;
                color: white;
            }

        </style>
        <title>Shop Monster: Orders</title>
        <meta charset="utf-8">
     
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link
        rel = "stylesheet" href = "../css/estilos.css">
        <link
        rel = "shortcut icon" href = "../img/la_sirena_r.png">
    <body>
    <img id = "imagen1" src = "../img/la_sirena_r.png" width="210" height="210" alt="Responsive image"> 
    <header>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: rgb(198, 47, 47);">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="Pagina Principal User.php"><b>Home</b><span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="Catalogo User.php"><b>Catalogue</b></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="Reg User.php"><b>Account</b></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="Contactanos User.php"><b>Contact Us</b></a>
          </li>
          <li class="nav-item">
                      <a class="nav-link" href="Pedidos.php"><b>Check Your Buys</b></a>
          </li>
          <li class="nav-item">
              <a class="nav-link" href="../php/Very.php"><b>Log out</b></a>
          </li>
          <b><?php
            echo "¡Welcome " . $_SESSION['username'] . "!";
          ?></b>
      </ul>
        </div>
      </nav>
      </header>  
        <br>
<h1 id = "titulo">
<br>
</h1>
    <h2 class= "mas-codigo"><br></h2>
    <br>
        <!--Aqui creamos un tab para seleccionar entre ver los paquetes recibidos y los no recibidos-->
    <ul class="nav nav2 nav-tabs" id="myTab" role="tablist">
        <li class="nav-item">
          <a class="nav-link nav-link2 active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">No Received</a>
        </li>
        <li class="nav-item">
          <a class="nav-link nav-link2" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Received</a>
        </li>
    </ul>
    <div class="tab-content" id="myTabContent">
      <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab"> <center><h2 id="sub"><b><?php
            echo "¡Hi " . $_SESSION['username'] . " check your things!";
          ?></b></h2></center>
          <?php
          require '../php/conexion.php';
          $sql="Select carro_product.cart_id,carro.username,productos.cod_product,carro_product.product_id,productos.nombre_producto,productos.precio,carro.creado, carro_product.q, carro_product.total, carro.estado from productos, carro, carro_product where carro.username ='".$_SESSION['username']."' and carro.id = carro_product.cart_id and productos.cod_product=carro_product.product_id and (carro.estado='Processing' or carro.estado='Sent')";
          $consulta= $cn->query($sql);
          ?>
          <!--Aqui creamos el una tabla para ver los pedidos en estado de proceso o enviados-->
          <table id="tabla" class="tabla">
            <thead>
              <th>Products!</th>
              <th>Prices!</th>
              <th>Date!</th>
              <th>Quantity!</th>
              <th>Total!</th>
              <th>Status!</th>
              <th></th>
              <th></th>
            </thead>
            <tbody>
              <?php while ($productos=mysqli_fetch_array($consulta)){?>
              <tr>
                <td><?php echo $productos['nombre_producto'];?></td>
                <td><?php echo $productos['precio'];?></td>
                <td><?php echo $productos['creado'];?></td>
                <td><?php echo $productos['q'];?></td>
                <td><?php echo $productos['total'];?></td>
                <td><?php echo $productos['estado'];?></td>
                <td><a href="../php/Up.php?cart_id=<?php echo $productos['cart_id']; ?>" class="btn btn-danger">Received</a></td>
                <td><a href="../php/Oppa.php?cart_id=<?php
                 if($productos['estado']=="Sent"){
                    echo 0;
                 }else{
                 echo $productos['cart_id']; } ?>" class="btn btn-danger">Cancel</a></td>
              </tr>
                <?php } ?>
              </tbody>
              </table></div>
                  <!--Aqui creamos la tabla para los pedidos ya recibidos -->
      <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab"><h2 id="sub"><center><b><?php
            echo "¡Hi " . $_SESSION['username'] . " check your things!";
          ?></b></h2></center>
          <?php
          require '../php/conexion.php';
          $sql="Select carro.username,productos.cod_product,carro_product.product_id,productos.nombre_producto,productos.precio,carro.creado, carro_product.q, carro_product.total, carro.estado from productos, carro, carro_product where carro.username ='".$_SESSION['username']."' and carro.id = carro_product.cart_id and productos.cod_product=carro_product.product_id and carro.estado='Received'";
          $consulta= $cn->query($sql);
          ?>
          <table id="tabla" class="tabla">
            <thead>
              <th>Products!</th>
              <th>Prices!</th>
              <th>Date!</th>
              <th>Quantity!</th>
              <th>Total!</th>
              <th>Status!</th>
              <th></th>
            </thead>
            <tbody>
              <?php while ($productos=mysqli_fetch_array($consulta)){?>
              <tr>
                <td><?php echo $productos['nombre_producto'];?></td>
                <td><?php echo $productos['precio'];?></td>
                <td><?php echo $productos['creado'];?></td>
                <td><?php echo $productos['q'];?></td>
                <td><?php echo $productos['total'];?></td>
                <td><?php echo $productos['estado'];?></td>
                <td><a class="btn btn-danger">Received</a></td>
              </tr>
                <?php } ?>
              </tbody>
              </table></div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
<br>
<footer id="creditos">Page made by Junior Hernandez only for educational purposes. Copyright © 2018 by Junior Hernandez.</footer>
</html>