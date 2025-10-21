<?php
if(!empty($_GET['codigo'])){

    require_once("credenciales.php");

    try {
        //Create connection and select DB using PDO
        $db = new PDO("mysql:host=$servername;dbname=$basedatos;charset=utf8", $username, $password);

        //Set PDO error mode to exception
        $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        $db->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);

        //Get image data from database using prepared statement
        $stmt = $db->prepare("SELECT codigo, caratula, tipo FROM caratulas WHERE codigo = :codigo");
        $stmt->bindParam(':codigo', $_GET['codigo'], PDO::PARAM_STR);
        $stmt->execute();

        if($stmt->rowCount() > 0){
            $imgData = $stmt->fetch(PDO::FETCH_ASSOC);

//            var_dump($imgData["tipo"]);
//            exit();

            //Render image
            header('Content-type: $imgData["tipo"]');
            echo $imgData['caratula'];
        } else {
            echo 'Image not found...';
        }

    } catch(PDOException $e) {
        die("Connection failed: " . $e->getMessage());
    }
}
?>