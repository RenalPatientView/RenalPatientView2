ALTER TABLE `renalpatientview`.`user`
 ADD COLUMN `lastlogon` DATETIME  DEFAULT NULL AFTER `dummypatient`,
 ADD COLUMN `failedlogons` TINYINT(4)  NOT NULL AFTER `lastlogon`,
 ADD COLUMN `accountlocked` TINYINT(1)  NOT NULL AFTER `failedlogons`;

ALTER TABLE `renalpatientview`.`unit` ADD COLUMN `rpvadminemail` VARCHAR(100)  DEFAULT NULL AFTER `rpvadminphone`;

ALTER TABLE `renalpatientview`.`user`
 ADD COLUMN `screenname` VARCHAR(100)  NOT NULL AFTER `failedlogons`;
