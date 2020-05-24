DROP TABLE IF EXISTS `assignment`.`cycle`;

CREATE TABLE `assignment`.`cycle` (
`cycle_id` INT NOT NULL AUTO_INCREMENT,
`business_year_id` INT NULL,
`period_name` VARCHAR(45) NULL,
`from_date` DATE NULL,
`to_date` DATE NULL,
`frequency_id` INT NULL,
PRIMARY KEY (`cycle_id`),
INDEX `FK_CYCLE_PERIOD_BYI_idx` (`business_year_id` ASC) ,
INDEX `FK_CYCLE_FREQUENCY_ID_idx` (`frequency_id` ASC) ,
CONSTRAINT `FK_CYCLE_PERIOD_BYI`
FOREIGN KEY (`business_year_id`)
REFERENCES `assignment`.`period` (`business_year_id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `FK_CYCLE_FREQUENCY_ID`
FOREIGN KEY (`frequency_id`)
REFERENCES `assignment`.`frequency` (`frequency_id`)
ON DELETE CASCADE
ON UPDATE CASCADE);


DROP TABLE IF EXISTS `assignment`.`period`;

CREATE TABLE `assignment`.`period` (
`business_year_id` INT NOT NULL AUTO_INCREMENT,
`from_date` VARCHAR(45) NULL,
`to_date` VARCHAR(45) NULL,
`year_used_for` VARCHAR(45) NULL,
PRIMARY KEY (`business_year_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `assignment`.`period` (`from_date`, `to_date`, `year_used_for`) VALUES ('01-Apr', '31-Mar', 'India Payroll');
INSERT INTO `assignment`.`period` (`from_date`, `to_date`, `year_used_for`) VALUES ('01-Jan', '31-Dec', 'Leave');
INSERT INTO `assignment`.`period` (`from_date`, `to_date`, `year_used_for`) VALUES ('01-Jan', '31-Dec', 'Dubai Payroll');
INSERT INTO `assignment`.`period` (`from_date`, `to_date`, `year_used_for`) VALUES ('26-Mar', '25-Mar', 'India Payroll');
INSERT INTO `assignment`.`period` (`from_date`, `to_date`, `year_used_for`) VALUES ('01-Jan', '31-Dec', 'Angola Payroll');

DROP TABLE IF EXISTS `assignment`.`frequency`;

CREATE TABLE `assignment`.`frequency` (
`frequency_id` INT NOT NULL AUTO_INCREMENT,
`frequency_name` VARCHAR(45) NULL,
PRIMARY KEY (`frequency_id`));

INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('Daily');
INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('Weekly');
INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('Bi-Weekly');
INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('Semi-Monthly');
INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('Monthly');
INSERT INTO `assignment`.`frequency` (`frequency_name`) VALUES ('AdHoc');


ON UPDATE CASCADE);
`business_year_id` int(11) DEFAULT NULL,
`period_name` varchar(255) DEFAULT NULL,
`from_date` date DEFAULT NULL,
`to_date` date DEFAULT NULL,
`frequency_id` int(11) DEFAULT NULL,
PRIMARY KEY (`cycle_id`),
KEY `FK_CYCLE_PERIOD_BYI_idx` (`business_year_id`),
KEY `FK_CYCLE_FREQUENCY_ID_idx` (`frequency_id`),
CONSTRAINT `FK_CYCLE_FREQUENCY_ID` FOREIGN KEY (`frequency_id`) REFERENCES `frequency` (`frequency_id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `FK_CYCLE_PERIOD_BYI` FOREIGN KEY (`business_year_id`) REFERENCES `period` (`business_year_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `assignment`.`cycle` (
`cycle_id` INT NOT NULL AUTO_INCREMENT,
`business_year_id` INT NULL,
`period_name` VARCHAR(45) NULL,
`from_date` DATE NULL,
`to_date` DATE NULL,
`frequency_id` INT NULL,
PRIMARY KEY (`cycle_id`),
INDEX `FK_CYCLE_PERIOD_BYI_idx` (`business_year_id` ASC) ,
INDEX `FK_CYCLE_FREQUENCY_ID_idx` (`frequency_id` ASC) ,
CONSTRAINT `FK_CYCLE_PERIOD_BYI`
FOREIGN KEY (`business_year_id`)
REFERENCES `assignment`.`period` (`business_year_id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
CONSTRAINT `FK_CYCLE_FREQUENCY_ID`
FOREIGN KEY (`frequency_id`)
REFERENCES `assignment`.`frequency` (`frequency_id`)
ON DELETE CASCADE
ON UPDATE CASCADE);





















-----------------------------------------------------------------------------------------------------------------------------------
OLD scripts -  DO - NOT - USE

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

INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('Daily');
INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('Weekly');
INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('Bi-Weekly');
INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('Semi-Monthly');
INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('Monthly');
INSERT INTO `assignment`.`frequency` (`frequencyName`) VALUES ('AdHoc');

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


