<?php
session_start();
session_unset();
session_destroy();
session_start();
?>
<!DOCTYPE html>
<body>
<form action="buscarjuegos.php" method="get">
    <input type="text" name="search" placeholder="Buscar">
    <input type="submit" name="" value="Buscar">
</form>
</body>

