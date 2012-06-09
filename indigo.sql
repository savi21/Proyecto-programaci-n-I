-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-04-2012 a las 07:55:29
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos de savi: `indigo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE IF NOT EXISTS `eventos` (
  `ID_Evento` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Fecha` date NOT NULL,
  `Ubicacion` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Evento`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `eventos`
--

INSERT INTO `eventos` (`ID_Evento`, `Nombre`, `Fecha`, `Ubicacion`) VALUES
(8, 'Fiesta playera', '2012-04-12', 'en boca chica'),
(9, 'programar', '2012-04-10', 'mi casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invitaciones`
--

CREATE TABLE IF NOT EXISTS `invitaciones` (
  `ID_Invitado` int(11) NOT NULL,
  `ID_Evento` int(11) NOT NULL,
  `Asistencia` varchar(2) NOT NULL DEFAULT 'No',
  PRIMARY KEY (`ID_Invitado`,`ID_Evento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `invitaciones`
--

INSERT INTO `invitaciones` (`ID_Invitado`, `ID_Evento`, `Asistencia`) VALUES
(7, 9, 'Si'),
(9, 8, 'No'),
(10, 9, 'Si');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `invitados`
--

CREATE TABLE IF NOT EXISTS `invitados` (
  `ID_Invitado` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `Direccion` varchar(70) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_Invitado`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Volcado de datos para la tabla `invitados`
--

INSERT INTO `invitados` (`ID_Invitado`, `Nombre`, `Apellido`, `sexo`, `Direccion`, `Telefono`) VALUES
(7, 'Ana', 'Llano Peña', 'Femenino', 'salome ureña', '(809)590-0016'),
(8, 'Anderson', 'Castillo', 'Femenino', 'sabana perdida', '(809)590-2106'),
(9, 'Jose', 'Rodriguez', 'Masculino', 'sabana perdida', '(333)333-3344'),
(10, 'Fulana', 'brea', 'Femenino', 'no se sabe', '(111)111-1111');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `ID_Usuarios` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Contraseña` varchar(30) NOT NULL,
  `Perfil_de_Usuario` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_Usuarios`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Usuarios`, `Nombre`, `Apellido`, `Usuario`, `Contraseña`, `Perfil_de_Usuario`) VALUES
(10, 'savi', 'rodriguez', 'saby21', '210193', 'Administrador'),
(13, 'luis', 'moreta', 'moreta02', 'mkjs', 'Portero'),
(14, 'a', 's', 'q', 's', 'Portero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita_imprevista`
--

CREATE TABLE IF NOT EXISTS `visita_imprevista` (
  `ID_visita` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Sexo` varchar(30) NOT NULL,
  `Usuario_portero` varchar(30) NOT NULL,
  `Razon_de_entrada` varchar(100) NOT NULL,
  `ID_Evento` int(11) NOT NULL,
  KEY `ID_visita` (`ID_visita`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=69 ;

--
-- Volcado de datos para la tabla `visita_imprevista`
--

INSERT INTO `visita_imprevista` (`ID_visita`, `Nombre`, `Apellido`, `Sexo`, `Usuario_portero`, `Razon_de_entrada`, `ID_Evento`) VALUES
(67, 'Jose', 'Asuncion', 'Masculino', 'saby21', 'Porque su madre quiere', 7),
(68, 'Savi', 'Rodriguez', 'Femenino', 'moreta02', 'Por nada', 7);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
