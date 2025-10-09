<!DOCTYPE html>
<html>
<head>
    <title>Buscaminas</title>
</head>
<body>
    <table border="1">
    <?php
    for($i=0; $i<8; $i++) {
        echo "<tr>";
        for($j=0; $j<8; $j++) {
            echo "<td width='30' height='30'></td>";
        }
        echo "</tr>";
    }
    ?>
    </table>
</body>
</html>