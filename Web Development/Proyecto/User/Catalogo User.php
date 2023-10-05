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
        <!--Aqui Hacemos una lista con imgenes por categoria d elos productos-->
    <div class="center slideUp">
        <a href="cart/products.php"><img class="img-fluid" src="../img/Shopping-Cart-11.png" width="50" height="50" alt="Responsive image"/>Order now!</a>
    <div class="card-group">
        <div class="card">
          <img class="card-img-top" src="../img/Makeup.jpg" alt="Card image cap" width="600" height="246">
          <div class="card-body">
            <h5 class="card-title">MakeUp</h5>
            <p class="card-text">Cosmetics are substances or products used to enhance or alter the 
              appearance of the face or fragrance and texture of the body. We sell what is best for you.
            </div>
          <div class="card-footer">
            <a href="Maquillaje User.php" class="btn btn-primary">Show!</a>
          </div>
        </div>

        <div class="card">
          <img class="card-img-top" src="../img/Utensilios-de-cocina-indispensables_kiwiblog.jpg" alt="Card image cap" width="600" height="246">
          <div class="card-body">
            <h5 class="card-title">Cookware</h5>
            <p class="card-text">Cookware comprises cooking vessels, such as saucepans and frying pans, intended for use 
              on a stove or range cooktop. We sell different types of kitchen utensils.We sell different types of kitchen utensils.</p>
          </div>
          <div class="card-footer">
            <a href="Utensilios de cocina User.php" class="btn btn-primary">Show!</a>
          </div>
        </div>
        
        <div class="card">
          <img class="card-img-top" src="../img/22.jpg" alt="Card image cap" width="600" height="246">
          <div class="card-body">
            <h5 class="card-title">Cleaning tools</h5>
            <p class="card-text">Cleaning is the process of removing unwanted substances, such as dirt, infectious 
              agents, and other impurities, from an object or environment. We have cleaning utensils so that the family can live in an impeccable place.</p>
          </div>
          <div class="card-footer">
            <a href="Utensilios de limpieza User.php" class="btn btn-primary">Show!</a>
          </div>
        </div>
      </div>
        <div class="card-group">
            <div class="card">
              <img class="card-img-top" src="../img/iStock-500395950.jpg" alt="Card image cap" width="600" height="246">
              <div class="card-body">
                <h5 class="card-title">Clothes</h5>
                <p class="card-text">Clothing is a collective term for garments, items worn on the body. 
                  We have different types of clothes for women man, boy or girl.</p>
              </div>
              <div class="card-footer">
                <a href="Ropa User.php" class="btn btn-primary">Show!</a>
              </div>
            </div>
    
            <div class="card">
              <img class="card-img-top" src="../img/El-uso-de-los-electrodomesticos-en-la-cocina.jpg" alt="Card image cap" width="600" height="246">
              <div class="card-body">
                <h5 class="card-title">Home Appliances</h5>
                <p class="card-text">Home appliances are electrical/mechanical machines which accomplish some household functions, 
                  such as cooking, cleaning, or food preservation. We sell computers, microwaves and TVs.</p>
              </div>
              <div class="card-footer">
                <a href="Electrodomesticos User.php" class="btn btn-primary">Show!</a>
              </div>
            </div>
            
            <div class="card">
              <img class="card-img-top" src="../img/618.jpg" alt="Card image cap" width="600" height="246">
              <div class="card-body">
                <h5 class="card-title">Others</h5>
                <p class="card-text"></p>
              </div>
              <div class="card-footer">
                <a href="Otros User.php" class="btn btn-primary">Show!</a>
              </div>
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