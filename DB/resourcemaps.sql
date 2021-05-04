create database ResourcesCluster;

use ResourcesCluster;

CREATE TABLE Resources_tb (
  idResources_tb INT NOT NULL AUTO_INCREMENT,
  VM_Host VARCHAR(45) NOT NULL,
  VM_Status VARCHAR(45) NOT NULL,
  Hostname VARCHAR(45) NOT NULL,
  Provider_name VARCHAR(45) NOT NULL,
  Serverport int NOT NULL,
  PRIMARY KEY (idResources_tb))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

SET SQL_SAFE_UPDATES = 0;


