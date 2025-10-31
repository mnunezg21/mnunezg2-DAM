-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-03-2017 a las 14:14:15
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `libreriawindowsform`




CREATE TABLE `tcliente` (
  `CodCliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `DNI` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Borrado` varchar(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

INSERT INTO `tcliente` (`CodCliente`, `Nombre`, `Apellidos`, `DNI`, `Direccion`, `Email`, `Borrado`) VALUES
('cod001', 'Javi', 'Díaz', '45562345L', 'Calle falsa nº2', 'javi@email.com', '0');

CREATE TABLE `tfactura` (
  `CodFactura` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cliente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FechaFactura` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Borrado` varchar(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `tfactura` (`CodFactura`, `Cliente`, `FechaFactura`, `Borrado`) VALUES
('cod001', 'Javi Díaz', '16/02/2017', '0');





CREATE TABLE `tlibro` (
  `CodLibro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Autor` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Titulo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Tema` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Paginas` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Precio` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Formatouno` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Formatodos` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Formatotres` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Estado` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Borrado` varchar(1) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `tlibro` (`CodLibro`, `Autor`, `Titulo`, `Tema`, `Paginas`, `Precio`, `Formatouno`, `Formatodos`, `Formatotres`, `Estado`, `Borrado`) VALUES
('cod001', 'Ceballos', 'Java a Fondo', 'Informática', '203', '35,5', 'N/A', 'Rústica', 'N/A', 'novedad', '0');



CREATE TABLE `tlineafactura` (
  `CodFactura` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Libro` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Cantidad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Total` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `tlineafactura` (`CodFactura`, `Libro`, `Cantidad`, `Total`) VALUES
('cod001', 'Java a Fondo', '4', '142,0');



CREATE TABLE `ttema` (
  `tema` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `Borrado` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `ttema` (`tema`, `Borrado`) VALUES
('Acción', 0),
('Aventuras', 0),
('Biografía', 0),
('Ciencia', 0),
('Ciencia Ficción', 0),
('Cine', 0),
('Economía', 0),
('Gastronomía', 0),
('Historia', 0),
('Informática', 0),
('Medicina', 0),
('Misterio', 0),
('Naturaleza', 0),
('Policíaco', 0),
('Política', 0),
('Romántica', 0),
('Teatro', 0),
('Terror', 0);


ALTER TABLE `tcliente`
  ADD PRIMARY KEY (`CodCliente`);


ALTER TABLE `tfactura`
  ADD PRIMARY KEY (`CodFactura`);


ALTER TABLE `tlibro`
  ADD PRIMARY KEY (`CodLibro`);


ALTER TABLE `tlineafactura`
  ADD PRIMARY KEY (`CodFactura`,`Libro`);


ALTER TABLE `ttema`
  ADD PRIMARY KEY (`tema`),
  ADD UNIQUE KEY `tema` (`tema`);



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
