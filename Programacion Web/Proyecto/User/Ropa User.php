<?php
  session_start();
  include '../php/Funcion.php';
  verificar_sesion();
?>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Monster: Catalogue</title>
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
    <div class="card-columns">
        <div class="card">
          <img class="card-img-top" src="../img/1.JPG" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">Mooncolour Womens Cold Shoulder Hollow Out Casual Tunic Solid Blouse Tops</h5>
            <p class="card-text">$10</p>
          </div>
        </div>
        <div class="card p-3">
          <blockquote class="blockquote mb-0 card-body">
            <img class="card-img" src="../img/2.JPG" alt="Card image">
            <p>Floral Print Chiffon Loose Shawl Kimono Cover up Shirt<br>
            $11
            </p>
            <footer class="blockquote-footer">
              <small class="text-muted">
                  <cite title="Source Title">Last updated 3 mins ago</cite>
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card">
          <img class="card-img-top" src="../img/3.JPG" alt="Card image cap">
          <div class="card-body">
            <h5 class="card-title">Moore Baby Kids Toddler Boy Printed Tops Pants Leggings Outfits Clothes Set 0-3 Y</h5>
            <p class="card-text">$11</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
        <div class="card bg-primary text-white text-center p-3">
          <blockquote class="blockquote mb-0">
            <img class="card-img" src="../img/4.JPG" alt="Card image">
            <p>Banana Bucket Floral Bomber Jacket Men<br>
            $18
            </p>
            <footer class="blockquote-footer">
              <small>
                <cite title="Source Title">Last updated 3 mins ago</cite>
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card text-center">
          <div class="card-body">
            <img class="card-img" src="../img/5.JPG" alt="Card image">
            <h5 class="card-title">Destroyed Ripped Slim Fit Skinny Stretch Denim Jeans</h5>
            <p class="card-text">$26</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
        <div class="card">
          <img class="card-img" src="../img/6.JPG" alt="Card image">
        </div>
        <div class="card p-3 text-right">
          <blockquote class="blockquote mb-0">
            <p>Skate Shoes Foot Massage Fashion Shoes for Men<br>
              $14
            </p>
            <footer class="blockquote-footer">
              <small class="text-muted">
                  <cite title="Source Title">Last updated 3 mins ago</cite>
              </small>
            </footer>
          </blockquote>
        </div>
        <div class="card">
          <div class="card-body">
            <img class="card-img" src="../img/7.JPG" alt="Card image">
            <h5 class="card-title">Jordan Air II (2) Retro Decon</h5>
            <p class="card-text">$70</p>
            <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
          </div>
        </div>
      </div>
        <img src="../img/preparar-archivos-para-Imprimir.png" class="img-fluid" alt="Responsive image">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
<footer id="creditos">Page made by Junior Hernandez only for educational purposes. Copyright © 2018 by Junior Hernandez.</footer>
</html>