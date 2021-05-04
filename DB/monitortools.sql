create database MonitorTools;
use MonitorTools;

CREATE TABLE Monitor_tb (
  idMonitor_tb INT NOT NULL AUTO_INCREMENT,
  Hostname VARCHAR(45) NOT NULL,
  ID_calc FLOAT NOT NULL,
  ID_cpu FLOAT NOT NULL,
  ID_mem FLOAT NOT NULL,
  tool VARCHAR(45) NOT NULL,
 # Whenhappen VARCHAR(45) NOT NULL,
  Whenhappen Datetime NOT NULL,
 
  PRIMARY KEY (idMonitor_tb));
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE LogMonitor_tb (
  idMonitor_tb INT NOT NULL AUTO_INCREMENT,
  Hostname VARCHAR(45) NOT NULL,
  ID_calc FLOAT NOT NULL,
  ID_cpu FLOAT NOT NULL,
  ID_mem FLOAT NOT NULL,
  tool VARCHAR(45) NOT NULL,
 # Whenhappen VARCHAR(45) NOT NULL,
  Whenhappen Datetime NOT NULL,
 
  PRIMARY KEY (idMonitor_tb));


Select * from Monitor_tb;

truncate Monitor_tb;

#drop database MonitorTools;