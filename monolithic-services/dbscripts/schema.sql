-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema truyum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `truyum` DEFAULT CHARACTER SET utf8 ;
USE `truyum` ;

-- -----------------------------------------------------
-- Table `truyum`.`menu_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`menu_item` (
  `me_id` INT(11) NOT NULL AUTO_INCREMENT,
  `me_name` VARCHAR(100) NULL DEFAULT NULL,
  `me_price` DECIMAL(8,2) NULL DEFAULT NULL,
  `me_active` VARCHAR(3) NULL DEFAULT NULL,
  `me_date_of_launch` DATE NULL DEFAULT NULL,
  `me_category` VARCHAR(45) NULL DEFAULT NULL,
  `me_free_delivery` VARCHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`cart` (
  `ct_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ct_us_id` INT(11) NULL DEFAULT NULL,
  `ct_pr_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ct_id`),
  INDEX `ct_us_fk_idx` (`ct_us_id` ASC),
  INDEX `ct_pr_fk_idx` (`ct_pr_id` ASC),
  CONSTRAINT `ct_pr_fk`
    FOREIGN KEY (`ct_pr_id`)
    REFERENCES `truyum`.`menu_item` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ct_us_fk`
    FOREIGN KEY (`ct_us_id`)
    REFERENCES `truyum`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`role` (
  `ro_id` INT(11) NOT NULL,
  `ro_name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ro_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `truyum`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `truyum`.`user_role` (
  `ur_id` INT(11) NOT NULL,
  `ur_us_id` INT(11) NOT NULL,
  `ur_ro_id` INT(11) NOT NULL,
  PRIMARY KEY (`ur_id`),
  INDEX `FKjia4161ecu6h4p0egc2oc04lt` (`ur_ro_id` ASC),
  INDEX `FK1t65ha4bv531fmav53vlu66fg` (`ur_us_id` ASC),
  CONSTRAINT `FK1t65ha4bv531fmav53vlu66fg`
    FOREIGN KEY (`ur_us_id`)
    REFERENCES `truyum`.`user` (`us_id`),
  CONSTRAINT `FKjia4161ecu6h4p0egc2oc04lt`
    FOREIGN KEY (`ur_ro_id`)
    REFERENCES `truyum`.`role` (`ro_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
