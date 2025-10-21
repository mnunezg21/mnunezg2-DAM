<?php
$tiempoini = date("Y-m-d H:i:s");
require "../credenciales.php";
$directorio = "../caratulas";

// Leer todo el contenido
$contenido = scandir($directorio, SCANDIR_SORT_ASCENDING);

try {
    $conn = new PDO("mysql:host=$servername;dbname=$basedatos;charset=utf8", $username, $password);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $sql = "DELETE FROM caratulas";
    $delete = $conn->query($sql);
    foreach ($contenido as $item) {
        if ($item != "." && $item != "..") {
            $nombrejuego = explode(".", $item);
            $nombrejuego = $nombrejuego[0];

            $check = getimagesize("$directorio/$item");
            if($check !== false){
                $image = "$directorio/$item";
                $imgContent = addslashes(file_get_contents($image));
                $tipo = $check['mime'];
                $sql = "INSERT into caratulas (codigo, caratula, tipo) VALUES ('$nombrejuego', '$imgContent', '$tipo')";
                $insert = $conn->query($sql);
                if($insert){
                    echo "Fichero insertado correctamente.";
                }else{
                    echo "Falló la subida del fichero, please try again.";
                }
            }
        }
    }
} catch (PDOException $e) {
    echo "Connection failed: " . $e->getMessage() . "<br>";
}



$tiempofin = date("Y-m-d H:i:s");
