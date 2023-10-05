<?php
include_once 'conexion.php';
$conn = new mysqli("localhost", "root", "", 'Shop_monster');
if(!$conn){
die('No se puede conectar'. mysql_error());
}



$nombre = $_POST["nombre"];
$apellido = $_POST['apellido'];
$usern = $_POST["user"];
$email = $_POST['email'];
$password = $_POST["pass"];
$direccion = $_POST['adr'];
$cone = $_POST["cone"];
$conpa = $_POST['conpa'];
if($cone==$email && $conpa==$password){
$sql1 =  $conn->query("SELECT * FROM usuarios WHERE username='".$usern."'");
if($dato= mysqli_fetch_array($sql1)){
if($dato["username"] == $usern){
    print "<script>alert('Username already exist!');window.location='../No User/Reg.html';</script>";
    $cn->close();
} else{
    
}
}
if($dato= mysqli_fetch_array($sql1)){
    if($dato["email"] == $email){
        print "<script>alert('Email is already signed!');window.location='../No User/Reg.html';</script>";
        $cn->close();
    } else{
        
    }
    }
else{

}
$sql = "insert into usuarios(contra, nombre, apellido, direccion, email, username) values ('$password','$nombre','$apellido','$direccion','$email','$usern')";
    if ((isset($password) && !empty($password)) && (isset($nombre)) && !empty($nombre)&& (isset($apellido)) && !empty($apellido)&& (isset($direccion)) && !empty($direccion)&& (isset($email)) && !empty($email)&& (isset($usern)) && !empty($usern)) {
        $resultado = $cn->query($sql);
        if ($resultado) {
            print "<script>alert('User Signed in!');window.location='../No User/Pagina Principal.html';</script>";
            //header('Location: Reg.html');
        } else {
            print "<script>alert('User No Signed!');window.location='../No User/Reg.html';</script>";
            //header('Location: Reg.html');
        }
    } else {
        echo "A Problem Ocurried";
    }
}else{
    print "<script>alert('Email confirm or password confirm are not the same!');window.location='../No User/Reg.html';</script>";
}
?>


