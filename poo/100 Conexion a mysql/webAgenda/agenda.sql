CREATE TABLE `contactos` (
  `con_id` int(11) NOT NULL auto_increment COMMENT 'identificador del contacto',
  `con_nombre` varchar(30) NOT NULL COMMENT 'nombre del contacto',
  `con_apellido` varchar(30) NOT NULL COMMENT 'apellido del contacto',
  `con_telefono_domicilio` varchar(15) NOT NULL COMMENT 'telefono de la casa',
  `con_telefono_oficina` varchar(15) NOT NULL COMMENT 'telefono trabajo',
  `con_celular` varchar(20) NOT NULL COMMENT 'celular personal',
  `con_correo` varchar(150) NOT NULL COMMENT 'email personal',
  `con_direccion_residencia` varchar(150) NOT NULL COMMENT 'direccion de residencia',
  `con_direccion_trabajo` varchar(150) NOT NULL COMMENT 'direccion de trabajo',
  PRIMARY KEY  (`con_id`)
) ENGINE=InnoDB;

INSERT INTO `contactos` VALUES (1,'Victor Alejandro','Perez','2331234','3214567','31645607089','alejo@mail.com','Cra 15 # 22 - 10','trans 33 # 34 -56'),
(2,'Juana Maria','Diaz','3445566','3111111','3112345678','jma@mail.com','cra 33 n° 20-50','trans 30 n° 45-10');

CREATE TABLE `citas` (
  `cit_id` int(11) NOT NULL auto_increment,
  `con_id` int(11) NOT NULL,
  `cit_fecha` date NOT NULL,
  `cit_hora` time NOT NULL,
  `cit_lugar` varchar(150) NOT NULL,
  `cit_asunto` varchar(150) NOT NULL,
  PRIMARY KEY  (`cit_id`),
  KEY `FK_CITA_CONTACTO` (`con_id`),
  CONSTRAINT `FK_CITA_CONTACTO` FOREIGN KEY (`con_id`) REFERENCES `contactos` (`con_id`)
) ENGINE=InnoDB;

INSERT INTO `citas` VALUES (1,1,'2008-10-01','13:10:00','Biblioteca UD','Grupo de trabajo'),
(2,2,'2008-07-08','14:45:00','Universidad - Lab','Parcial'),
(3,1,'2008-06-30','16:59:00','Salon 308','Quiz de recuperación'),
(4,1,'2008-10-10','10:00:00','UD','prueba'),
(5,2,'2008-06-02','11:00:00','UD','codigo problema');

