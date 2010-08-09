USE patientview;

ALTER table unit ADD column shortname varchar(15) NOT NULL DEFAULT '' AFTER name;

ALTER table unit ADD column haemodialysisunitname9 varchar(100);
ALTER table unit ADD column haemodialysisunitphone9 varchar(100);
ALTER table unit ADD column haemodialysisunitlocation9 varchar(100);
ALTER table unit ADD column haemodialysisuniturl9 varchar(100);

ALTER table unit ADD column haemodialysisunitname10 varchar(100);
ALTER table unit ADD column haemodialysisunitphone10 varchar(100);
ALTER table unit ADD column haemodialysisunitlocation10 varchar(100);
ALTER table unit ADD column haemodialysisuniturl10 varchar(100);

ALTER table unit ADD column haemodialysisunitname11 varchar(100);
ALTER table unit ADD column haemodialysisunitphone11 varchar(100);
ALTER table unit ADD column haemodialysisunitlocation11 varchar(100);
ALTER table unit ADD column haemodialysisuniturl11 varchar(100);

ALTER table unit ADD column haemodialysisunitname12 varchar(100);
ALTER table unit ADD column haemodialysisunitphone12 varchar(100);
ALTER table unit ADD column haemodialysisunitlocation12 varchar(100);
ALTER table unit ADD column haemodialysisuniturl12 varchar(100);

INSERT INTO unit (unitcode, name, shortname) VALUES ("PATIENT", "Patient Entered", "Patient");