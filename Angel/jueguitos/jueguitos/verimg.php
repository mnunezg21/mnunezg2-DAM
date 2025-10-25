<?php
if(!empty($_GET['codigo'])) {
    require 'miBD.php';
    $conexion = new miBD();
    $consulta = "SELECT codigo, caratula, tipo FROM caratulas WHERE codigo='" . $_GET['codigo'] . "'";
    $imgData = $conexion->getRegistros($consulta);
    $tipo = $imgData[0]["tipo"];
    $caratula = ($imgData[0]["caratula"]);
    header("Content-type: $tipo");
    header("Content-Length: " . strlen($caratula)); // Cambiado de filesize a strlen
    echo $caratula;
}