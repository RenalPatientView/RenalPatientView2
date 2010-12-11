USE patientview;

DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
  id int(11) NOT NULL AUTO_INCREMENT,
  datestamp datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  nhsno varchar(10) NOT NULL DEFAULT '',
  body text NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO comment (datestamp, nhsno, body)
   SELECT testresult.datestamp, testresult.nhsno, testresult.value
   FROM testresult WHERE testresult.testcode = 'resultcomment';

DELETE FROM testresult WHERE testresult.testcode = 'resultcomment';