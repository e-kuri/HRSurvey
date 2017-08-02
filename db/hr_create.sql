-- MySQL Script generated by MySQL Workbench
-- Mon Jul 24 15:29:35 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hr
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `hr` ;

-- -----------------------------------------------------
-- Schema hr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hr` DEFAULT CHARACTER SET utf8 ;
USE `hr` ;

-- -----------------------------------------------------
-- Table `hr`.`Employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`Employee` ;

CREATE TABLE IF NOT EXISTS `hr`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT,
  `employeeNumber` VARCHAR(15) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `isHR` TINYINT NOT NULL,
  `email` VARCHAR(70) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idEmployee`))
ENGINE = InnoDB;

CREATE UNIQUE INDEX `email_UNIQUE` ON `hr`.`Employee` (`email` ASC);

CREATE UNIQUE INDEX `employeeNumber_UNIQUE` ON `hr`.`Employee` (`employeeNumber` ASC);


-- -----------------------------------------------------
-- Table `hr`.`CatGrade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`CatGrade` ;

CREATE TABLE IF NOT EXISTS `hr`.`CatGrade` (
  `idCatGrade` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCatGrade`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hr`.`Survey`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`Survey` ;

CREATE TABLE IF NOT EXISTS `hr`.`Survey` (
  `idSurvey` INT NOT NULL AUTO_INCREMENT,
  `idEmployee_evaluated` INT NOT NULL,
  `idEmployee_evaluator` INT NOT NULL,
  `answered` TINYINT NOT NULL,
  `comments` TEXT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idSurvey`),
  CONSTRAINT `fk_Survey_Employee`
    FOREIGN KEY (`idEmployee_evaluated`)
    REFERENCES `hr`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Survey_Employee1`
    FOREIGN KEY (`idEmployee_evaluator`)
    REFERENCES `hr`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Survey_Employee_idx` ON `hr`.`Survey` (`idEmployee_evaluated` ASC);

CREATE INDEX `fk_Survey_Employee1_idx` ON `hr`.`Survey` (`idEmployee_evaluator` ASC);


-- -----------------------------------------------------
-- Table `hr`.`Grade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`Grade` ;

CREATE TABLE IF NOT EXISTS `hr`.`Grade` (
  `idGrade` INT NOT NULL AUTO_INCREMENT,
  `grade` TINYINT check(grade between 1 and 5),
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idCatGrade` INT NOT NULL,
  `idSurvey` INT NOT NULL,
  PRIMARY KEY (`idGrade`),
  CONSTRAINT `fk_Grade_Cat_Grade1`
    FOREIGN KEY (`idCatGrade`)
    REFERENCES `hr`.`CatGrade` (`idCatGrade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Grade_Survey1`
    FOREIGN KEY (`idSurvey`)
    REFERENCES `hr`.`Survey` (`idSurvey`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Grade_Cat_Grade1_idx` ON `hr`.`Grade` (`idCatGrade` ASC);

CREATE INDEX `fk_Grade_Survey1_idx` ON `hr`.`Grade` (`idSurvey` ASC);


-- -----------------------------------------------------
-- Table `hr`.`EmployeeCategoryAverage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`EmployeeCategoryAverage` ;
/*
CREATE TABLE IF NOT EXISTS `hr`.`EmployeeCategoryAverage` (
  `idCatGrade` INT NOT NULL,
  `idEmployee` INT NOT NULL,
  `average` FLOAT NULL,
  `updated` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCatGrade`, `idEmployee`),
  CONSTRAINT `fk_CategoryAverage_CatGrade1`
    FOREIGN KEY (`idCatGrade`)
    REFERENCES `hr`.`CatGrade` (`idCatGrade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_CategoryAverage_Employee1`
    FOREIGN KEY (`idEmployee`)
    REFERENCES `hr`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_CategoryAverage_CatGrade1_idx` ON `hr`.`EmployeeCategoryAverage` (`idCatGrade` ASC);

CREATE INDEX `fk_CategoryAverage_Employee1_idx` ON `hr`.`EmployeeCategoryAverage` (`idEmployee` ASC);

*/
-- -----------------------------------------------------
-- Table `hr`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `hr`.`User` ;

CREATE TABLE IF NOT EXISTS `hr`.`User` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `created` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idEmployee` INT NOT NULL,
  PRIMARY KEY (`idUser`),
  CONSTRAINT `fk_User_Employee1`
    FOREIGN KEY (`idEmployee`)
    REFERENCES `hr`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `username_UNIQUE` ON `hr`.`User` (`username` ASC);

CREATE INDEX `fk_User_Employee1_idx` ON `hr`.`User` (`idEmployee` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*
DELIMITER //
DROP TRIGGER IF EXISTS employee_category_average//
CREATE TRIGGER employee_category_average AFTER INSERT ON Grade
FOR EACH ROW BEGIN
DECLARE eid INT;
SET eid = (select idEmployee from survey where idSurvey = NEW.idSurvey);
UPDATE employeecategoryaverage SET average = (
	SELECT AVG(grade) FROM Grade where idCatGrade = NEW.idCatGrade AND idSurvey in (
		SELECT idSurvey FROM survey WHERE idEmployee_evaluated = eid
	)
) where idCatGrade = NEW.idCatGrade AND idEmployee = eid;
END//
*/