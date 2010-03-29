ALTER TABLE unit ADD COLUMN rpvadminemail VARCHAR(100)  DEFAULT NULL AFTER rpvadminphone;

ALTER TABLE user ADD COLUMN screenname VARCHAR(100) NOT NULL AFTER accountlocked;
