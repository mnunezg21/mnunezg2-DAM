-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-11-2019 a las 13:10:48
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `piaonoteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcuadro`
--

CREATE TABLE `tcuadro` (
  `CodCuadro` varchar(50) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Pintor` varchar(50) NOT NULL,
  `Borrado` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tcuadro`
--

INSERT INTO `tcuadro` (`CodCuadro`, `Nombre`, `Pintor`, `Borrado`) VALUES
('cod001', 'uno', 'autor1', '0'),
('cod002', 'autor2', 'dos', '1'),
('cod003', 'dos', 'autor2', '1'),
('cod004', 'luis', '2', '1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
