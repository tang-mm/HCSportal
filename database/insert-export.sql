CREATE DATABASE  IF NOT EXISTS `testdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `testdb`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: testdb
-- ------------------------------------------------------
-- Server version	5.6.21

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
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(40) NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_name` (`customer_name`),
  KEY `idx_customers_customer_name` (`customer_name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'OBS','0','reserved for OBS Experts and Super Administrator'),(9,'test','111222222',NULL),(10,'new2','23131311','desc');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipment` (
  `equipment_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `equipment_name` varchar(20) NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `machine_type` varchar(20) NOT NULL,
  `is_virtualized` tinyint(1) NOT NULL,
  `operating_system` varchar(20) NOT NULL,
  `app_version` varchar(20) NOT NULL,
  `hardware` varchar(20) NOT NULL,
  `geo_location` varchar(20) NOT NULL,
  PRIMARY KEY (`equipment_id`),
  UNIQUE KEY `equipment_name` (`equipment_name`),
  UNIQUE KEY `ip_address` (`ip_address`),
  UNIQUE KEY `serial_number` (`serial_number`),
  KEY `idx_equipment_customer_id` (`customer_id`),
  KEY `idx_equipment_equipment_name` (`equipment_name`),
  KEY `idx_equipment_ip_address` (`ip_address`),
  KEY `idx_equipment_serial_number` (`serial_number`),
  KEY `idx_equipment_geo_location` (`geo_location`),
  CONSTRAINT `equipment_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
INSERT INTO `equipment` VALUES (1,9,'name1','ip1','serial1','type1',1,'os1','version1','hard1','DataCenter2'),(2,9,'22222','ip2','serial2','type1',1,'os1','version1','hard1','DataCenter1'),(3,9,'333333','ip3','serial3','type1',1,'os1','version1','hard1','DataCenter1'),(4,9,'44444','ip4','serial4','type2',1,'os2','version2','hard1','DataCenter1');
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exceptional_days`
--

DROP TABLE IF EXISTS `exceptional_days`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exceptional_days` (
  `service_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `exception_date` date NOT NULL,
  `open_time_1` time DEFAULT NULL,
  `close_time_1` time DEFAULT NULL,
  `open_time_2` time DEFAULT NULL,
  `close_time_2` time DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_id`,`exception_date`),
  KEY `idx_exceptional_days_date` (`exception_date`),
  CONSTRAINT `exceptional_days_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exceptional_days`
--

LOCK TABLES `exceptional_days` WRITE;
/*!40000 ALTER TABLE `exceptional_days` DISABLE KEYS */;
INSERT INTO `exceptional_days` VALUES (1,'2014-11-11','10:00:00','16:00:00',NULL,NULL,'exception');
/*!40000 ALTER TABLE `exceptional_days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `holidays`
--

DROP TABLE IF EXISTS `holidays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `holidays` (
  `service_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `holiday` date NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`service_id`,`holiday`),
  KEY `idx_holidays_holiday` (`holiday`),
  CONSTRAINT `holidays_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `holidays`
--

LOCK TABLES `holidays` WRITE;
/*!40000 ALTER TABLE `holidays` DISABLE KEYS */;
INSERT INTO `holidays` VALUES (1,'2014-11-11','Armistice'),(1,'2014-12-25','Noël'),(2,'2014-12-25','Christmas');
/*!40000 ALTER TABLE `holidays` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_shared_management_components`
--

DROP TABLE IF EXISTS `ip_shared_management_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_shared_management_components` (
  `component_id` int(11) NOT NULL DEFAULT '0',
  `component_name` varchar(20) NOT NULL,
  `side` varchar(10) NOT NULL,
  `ip_address` varchar(15) NOT NULL,
  `url_suffix` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`component_id`),
  UNIQUE KEY `ip_address` (`ip_address`),
  UNIQUE KEY `idx_ip_shared_management_components_component_name_side` (`component_name`,`side`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_shared_management_components`
--

LOCK TABLES `ip_shared_management_components` WRITE;
/*!40000 ALTER TABLE `ip_shared_management_components` DISABLE KEYS */;
/*!40000 ALTER TABLE `ip_shared_management_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ip_suffix_customer_components`
--

DROP TABLE IF EXISTS `ip_suffix_customer_components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ip_suffix_customer_components` (
  `component_id` int(11) NOT NULL DEFAULT '0',
  `component_name` varchar(20) NOT NULL,
  `side` varchar(10) NOT NULL,
  `ip_suffix` varchar(3) NOT NULL,
  `url_suffix` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`component_id`),
  UNIQUE KEY `idx_ip_suffix_customer_components_component_name_side` (`component_name`,`side`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ip_suffix_customer_components`
--

LOCK TABLES `ip_suffix_customer_components` WRITE;
/*!40000 ALTER TABLE `ip_suffix_customer_components` DISABLE KEYS */;
/*!40000 ALTER TABLE `ip_suffix_customer_components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locations` (
  `location_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `country` varchar(20) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) NOT NULL,
  `time_zone` varchar(20) NOT NULL,
  PRIMARY KEY (`location_id`),
  UNIQUE KEY `idx_locations_country_city` (`country`,`city`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'France',NULL,'Paris','+1:00'),(2,'UK',NULL,'London','+0:00');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pin_codes`
--

DROP TABLE IF EXISTS `pin_codes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pin_codes` (
  `pin_code_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `service_code` varchar(20) NOT NULL,
  `caller_name` varchar(20) NOT NULL,
  `pin_code` varchar(10) NOT NULL,
  `target1_agent1_username` varchar(20) DEFAULT NULL,
  `target2_agent2_username` varchar(20) DEFAULT NULL,
  `target3_agent3_username` varchar(20) DEFAULT NULL,
  `target4_skill_group1` varchar(20) DEFAULT NULL,
  `target5_skill_group2` varchar(20) DEFAULT NULL,
  `target6_supervisor_username` varchar(20) DEFAULT NULL,
  `target7_voicemail` varchar(20) DEFAULT NULL,
  `free_text1` varchar(20) DEFAULT NULL,
  `free_text2` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`pin_code_id`),
  UNIQUE KEY `service_code` (`service_code`,`caller_name`,`pin_code`),
  UNIQUE KEY `idx_pin_codes_service_code_caller_name_pin_code` (`service_code`,`caller_name`,`pin_code`),
  KEY `idx_pin_codes_caller_name` (`caller_name`),
  KEY `idx_pin_codes_pin_code` (`pin_code`),
  CONSTRAINT `pin_codes_ibfk_1` FOREIGN KEY (`service_code`) REFERENCES `services` (`service_code`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pin_codes`
--

LOCK TABLES `pin_codes` WRITE;
/*!40000 ALTER TABLE `pin_codes` DISABLE KEYS */;
/*!40000 ALTER TABLE `pin_codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `services`
--

DROP TABLE IF EXISTS `services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `services` (
  `service_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `service_code` varchar(20) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `location_id` bigint(20) unsigned NOT NULL,
  `emergency_state` tinyint(1) NOT NULL,
  PRIMARY KEY (`service_id`),
  UNIQUE KEY `service_code` (`service_code`),
  UNIQUE KEY `service_code_2` (`service_code`,`customer_id`),
  UNIQUE KEY `idx_services_service_code_customer_id` (`service_code`,`customer_id`),
  KEY `location_id` (`location_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `services_ibfk_1` FOREIGN KEY (`location_id`) REFERENCES `locations` (`location_id`) ON UPDATE CASCADE,
  CONSTRAINT `services_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services`
--

LOCK TABLES `services` WRITE;
/*!40000 ALTER TABLE `services` DISABLE KEYS */;
INSERT INTO `services` VALUES (1,'Serv_FRA_1',9,1,0),(2,'Serv_UK_1',9,2,0);
/*!40000 ALTER TABLE `services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_types`
--

DROP TABLE IF EXISTS `user_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_types` (
  `user_type_id` int(11) NOT NULL DEFAULT '0',
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`user_type_id`),
  UNIQUE KEY `user_type` (`user_type`),
  KEY `idx_user_types_user_type` (`user_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_types`
--

LOCK TABLES `user_types` WRITE;
/*!40000 ALTER TABLE `user_types` DISABLE KEYS */;
INSERT INTO `user_types` VALUES (5,'Admin'),(7,'Agent'),(4,'Expert_L1'),(3,'Expert_L2'),(2,'Expert_L3'),(1,'SuperAdmin'),(6,'Supervisor');
/*!40000 ALTER TABLE `user_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_type_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `created_by` bigint(20) unsigned NOT NULL,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `idx_users_username_customer_id` (`username`,`customer_id`),
  KEY `created_by` (`created_by`),
  KEY `idx_users_user_type_id` (`user_type_id`),
  KEY `idx_users_customer_id` (`customer_id`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`user_type_id`) REFERENCES `user_types` (`user_type_id`) ON UPDATE CASCADE,
  CONSTRAINT `users_ibfk_2` FOREIGN KEY (`created_by`) REFERENCES `users` (`user_id`) ON UPDATE CASCADE,
  CONSTRAINT `users_ibfk_3` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `weekdays`
--

DROP TABLE IF EXISTS `weekdays`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `weekdays` (
  `service_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `weekday` int(10) unsigned NOT NULL,
  `open_time_1` time DEFAULT NULL,
  `close_time_1` time DEFAULT NULL,
  `open_time_2` time DEFAULT NULL,
  `close_time_2` time DEFAULT NULL,
  PRIMARY KEY (`service_id`,`weekday`),
  CONSTRAINT `weekdays_ibfk_1` FOREIGN KEY (`service_id`) REFERENCES `services` (`service_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `weekdays`
--

LOCK TABLES `weekdays` WRITE;
/*!40000 ALTER TABLE `weekdays` DISABLE KEYS */;
INSERT INTO `weekdays` VALUES (1,1,'08:00:00','19:00:00',NULL,NULL),(1,2,'08:00:00','18:00:00',NULL,NULL),(1,3,'08:00:00','17:00:00',NULL,NULL),(1,4,'08:00:00','16:00:00',NULL,NULL),(1,5,'08:00:00','12:00:00','13:00:00','18:00:00'),(2,1,'08:00:00','12:00:00','14:00:00','18:00:00'),(2,2,'08:00:00','12:00:00','14:00:00','18:00:00');
/*!40000 ALTER TABLE `weekdays` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-14 17:55:18
