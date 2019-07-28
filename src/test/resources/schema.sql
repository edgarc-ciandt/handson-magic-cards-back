DROP TABLE IF EXISTS magiccard;
CREATE TABLE magiccard (
  GathererId varchar(16) NOT NULL,
  Variation smallint DEFAULT NULL,
  SearchName varchar(128)  NOT NULL,
  PtBRSearchName varchar(128) ,
  EnglishName varchar(128)  NOT NULL,
  PtBRName varchar(128) ,
  LinkName varchar(128)  NOT NULL,
  Color int NOT NULL,
  ManaCost varchar(128) DEFAULT NULL,
  CollectionNumber smallint DEFAULT NULL,
  Rarity varchar(1) NOT NULL,
  Rules varchar(128)  NOT NULL,
  FlavorText varchar(128)  NOT NULL,
  SuperTypes int NOT NULL,
  CardTypes int NOT NULL,
  UnseriousSubTypes varchar(128) DEFAULT NULL,
  Power varchar(4) DEFAULT NULL,
  Toughness varchar(4) DEFAULT NULL,
  Loyalty varchar(4) DEFAULT NULL,
  ExpansionId int NOT NULL,
  ArtistId int NOT NULL,
  FlipName varchar(128) ,
  FlipRules varchar(128) ,
  FlipSuperTypes int DEFAULT NULL,
  FlipTypes int DEFAULT NULL,
  FlipPower varchar(4) DEFAULT NULL,
  FlipToughness varchar(4) DEFAULT NULL,
  FlipGathererId varchar(16) DEFAULT NULL,
  SplitManaCost varchar(128) DEFAULT NULL,
  PRIMARY KEY (GathererId)
);

DROP TABLE IF EXISTS magicexpansion;
CREATE TABLE magicexpansion (
  ExpansionId int NOT NULL IDENTITY,
  Name varchar(128)  NOT NULL,
  PtBRName varchar(128) ,
  LinkName varchar(128)  NOT NULL,
  Code varchar(16) NOT NULL,
  LaunchDate date NOT NULL,
  ExpansionCategoryId smallint NOT NULL,
  IsPromo bit(1) DEFAULT NULL,
  IsLegal bit(1) DEFAULT NULL
);