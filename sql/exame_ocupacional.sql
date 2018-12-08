-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema exame_ocupacional
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema exame_ocupacional
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `exame_ocupacional` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `exame_ocupacional` ;

-- -----------------------------------------------------
-- Table `exame_ocupacional`.`tipo_exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exame_ocupacional`.`tipo_exame` ;

CREATE TABLE IF NOT EXISTS `exame_ocupacional`.`tipo_exame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exame_ocupacional`.`medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exame_ocupacional`.`medico` ;

CREATE TABLE IF NOT EXISTS `exame_ocupacional`.`medico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(60) NOT NULL,
  `crm` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `crm_UNIQUE` ON `exame_ocupacional`.`medico` (`crm` ASC);


-- -----------------------------------------------------
-- Table `exame_ocupacional`.`exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exame_ocupacional`.`exame` ;

CREATE TABLE IF NOT EXISTS `exame_ocupacional`.`exame` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo_exame` INT NOT NULL,
  `medico` INT NOT NULL,
  `dt_exame` DATETIME NOT NULL,
  `dt_vencimento` DATETIME NOT NULL,
  `resultado` TINYINT(1) NOT NULL,
  `finalidade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE INDEX `fk_exame_tipo_exame_idx` ON `exame_ocupacional`.`exame` (`tipo_exame` ASC);

CREATE INDEX `fk_exame_medico1_idx` ON `exame_ocupacional`.`exame` (`medico` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;