<?php
session_start();
if (!empty($_GET['codigo'])) {
    require 'miBD.php';
    $conexion = new miBD();
    $consulta = "DELETE FROM caratulas WHERE codigo='" . $_GET['codigo'] . "'";
    $result = $conexion->modificar($consulta);
    $consulta = "DELETE FROM nombres WHERE codigo='" . $_GET['codigo'] . "'";
    $result = $conexion->modificar($consulta);
    header("Location: buscarjuegos.php");
}