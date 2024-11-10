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
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  `deleteDate` datetime DEFAULT NULL,
  `deleted` bit(1) NOT NULL DEFAULT b'0',
  `createDate` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jperez','pass123','Juan Pérez',0,NULL,'\0','2024-11-07 22:10:24'),(2,'mgomez','pass456','María Gómez',1,NULL,'\0','2024-11-07 22:10:24'),(3,'clopez','pass789','Carlos López',0,NULL,'\0','2024-11-07 22:10:24'),(4,'lmartinez','pass101','Lucía Martínez',0,NULL,'\0','2024-11-07 22:10:24'),(5,'afernandez','pass202','Ana Fernández',1,'2023-10-01 14:30:00','','2024-11-07 22:10:24'),(6,'dramirez','pass303','Diego Ramírez',0,NULL,'\0','2024-11-07 22:10:24'),(7,'ltorres','pass404','Laura Torres',1,'2023-08-15 09:45:00','','2024-11-07 22:10:24'),(8,'amolina','pass505','Andrés Molina',0,NULL,'\0','2024-11-07 22:10:24'),(9,'scastro','pass606','Sofía Castro',1,NULL,'\0','2024-11-07 22:10:24'),(10,'mgimenez','pass707','Miguel Giménez',0,NULL,'\0','2024-11-07 22:10:24');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
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
