DROP TABLE IF EXISTS `magiccard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magiccard` (
  `GathererId` varchar(16) NOT NULL,
  `Variation` smallint(5) DEFAULT NULL,
  `SearchName` text NOT NULL,
  `PtBRSearchName` text,
  `EnglishName` text NOT NULL,
  `PtBRName` text,
  `LinkName` text NOT NULL,
  `Color` int(10) NOT NULL,
  `ManaCost` varchar(128) DEFAULT NULL,
  `CollectionNumber` smallint(5) DEFAULT NULL,
  `ConvertedManaCost` float DEFAULT NULL,
  `Rarity` char(1) NOT NULL,
  `Rules` text NOT NULL,
  `FlavorText` text NOT NULL,
  `SuperTypes` int(10) NOT NULL,
  `CardTypes` int(10) NOT NULL,
  `UnseriousSubTypes` varchar(128) DEFAULT NULL,
  `Power` varchar(4) DEFAULT NULL,
  `Toughness` varchar(4) DEFAULT NULL,
  `Loyalty` varchar(4) DEFAULT NULL,
  `ExpansionId` int(10) NOT NULL,
  `ArtistId` int(10) NOT NULL,
  `FlipName` text,
  `FlipRules` text,
  `FlipSuperTypes` int(10) DEFAULT NULL,
  `FlipTypes` int(10) DEFAULT NULL,
  `FlipPower` varchar(4) DEFAULT NULL,
  `FlipToughness` varchar(4) DEFAULT NULL,
  `FlipGathererId` varchar(16) DEFAULT NULL,
  `SplitManaCost` varchar(128) DEFAULT NULL,
  `SplitConvertedManaCost` float DEFAULT NULL,
  PRIMARY KEY (`GathererId`),
  UNIQUE KEY `PK_MagicCard` (`GathererId`),
  KEY `ArtistId` (`ArtistId`),
  KEY `ExpansionId` (`ExpansionId`),
  KEY `IX_MagicCard_AdvancedSearch` (`ExpansionId`,`GathererId`,`Color`,`CardTypes`,`FlipTypes`),
  KEY `IX_MagicCard_ExpansionId` (`ExpansionId`),
  KEY `IX_MagicCard_LinkName` (`LinkName`(255),`GathererId`,`ExpansionId`,`Variation`,`ArtistId`),
  CONSTRAINT `magiccard_ibfk_1` FOREIGN KEY (`ArtistId`) REFERENCES `artist` (`ArtistId`),
  CONSTRAINT `magiccard_ibfk_2` FOREIGN KEY (`ExpansionId`) REFERENCES `magicexpansion` (`ExpansionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

DROP TABLE IF EXISTS `magicexpansion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `magicexpansion` (
  `ExpansionId` int(10) NOT NULL AUTO_INCREMENT,
  `Name` text NOT NULL,
  `PtBRName` text,
  `LinkName` text NOT NULL,
  `Code` varchar(16) NOT NULL,
  `LaunchDate` date NOT NULL,
  `ExpansionCategoryId` smallint(5) NOT NULL,
  `IsPromo` bit(1) DEFAULT NULL,
  `IsLegal` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ExpansionId`),
  UNIQUE KEY `PK_MagicExpansion` (`ExpansionId`),
  KEY `FK_MagicExpansion_MagicExpansionCategory` (`ExpansionCategoryId`),
  CONSTRAINT `magicexpansion_ibfk_1` FOREIGN KEY (`ExpansionCategoryId`) REFERENCES `magicexpansioncategory` (`ExpansionCategoryId`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;