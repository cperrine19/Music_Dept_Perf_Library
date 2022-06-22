-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema music_dept_perf_library
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema music_dept_perf_library
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `music_dept_perf_library` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `music_dept_perf_library` ;

-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`composer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`composer` (
  `idcomposer` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcomposer`, `last_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`composer_song_title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`composer_song_title` (
  `song_title` VARCHAR(45) NOT NULL,
  `idcomposer` INT NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  INDEX `idcomposer_idx` (`idcomposer` ASC) VISIBLE,
  INDEX `last_name_idx` (`last_name` ASC) VISIBLE,
  CONSTRAINT `idcomposer`
    FOREIGN KEY (`idcomposer`)
    REFERENCES `music_dept_perf_library`.`composer` (`idcomposer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `last_name`
    FOREIGN KEY (`last_name`)
    REFERENCES `music_dept_perf_library`.`composer` (`last_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`performer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`performer` (
  `idperformer` INT NOT NULL AUTO_INCREMENT,
  `artist_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`artist_name`),
  UNIQUE INDEX `idperformer` (`idperformer` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`song_title`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`song_title` (
  `idsong_title` INT NOT NULL AUTO_INCREMENT,
  `song_title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`song_title`),
  UNIQUE INDEX `idsong_title` (`idsong_title` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`performance_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`performance_type` (
  `idperformance_type` INT NOT NULL AUTO_INCREMENT,
  `performance_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`performance_type`),
  UNIQUE INDEX `idsong_type` (`idperformance_type` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`song_title_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`song_title_type` (
  `song_title` VARCHAR(45) NOT NULL,
  `performance_type` VARCHAR(45) NULL DEFAULT NULL,
  `idcomposer` INT NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  INDEX `song_title_idx` (`song_title` ASC) VISIBLE,
  INDEX `performance_type_idx` (`performance_type` ASC) VISIBLE,
  INDEX `idcomposer_idx` (`idcomposer` ASC) VISIBLE,
  INDEX `last_name_idx` (`last_name` ASC) VISIBLE,
  CONSTRAINT `song_title`
    FOREIGN KEY (`song_title`)
    REFERENCES `music_dept_perf_library`.`song_title` (`song_title`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `performance_type`
    FOREIGN KEY (`performance_type`)
    REFERENCES `music_dept_perf_library`.`performance_type` (`performance_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idcomposer`
    FOREIGN KEY (`idcomposer`)
    REFERENCES `music_dept_perf_library`.`composer` (`idcomposer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `last_name`
    FOREIGN KEY (`last_name`)
    REFERENCES `music_dept_perf_library`.`composer` (`last_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `music_dept_perf_library`.`performances`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `music_dept_perf_library`.`performances` (
  `idperformances` INT NOT NULL AUTO_INCREMENT,
  `performance_date` DATE NOT NULL,
  `artist_name` VARCHAR(45) NOT NULL,
  `song_title` VARCHAR(45) NOT NULL,
  `performance_type` VARCHAR(45) NOT NULL,
  `idcomposer` INT NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idperformances`),
  UNIQUE INDEX `idperformances_UNIQUE` (`idperformances` ASC) VISIBLE,
  INDEX `artist_name_idx` (`artist_name` ASC) VISIBLE,
  INDEX `song_title_idx` (`song_title` ASC) VISIBLE,
  INDEX `idcomposer_idx` (`idcomposer` ASC) VISIBLE,
  INDEX `last_name_idx` (`last_name` ASC) VISIBLE,
  INDEX `performance_type_idx` (`performance_type` ASC) VISIBLE,
  CONSTRAINT `artist_name`
    FOREIGN KEY (`artist_name`)
    REFERENCES `music_dept_perf_library`.`performer` (`artist_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `song_title`
    FOREIGN KEY (`song_title`)
    REFERENCES `music_dept_perf_library`.`song_title` (`song_title`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idcomposer`
    FOREIGN KEY (`idcomposer`)
    REFERENCES `music_dept_perf_library`.`composer` (`idcomposer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `last_name`
    FOREIGN KEY (`last_name`)
    REFERENCES `music_dept_perf_library`.`composer` (`last_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `performance_type`
    FOREIGN KEY (`performance_type`)
    REFERENCES `music_dept_perf_library`.`performance_type` (`performance_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
