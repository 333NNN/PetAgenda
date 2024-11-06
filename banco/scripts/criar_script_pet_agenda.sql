CREATE DATABASE  IF NOT EXISTS `pet_agenda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `pet_agenda`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pet_agenda
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `agendamento`
--

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agendamento` (
  `id_agendamento` int(11) NOT NULL AUTO_INCREMENT,
  `dt_hr_marcada` datetime NOT NULL,
  `endereco_pet` varchar(255) NOT NULL,
  `qnt_passeios` int(11) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `pet_buscar_com` varchar(64) DEFAULT NULL,
  `pet_devolver_para` varchar(64) DEFAULT NULL,
  `local_cuidado` varchar(255) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  `id_pet` int(11) DEFAULT NULL,
  `id_func` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `id_servico` (`id_servico`),
  KEY `id_pet` (`id_pet`),
  KEY `id_func` (`id_func`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`),
  CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`id_pet`) REFERENCES `pet` (`id_pet`),
  CONSTRAINT `agendamento_ibfk_3` FOREIGN KEY (`id_func`) REFERENCES `funcionario` (`id_func`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `numero` varchar(16) NOT NULL,
  `bairro` varchar(32) NOT NULL,
  `cidade` varchar(32) NOT NULL,
  `cep` char(8) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `cpf` char(11) NOT NULL,
  `check_entrega` tinyint(4) NOT NULL,
  `buscar_com` varchar(64) DEFAULT NULL,
  `devolver_para` varchar(64) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  KEY `id_servico` (`id_servico`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financeiro`
--

DROP TABLE IF EXISTS `financeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financeiro` (
  `id_financeiro` int(11) NOT NULL AUTO_INCREMENT,
  `relatorio_dia` decimal(8,2) NOT NULL,
  `relatorio_semanal` decimal(8,2) NOT NULL,
  `relatorio_mes` decimal(8,2) NOT NULL,
  `relatorio_anual` decimal(8,2) NOT NULL,
  `id_historico_servico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_financeiro`),
  KEY `id_historico_servico` (`id_historico_servico`),
  CONSTRAINT `financeiro_ibfk_1` FOREIGN KEY (`id_historico_servico`) REFERENCES `historico_servico` (`id_historico_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financeiro`
--

LOCK TABLES `financeiro` WRITE;
/*!40000 ALTER TABLE `financeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `financeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_func` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `cpf` char(11) NOT NULL,
  `rua` varchar(45) NOT NULL,
  `cep` char(8) NOT NULL,
  `numero` varchar(16) NOT NULL,
  `cidade` varchar(32) NOT NULL,
  `telefone` varchar(12) NOT NULL,
  `local_de_atuacao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_func`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historico_servico`
--

DROP TABLE IF EXISTS `historico_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_servico` (
  `id_historico_servico` int(11) NOT NULL AUTO_INCREMENT,
  `dt_hora_iniciado` datetime NOT NULL,
  `dt_hr_finalizado` datetime NOT NULL,
  `caminho_anexo` varchar(200) NOT NULL,
  `id_incidente` int(11) DEFAULT NULL,
  `id_agendamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_historico_servico`),
  KEY `id_incidente` (`id_incidente`),
  KEY `id_agendamento` (`id_agendamento`),
  CONSTRAINT `historico_servico_ibfk_1` FOREIGN KEY (`id_incidente`) REFERENCES `incidente` (`id_incidente`),
  CONSTRAINT `historico_servico_ibfk_2` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_servico`
--

LOCK TABLES `historico_servico` WRITE;
/*!40000 ALTER TABLE `historico_servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `historico_servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hr_alim_agend`
--

DROP TABLE IF EXISTS `hr_alim_agend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_alim_agend` (
  `id_hr_alim_agend` time NOT NULL,
  `horario` time NOT NULL,
  `id_agendamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_hr_alim_agend`),
  KEY `id_agendamento` (`id_agendamento`),
  CONSTRAINT `hr_alim_agend_ibfk_1` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hr_alim_agend`
--

LOCK TABLES `hr_alim_agend` WRITE;
/*!40000 ALTER TABLE `hr_alim_agend` DISABLE KEYS */;
/*!40000 ALTER TABLE `hr_alim_agend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `incidente`
--

DROP TABLE IF EXISTS `incidente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `incidente` (
  `id_incidente` int(11) NOT NULL AUTO_INCREMENT,
  `data_hora` datetime NOT NULL,
  `e_emergencia` bit(1) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `id_pet` int(11) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_incidente`),
  KEY `id_pet` (`id_pet`),
  KEY `id_servico` (`id_servico`),
  CONSTRAINT `incidente_ibfk_1` FOREIGN KEY (`id_pet`) REFERENCES `pet` (`id_pet`),
  CONSTRAINT `incidente_ibfk_2` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `incidente`
--

LOCK TABLES `incidente` WRITE;
/*!40000 ALTER TABLE `incidente` DISABLE KEYS */;
/*!40000 ALTER TABLE `incidente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pet`
--

DROP TABLE IF EXISTS `pet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet` (
  `id_pet` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `raca` varchar(45) NOT NULL,
  `sexo` enum('M','F') NOT NULL,
  `porte` enum('Pequeno','Médio','Grande') NOT NULL,
  `comportamento` varchar(80) NOT NULL,
  `e_castrado` bit(1) NOT NULL,
  `caminho_cartao_vacinacao` varchar(255) NOT NULL,
  `estado_saude` varchar(80) NOT NULL,
  `cor` varchar(16) NOT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pet`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `pet_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet`
--

LOCK TABLES `pet` WRITE;
/*!40000 ALTER TABLE `pet` DISABLE KEYS */;
/*!40000 ALTER TABLE `pet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remedio_agend`
--

DROP TABLE IF EXISTS `remedio_agend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `remedio_agend` (
  `id_remedio_agend` int(11) NOT NULL AUTO_INCREMENT,
  `nome_remedio` varchar(64) DEFAULT NULL,
  `hr_administrar` time DEFAULT NULL,
  `instrucoes` varchar(120) DEFAULT NULL,
  `id_agendamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_remedio_agend`),
  KEY `id_agendamento` (`id_agendamento`),
  CONSTRAINT `remedio_agend_ibfk_1` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id_agendamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remedio_agend`
--

LOCK TABLES `remedio_agend` WRITE;
/*!40000 ALTER TABLE `remedio_agend` DISABLE KEYS */;
/*!40000 ALTER TABLE `remedio_agend` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico` (
  `id_servico` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(64) NOT NULL,
  `preco` decimal(8,2) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_servico`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` char(11) NOT NULL,
  `nome_usuario` varchar(45) NOT NULL,
  `senha_usuario` varchar(25) NOT NULL,
  `permissao` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'88784449012','administrador','1234',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-06 20:12:06
