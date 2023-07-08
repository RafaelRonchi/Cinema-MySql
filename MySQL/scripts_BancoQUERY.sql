-- MySQL Workbench Forward Engineering
-- DROP DATABASE cinemapds;

CREATE DATABASE IF NOT EXISTS `cinemapds`;
USE `cinemapds` ;

-- -----------------------------------------------------
-- Table `cinemapds`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`admin` (
  `idadmin` INT NOT NULL AUTO_INCREMENT,
  `admin_login` VARCHAR(5) NOT NULL,
  `admin_pass` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`idadmin`));
 
-- -----------------------------------------------------
-- Table `cinemapds`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`funcionario` (
  `id_funcionario` INT NOT NULL AUTO_INCREMENT,
  `cpf_funcionario` VARCHAR(14) NOT NULL,
  `nome_funcionario` VARCHAR(200) NOT NULL,
  `funcionario_valor_vendas` DOUBLE NOT NULL,
  PRIMARY KEY (`id_funcionario`));
 

-- -----------------------------------------------------
-- Table `cinemapds`.`filme`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`filme` (
  `idfilme` INT NOT NULL AUTO_INCREMENT,
  `filme_nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idfilme`));
 

-- -----------------------------------------------------
-- Table `cinemapds`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`sala` (
  `idsala` INT NOT NULL AUTO_INCREMENT,
  `sala_horario` DATETIME NOT NULL,
  `filme_idfilme` INT NOT NULL,
  PRIMARY KEY (`idsala`),
  INDEX `fk_sala_filme_idx` (`filme_idfilme` ASC) VISIBLE,
  CONSTRAINT `fk_sala_filme`
    FOREIGN KEY (`filme_idfilme`)
    REFERENCES `cinemapds`.`filme` (`idfilme`)
    ON DELETE CASCADE);
 

-- -----------------------------------------------------
-- Table `cinemapds`.`assento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`assento` (
  `idassento` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(2) NOT NULL,
  `sala_idsala` INT NOT NULL,
  PRIMARY KEY (`idassento`),
  INDEX `fk_assento_sala1_idx` (`sala_idsala` ASC) VISIBLE,
  CONSTRAINT `fk_assento_sala1`
    FOREIGN KEY (`sala_idsala`)
    REFERENCES `cinemapds`.`sala` (`idsala`)
    ON DELETE CASCADE);
 

-- -----------------------------------------------------
-- Table `cinemapds`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `cliente_nome` VARCHAR(200) NOT NULL,
  `cliente_cpf` VARCHAR(14) NOT NULL,
  `cliente_meia_entrada` TINYINT NOT NULL,
  PRIMARY KEY (`idcliente`));
 
-- -----------------------------------------------------
-- Table `cinemapds`.`venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cinemapds`.`venda` (
  `idvenda` INT NOT NULL AUTO_INCREMENT,
  `venda_valor` DOUBLE NOT NULL,
  `funcionario_id_funcionario` INT NOT NULL,
  `cliente_idcliente` INT NOT NULL,
  `assento_idassento` INT NOT NULL,
  PRIMARY KEY (`idvenda`),
  INDEX `fk_venda_funcionario1_idx` (`funcionario_id_funcionario` ASC) VISIBLE,
  INDEX `fk_venda_cliente1_idx` (`cliente_idcliente` ASC) VISIBLE,
  INDEX `fk_venda_assento1_idx` (`assento_idassento` ASC) VISIBLE,
  CONSTRAINT `fk_venda_funcionario1`
    FOREIGN KEY (`funcionario_id_funcionario`)
    REFERENCES `cinemapds`.`funcionario` (`id_funcionario`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_venda_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `cinemapds`.`cliente` (`idcliente`)
    ON DELETE CASCADE,
  CONSTRAINT `fk_venda_assento1`
    FOREIGN KEY (`assento_idassento`)
    REFERENCES `cinemapds`.`assento` (`idassento`)
    ON DELETE CASCADE);
 