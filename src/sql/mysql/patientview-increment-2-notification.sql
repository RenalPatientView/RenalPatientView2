-- Create table last_notification
DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `name` varchar(100) NOT NULL,
  `lastnotification` datetime NOT NULL,
  PRIMARY KEY (`name`)
);

