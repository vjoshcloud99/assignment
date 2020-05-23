CREATE TABLE `assignment`.`period` (
  `businessYearId` INT NOT NULL AUTO_INCREMENT,
  `fromDate` VARCHAR(45) NULL,
  `toDate` VARCHAR(45) NULL,
  `yearUsedFor` VARCHAR(45) NULL,
  PRIMARY KEY (`businessYearId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `assignment`.`period` (`fromDate`, `toDate`, `yearUsedFor`) VALUES ('01-Apr', '31-Mar', 'India Payroll');
INSERT INTO `assignment`.`period` (`fromDate`, `toDate`, `yearUsedFor`) VALUES ('01-Jan', '31-Dec', 'Leave');
INSERT INTO `assignment`.`period` (`fromDate`, `toDate`, `yearUsedFor`) VALUES ('01-Jan', '31-Dec', 'Dubai Payroll');
INSERT INTO `assignment`.`period` (`fromDate`, `toDate`, `yearUsedFor`) VALUES ('26-Mar', '25-Mar', 'India Payroll');
INSERT INTO `assignment`.`period` (`fromDate`, `toDate`, `yearUsedFor`) VALUES ('01-Jan', '31-Dec', 'Angola Payroll');


CREATE TABLE `assignment`.`frequency` (
  `frequencyId` INT NOT NULL AUTO_INCREMENT,
  `freqencyName` VARCHAR(45) NULL,
  PRIMARY KEY (`frequencyId`));

INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('Daily');
INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('Weekly');
INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('Bi-Weekly');
INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('Semi-Monthly');
INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('Monthly');
INSERT INTO `assignment`.`frequency` (`freqencyName`) VALUES ('AdHoc');

CREATE TABLE `assignment`.`cycle` (
  `cycleId` INT NOT NULL AUTO_INCREMENT,
  `businessYearId` INT NULL,
  `periodName` VARCHAR(45) NULL,
  `fromDate` DATE NULL,
  `toDate` DATE NULL,
  `frequencyId` INT NULL,
  PRIMARY KEY (`cycleId`),
  INDEX `FK_CYCLE_PERIOD_BYI_idx` (`businessYearId` ASC) ,
  INDEX `FK_CYCLE_FREQUENCY_ID_idx` (`frequencyId` ASC) ,
  CONSTRAINT `FK_CYCLE_PERIOD_BYI`
    FOREIGN KEY (`businessYearId`)
    REFERENCES `assignment`.`period` (`businessYearId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `FK_CYCLE_FREQUENCY_ID`
    FOREIGN KEY (`frequencyId`)
    REFERENCES `assignment`.`frequency` (`frequencyId`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


