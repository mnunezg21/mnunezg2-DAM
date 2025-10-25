<?php
require '../miBD.php';

$conexion = new miBD();
$resultado = $conexion->modificar("DELETE FROM nombres");
$nombrefichero ="../wiitdb.txt";
$fich = fopen($nombrefichero,"r");
while(!feof($fich)) {
    $linea = fgets($fich);
    $items = explode(" = ", $linea);
    if ($items[0] == "TITLES") { continue;}
    if (strlen($items[0]) < 1) { continue;}
    echo $items[0] . " > " . $items[1] . " > ";
    $nombrejuego = htmlspecialchars($items[1]);
    $insertaSQL = "INSERT INTO nombres (codigo, nombre) VALUES ('$items[0]','" . $nombrejuego . "')";
//    echo $insertaSQL . "<br>";
    $resultado = $conexion->modificar($insertaSQL);
    echo $resultado . "<br>";;

}
fclose($fich);
echo "CHIN PUN GORI GORI";