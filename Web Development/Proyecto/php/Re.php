<?php
    $response_recaptcha=$_POST['g-recaptcha-response'];
    if(isset($response_recaptcha)&&$response_recaptcha){
        $secret = "6Lcu1VgUAAAAAHNPoeL6hNroU-cfDfYr6fa6_pPb";
        $ip=$_SERVER['REMOTE_ADDR'];
        $validation_server= file_get_contents("https://www.google.com/recaptcha/api/siteverify?secret=$secret
        &response=$response_recaptcha&remoteip=$ip");
        include 'insertar.php';
    }else{
        print "<script>alert('Please check the captcha!');window.location='../No User/Reg.html';</script>";
    }
?>