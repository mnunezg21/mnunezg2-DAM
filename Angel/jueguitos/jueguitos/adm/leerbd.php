<?php
require 'miBD.php';
$conexion = new miBD();
$registros = $conexion->getRegistros("SELECT codigo FROM caratulas ORDER BY codigo ASC");
foreach ($registros as $registro) {
    echo $registro["codigo"] . "<br>";
}
