<?php
session_start();
require ("miBD.php");

if (!empty($_SESSION['search'])) {
    $textobuscar = $_SESSION['search'];
} else {
    $textobuscar = $_GET['search'];
    $_SESSION['search'] = $textobuscar;
}

$conexion = new miBD();
$sqlbusqueda = "SELECT N.codigo AS codigo, N.nombre AS nombre FROM nombres AS N RIGHT JOIN caratulas AS C ON (N.codigo = C.codigo) WHERE N.nombre LIKE '%".$textobuscar."%'";
$registros = $conexion->getRegistros($sqlbusqueda);
?>
<hr>
<a href="formbusq.php">Buscar unos juegos</a>
<hr>
<table border="1">
<?php
foreach ($registros as $registro) {
?>
    <tr><td><img src='verimg.php?codigo=<?php echo $registro["codigo"]; ?>' width="100"></td><td>
<?php
    echo $registro["nombre"];
?>
        </td>
        <td><a href="borrar.php?codigo=<?php echo $registro["codigo"];?>">borrar</a></td>
    </tr>

<?php
}
?>

</table>
