<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Formulario</title>
</head>
<body>
  <form method="post" enctype="multipart/form-data">
    <p>Imagen de fondo: <input type="file" name="imagen" accept="image/*" required></p>
    <p>Texto grande: <textarea name="texto_grande" rows="4" cols="40"></textarea></p>
    <p>Texto pequeño: <input type="text" name="texto_pequeno"></p>
    <p>Nombre de la máquina: <input type="text" name="nombre_maquina"></p>
    <p>MAC de la máquina: <input type="text" name="mac"></p>
    <p><input type="submit" value="Generar imagen"></p>
  </form>
</body>
</html>
<?php
// Procesar imagen
$imagen = $_FILES['imagen']["tmp_name"];
$tipo=mime_content_type($imagen);

switch($tipo){
    case "image/jpeg":
        $img= imagecreateformjpeg($imagen);
        break;
    case "image/png":
        $img = imagecreatefrompng($imagen);
        break;
    case "image/gif":
        $img = imagecreatefromgif($imagen);
        break;
        default:
            die("Formato de imagen incorrecto");
}
$negro = imagecolorallocate($img,0,0,0);
$blanco = imagecolorallocate($img, 255, 255, 255);

$textoGrande = $_POST["texto_grande"];
$textoPequeno = $_POST["texto_pequeno"];
$nombreMaquina = $_POST["nombre_maquina"];
$mac = $_POST["mac"];
$ip=$_SERVER['REMOTE_ADDR'];

$ancho = imagesx($img);
$alto = imagesy($img);

imagestring($img, 5, 10, 10, $textoGrande, $blanco);
imagestring($img, 3, 10, 40, $textoPequeno, $blanco);
imagestring($img, 3, 10, $alto - 60, "Máquina: $nombreMaquina", $blanco);
imagestring($img, 3, 10, $alto - 40, "MAC: $mac", $blanco);
imagestring($img, 3, 10, $alto - 20, "IP: $ip", $blanco);

header("Content-Type: image/png");
header("Content-Disposition: attachment; filename=\"imagen_generada.png\"");
imagepng($img);
imagedestroy($img);
?>