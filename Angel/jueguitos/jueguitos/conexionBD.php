<?php
require("credenciales.php");

class conexionBD
{
    private static $host;
    private static $dbname;
    private static $usuario;
    private static $pass;
    private static $instance=NULL;

    private function __construct(){}

    private function __clone(){}

    public static function getConnect(){
        global $servername;
        global $username;
        global $password;
        global $basedatos;

        self::$host = $servername;
        self::$usuario = $username;
        self::$pass = $password;
        self::$dbname = $basedatos;

        $dsn = "mysql:host=" . self::$host . ";dbname=" . self::$dbname;
        if (!isset(self::$instance)) {
            $pdo_options[PDO::ATTR_ERRMODE]=PDO::ERRMODE_EXCEPTION;
            $pdo_options[PDO::ATTR_EMULATE_PREPARES]=false;
            self::$instance= new PDO($dsn,self::$usuario,self::$pass,$pdo_options);
        }
        return self::$instance;
    }
}