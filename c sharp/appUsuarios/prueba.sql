-- phpMyAdmin SQL Dump
-- version 2.9.2
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 03-12-2007 a las 10:51:03
-- Versión del servidor: 5.0.27
-- Versión de PHP: 5.2.1
-- 
-- Base de datos: `prueba`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `estudiante`
-- 

CREATE TABLE `estudiante` (
  `codigo` varchar(15) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `correo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `estudiante`
-- 

INSERT INTO `estudiante` (`codigo`, `nombre`, `apellido`, `correo`) VALUES 
('20072020040', 'Juan Antonio', 'Diaz Martinez', 'juand@mail.com'),
('20072020056', 'Maria Helena', 'Perez Games', 'mariap@mail.com'),
('20072020089', 'Ana Lucia', 'Hernandez Gomez', 'anah@mail.com');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL auto_increment,
  `usuario` varchar(15) NOT NULL,
  `clave` varchar(60) NOT NULL default '',
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `estado` enum('a','i') NOT NULL default 'a',
  PRIMARY KEY  (`id`),
  KEY `in_usuario_clave` (`usuario`,`clave`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

-- 
-- Volcar la base de datos para la tabla `usuario`
-- 

INSERT INTO `usuario` (`id`, `usuario`, `clave`, `nombres`, `apellidos`, `estado`) VALUES 
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Alejandro', 'Daza', 'a'),
(2, 'almacen', '4e210009a1cfbf891ee1a8f75f441e2f', 'Marcela', 'Espinosa', 'a'),
(3, 'ventas', '530b350d414da3378a15b3149b322908', 'Gandalf', 'Daza', 'a'),
(10, 'alejo', 'fe53e7c460e5a053b7b9c5f1576e4c71', 'Alejandro Paolo', 'Daza Corredor', 'a');
