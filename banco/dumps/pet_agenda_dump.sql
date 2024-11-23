CREATE DATABASE  IF NOT EXISTS `pet_agenda` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `pet_agenda`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: pet_agenda
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
  `dta_hr_iniciado` datetime NOT NULL,
  `dta_hr_finalizado` datetime NOT NULL,
  `check_entrega` tinyint(4) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `id_servico` int(11) DEFAULT NULL,
  `id_func` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_agendamento`),
  KEY `id_servico` (`id_servico`),
  KEY `id_func` (`id_func`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`),
  CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`id_func`) REFERENCES `funcionario` (`id_func`)
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
  `cpf` char(11) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `rua` varchar(64) NOT NULL,
  `numero` varchar(16) NOT NULL,
  `bairro` varchar(64) NOT NULL,
  `cidade` varchar(64) NOT NULL,
  `cep` char(8) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Andrea Lavínia Melissa da Mata','02039476903','(62) 2964-9797','Rua 82','343','Setor Central','Goiânia','74015095'),(2,'Flávia Ester Hadassa da Conceição','82736160100','(96) 2839-8602','Rua Iraci Nunes Nadior','738','Santa Inês','Macapá','68901380'),(3,'Luiz Luan Gael Souza','18973207792','(82) 2856-5469','Rua C-64','618','Benedito Bentes','Maceió','57085062'),(4,'Marlene Mariah Jesus','37827110177','(51) 2511-0744','Rua Jacob Schaan Filho','393','Teresópolis','Porto Alegre','91720050'),(5,'Heitor Raul Pires','65428724935','(88) 3933-4992','Travessa Tenente Antonio João','866','Vila Alta','Crato','63119013'),(6,'Mariane Rayssa da Rosa','24064752040','(86) 3945-7855','Rua Júlio Mendes','848','Fátima','Teresina','64049320');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente_contrata_servico`
--

DROP TABLE IF EXISTS `cliente_contrata_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente_contrata_servico` (
  `id_servico` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  KEY `id_servico` (`id_servico`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `cliente_contrata_servico_ibfk_1` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`),
  CONSTRAINT `cliente_contrata_servico_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente_contrata_servico`
--

LOCK TABLES `cliente_contrata_servico` WRITE;
/*!40000 ALTER TABLE `cliente_contrata_servico` DISABLE KEYS */;
INSERT INTO `cliente_contrata_servico` VALUES (2,1),(2,2),(1,3),(2,4),(1,5),(1,6);
/*!40000 ALTER TABLE `cliente_contrata_servico` ENABLE KEYS */;
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
  `telefone` varchar(15) NOT NULL,
  `rua` varchar(64) NOT NULL,
  `cep` char(8) NOT NULL,
  `numero` varchar(16) NOT NULL,
  `bairro` varchar(64) NOT NULL,
  `cidade` varchar(64) NOT NULL,
  PRIMARY KEY (`id_func`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Cauê Cláudio Thales Moraes','10959433910','(96) 3615-2792','Avenida Maria Cavalcante de Azevedo Picanço','68908076','688','Infraero','Macapá'),(2,'Daniel Bernardo Lima','97145275546','(82) 2935-2875','Rua Sombra dos Eucaliptos','57081004','260','Tabuleiro do Martins','Maceió'),(3,'Caleb Martin Yago da Cunha','27910388250','(12) 2981-1532','Rua João Gonçalves da Costa','12609030','921','Parque Mondesir','Lorena'),(4,'Patrícia Olivia Elza Galvão','16531388315','(33) 3669-2439','Rua Desembargador Eustáquio Peixoto','39803007','217','São Diogo','Teófilo Otoni'),(5,'Raquel Vanessa Márcia Baptista','59391414630','(84) 2777-9087','Rua Bogotá','59072020','136','Felipe Camarão','Natal'),(6,'Pietra Silvana Fogaça','13962051015','(95) 2533-2343','Avenida Sebastião Correia Lira','69317472','853','Cidade Satélite','Boa Vista');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hr_alim_agend`
--

DROP TABLE IF EXISTS `hr_alim_agend`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hr_alim_agend` (
  `id_hr_alim_agend` int(11) NOT NULL,
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
  `id_agendamento` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_incidente`),
  KEY `id_pet` (`id_pet`),
  KEY `id_servico` (`id_servico`),
  KEY `id_agendamento` (`id_agendamento`),
  CONSTRAINT `incidente_ibfk_1` FOREIGN KEY (`id_pet`) REFERENCES `pet` (`id_pet`),
  CONSTRAINT `incidente_ibfk_2` FOREIGN KEY (`id_servico`) REFERENCES `servico` (`id_servico`),
  CONSTRAINT `incidente_ibfk_3` FOREIGN KEY (`id_agendamento`) REFERENCES `agendamento` (`id_agendamento`)
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
-- Table structure for table `pet_agendamento`
--

DROP TABLE IF EXISTS `pet_agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pet_agendamento` (
  `id_agendamento_pet` int(11) DEFAULT NULL,
  `id_pet_agend` int(11) DEFAULT NULL,
  KEY `id_agendamento_pet` (`id_agendamento_pet`),
  KEY `id_pet_agend` (`id_pet_agend`),
  CONSTRAINT `pet_agendamento_ibfk_1` FOREIGN KEY (`id_agendamento_pet`) REFERENCES `agendamento` (`id_agendamento`),
  CONSTRAINT `pet_agendamento_ibfk_2` FOREIGN KEY (`id_pet_agend`) REFERENCES `pet` (`id_pet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pet_agendamento`
--

LOCK TABLES `pet_agendamento` WRITE;
/*!40000 ALTER TABLE `pet_agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `pet_agendamento` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'Dog Walking',80.00,'Caminhada com um grupo de cachorros'),(2,'Pet Sitting',100.00,'Atendimento doméstico\'');
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
  `permissao` enum('1','2','3') NOT NULL,
  `codigo_recup` varchar(4) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `cpf` (`cpf`),
  UNIQUE KEY `codigo_recup` (`codigo_recup`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'88784449012','administrador','1234','1','4528');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `visualizacao_cliente`
--

DROP TABLE IF EXISTS `visualizacao_cliente`;
/*!50001 DROP VIEW IF EXISTS `visualizacao_cliente`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `visualizacao_cliente` AS SELECT 
 1 AS `nome_cliente`,
 1 AS `cpf`,
 1 AS `telefone`,
 1 AS `nome_servico`,
 1 AS `rua`,
 1 AS `numero`,
 1 AS `bairro`,
 1 AS `cidade`,
 1 AS `cep`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `visualizacao_cliente`
--

/*!50001 DROP VIEW IF EXISTS `visualizacao_cliente`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `visualizacao_cliente` AS select `cliente`.`nome` AS `nome_cliente`,`cliente`.`cpf` AS `cpf`,`cliente`.`telefone` AS `telefone`,`servico`.`nome` AS `nome_servico`,`cliente`.`rua` AS `rua`,`cliente`.`numero` AS `numero`,`cliente`.`bairro` AS `bairro`,`cliente`.`cidade` AS `cidade`,`cliente`.`cep` AS `cep` from ((`cliente_contrata_servico` join `cliente` on(`cliente`.`id_cliente` = `cliente_contrata_servico`.`id_cliente`)) join `servico` on(`servico`.`id_servico` = `cliente_contrata_servico`.`id_servico`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-23 13:18:28
