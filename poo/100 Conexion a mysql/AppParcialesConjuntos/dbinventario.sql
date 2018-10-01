-- phpMyAdmin SQL Dump
-- version 2.9.1.1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 08-12-2006 a las 00:39:11
-- Versión del servidor: 5.0.27
-- Versión de PHP: 5.1.6
-- 
-- Base de datos: `dbinventario`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `opciones`
-- 

DROP TABLE IF EXISTS `opciones`;
CREATE TABLE `opciones` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL default '',
  `nivel` int(2) unsigned NOT NULL default '0',
  `id_padre` int(10) unsigned NOT NULL default '0',
  `orden` int(10) unsigned NOT NULL default '0',
  `task` varchar(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

-- 
-- Volcar la base de datos para la tabla `opciones`
-- 

INSERT INTO `opciones` (`id`, `nombre`, `nivel`, `id_padre`, `orden`, `task`) VALUES 
(1, 'Administracion', 0, 0, 1, ''),
(2, 'Opciones', 0, 0, 4, ''),
(3, 'Administrar Usuarios', 1, 1, 1, 'admUsuario'),
(4, 'Administrar Roles', 1, 1, 2, 'admRol'),
(5, 'Administrar Opciones', 1, 1, 3, 'admOpcione'),
(6, 'Cerrar Sesión', 1, 2, 1, 'clsSesion'),
(7, 'Salir', 1, 2, 2, 'salir'),
(8, 'Ventas', 0, 0, 2, ''),
(9, 'Almacen', 0, 0, 3, ''),
(10, 'Generar Factura', 1, 8, 1, 'factura'),
(11, 'Registrar Devolucion', 1, 8, 2, 'devolucion'),
(12, 'Existencias', 1, 9, 1, 'existencia'),
(13, 'Configuracion Producto', 1, 9, 2, 'confProduc'),
(14, 'Editar Rol Usuario', 1, 1, 4, 'editRolUse');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rol`
-- 

DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol` (
  `id` int(1) NOT NULL auto_increment,
  `nombre` varchar(15) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `rol`
-- 

INSERT INTO `rol` (`id`, `nombre`) VALUES 
(0, 'General'),
(1, 'Administrador'),
(2, 'Almacenista'),
(3, 'Vendedor');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rol_opciones`
-- 

DROP TABLE IF EXISTS `rol_opciones`;
CREATE TABLE `rol_opciones` (
  `id_rol` int(10) unsigned NOT NULL default '0',
  `id_opcion` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id_rol`,`id_opcion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `rol_opciones`
-- 

INSERT INTO `rol_opciones` (`id_rol`, `id_opcion`) VALUES 
(0, 2),
(0, 6),
(0, 7),
(1, 1),
(1, 3),
(1, 4),
(1, 5),
(1, 14),
(2, 9),
(2, 12),
(2, 13),
(3, 8),
(3, 10),
(3, 11);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `rol_usuario`
-- 

DROP TABLE IF EXISTS `rol_usuario`;
CREATE TABLE `rol_usuario` (
  `id_rol` int(10) unsigned NOT NULL default '0',
  `id_usuario` int(10) unsigned NOT NULL default '0',
  PRIMARY KEY  (`id_rol`,`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `rol_usuario`
-- 

INSERT INTO `rol_usuario` (`id_rol`, `id_usuario`) VALUES 
(0, 1),
(0, 2),
(0, 3),
(0, 10),
(1, 1),
(1, 10),
(2, 2),
(3, 3);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

DROP TABLE IF EXISTS `usuario`;
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
