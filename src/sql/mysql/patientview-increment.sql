ALTER TABLE user ADD COLUMN emailverified tinyint(1) NULL DEFAULT 0 AFTER email;
DROP TABLE IF EXISTS `emailverification`;
CREATE TABLE emailverification (
  id int(11) NOT NULL,
  username varchar(100) NOT NULL,
  email varchar(100) NOT NULL,
  verificationcode varchar(50) NOT NULL,
  expirydatestamp datetime NOT NULL,
  PRIMARY KEY (id)
);