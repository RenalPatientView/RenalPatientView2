-- MySQL dump 8.23
--
-- Host: localhost    Database: patientview
---------------------------------------------------------
-- Server version   3.23.58-nt

--
-- Table structure for table `centre`
--

USE patientview;

DROP TABLE IF EXISTS centre;
CREATE TABLE centre (
  centreCode varchar(10) NOT NULL default '',
  centreName varchar(100) default '',
  centreAddress1 varchar(100) default '',
  centreAddress2 varchar(100) default '',
  centreAddress3 varchar(100) default '',
  centreAddress4 varchar(100) default '',
  centrePostCode varchar(100) default '',
  centreTelephone varchar(100) default '',
  centreEmail varchar(100) default ''
) TYPE=MyISAM;

/*!40000 ALTER TABLE `centre` DISABLE KEYS */;

--
-- Dumping data for table `centre`
--


LOCK TABLES centre WRITE;
INSERT INTO centre VALUES ('RQR00','St. James\'s University Hospital','Renal Unit','Beckett Street','Leeds','North Yorks','LS9 7TF','0113 206 4600','renal@leedsth.nhs.uk');

/*!40000 ALTER TABLE `centre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edtacode`
--

DROP TABLE IF EXISTS edtaCode;
CREATE TABLE edtaCode (
  edtaCode varchar(100) NOT NULL default '',
  description varchar(100) default '',
  medicalLink01 varchar(100) default '',
  medicalLink02 varchar(100) default '',
  medicalLink03 varchar(100) default '',
  medicalLink04 varchar(100) default '',
  medicalLink05 varchar(100) default '',
  medicalLink06 varchar(100) default '',
  medicalLinkText01 varchar(100) default '',
  medicalLinkText02 varchar(100) default '',
  medicalLinkText03 varchar(100) default '',
  medicalLinkText04 varchar(100) default '',
  medicalLinkText05 varchar(100) default '',
  medicalLinkText06 varchar(100) default '',
  patientLink01 varchar(100) default '',
  patientLink02 varchar(100) default '',
  patientLink03 varchar(100) default '',
  patientLink04 varchar(100) default '',
  patientLink05 varchar(100) default '',
  patientLink06 varchar(100) default '',
  patientLinkText01 varchar(100) default '',
  patientLinkText02 varchar(100) default '',
  patientLinkText03 varchar(100) default '',
  patientLinkText04 varchar(100) default '',
  patientLinkText05 varchar(100) default '',
  patientLinkText06 varchar(100) default '',
  PRIMARY KEY  (edtaCode)
) TYPE=MyISAM;

/*!40000 ALTER TABLE `edtacode` DISABLE KEYS */;

--
-- Dumping data for table `edtacode`
--


LOCK TABLES edtaCode WRITE;
INSERT INTO edtaCode VALUES ('1','oneonef','','','','med link 04','','','','','','','','','','','','','','','','','','','',''),('2','TWO','a','c','f','a','','a','b','d','','','','','','','','','','','','','','','',''),('81','eighty one l','a','c','e','g','i','k','b','d','f','h','j','l','m','o','q','s','u','v','n','p','r','t','r','w');

/*!40000 ALTER TABLE `edtaCode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS patient;
CREATE TABLE patient (
  surname varchar(100) NOT NULL default '',
  forename varchar(100) NOT NULL default '',
  dateofbirth varchar(100) NOT NULL default '',
  sex varchar(100) NOT NULL default '',
  nhsno varchar(100) NOT NULL default '',
  hospitalnumber varchar(100) NOT NULL default '',
  address1 varchar(100) NOT NULL default '',
  address2 varchar(100) NOT NULL default '',
  address3 varchar(100) NOT NULL default '',
  postcode varchar(100) NOT NULL default '',
  telephone1 varchar(100) NOT NULL default '',
  telephone2 varchar(100) NOT NULL default '',
  PRIMARY KEY  (nhsno)
) TYPE=MyISAM;

/*!40000 ALTER TABLE `patient` DISABLE KEYS */;

--
-- Dumping data for table `patient`
--


LOCK TABLES patient WRITE;

/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequencer`
--

DROP TABLE IF EXISTS Sequencer;
CREATE TABLE Sequencer (
  name varchar(20) NOT NULL default '',
  seed bigint(20) NOT NULL default '0',
  lastUpdate bigint(20) NOT NULL default '0',
  PRIMARY KEY  (name)
) TYPE=MyISAM;

/*!40000 ALTER TABLE `Sequencer` DISABLE KEYS */;

--
-- Dumping data for table `sequencer`
--


LOCK TABLES Sequencer WRITE;

/*!40000 ALTER TABLE `Sequencer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
CREATE TABLE user (
  username varchar(100) NOT NULL default '',
  password varchar(100) NOT NULL default '',
  role varchar(100) NOT NULL default '',
  PRIMARY KEY  (username)
) TYPE=MyISAM;

/*!40000 ALTER TABLE `user` DISABLE KEYS */;

--
-- Dumping data for table `user`
--


LOCK TABLES user WRITE;

/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

