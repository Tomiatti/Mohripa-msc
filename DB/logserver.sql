use logserver;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE TimerMethod_tb (
  idTimerMethod_tb INT(11) AUTO_INCREMENT NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  WhichClass VARCHAR(45) NOT NULL,
  Whenhappen VARCHAR(45) NOT NULL,
  WhichMethod VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerMethod_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE TABLE TimerClass_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  WhichClass VARCHAR(45) NOT NULL,
  Whenhappen VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogMessages_tb (
  Data VARCHAR(30) NOT NULL,
  Logger VARCHAR(50) NOT NULL,
  Level VARCHAR(10) NOT NULL,
  Message VARCHAR(1000) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE LogTimer_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogRequest_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  Description VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogResponse_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  Description VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogApp_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  Description VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogAlocator_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  Description VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE LogTransportador_tb (
  idTimerClass_tb INT(11) AUTO_INCREMENT NOT NULL,
  Whenstart VARCHAR(45) NOT NULL,
  InicialTime VARCHAR(45) NOT NULL,  
  WhichModule VARCHAR(45) NOT NULL,  
  Whenfinish VARCHAR(45) NOT NULL,
  FinalTime VARCHAR(45) NOT NULL,
  TookTime VARCHAR(45) NOT NULL,
  Description VARCHAR(45) NOT NULL,
  PRIMARY KEY (idTimerClass_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


SET GLOBAL max_connections = 2048;