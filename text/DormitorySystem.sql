CREATE TABLE `dormitory` (
  `DroomNr` char(10) NOT NULL,
  `capacity` int(11) NOT NULL,
  `finish` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `orientation` varchar(45) NOT NULL,
  PRIMARY KEY (`DroomNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `students` (
  `Sno` char(12) NOT NULL,
  `Sname` char(10) NOT NULL,
  `Sgender` char(2) DEFAULT NULL,
  `SroomNr` char(10) DEFAULT NULL,
  `Spassword` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Sno`),
  KEY `SroomNr_pk` (`SroomNr`),
  CONSTRAINT `SroomNr_pk` FOREIGN KEY (`SroomNr`) REFERENCES `dormitory` (`DroomNr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `question` (
  `Sno` char(12) NOT NULL,
  `Qfuture` int(11) NOT NULL,
  `Qpart2_3` char(15) NOT NULL,
  `Qwant` char(12) DEFAULT NULL,
  PRIMARY KEY (`Sno`),
  CONSTRAINT `sno_pk` FOREIGN KEY (`Sno`) REFERENCES `students` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `matchstudents` (
  `Mno1` char(12) NOT NULL,
  `Mno2` char(12) NOT NULL,
  `type` int(11) NOT NULL,
  UNIQUE KEY `Mno1_UNIQUE` (`Mno1`),
  KEY `no2_pk` (`Mno2`),
  CONSTRAINT `no1_pk` FOREIGN KEY (`Mno1`) REFERENCES `students` (`Sno`),
  CONSTRAINT `no2_pk` FOREIGN KEY (`Mno2`) REFERENCES `students` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `score` (
  `SmainNr` char(12) NOT NULL,
  `SotherNr` char(12) NOT NULL,
  `SameScore` int(11) DEFAULT NULL,
  `CompareScore` int(11) DEFAULT NULL,
  KEY `main_fk` (`SmainNr`),
  KEY `other_fk` (`SotherNr`),
  CONSTRAINT `main_fk` FOREIGN KEY (`SmainNr`) REFERENCES `students` (`Sno`),
  CONSTRAINT `other_fk` FOREIGN KEY (`SotherNr`) REFERENCES `students` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `standardScore` (
  `Sno` char(12) NOT NULL,
  `Score` int(11) DEFAULT NULL,
  PRIMARY KEY (`Sno`),
  CONSTRAINT `standard_fk` FOREIGN KEY (`Sno`) REFERENCES `students` (`Sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
