<?php

require("conexionBD.php");

	class miBD {
        private $pdo = null;

        public function __construct() {
            $this->pdo = conexionBD::getConnect();
        }
         public function getRegistros($consultaSQL) {
            $registros = null;
             $stmt = $this->pdo->prepare($consultaSQL);
//             $stmt->bindParam(':codigo', $_GET['codigo'], PDO::PARAM_STR);
             $stmt->execute();
             if($stmt->rowCount() > 0){
                 $registros = $stmt->fetchAll(PDO::FETCH_ASSOC);
             }
             return $registros;
        }

        public function modificar($consultaSQL) {
            $resultado = $this->pdo->exec($consultaSQL);
            return $resultado;
        }

	}


//        $conn=miBD::getConnect();
//        $registros=$conn->query('SELECT * FROM usuarios');
//        foreach ($registros->fetchAll() as $usuario) {
//            $listaUsuarios[]= $usuario['nombre'];
//        }
//        return $listaUsuarios;
