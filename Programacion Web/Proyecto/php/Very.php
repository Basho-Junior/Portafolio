<?php
    session_start();
    session_destroy();//destruimos la sesion
    header("Location: ../No User/Pagina Principal.html");//volvemos a la pagina del no usuario
?>