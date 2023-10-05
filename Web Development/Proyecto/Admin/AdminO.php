<?php
  session_start();
  include '../php/Funcion.php';
  verificar_sesion();
?>
<html>
    <head>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">   
            <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <meta name="HandheldFriendly" content="true"> 
            <title>Shop Monster: Administrator Page</title>
            <meta charset="utf-8">
            <script src="../JS/funciones.js"></script>
        <link
        rel = "stylesheet" href = "../css/main.css">
            <link
        rel = "stylesheet" href = "../css/Ad.css">
        <link
        rel = "shortcut icon" href = "../img/la_sirena_r.png">
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <header class = "head-ad">
        <br>
        <img id = "imagen1" src = "../img/user-male-icon.png" width="50" height="50" alt="Responsive image"><span id = "Letras1">Welcome Admin!</span>
        <a class="nav-link out" href="../php/Very.php"><b>Log out</b></a>
        <br>
    </header>
    <body>
            <div class="row">
                    <div class="col-3">
                      <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                        <hr>
                        <a class="nav-link" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">DashBoard</a>
                        <hr>
                        <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">Accounts</a>
                        <hr>
                        <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Products</a>
                        <hr>
                        <a class="nav-link active" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Orders</a>
                      </div>
                    </div>
                    <div class="col-9">
                      <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"></div>
                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                        <br>
                        <center><nav class="navbar navbar-light bg-light">
                          <a class="navbar-brand">Search an Account!</a>
                          <form class="form-inline" action="AdminU.php" method="post">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busU" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                          </form>
                          </nav>
                        <br>
                        <h1>Accounts<span class="badge badge-secondary">Shop Monster</span></h1>
                        <br>
                        </center>
                          <?php
                              require '../php/conexion.php';
                              $sql="Select username, nombre, apellido, email, direccion from usuarios";
                              $consulta= $cn->query($sql);
                              ?>
                              <table id="tabla" class="tabla">
                                <thead>
                                  <th>Username</th>
                                  <th>Name</th>
                                  <th>Last-name</th>
                                  <th>E-mail</th>
                                  <th>Address</th>
                                </thead>
                                <tbody>
                                  <?php while ($productos=mysqli_fetch_array($consulta)){?>
                                  <tr>
                                    <td><?php echo $productos['username'];?></td>
                                    <td><?php echo $productos['nombre'];?></td>
                                    <td><?php echo $productos['apellido'];?></td>
                                    <td><?php echo $productos['email'];?></td>
                                    <td><?php echo $productos['direccion'];?></td>
                                  </tr>
                                    <?php } ?>
                                  </tbody>
                                  </table></div>
                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"> 
                          <br>
                          <center><nav class="navbar navbar-light bg-light">
                          <a class="navbar-brand">Search a Product!</a>
                          <form class="form-inline" action="AdminPro.php" method="post">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busP" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                          </form>
                          </nav>
                        <br>
                        <h1>Products<span class="badge badge-secondary">Shop Monster</span></h1>
                        <br>
                        </center>
                        <input type="button" class="btn btn-primary float-right" data-toggle="modal" data-target="#exampleModal2" data-whatever="@mdo" value="Add Products">
                          <br>
                          <br>
                          <?php
                              require '../php/conexion.php';
                              $sql="Select cod_product, nombre_producto,precio, cantidad, categorias.nombre from productos, categorias where productos.id_categoria = categorias.id_categoria";
                              $consulta= $cn->query($sql);
                              ?>
                              <table id="tabla" class="tabla">
                                <thead>
                                  <th>Product´s Code</th>
                                  <th>Products</th>
                                  <th>Prices</th>
                                  <th>Quantity</th>
                                  <th>Category</th>
                                  <th></th>
                                  <th></th>
                                </thead>
                                <tbody>
                                  <?php while ($productos=mysqli_fetch_array($consulta)){
                                    $id=$productos['cod_product'];
                                    $nom=$productos['nombre_producto'];
                                    $pre=$productos['precio'];
                                    $can=$productos['cantidad'];
                                    $ca=$productos['nombre'];
                                    $datos=$id."||".$nom."||".$pre."||".$can."||".$ca;
                                    ?>
                                  <tr>
                                  <?php 
                                    if($productos['cantidad'] < 10){
                                      print"<script>alert('You have a product less than 10!');</script>";
                                    }
                                    ?>
                                    <td><?php echo $productos['cod_product'];?></td>
                                    <td><?php echo $productos['nombre_producto'];?></td>
                                    <td><?php echo $productos['precio'];?></td>
                                    <td><?php echo $productos['cantidad'];?></td>
                                    <td><?php echo $productos['nombre'];?></td>
                                    <td><button onclick="agregaform('<?php 
                                    echo $datos;
                                    ?>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Edit</button></td>
                                    <td><a href="../php/Delete.php?cod_product=<?php echo $productos['cod_product']; ?>" class="btn btn-primary">Delete</a></td>
                                  </tr>
                                    <?php } ?>
                                  </tbody>
                                  </table>
                                  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Edit This Product</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                  <form class="form__reg" action="../php/Upda.php" method="post">
                                    <div class="form-group">
                                      <label for="recipient-name" class="col-form-label">Product Code:</label>
                                      <input type="text" class="form-control" id="recipient-code" name="code">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Name:</label>
                                      <input type="text" class="form-control" id="recipient-name" name="name">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Price:</label>
                                      <input type="text" class="form-control" id="recipient-price" name="pri">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Quantity:</label>
                                      <input type="text" class="form-control" id="recipient-quantity" name="quan">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Category:</label>
                                      <select id="recipient-category" name="cat" class="form-control">
                                        <option value = "Makeup">MakeUp</option>
                                        <option value = "Cookware">Cookware</option>
                                        <option value = "Cleaning tools">Cleaning tools</option>
                                        <option value = "Clothes">Clothes</option>
                                        <option value = "Home appliances">Home appliances</option>
                                        <option value = "Other">Other</option>
                                      </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                  <input  class="btn btn-primary" type="submit" value="Save">
                                </div>
                                </form>
                              </div>
                            </div>
                          </div>
                          <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                              <div class="modal-content">
                                <div class="modal-header">
                                  <h5 class="modal-title" id="exampleModalLabel">Add a Product</h5>
                                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                  </button>
                                </div>
                                <div class="modal-body">
                                  <form class="form__reg" action="../php/Add.php" method="post">
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Name:</label>
                                      <input type="text" class="form-control" id="recipient-name" name="name">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Price:</label>
                                      <input type="text" class="form-control" id="recipient-price" name="pri">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Quantity:</label>
                                      <input type="text" class="form-control" id="recipient-quantity" name="quan">
                                    </div>
                                    <div class="form-group">
                                      <label for="message-text" class="col-form-label">Product Category:</label>
                                      <select id="recipient-category" name="cat" class="form-control">
                                        <option value = "Makeup">MakeUp</option>
                                        <option value = "Cookware">Cookware</option>
                                        <option value = "Cleaning tools">Cleaning tools</option>
                                        <option value = "Clothes">Clothes</option>
                                        <option value = "Home appliances">Home appliances</option>
                                        <option value = "Other">Other</option>
                                      </select>
                                    </div>
                            
                                </div>
                                <div class="modal-footer">
                                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                  <input  class="btn btn-primary" type="submit" value="Add">
                                </div>
                                </form>
                                </div>
                                  </div>
                                  </div>
                        </div>
                        <div class="tab-pane fade show active" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                        <br>
                        <center><nav class="navbar navbar-light bg-light">
                          <a class="navbar-brand">Search an Order´s Account!</a>
                          <form class="form-inline" action="AdminO.php" method="post">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" name="busO" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                          </form>
                          </nav>
                        <br>
                        <h1>Orders<span class="badge badge-secondary">Shop Monster</span></h1>
                        <br>
                        </center>
                        <?php
                              require '../php/conexion.php';
                              if($_POST['busO']==""||empty($_POST['busO'])){
                              $sql="Select carro_product.cart_id, carro_product.id, usuarios.username,productos.nombre_producto,categorias.nombre,carro.creado,carro_product.q,carro_product.total,carro.estado
                              from productos, categorias, carro, carro_product, usuarios  where productos.id_categoria = categorias.id_categoria and carro_product.product_id = productos.cod_product and carro_product.cart_id = carro.id and usuarios.username = carro.username";
                              $consulta= $cn->query($sql);
                              ?>
                              <table id="tabla" class="tabla">
                              <thead>
                                <th>Username</th>
                                <th>Product</th>
                                <th>Category</th>
                                <th>Purchase Date</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Status</th>
                                <th></th>
                                <th></th>
                              </thead>
                              <tbody>
                                <?php while ($productos=mysqli_fetch_array($consulta)){
                                  $code=$productos['id'];
                                  $pro=$productos['nombre_producto'];
                                  $canti=$productos['q'];
                                  $to=$productos['total'];
                                  $datos2=$code."||".$pro."||".$canti."||".$to;
                                  ?>
                                <tr>
                                  <td><?php echo $productos['username'];?></td>
                                  <td><?php echo $productos['nombre_producto'];?></td>
                                  <td><?php echo $productos['nombre'];?></td>
                                  <td><?php echo $productos['creado'];?></td>
                                  <td><?php echo $productos['q'];?></td>
                                  <td><?php echo $productos['total'];?></td>
                                  <td><?php echo $productos['estado'];?></td>
                                  <td><a href="../php/Sen.php?cart_id=<?php 
                                  if($productos['estado']=="Cancelled" || $productos['estado']=="Received"){
                                    echo 0;
                                  }else{
                                  echo $productos['cart_id']; } ?>" class="btn btn-danger">Send</a></td>
                                  <td><button onclick="agregaform2('<?php 
                                  echo $datos2;
                                  ?>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal3" data-whatever="@mdo">Edit</button></td>
                                </tr>
                                  <?php }
                                  }else{
                                    $sql="Select carro_product.cart_id, carro_product.id, usuarios.username,productos.nombre_producto,categorias.nombre,carro.creado,carro_product.q,carro_product.total,carro.estado
                              from productos, categorias, carro, carro_product, usuarios  where productos.id_categoria = categorias.id_categoria and carro_product.product_id = productos.cod_product and carro_product.cart_id = carro.id and usuarios.username = carro.username and (carro.estado like '%".$_POST['busO']."%' or carro.username like '%".$_POST['busO']."%')";
                              $consulta= $cn->query($sql);
                              ?>
                               <table id="tabla" class="tabla">
                               <thead>
                                 <th>Username</th>
                                 <th>Product</th>
                                 <th>Category</th>
                                 <th>Purchase Date</th>
                                 <th>Quantity</th>
                                 <th>Total</th>
                                 <th>Status</th>
                                 <th></th>
                                 <th></th>
                               </thead>
                               <tbody>
                                 <?php while ($productos=mysqli_fetch_array($consulta)){
                                   $code=$productos['id'];
                                   $pro=$productos['nombre_producto'];
                                   $canti=$productos['q'];
                                   $to=$productos['total'];
                                   $datos2=$code."||".$pro."||".$canti."||".$to;
                                   ?>
                                 <tr>
                                   <td><?php echo $productos['username'];?></td>
                                   <td><?php echo $productos['nombre_producto'];?></td>
                                   <td><?php echo $productos['nombre'];?></td>
                                   <td><?php echo $productos['creado'];?></td>
                                   <td><?php echo $productos['q'];?></td>
                                   <td><?php echo $productos['total'];?></td>
                                   <td><?php echo $productos['estado'];?></td>
                                   <td><a href="../php/Sen.php?cart_id=<?php 
                                   if($productos['estado']=="Cancelled" || $productos['estado']=="Received"){
                                     echo 0;
                                   }else{
                                   echo $productos['cart_id']; } ?>" class="btn btn-danger">Send</a></td>
                                   <td><button onclick="agregaform2('<?php 
                                   echo $datos2;
                                   ?>')" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal3" data-whatever="@mdo">Edit</button></td>
                                 </tr>
                                   <?php } } ?>
                                 </tbody>
                                 </table>
                                 <div class="modal fade" id="exampleModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                 <div class="modal-dialog" role="document">
                                   <div class="modal-content">
                                     <div class="modal-header">
                                       <h5 class="modal-title" id="exampleModalLabel">Edit This Product</h5>
                                       <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                         <span aria-hidden="true">&times;</span>
                                       </button>
                                     </div>
                                     <div class="modal-body">
                                       <form class="form__reg" action="../php/Upda2.php" method="post">
                                       <div class="form-group">
                                           <label for="message-text" class="col-form-label">Cart Code:</label>
                                           <input type="text" class="form-control" id="recipient-id" name="code">
                                         </div>
                                         <div class="form-group">
                                           <label for="message-text" class="col-form-label">Product Name:</label>
                                           <input type="text" class="form-control" id="recipient-nombre" name="name">
                                         </div>
                                         <div class="form-group">
                                           <label for="message-text" class="col-form-label">Product Quantity:</label>
                                           <input type="text" class="form-control" id="recipient-cantidad" name="quan">
                                         </div>
                                         <div class="form-group">
                                           <label for="message-text" class="col-form-label">Total:</label>
                                           <input type="text" class="form-control" id="recipient-total" name="tot">
                                         </div>
                           
                               </div>
                               <div class="modal-footer">
                                 <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                 <input  class="btn btn-primary" type="submit" value="Save">
                               </div>
                               </form>
                       </div>
                     </div>
                   </div>
                 </div>
                 

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>   
    </body>
</html>