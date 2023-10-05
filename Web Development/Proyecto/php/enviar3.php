<?php
require 'conexion.php';

if (isset($_GET['email'])) {
    $sql = "SELECT * FROM carro where client_email='{$_GET['email']}'";
    $sql2 = $cn->query($sql);
    $usuario = mysqli_fetch_assoc($sql2);
    $id=$usuario['id'];
    $sql4 = "SELECT * FROM carro_product,carro where carro.username = usuarios.username and carro_product.cart_id = carro.id";
    $sql5 = $cn->query($sql4);
    $car = mysqli_fetch_assoc($sql5);
}
?>
<?php
header("Content-type: text/html;charset=\"utf-8\"");
$nombre = $usuario['username'];
$mail = 'sebastich123@gmail.com';
$asunto = 'Purchase';
$empresa = ;

$header = 'From: ' . $mail . " \r\n";
$header .= "X-Mailer: PHP/" . phpversion() . " \r\n";
$header .= "Mime-Version: 1.0 \r\n";
$header .= "Content-Type: text/plain";

$mensaje = "Thanks for buying with us " . $nombre . ",\r\n";
$mensaje .= "Subject: " . $asunto . " \r\n";
$mensaje .= "Your Pucharse are: " . $empresa . " \r\n";
$mensaje .= "Sent: " . date('d/m/Y', time());

$para = $usuario['email'];;
$asunto = 'A Message from Shop Monster';

if (mail($para, $asunto, utf8_decode($mensaje), $header))
?>