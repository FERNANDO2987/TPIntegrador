CREATE DATABASE  IF NOT EXISTS `bdbanco` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdbanco`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bdbanco
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dni` int(11) NOT NULL,
  `cuil` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `id_pais_nacimiento` int(11) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  `deleteDate` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_pais_nacimiento` (`id_pais_nacimiento`),
  CONSTRAINT `clientes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  CONSTRAINT `clientes_ibfk_2` FOREIGN KEY (`id_pais_nacimiento`) REFERENCES `paises` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,12345678,201234567,'Juan','Pérez','Masculino',1,'1985-04-15',1,NULL,'\0','2024-11-07 22:12:12'),(2,87654321,202345678,'María','Gómez','Femenino',2,'1990-11-22',2,NULL,'\0','2024-11-07 22:12:12'),(3,23456789,203456789,'Carlos','López','Masculino',1,'1978-07-10',3,NULL,'\0','2024-11-07 22:12:12'),(4,34567890,204567890,'Lucía','Martínez','Femenino',3,'2001-05-27',4,NULL,'\0','2024-11-07 22:12:12'),(5,45678901,205678901,'Ana','Fernández','Femenino',4,'1995-03-02',5,'2023-10-01 14:30:00','','2024-11-07 22:12:12'),(6,56789012,206789012,'Diego','Ramírez','Masculino',2,'1988-12-19',6,NULL,'\0','2024-11-07 22:12:12'),(7,67890123,207890123,'Laura','Torres','Femenino',5,'1993-06-15',7,'2023-08-15 09:45:00','','2024-11-07 22:12:12'),(8,78901234,208901234,'Andrés','Molina','Masculino',6,'1980-01-29',8,NULL,'\0','2024-11-07 22:12:12'),(9,89012345,209012345,'Sofía','Castro','Femenino',1,'1997-09-13',9,NULL,'\0','2024-11-07 22:12:12'),(10,90123456,210123456,'Miguel','Giménez','Masculino',2,'1975-11-05',10,NULL,'\0','2024-11-07 22:12:12');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-10 18:37:10
