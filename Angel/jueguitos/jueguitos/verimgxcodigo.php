<?php
if(!empty($_GET['id'])){

    require_once("credenciales.php");

    //Create connection and select DB
    $db = new mysqli($servername, $username, $password, $basedatos);

    //Check connection
    if($db->connect_error){
        die("Connection failed: " . $db->connect_error);
    }

    //Get image data from database
    $result = $db->query("SELECT codigo, caratula, tipo FROM caratulas WHERE codigo = '" . $_GET['id'] ."'");

    if($result->num_rows > 0){
        $imgData = $result->fetch_assoc();

        //Render image
        header("Content-type: " . $imgData['tipo']);
        echo $imgData['caratula'];
    }else{
        echo 'Image not found...';
    }
}
?>
