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
-- Temporary view structure for view `vw_detalhes_servico`
--

DROP TABLE IF EXISTS `vw_detalhes_servico`;
/*!50001 DROP VIEW IF EXISTS `vw_detalhes_servico`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_detalhes_servico` AS SELECT 
 1 AS `Pet`,
 1 AS `NomeFuncionario`,
 1 AS `Data`,
 1 AS `Horario`,
 1 AS `ServicoPrestado`,
 1 AS `Incidente`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_detalhes_servico`
--

/*!50001 DROP VIEW IF EXISTS `vw_detalhes_servico`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_detalhes_servico` AS select `pet`.`nome` AS `Pet`,`funcionario`.`nome` AS `NomeFuncionario`,cast(`historico_servico`.`dt_hora_iniciado` as date) AS `Data`,cast(`historico_servico`.`dt_hora_iniciado` as time) AS `Horario`,`servico`.`nome` AS `ServicoPrestado`,`incidente`.`descricao` AS `Incidente` from (((((`historico_servico` join `agendamento` on(`historico_servico`.`id_agendamento` = `agendamento`.`id_agendamento`)) join `pet` on(`agendamento`.`id_pet` = `pet`.`id_pet`)) join `funcionario` on(`agendamento`.`id_func` = `funcionario`.`id_func`)) left join `incidente` on(`historico_servico`.`id_incidente` = `incidente`.`id_incidente`)) left join `servico` on(`incidente`.`id_servico` = `servico`.`id_servico`)) */;
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

-- Dump completed on 2024-11-13 23:06:14
