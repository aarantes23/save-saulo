-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phonebook` DEFAULT CHARACTER SET utf8 ;
USE `phonebook` ;

-- -----------------------------------------------------
-- Table `phonebook`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phonebook`.`city` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `state` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phonebook`.`contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phonebook`.`contact` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `name` VARCHAR(200) NOT NULL COMMENT '',
  `birth_date` DATE NOT NULL COMMENT '',
  `address_street` VARCHAR(200) NOT NULL COMMENT '',
  `address_num` VARCHAR(45) NOT NULL COMMENT '',
  `address_comp` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `address_neighborhood` VARCHAR(200) NOT NULL COMMENT '',
  `id_City` INT(11) NOT NULL COMMENT '',
  `cep` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(200) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Contact_City_idx` (`id_City` ASC)  COMMENT '',
  CONSTRAINT `fk_Contact_City`
    FOREIGN KEY (`id_City`)
    REFERENCES `phonebook`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phonebook`.`commitment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phonebook`.`commitment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `date_start` DATE NOT NULL COMMENT '',
  `hour_start` DATE NOT NULL COMMENT '',
  `date_end` DATE NOT NULL COMMENT '',
  `hour_end` DATE NOT NULL COMMENT '',
  `description` VARCHAR(200) NOT NULL COMMENT '',
  `observation` VARCHAR(200) NOT NULL COMMENT '',
  `status` VARCHAR(200) NOT NULL COMMENT '',
  `Contact_id` INT(11) NOT NULL COMMENT '',
  `Contact_id_City` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Commitment_Contact1_idx` (`Contact_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Commitment_Contact1`
    FOREIGN KEY (`Contact_id`)
    REFERENCES `phonebook`.`contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `phonebook`.`phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `phonebook`.`phone` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `Contact_id` INT(11) NOT NULL COMMENT '',
  `phone` VARCHAR(45) NOT NULL COMMENT '',
  `phone_type` VARCHAR(45) NOT NULL COMMENT '',
  `main` VARCHAR(45) NOT NULL COMMENT '',
  `Contact_id_City` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `fk_Phone_Contact1_idx` (`Contact_id` ASC)  COMMENT '',
  CONSTRAINT `fk_Phone_Contact1`
    FOREIGN KEY (`Contact_id`)
    REFERENCES `phonebook`.`contact` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
