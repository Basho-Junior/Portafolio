<?php
header("Content-type: text/html;charset=\"utf-8\"");
$nombre = $_POST['name'];
$mail = $_POST['email'];
$asunto = $_POST['subject'];
$empresa = $_POST['message'];

$header = 'From: ' . $mail . " \r\n";
$header .= "X-Mailer: PHP/" . phpversion() . " \r\n";
$header .= "Mime-Version: 1.0 \r\n";
$header .= "Content-Type: text/plain";

$mensaje = "Este mensaje fue enviado por " . $nombre . ",\r\n";
$mensaje .= "Su e-mail es: " . $mail . " \r\n";
$mensaje .= "Asunto: " . $asunto . " \r\n";
$mensaje .= "Mensaje: " . $empresa . " \r\n";
$mensaje .= "Enviado el " . date('d/m/Y', time());

$para = 'sebastich123@gmail.com';
$asunto = 'Mensaje de mi sitio web';

if (mail($para, $asunto, utf8_decode($mensaje), $header)){
    print "<script>alert('Sent!');window.location='../No User/Contactanos.html';</script>";
}else{
    print "<script>alert('An error ocurried!');window.location='../No User/Contactanos.html';</script>";
}
?>