-- MySQL dump 10.11
--
-- Host: localhost    Database: agenda
-- ------------------------------------------------------
-- Server version	5.0.51a-3ubuntu5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (2,1,'2008-10-01','13:10:00','Biblioteca UD','Grupo de trabajo'),(4,2,'2008-07-08','14:45:00','Universidad - Lab','Parcial'),(11,1,'2008-06-30','16:59:00','Salon 308','Quiz de recuperación'),(12,1,'2008-10-10','10:00:00','UD','prueba'),(13,2,'2008-06-02','11:00:00','UD','codigo problema');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactos`
--

DROP TABLE IF EXISTS `contactos`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='tabla con los nombres de conocidos';
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `contactos`
--

LOCK TABLES `contactos` WRITE;
/*!40000 ALTER TABLE `contactos` DISABLE KEYS */;
INSERT INTO `contactos` VALUES (1,'Victor Alejandro','Perez','2331234','3214567','31645607089','alejo@mail.com','Cra 15 # 22 - 10','trans 33 # 34 -56'),(2,'Juana Maria','Diaz','3445566','3111111','3112345678','jma@mail.com','cra 33 n° 20-50','trans 30 n° 45-10');
/*!40000 ALTER TABLE `contactos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2008-05-16 15:36:58
