-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tedora_db
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tedora_db` ;

-- -----------------------------------------------------
-- Schema tedora_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tedora_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `tedora_db` ;

-- -----------------------------------------------------
-- Table `TaxPeriod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TaxPeriod` (
  `id` CHAR(6) NOT NULL,
  `year` SMALLINT NOT NULL,
  `month` SMALLINT NOT NULL,
  `open` DATE NOT NULL,
  `close` DATE NOT NULL,
  `closed` TINYINT NOT NULL,
  `countPurchase` BIGINT NULL,
  `countSales` BIGINT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UQ_TAXPERIOD_YEARMONTH` (`year` DESC, `month` DESC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `XRate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `XRate` (
  `id` CHAR(36) NOT NULL,
  `taxDate` DATE NOT NULL,
  `purchase` DECIMAL(6,3) NOT NULL,
  `sale` DECIMAL(6,3) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `taxDate_UNIQUE` (`taxDate` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `DoiType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `DoiType` (
  `id` CHAR(1) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `purchase` TINYINT NOT NULL,
  `sale` TINYINT NOT NULL,
  `foreign` TINYINT NOT NULL,
  `regex` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Partner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Partner` (
  `id` CHAR(36) NOT NULL,
  `doiType` CHAR(1) NOT NULL,
  `doiNum` VARCHAR(20) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `address` TEXT NULL,
  `countryTaxID` CHAR(4) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Partner_DoiType_idx` (`doiType` ASC) VISIBLE,
  UNIQUE INDEX `uq_PartnerDoiNum` (`doiType` ASC, `doiNum` ASC) VISIBLE,
  CONSTRAINT `fk_Partner_DoiType`
    FOREIGN KEY (`doiType`)
    REFERENCES `DoiType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FolioType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FolioType` (
  `id` CHAR(2) NOT NULL,
  `title` VARCHAR(200) NOT NULL,
  `purchase` TINYINT NOT NULL,
  `sale` TINYINT NOT NULL,
  `foreign` TINYINT NOT NULL,
  `allowDueDate` TINYINT NOT NULL,
  `regexSerie` VARCHAR(45) NOT NULL,
  `regexNum` VARCHAR(45) NOT NULL,
  `taxable` TINYINT NOT NULL,
  `serieTooltip` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Purchase` (
  `id` CHAR(36) NOT NULL,
  `period` CHAR(6) NOT NULL,
  `partner` CHAR(36) NOT NULL,
  `correlative` CHAR(10) NOT NULL,
  `dateIssue` DATE NULL,
  `dateDue` DATE NULL,
  `folioType` CHAR(2) NOT NULL,
  `folioSerie` VARCHAR(20) NULL,
  `folioNum` VARCHAR(20) NOT NULL,
  `priceFC` DECIMAL(14,2) NOT NULL,
  `taxFC` DECIMAL(14,2) NOT NULL,
  `taxFreeFC` DECIMAL(14,2) NOT NULL,
  `icbpFC` DECIMAL(14,2) NOT NULL,
  `othFC` DECIMAL(14,2) NOT NULL,
  `totalFC` DECIMAL(14,2) NOT NULL,
  `xrate` DECIMAL(6,3) NOT NULL,
  `currency` ENUM('PEN', 'USD') NOT NULL,
  `priceSC` DECIMAL(14,2) NOT NULL,
  `taxSC` DECIMAL(14,2) NOT NULL,
  `taxFreeSC` DECIMAL(14,2) NOT NULL,
  `icbpSC` DECIMAL(14,2) NOT NULL,
  `othSC` DECIMAL(14,2) NOT NULL,
  `totalSC` DECIMAL(14,2) NOT NULL,
  `modified` CHAR(36) NULL,
  `voidFlag` TINYINT NOT NULL,
  `spotID` VARCHAR(24) NULL,
  `spotDate` DATE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Purchase_TaxPeriod1_idx` (`period` ASC) VISIBLE,
  INDEX `fk_Purchase_FolioType1_idx` (`folioType` ASC) VISIBLE,
  INDEX `fk_Purchase_Partner1_idx` (`partner` ASC) VISIBLE,
  INDEX `fk_Purchase_Modified_idx` (`modified` ASC) VISIBLE,
  UNIQUE INDEX `uq_Purchase_FolioNum` (`partner` ASC, `folioType` ASC, `folioSerie` ASC, `folioNum` ASC) VISIBLE,
  UNIQUE INDEX `uq_Purchase_Correlative` (`period` ASC, `correlative` ASC) VISIBLE,
  CONSTRAINT `fk_Purchase_TaxPeriod1`
    FOREIGN KEY (`period`)
    REFERENCES `TaxPeriod` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_FolioType1`
    FOREIGN KEY (`folioType`)
    REFERENCES `FolioType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Partner1`
    FOREIGN KEY (`partner`)
    REFERENCES `Partner` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Modified`
    FOREIGN KEY (`modified`)
    REFERENCES `Purchase` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Sale` (
  `id` CHAR(36) NOT NULL,
  `period` CHAR(6) NOT NULL,
  `partner` CHAR(36) NOT NULL,
  `correlative` CHAR(10) NOT NULL,
  `dateIssue` DATE NULL,
  `folioType` CHAR(2) NOT NULL,
  `folioSerie` VARCHAR(20) NULL,
  `folioNum` VARCHAR(20) NOT NULL,
  `priceFC` DECIMAL(14,2) NOT NULL,
  `taxFC` DECIMAL(14,2) NOT NULL,
  `discFC` DECIMAL(14,2) NOT NULL,
  `discTaxFC` DECIMAL(14,2) NOT NULL,
  `totalFC` DECIMAL(14,2) NOT NULL,
  `xrate` DECIMAL(6,3) NOT NULL,
  `currency` ENUM('PEN', 'USD') NOT NULL,
  `priceSC` DECIMAL(14,2) NOT NULL,
  `taxSC` DECIMAL(14,2) NOT NULL,
  `discSC` DECIMAL(14,2) NOT NULL,
  `discTaxSC` DECIMAL(14,2) NOT NULL,
  `totalSC` DECIMAL(14,2) NOT NULL,
  `modified` CHAR(36) NULL,
  `voidFlag` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Purchase_TaxPeriod1_idx` (`period` ASC) VISIBLE,
  INDEX `fk_Purchase_FolioType1_idx` (`folioType` ASC) VISIBLE,
  INDEX `fk_Purchase_Partner1_idx` (`partner` ASC) VISIBLE,
  INDEX `fk_Sale_Modified_idx` (`modified` ASC) VISIBLE,
  UNIQUE INDEX `uq_Sale_SerieNum` (`folioType` ASC, `folioSerie` ASC, `folioNum` ASC) VISIBLE,
  UNIQUE INDEX `uq_Sale_Correlative` (`period` ASC, `correlative` ASC) VISIBLE,
  CONSTRAINT `fk_Purchase_TaxPeriod10`
    FOREIGN KEY (`period`)
    REFERENCES `TaxPeriod` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_FolioType10`
    FOREIGN KEY (`folioType`)
    REFERENCES `FolioType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Purchase_Partner10`
    FOREIGN KEY (`partner`)
    REFERENCES `Partner` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Sale_Modified`
    FOREIGN KEY (`modified`)
    REFERENCES `Sale` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FgnIncomeType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FgnIncomeType` (
  `id` CHAR(2) NOT NULL,
  `shortName` VARCHAR(100) NOT NULL,
  `incomeTaxRate` DECIMAL(5,4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FgnServiceType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FgnServiceType` (
  `id` CHAR(1) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `FgnPurchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FgnPurchase` (
  `id` CHAR(36) NOT NULL,
  `period` CHAR(6) NOT NULL,
  `correlative` CHAR(10) NOT NULL,
  `dateIssue` DATE NOT NULL,
  `folioType` CHAR(2) NOT NULL,
  `folioSerie` VARCHAR(20) NULL,
  `folioNum` VARCHAR(20) NOT NULL,
  `priceFC` DECIMAL(14,2) NOT NULL,
  `othFC` DECIMAL(14,2) NOT NULL,
  `totalFC` DECIMAL(14,2) NOT NULL,
  `taxFC` DECIMAL(14,2) NOT NULL,
  `incomeTaxRate` DECIMAL(5,4) NOT NULL,
  `incomeTaxFC` DECIMAL(14,2) NOT NULL,
  `priceSC` DECIMAL(14,2) NOT NULL,
  `othSC` DECIMAL(14,2) NOT NULL,
  `totalSC` DECIMAL(14,2) NOT NULL,
  `taxSC` DECIMAL(14,2) NOT NULL,
  `incomeTaxSC` DECIMAL(14,2) NOT NULL,
  `currency` ENUM('PEN', 'USD') NOT NULL,
  `xrate` DECIMAL(6,3) NOT NULL,
  `taxFolio` CHAR(36) NOT NULL,
  `incomeType` CHAR(2) NOT NULL,
  `serviceType` CHAR(1) NOT NULL,
  `provision76` TINYINT NOT NULL,
  `partner` CHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FgnPurchase_TaxPeriod1_idx` (`period` ASC) VISIBLE,
  INDEX `fk_FgnPurchase_FolioType1_idx` (`folioType` ASC) VISIBLE,
  INDEX `fk_FgnPurchase_Purchase1_idx` (`taxFolio` ASC) VISIBLE,
  INDEX `fk_FgnPurchase_FgnIncomeType1_idx` (`incomeType` ASC) VISIBLE,
  INDEX `fk_FgnPurchase_FgnServiceType1_idx` (`serviceType` ASC) VISIBLE,
  INDEX `fk_FgnPurchase_Partner1_idx` (`partner` ASC) VISIBLE,
  UNIQUE INDEX `uq_FgnPurchase_FolioNum` (`partner` ASC, `folioType` ASC, `folioSerie` ASC, `folioNum` ASC) VISIBLE,
  UNIQUE INDEX `uq_FgnPurchase_Correlative` (`period` ASC, `correlative` ASC) VISIBLE,
  CONSTRAINT `fk_FgnPurchase_TaxPeriod1`
    FOREIGN KEY (`period`)
    REFERENCES `TaxPeriod` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FgnPurchase_FolioType1`
    FOREIGN KEY (`folioType`)
    REFERENCES `FolioType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FgnPurchase_Purchase1`
    FOREIGN KEY (`taxFolio`)
    REFERENCES `Purchase` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FgnPurchase_FgnIncomeType1`
    FOREIGN KEY (`incomeType`)
    REFERENCES `FgnIncomeType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FgnPurchase_FgnServiceType1`
    FOREIGN KEY (`serviceType`)
    REFERENCES `FgnServiceType` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FgnPurchase_Partner1`
    FOREIGN KEY (`partner`)
    REFERENCES `Partner` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `DoiType`
-- -----------------------------------------------------
START TRANSACTION;
USE `tedora_db`;
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('0', 'OTROS', 0, 1, 1, '\\p{Alnum}{1,15}');
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('1', 'DNI', 0, 1, 0, '\\p{Digit}{8}');
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('4', 'C. EXT', 0, 1, 1, '\\p{Alnum}{1,12}');
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('6', 'RUC', 1, 1, 0, '\\p{Digit}{11}');
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('7', 'PAS', 0, 1, 1, '\\p{Alnum}{1,12}');
INSERT INTO `DoiType` (`id`, `title`, `purchase`, `sale`, `foreign`, `regex`) VALUES ('A', 'CD', 0, 1, 1, '\\p{Digit}{15}');

COMMIT;


-- -----------------------------------------------------
-- Data for table `FolioType`
-- -----------------------------------------------------
START TRANSACTION;
USE `tedora_db`;
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('00', 'OTROS', 1, 0, 0, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Alfanumérico hasta 20.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('01', 'FACTURA', 1, 1, 0, 0, '(E001)|(F\\p{Alnum}{3})|\\p{Digit}{4}', '\\p{Digit}{1,8}', 1, 'E001 o FXXX o 4 dígitos.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('02', 'HONORARIOS', 1, 0, 0, 0, 'E001', '\\p{Digit}{1,8}', 0, 'E001');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('03', 'BOLETA', 1, 1, 0, 0, '(EB01)|(B\\p{Alnum}{3}|\\p{Digit}{4}', '\\p{Digit}{1,8}', 0, 'EB01 o BXXX o 4 dígitos');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('05', 'AEREO REGULAR', 1, 0, 0, 0, '[1-5]', '\\p{Digit}{1,11}', 0, '1: Boleto Manual\n2: Boleto Automático\n3: Boleto Electrónico\n4: Otros\n5: Anulado');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('06', 'PORTE AEREO', 1, 0, 0, 0, '\\p{Digit}{4}', '\\p{Digit}{1,8}', 0, '4 dígitos');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('07', 'N. CREDITO', 1, 1, 0, 0, '(E[0B]01)|([FB]\\p{Alnum}{3}|\\p{Digit}{4}', '\\p{Digit}{1,8}', 1, 'E001 o EB01 o BXXX o FXXX o 4 dígitos');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('08', 'N. DEBITO', 1, 1, 0, 0, '(E[0B]01)|([FB]\\p{Alnum}{3}|\\p{Digit}{4}', '\\p{Digit}{1,8}', 1, 'E001 o EB01 o BXXX o FXXX o 4 dígitos');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('12', 'TICKET', 1, 0, 0, 0, '\\p{Alnum}{1,20}', '\\p{Digit}{1,20}', 1, 'Hasta 20 alfanuméricos (obligatorio)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('14', 'RECIBO', 1, 0, 0, 1, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 1, 'Hasta 20 alfanuméricos (opcional)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('15', 'TERRESTRE URBANO', 1, 0, 0, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Hasta 20 alfanuméricos (opcional)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('16', 'TERRESTRE NACIONAL', 1, 0, 0, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Hasta 20 alfanuméricos (opcional)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('46', 'PDT', 1, 0, 0, 0, '\\p{Digit}{4}', '\\p{Digit}{1,20}', 1, 'Código de PDT/Formulario');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('50', 'DUA', 1, 0, 0, 0, '\\p{Digit}{3}', '\\p{Digit}{6}', 1, 'Código de intendencia aduanera.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('51', 'DUI', 1, 0, 0, 0, '\\p{Digit}{3}', '\\p{Digit}{6}', 1, 'Código de intendencia aduanera.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('52', 'DSI', 1, 0, 0, 0, '\\p{Digit}{3}', '\\p{Digit}{6}', 1, 'Código de intendencia aduanera.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('53', 'DMC', 1, 0, 0, 0, '\\p{Digit}{3}', '\\p{Digit}{6}', 1, 'Código de intendencia aduanera.');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('91', 'NO DOM', 0, 0, 1, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Hasta 20 alfanuméricos (opcional)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('97', 'N.C. NO DOM', 0, 0, 1, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Hasta 20 alfanuméricos (opcional)');
INSERT INTO `FolioType` (`id`, `title`, `purchase`, `sale`, `foreign`, `allowDueDate`, `regexSerie`, `regexNum`, `taxable`, `serieTooltip`) VALUES ('98', 'N.D. NO DOM', 0, 0, 1, 0, '\\p{Alnum}{,20}', '\\p{Alnum}{1,20}', 0, 'Hasta 20 alfanuméricos (opcional)');

COMMIT;


-- -----------------------------------------------------
-- Data for table `FgnIncomeType`
-- -----------------------------------------------------
START TRANSACTION;
USE `tedora_db`;
INSERT INTO `FgnIncomeType` (`id`, `shortName`, `incomeTaxRate`) VALUES ('00', 'BIENES', 0.0000);
INSERT INTO `FgnIncomeType` (`id`, `shortName`, `incomeTaxRate`) VALUES ('18', 'SERV. DIGITAL', 0.3000);

COMMIT;


-- -----------------------------------------------------
-- Data for table `FgnServiceType`
-- -----------------------------------------------------
START TRANSACTION;
USE `tedora_db`;
INSERT INTO `FgnServiceType` (`id`, `description`) VALUES ('1', 'EN PERU');
INSERT INTO `FgnServiceType` (`id`, `description`) VALUES ('2', 'MIXTO');
INSERT INTO `FgnServiceType` (`id`, `description`) VALUES ('3', 'EN EXTRANJERO');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
