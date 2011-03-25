USE patientview;

DROP TABLE IF EXISTS `aboutme`;
CREATE TABLE `aboutme` (
  `id` int(11) NOT NULL,
  `nhsno` varchar(10) NOT NULL,
  `aboutme` text,
  `talkabout` text,
  PRIMARY KEY (`id`)
);