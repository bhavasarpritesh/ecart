CREATE DATABASE  IF NOT EXISTS `shop5` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop5`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: shop5
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `add_seq`
--

DROP TABLE IF EXISTS `add_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `add_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `add_seq`
--

LOCK TABLES `add_seq` WRITE;
/*!40000 ALTER TABLE `add_seq` DISABLE KEYS */;
INSERT INTO `add_seq` VALUES (501);
/*!40000 ALTER TABLE `add_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_tab`
--

DROP TABLE IF EXISTS `address_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_tab` (
  `add_id_col` int NOT NULL,
  `user_city_col` varchar(255) DEFAULT NULL,
  `user_landmark_col` varchar(255) DEFAULT NULL,
  `user_pincode_col` int DEFAULT NULL,
  `user_street_col` varchar(255) DEFAULT NULL,
  `add_type_col` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`add_id_col`),
  KEY `FK5m2wpob5it8uqltulwggktpi7` (`user_id`),
  CONSTRAINT `FK5m2wpob5it8uqltulwggktpi7` FOREIGN KEY (`user_id`) REFERENCES `user_tab` (`user_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_tab`
--

LOCK TABLES `address_tab` WRITE;
/*!40000 ALTER TABLE `address_tab` DISABLE KEYS */;
INSERT INTO `address_tab` VALUES (1,'pune','starbucks',411006,'fc road','home',1),(2,'shirpur','kalyani nagar',50000,'main','home',2),(3,'shirpur','jadhav nagar',425405,'near court','home',4),(402,'shirpur','bijali nagar',50000,'main','business',1),(403,'shirpur','bijali nagar',425421,'main','office',2);
/*!40000 ALTER TABLE `address_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (15);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_prod_tab`
--

DROP TABLE IF EXISTS `order_prod_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_prod_tab` (
  `order_id_col` int NOT NULL,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `order_order_id_col` int DEFAULT NULL,
  `product_product_id_col` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`order_id_col`),
  KEY `FKjliqqr2yalpc7q2sk1wqgv4ty` (`order_order_id_col`),
  KEY `FKs9su2p635p264b0kvua144yaa` (`product_product_id_col`),
  CONSTRAINT `FKjliqqr2yalpc7q2sk1wqgv4ty` FOREIGN KEY (`order_order_id_col`) REFERENCES `order_tab` (`order_id_col`),
  CONSTRAINT `FKs9su2p635p264b0kvua144yaa` FOREIGN KEY (`product_product_id_col`) REFERENCES `product_tab` (`product_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_prod_tab`
--

LOCK TABLES `order_prod_tab` WRITE;
/*!40000 ALTER TABLE `order_prod_tab` DISABLE KEYS */;
INSERT INTO `order_prod_tab` VALUES (102,4000,3,52,1,4),(103,550,2,52,2,4),(104,5000,3,53,2,3),(105,5050,2,53,1,4),(106,6000,3,54,3,3),(107,8050,2,54,3,4),(202,600,3,152,3,6),(203,8050,2,152,3,4),(204,600,3,153,3,4),(205,8050,2,153,3,1),(302,222,1,253,9,1),(429,900,1,366,6,3),(430,5555,1,366,9,2),(502,400,1,452,1,3),(503,77,1,453,11,3),(504,777,1,453,12,4),(602,88,1,552,14,4),(603,8897,1,552,13,1),(702,77,1,652,11,2),(703,777,1,652,12,3),(704,77,1,653,11,4),(705,777,1,654,12,4),(706,77,1,655,11,4),(802,77,1,752,11,2),(803,777,1,752,12,4),(804,8897,1,753,13,4),(805,77,1,754,11,4),(806,777,1,755,12,4),(807,777,1,756,12,4),(902,38000,1,852,2,4),(903,44000,1,853,3,2),(904,38000,1,854,2,3),(1002,44000,2,952,3,1),(1003,1200,1,952,4,4);
/*!40000 ALTER TABLE `order_prod_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_seq`
--

DROP TABLE IF EXISTS `order_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_seq`
--

LOCK TABLES `order_seq` WRITE;
/*!40000 ALTER TABLE `order_seq` DISABLE KEYS */;
INSERT INTO `order_seq` VALUES (1101);
/*!40000 ALTER TABLE `order_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_status_tab`
--

DROP TABLE IF EXISTS `order_status_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_status_tab` (
  `orderstatus_id_col` int NOT NULL,
  `order_status_col` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderstatus_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_status_tab`
--

LOCK TABLES `order_status_tab` WRITE;
/*!40000 ALTER TABLE `order_status_tab` DISABLE KEYS */;
INSERT INTO `order_status_tab` VALUES (1,'placed'),(2,'cancel'),(3,'shipped'),(4,'in-transit'),(5,'deliverd');
/*!40000 ALTER TABLE `order_status_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tab`
--

DROP TABLE IF EXISTS `order_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_tab` (
  `order_id_col` int NOT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `order_quanity_col` float DEFAULT NULL,
  `address_add_id_col` int DEFAULT NULL,
  `status_id` int DEFAULT NULL,
  `mode_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `payment_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id_col`),
  KEY `FK625tiblbhoh4mg2uv15sd8cm9` (`address_add_id_col`),
  KEY `FKiqyatnivi5abb4fnjp6hc9o4x` (`status_id`),
  KEY `FKfcnysh097kpkbebrfjb2k2bvb` (`mode_id`),
  KEY `FK7p6g59uouq2ji918y7fyye1dy` (`user_id`),
  CONSTRAINT `FK625tiblbhoh4mg2uv15sd8cm9` FOREIGN KEY (`address_add_id_col`) REFERENCES `address_tab` (`add_id_col`),
  CONSTRAINT `FK7p6g59uouq2ji918y7fyye1dy` FOREIGN KEY (`user_id`) REFERENCES `user_tab` (`user_id_col`),
  CONSTRAINT `FKfcnysh097kpkbebrfjb2k2bvb` FOREIGN KEY (`mode_id`) REFERENCES `payment_mode_tab` (`paymentmode_id_col`),
  CONSTRAINT `FKiqyatnivi5abb4fnjp6hc9o4x` FOREIGN KEY (`status_id`) REFERENCES `order_status_tab` (`orderstatus_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tab`
--

LOCK TABLES `order_tab` WRITE;
/*!40000 ALTER TABLE `order_tab` DISABLE KEYS */;
INSERT INTO `order_tab` VALUES (52,'2022-04-19 15:25:45.019000',4000,1,3,1,1,'pay_JRTQ8dFT1TE6D'),(53,'2022-04-19 15:28:02.697000',6000,2,2,2,2,'pay_JRTQ8dFT1L9OL'),(54,'2022-04-19 15:29:15.687000',9000,3,3,3,4,'pay_WTQ8dFT1L90G'),(152,'2022-04-19 16:42:43.715000',900,3,1,3,4,'pay_VETQ8dFT1L90F'),(153,'2022-04-19 16:43:02.720000',900,3,3,3,4,'pay_LRTQ8dFT1L90P'),(252,'2022-05-02 17:13:02.892000',5555,2,4,1,2,'pay_NTTQ8dFT1L90Q'),(253,'2022-05-02 17:13:02.892000',5555,1,4,1,2,'pay_KRTQ8dFT1L90W'),(366,'2022-05-04 11:15:14.061000',6455,2,1,1,2,'pay_JRTQ8dWo1L90G'),(452,'2022-05-05 13:34:05.361000',400,2,1,1,2,'pay_JRTQ8dFT1L90GB'),(453,'2022-05-05 15:16:43.202000',854,2,4,1,2,'pay_JRVAV9PJ0XRa8m'),(552,'2022-05-05 17:37:12.106000',8985,1,1,1,1,'pay_JRXYuMa94bP681'),(652,'2022-05-06 09:44:13.659000',854,1,1,1,1,'pay_JRo2Oj3ahOSZs5'),(653,'2022-05-06 10:11:21.270000',77,1,1,1,1,'pay_JRoV7COeYjbtiw'),(654,'2022-05-06 10:12:38.374000',777,1,1,1,1,'pay_JRoWULFRfvtZae'),(655,'2022-05-06 10:16:05.385000',77,1,1,1,1,'pay_JRoa7vK2eejXy0'),(752,'2022-05-06 10:20:49.040000',854,1,1,1,1,'pay_JRof7IKbUCdRyI'),(753,'2022-05-06 10:22:17.387000',8897,1,1,1,1,'pay_JRogfgYKuQesAw'),(754,'2022-05-06 10:23:39.067000',77,1,1,1,1,'pay_JRoi6kMYJPe0hR'),(755,'2022-05-06 10:25:13.754000',777,1,1,1,1,'pay_JRojmeqQexyH6p'),(756,'2022-05-06 10:26:23.709000',777,1,1,1,1,'pay_JRokzLdEEmauy4'),(852,'2022-05-11 12:01:40.452000',38000,2,1,1,2,'pay_JTp3DkYvLCA56p'),(853,'2022-05-11 12:05:55.654000',44000,2,1,1,2,'pay_JTp7k3wHW5K8Sk'),(854,'2022-05-11 12:07:06.798000',38000,2,1,1,2,'pay_JTp8z4Mnwta7RF'),(952,'2022-05-19 16:55:11.025000',89200,2,1,1,2,'pay_JX4K4oDP80J5Bq');
/*!40000 ALTER TABLE `order_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderstatus_seq`
--

DROP TABLE IF EXISTS `orderstatus_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderstatus_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderstatus_seq`
--

LOCK TABLES `orderstatus_seq` WRITE;
/*!40000 ALTER TABLE `orderstatus_seq` DISABLE KEYS */;
INSERT INTO `orderstatus_seq` VALUES (101);
/*!40000 ALTER TABLE `orderstatus_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_mode_tab`
--

DROP TABLE IF EXISTS `payment_mode_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_mode_tab` (
  `paymentmode_id_col` int NOT NULL,
  `paymentmode_mode_col` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`paymentmode_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_mode_tab`
--

LOCK TABLES `payment_mode_tab` WRITE;
/*!40000 ALTER TABLE `payment_mode_tab` DISABLE KEYS */;
INSERT INTO `payment_mode_tab` VALUES (1,'Netbanking'),(2,'Debit'),(3,'creditcard'),(4,'COD'),(5,'Netbanking');
/*!40000 ALTER TABLE `payment_mode_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmode_seq`
--

DROP TABLE IF EXISTS `paymentmode_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paymentmode_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmode_seq`
--

LOCK TABLES `paymentmode_seq` WRITE;
/*!40000 ALTER TABLE `paymentmode_seq` DISABLE KEYS */;
INSERT INTO `paymentmode_seq` VALUES (101);
/*!40000 ALTER TABLE `paymentmode_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodcat_seq`
--

DROP TABLE IF EXISTS `prodcat_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodcat_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodcat_seq`
--

LOCK TABLES `prodcat_seq` WRITE;
/*!40000 ALTER TABLE `prodcat_seq` DISABLE KEYS */;
INSERT INTO `prodcat_seq` VALUES (151);
/*!40000 ALTER TABLE `prodcat_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodcat_tab`
--

DROP TABLE IF EXISTS `prodcat_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodcat_tab` (
  `prodcat_id_col` int NOT NULL,
  `prodcat_category_col` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`prodcat_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodcat_tab`
--

LOCK TABLES `prodcat_tab` WRITE;
/*!40000 ALTER TABLE `prodcat_tab` DISABLE KEYS */;
INSERT INTO `prodcat_tab` VALUES (1,'fashion'),(2,'electronics'),(3,'home appliance');
/*!40000 ALTER TABLE `prodcat_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prodrat_seq`
--

DROP TABLE IF EXISTS `prodrat_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prodrat_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prodrat_seq`
--

LOCK TABLES `prodrat_seq` WRITE;
/*!40000 ALTER TABLE `prodrat_seq` DISABLE KEYS */;
INSERT INTO `prodrat_seq` VALUES (101);
/*!40000 ALTER TABLE `prodrat_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_rating_tab`
--

DROP TABLE IF EXISTS `product_rating_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_rating_tab` (
  `prodrat_id_col` int NOT NULL,
  `prodrat_rate_col` int DEFAULT NULL,
  `product_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`prodrat_id_col`),
  KEY `FKkrb046c2nb26838y2o52hdmi3` (`product_id`),
  KEY `FKr4ux8ssyxpf77b1my1r2dwdi4` (`user_id`),
  CONSTRAINT `FKkrb046c2nb26838y2o52hdmi3` FOREIGN KEY (`product_id`) REFERENCES `product_tab` (`product_id_col`),
  CONSTRAINT `FKr4ux8ssyxpf77b1my1r2dwdi4` FOREIGN KEY (`user_id`) REFERENCES `user_tab` (`user_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_rating_tab`
--

LOCK TABLES `product_rating_tab` WRITE;
/*!40000 ALTER TABLE `product_rating_tab` DISABLE KEYS */;
INSERT INTO `product_rating_tab` VALUES (1,5,1,1),(2,4,2,2),(3,3,3,4);
/*!40000 ALTER TABLE `product_rating_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_seq`
--

DROP TABLE IF EXISTS `product_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_seq`
--

LOCK TABLES `product_seq` WRITE;
/*!40000 ALTER TABLE `product_seq` DISABLE KEYS */;
INSERT INTO `product_seq` VALUES (501);
/*!40000 ALTER TABLE `product_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_tab`
--

DROP TABLE IF EXISTS `product_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_tab` (
  `product_id_col` int NOT NULL,
  `product_avl_quanity_col` int DEFAULT NULL,
  `product_disc_col` varchar(255) DEFAULT NULL,
  `product_img_col` varchar(255) DEFAULT NULL,
  `product_name_col` varchar(255) DEFAULT NULL,
  `product_price_col` float DEFAULT NULL,
  `cat_id` int DEFAULT NULL,
  `product_status` int DEFAULT NULL,
  PRIMARY KEY (`product_id_col`),
  KEY `FKln5nd7qg8hlq1i69sc2xdcc0l` (`cat_id`),
  CONSTRAINT `FKln5nd7qg8hlq1i69sc2xdcc0l` FOREIGN KEY (`cat_id`) REFERENCES `prodcat_tab` (`prodcat_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_tab`
--

LOCK TABLES `product_tab` WRITE;
/*!40000 ALTER TABLE `product_tab` DISABLE KEYS */;
INSERT INTO `product_tab` VALUES (1,15,'Universal Voltage, Output Current : 2 A','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/charger.png','Samsung T20 Charger',400,2,0),(2,0,'6GB Ram,128 Gb Storage,5G','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/samsung3.png','Samsung S10 Plus+',38000,2,1),(3,11,'Intel Core i7,8 Gb Ram','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/laptop.png','Mi Notebook Horizon',44000,2,1),(4,19,'Good Fabric','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/adidas.png','Adidas T-shirt K2',1200,1,1),(5,20,'For Girls under 10 years','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/girl.png','Layca Tops',900,1,1),(6,15,'High Quality Material','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/mixer.png','Havells Mixer',1600,3,1),(7,20,'Slim Men Blue Jeans','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/jeans.png','Levi\'s Jeans',999,1,1),(8,20,'Best Washing Machine','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/Lg.png','LG Washing Machine',18900,3,1),(9,20,'Premium Quality Product','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/Leather-Jacket.png','Leather Jacket',4999,1,1),(10,20,'Cool Whole Room','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/cooler.png','Havells Cooler',12999,3,1),(11,14,'64 Ench, Android tv','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/tv.png','Samsung Smart Tv',64900,2,1),(12,14,'1 Ton Ac with 5 Star ','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/samsung ac.png','Samsung AC',87900,2,1),(13,18,'Sneakers For Men Size:8,9,10','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/shoes.png','Sneakers SW2',2999,1,1),(14,15,'Active Noice Cancellation','https://spring-aws-ecart.s3.ap-south-1.amazonaws.com/Sony-Headphone.png','Sony Headphones',8999,2,1);
/*!40000 ALTER TABLE `product_tab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_user_id_col` int NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FK561a33tgv2ad9g6l833lc8823` (`user_user_id_col`),
  CONSTRAINT `FK561a33tgv2ad9g6l833lc8823` FOREIGN KEY (`user_user_id_col`) REFERENCES `user_tab` (`user_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,'user'),(2,'user'),(3,'admin'),(4,'user'),(52,'user'),(102,'user'),(152,'user'),(402,'user'),(453,'user'),(502,'user');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (601);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tab`
--

DROP TABLE IF EXISTS `user_tab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_tab` (
  `user_id_col` int NOT NULL,
  `user_email_col` varchar(255) DEFAULT NULL,
  `user_mobile_col` bigint DEFAULT NULL,
  `user_name_col` varchar(255) DEFAULT NULL,
  `user_password_col` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id_col`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tab`
--

LOCK TABLES `user_tab` WRITE;
/*!40000 ALTER TABLE `user_tab` DISABLE KEYS */;
INSERT INTO `user_tab` VALUES (1,'vaishali@bbd.co.za',8888665190,'vaishali','$2a$10$FAwasWPiq0IU2SOGlkEa8.jiEt/pXSSa30u.6AhPyBemIpci90/he'),(2,'pritesh@bbd.co.za',7020371473,'pritesh','$2a$10$8szbTfP.OGEfwZu8FYVIPuUDnOp2RdWTPSySWdmz0WmtpuCSCBWGm'),(3,'admin@bbd.co.za',8877665544,'admin','$2a$10$HpcbAStRPwQ1ougS15.v1OzCsm2D8NRnyHSuD5VSemGUrS97mkC2C'),(4,'apurva@bbd.co.za',99887766,'apurva','$2a$10$rDbeenE9Dxmgtd5YGy9dgelDLoxckIFHRDKXFr9lNCwccExotNY22'),(52,'prince@bbd.co.za',99887777,'prince','$2a$10$VOODML.lEiSsWKGMGpr7XeaZ1xtm1UQsvC.QV8lTzgl8DC9/q1/eS'),(102,'hetvi@bbd.co.za',88887779,'hetvi','$2a$10$HojYdRHjDlYGzYGcpsNtKeJuCzV4vpm9tNRS8qJiZemyHrgw13TFy'),(152,'kaveri@bbd.co.za',7020518314,'kaveri','$2a$10$etzjkcu8XsblO46G6lpXkuR9GtQs/jz8Sr0b.HbOZTdbvzJRXxotq'),(402,'vaishalip@bbd.co.za',8888665190,'vaishali','$2a$10$G43Cr64jRyA4kjFftav7Teq2QLaPn0NJE3mkdUsFoZNfw2373/jZy'),(453,'priteshbe@gmail.com',8521563254,'pritesh','$2a$10$ukA9hEp5knkDi29iwREqhOoFJrgTvquyB8SKoR8EIO92AZh7quEza'),(502,'paresh@gmail.com',7744854574,'paresh','$2a$10$389EemfEYe/RNTU7u5tP2e3XuqbJa9RTOsnV8KwZPI.42xG/r/0P.');
/*!40000 ALTER TABLE `user_tab` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-14 14:09:28
