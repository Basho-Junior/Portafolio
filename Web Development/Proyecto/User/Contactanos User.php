<!--Aqui el usario puede mandar un mensaje al creador de la pagina-->
<?php
  session_start();
  include '../php/Funcion.php';
  verificar_sesion();
?>
<html>
    <head>
        <title>Shop Monster: Contact Us</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link
        rel = "stylesheet" href = "../css/estilos.css">
        <link
        rel = "stylesheet" href = "../css/main.css">
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
    <center><img id="or" class = "Informacion img-fluid float-right" src = "../img/Covers.png" width="544" height="463" alt="Responsive image"></center>
    <div id="Planti">
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
      <div class="container cont">
          <br>
          <form method="post" action="../php/enviar2.php">
          <center>  
            <p>
                  <label for="name">Name</label><br>
                  <input type="text" id="name" name="name" value="<?php 
                  $conn = new mysqli("localhost", "root", "", 'Shop_monster');
                  $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
                  if($dato=mysqli_fetch_array($sql)){
                    echo $dato['nombre'];
                  }else{
                  
                  }
                ?>" required/>
              </p>
              <p>
                  <label for="email">Email</label><br>
                  <input type="email" id="email" name="email" value="<?php 
                    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
                    $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
                    if($dato=mysqli_fetch_array($sql)){
                      echo $dato['email'];
                    }else{
                          
                    }
                    ?>" required/>
              </p>
              <p>
                  <label for="message">Subject</label><br>
                  <input type="text" id="subject" name="subject" required/><!--Aqui llenamos el campo con lo que s enos pide -->
              </p>
              <p>
                  <label for="message">Message</label><br>
                  <textarea id="message" name="message" rows="6" cols="30"></textarea>
              </p>
              <p>
                  <input type="submit" name="send" value="Send message" />
              </p>
            </center>
          </form>
      </div>
      <br>
      <br>
    </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
<footer id="creditos">Page made by Junior Hernandez only for educational purposes. Copyright © 2018 by Junior Hernandez.</footer>
</html>