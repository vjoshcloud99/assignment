CREATE TABLE `cycle` (
  `cycleId` int(11) NOT NULL AUTO_INCREMENT,
  `periodId` int(11) NOT NULL,
  `businessYearId` int(11) NOT NULL,
  `periodName` varchar(45) NOT NULL,
  `fromDate` date NOT NULL,
  `toDate` date NOT NULL,
  `frequencyId` int(11) NOT NULL,
  PRIMARY KEY (`cycleId`),
  KEY `FK_CYCLE_PERIOD_businessYearId_idx` (`businessYearId`),
  KEY `FK_CYCLE_FREQUENCY_ID_idx` (`frequencyId`),
  CONSTRAINT `FK_CYCLE_FREQUENCY_ID` FOREIGN KEY (`frequencyId`) REFERENCES `frequency` (`frequencyId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_CYCLE_PERIOD_businessYearId` FOREIGN KEY (`businessYearId`) REFERENCES `period` (`businessYearId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
