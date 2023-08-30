<?php
session_start();
?>
<?php 
    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
    if(!$conn){
    die('No se puede conectar'. mysql_error());
    }


    $usuario = $_POST["nombre"];
    $pass = $_POST["membresia"];

    $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$usuario."'");
    if($dato=mysqli_fetch_array($sql)){
        if($dato["username"]=="Admin" && $dato["contra"]==$pass){
            $_SESSION['loggedin'] = true;
            $_SESSION['username'] = $usuario;
            header('Location: ../Admin/Admin.php');
        }else{
    if($dato["contra"] == $pass){
        $_SESSION['loggedin'] = true;
        $_SESSION['username'] = $usuario;
        header('Location: ../User/Pagina Principal User.php');
        
    }
    else{
        print "<script>alert('Incorrect Password!');window.location='../No User/Log.html';</script>";
    }
    }
}else{
        print "<script>alert('Username Doesnt exist!');window.location='../No User/Log.html';</script>";
    }

?>