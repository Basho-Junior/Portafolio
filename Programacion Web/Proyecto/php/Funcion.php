<?php
    function verificar_sesion(){
        if(!isset($_SESSION['username'])){
            unset($_SESSION);
            header("Location: ../No User/Pagina Principal.html");
        }
    }
?>