<!--Llenaremos un formulario para editar la informacion del usuario si este lo desea-->
<?php
  session_start();
  include '../php/Funcion.php';
  verificar_sesion();
?>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop Monster: My Account</title>
        <meta charset="utf-8">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
        <link
        rel = "stylesheet" href = "../css/estilos.css">
        <link
        rel = "stylesheet" href = "../css/main.css">
        <link
        rel = "shortcut icon" href = "../img/la_sirena_r.png">
    <body background="../img/1920x1200-2943445-digital-art-solid-color___abstract-wallpapers.jpg">
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
    <div id ="todo">
    <div id = "LogReg" class="container">	
		<form class="form__reg" action="../php/Update.php" method="post">
            <center><h2>Your Account!</h2>
            <hr>
            <label for="nombre">Name</label>
            <input class="input input2" type="text" name="nombre" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');//llenamos de forma automatica los campos del usuario
            
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['nombre'];
            }else{
                  
            }
            ?>" disabled>
            <br>
            <label for="nombre">Last Name</label>
            <input class="input input2" type="text" name="apellido" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');
           
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['apellido'];
            }else{
                  
            }
            ?>" disabled>
            <br>
            <br>
            <label for="nombre">Username</label>
            <input class="input input2" type="text" name="Username" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');
           
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['username'];
            }else{
                  
            }
            ?>" disabled>
            <br>
            <br>
            <label for="nombre">E-mail</label>
            <input class="input input2" type="email" placeholder="&#9993; E-mail" name="email" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');
          
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['email'];
            }else{
                  
            }
            ?>">
            <br>
            <br>
            <label for="nombre">New Password</label>
            <input class="input input2" type="password" placeholder="&#128273; Password" name="newpass">
            <br>
            <label for="nombre">Confirm New Password</label>
            <input class="input input2" type="password" placeholder="&#128273; Confirm New Password" name="conewpa">
            <br>
            <br>
            <label for="nombre">Address</label>
            <input class="input input2" type="text" placeholder="&#128665; Address" name="direccion" value="<?php 
            $conn = new mysqli("localhost", "root", "", 'Shop_monster');
           
            $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
            if($dato= mysqli_fetch_array($sql)){
             echo $dato['direccion'];
            }else{
                  
            }
            ?>">
            <br>
            <br>
            <label for="nombre">Password</label>
            <input class="input input2" type="password" placeholder="&#128273; Password" name="pass" >
            <br>
            <input  class="btn__submit" type="submit" value="Save!">
            <br>
        </center>
        </form>
        </div>
    </div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>

<footer id="creditos">Page made by Junior Hernandez only for educational purposes. Copyright © 2018 by Junior Hernandez.</footer>
</html>