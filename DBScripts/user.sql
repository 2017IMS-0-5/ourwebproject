-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mis
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(12) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oidlpt3w74aa9f4bxdiamid0w` (`account`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'201711260115','201711260115@mail.bnu.edu.cn','女','2017','信管','李歆然','260115',1),(2,'201711260111','201711260111@mail.bnu.edu.cn','女','2017','信管','孙静彤','260111',1),(3,'201711260101','201711260101@mail.bnu.edu.cn','女','2017','信管','陈琛妍','260101',1),(4,'201711260103','201711260103@mail.bnu.edu.cn','女','2017','管科','强纾旖','260103',1),(5,'201611260101','201611260101@mail.bnu.edu.cn','男','2016','管科','张三','260101',1),(6,'201611260150','201611260150@mail.bnu.edu.cn','男','2016','公管','李四','260150',1),(7,'201811260166','201811260166@mail.bnu.edu.cn','男','2018','人管','王五','260166',1),(8,'201911260120','201911260120@mail.bnu.edu.cn','女','2019','人管大类','赵六','260120',1),(9,'201911260108','201911260108@mail.bnu.edu.cn','男','2019','人管大类','钱七','260108',1),(10,'201911260155','201911260155@mail.bnu.edu.cn','女','2019','管工大类','刘八','260155',1),(11,'201711260132','201711260132@mail.bnu.edu.cn','女','2017','人管','张同学','260132',1),(12,'201811260200','201811260200@mail.bnu.edu.cn','男','2018','公管','孙同学','260200',1),(13,'201911260254','201911260254@mail.bnu.edu.cn','女','2019','人管大类','李同学','260254',1),(14,'201611260233','201611260233@mail.bnu.edu.cn','女','2016','人管','杨同学','260233',1),(15,'201711260119','201711260119@mail.bnu.edu.cn','男','2017','管科','王同学','260119',1),(16,'11260001','zls@bnu.edu.cn','女','','行政管理系','张老师','260001',2),(17,'11260002','lxs@bnu.edu.cn','男','','信息管理系','李老师','260002',2),(18,'11260003','wls@bnu.edu.cn','女','','组织与人力资源系','王老师','260003',2),(19,'11260004','sls@bnu.edu.cn','女','','组织与人力资源系','孙老师','260004',2),(20,'11260005','yls@bnu.edu.cn','男','','信息管理系','杨老师','260005',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-08 13:58:17
