<?php
  session_start();//Aqui colocanos session start para dejar iniciada la sesion anterior
  include '../php/Funcion.php';//Incluimos una funcion php
  verificar_sesion();//Utilizamos la funcion de verificar_sesion para cuando cerremos la sesion
?>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">   
        <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="HandheldFriendly" content="true"> 
        <title>Shop Monster: Home</title>
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
              <li class="nav-item active"><!--Aqui creamos el menu poniendo la referencia donde van cada una-->
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
              <b><?php//Aqui ponemos un saludo al usuario
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
    <div id="carouselExampleControls" class="carousel slide informacion" data-ride="carousel"><!--Aqui creamos un slider con imagenes-->
              <div class="carousel-inner">
              <div class="carousel-item active">
                <img class="d-block w-100" src="../img/You have to expectthings of yourself beforeyou can do them.png" alt="First slide" width="720" height="630">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="../img/Brush Lettered Night Sky Nature Desktop Wallpaper.png" alt="Second slide" width="720" height="630">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="../img/Coral and Orange Patterned Cute Desktop Wallpaper.png" alt="Third slide" width="720" height="630">
              </div>
              <div class="carousel-item">
                <img class="d-block w-100" src="../img/Black and Yellow Illustration Desktop Wallpaper.png" alt="Third slide" width="720" height="630">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>
          <div id = "Info" class = "container-fluid"><!--Colocamos informacion con una imagen y otra de fondo-->  
                      <div class ="tossing">    
                          <center><img src="../img/ftgyuio_by_sody_pop-d9fvblo.png" width="290" height="250"></center>
                        </div>
                  <p><center>Shop Monster
                        Shop Monster is a web aplication that facilitates the
                        needs of the user at the time of making a purchase and the administration of different products.
                 
                          Is a test web APP for starters sellers in the marketing area that want to 
                          show what they got for their clients for them to be known today in the international market
                          economy Shop Monster still in test status any problem, bugs or suggestion please make us know by sending an 
                          email to give our users and clients the best service that we can do.<br>
                        <a href="Contactanos User.php">Click here for suggestions</a></center></p>
                      </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>

<footer id="creditos">Page made by Junior Hernandez only for educational purposes. Copyright © 2018 by Junior Hernandez.</footer>
</html>