<?php
session_start();
?>
<?php
    include_once 'conexion.php';
    $conn = new mysqli("localhost", "root", "", 'Shop_monster');
    if(!$conn){
    die('No se puede conectar'. mysql_error());
    }


    $email = $_POST['email'];
    $password=$_POST["pass"];
    $newpassword=$_POST["newpass"];
    $conpassword = $_POST["conewpa"];
    $direccion = $_POST['direccion'];
    $username = $_SESSION['username'];
    $sql2 = $conn->query("SELECT * FROM usuarios");
    if($dato1= mysqli_fetch_array($sql2)){
        if($dato1["email"] == $email){
            print "<script>alert('Email is already signed!');window.location='../User/Reg User.php';</script>";
        }
            
            else{

        }
    }
        else{

    }
    if($conpassword==$newpassword){
    $sql = $conn->query("SELECT * FROM usuarios WHERE username='".$_SESSION['username']."'");
    if($dato= mysqli_fetch_array($sql)){
    if($dato["contra"] == $password){
    if (empty($newpassword)){
        $sql = "UPDATE usuarios SET email = '$email', direccion='$direccion' where username='$username'";
    $resultado = $cn->query($sql);
        if ($resultado) {
            print "<script>alert('User Modified!');window.location='../User/Reg User.php';</script>";
            //header('Location: Reg.html');
        } else {
            print "<script>alert('User No Modified!');window.location='../User/Reg User.php';</script>";
            //header('Location: Reg.html');
        }
    }else{
    $sql = "UPDATE usuarios SET email = '$email', contra = '$newpassword', direccion='$direccion' where username='$username'";
    $resultado = $cn->query($sql);
        if ($resultado) {
            print "<script>alert('User Modified!');window.location='../User/Reg User.php';</script>";
            //header('Location: Reg.html');
        } else {
            print "<script>alert('User No Modified!');window.location='../User/Reg User.php';</script>";
            //header('Location: Reg.html');
        }
    }
 } else {
        echo "<script>alert('Enter Your Password!');window.location='../User/Reg User.php';</script>";
    }
    }else{
        echo"no";
    }
}else{
    echo "no";
}
?>