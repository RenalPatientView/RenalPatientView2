/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Version : 50136
 Source Host           : localhost
 Source Database       : patientview

 Target Server Version : 50136
 File Encoding         : iso-8859-1

 Date: 12/08/2009 16:42:19 PM
*/

SET NAMES latin1;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `Sequencer`
-- ----------------------------
DROP TABLE IF EXISTS `Sequencer`;

-- ----------------------------
--  Table structure for `centre`
-- ----------------------------
DROP TABLE IF EXISTS `centre`;
CREATE TABLE `centre` (
`centreCode` varchar(10) NOT NULL DEFAULT '',
`centreName` varchar(100) DEFAULT '',
`centreAddress1` varchar(100) DEFAULT '',
`centreAddress2` varchar(100) DEFAULT '',
`centreAddress3` varchar(100) DEFAULT '',
`centreAddress4` varchar(100) DEFAULT '',
`centrePostCode` varchar(100) DEFAULT '',
`centreTelephone` varchar(100) DEFAULT '',
`centreEmail` varchar(100) DEFAULT '',
KEY `centreCode` (`centreCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `centre`
-- ----------------------------
INSERT INTO `centre` VALUES ('RFPFG', 'Derby City Hospital', 'Renal Unit', 'Uttoxeter Road', 'Derby', 'Derbyshire', 'DE22 3NE', '1332 340131', null), ('rj100', 'Renal Patient View', 'Renal Offices', '6th Floor, Borough Wing', 'Guy\'s Hospital', 'London', 'SE1 9RT', '020 7188 7635', 'rpvadministrator@gstt.nhs.uk');

-- ----------------------------
--  Table structure for `diagnosis`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
`id` int(11) NOT NULL DEFAULT '0',
`nhsno` varchar(20) NOT NULL DEFAULT '',
`unitcode` varchar(20) NOT NULL DEFAULT '',
`diagnosis` varchar(200) DEFAULT '',
`displayorder` int(3) DEFAULT '0',
KEY `nhsno_unitcode` (`nhsno`,`unitcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `edtaCode`
-- ----------------------------
DROP TABLE IF EXISTS `edtaCode`;
CREATE TABLE `edtaCode` (
`edtaCode` varchar(100) NOT NULL DEFAULT '',
`linkType` varchar(20) DEFAULT NULL,
`description` varchar(100) DEFAULT '',
`medicalLink01` varchar(100) DEFAULT '',
`medicalLink02` varchar(100) DEFAULT '',
`medicalLink03` varchar(100) DEFAULT '',
`medicalLink04` varchar(100) DEFAULT '',
`medicalLink05` varchar(100) DEFAULT '',
`medicalLink06` varchar(100) DEFAULT '',
`medicalLinkText01` varchar(100) DEFAULT '',
`medicalLinkText02` varchar(100) DEFAULT '',
`medicalLinkText03` varchar(100) DEFAULT '',
`medicalLinkText04` varchar(100) DEFAULT '',
`medicalLinkText05` varchar(100) DEFAULT '',
`medicalLinkText06` varchar(100) DEFAULT '',
`patientLink01` varchar(100) DEFAULT '',
`patientLink02` varchar(100) DEFAULT '',
`patientLink03` varchar(100) DEFAULT '',
`patientLink04` varchar(100) DEFAULT '',
`patientLink05` varchar(100) DEFAULT '',
`patientLink06` varchar(100) DEFAULT '',
`patientLinkText01` varchar(100) DEFAULT '',
`patientLinkText02` varchar(100) DEFAULT '',
`patientLinkText03` varchar(100) DEFAULT '',
`patientLinkText04` varchar(100) DEFAULT '',
`patientLinkText05` varchar(100) DEFAULT '',
`patientLinkText06` varchar(100) DEFAULT '',
PRIMARY KEY (`edtaCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `edtaCode`
-- ----------------------------
INSERT INTO `edtaCode` VALUES ('41', 'edtaCode', 'Adult polycystic kidney disease (PKD)', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/PCKDLong.html', 'http://www.pkdcharity.org.uk/adpkd.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/pckd.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', 'Adult PKD (long version) (EdREN)', 'Adult PKD (PKD Charity)', 'Adult PKD (NKF)', 'Chronic renal failure (EdREN)', '', ''), ('80', 'edtaCode', 'Diabetic Nephropathy', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', 'Chronic renal failure (Merck)', 'Blood pressure and renal disease (EdREN Handbook)', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/diabetes.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diabetic_nephLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', 'Diabetes and the kidney (NKF)', 'Diabetic kidney disease (EdREN)', 'Chronic renal failure (EdREN)', '', '', ''), ('00', 'edtaCode', 'Chronic renal failure, cause uncertain', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', 'Chronic renal failure (Merck)', 'Blood pressure and renal disease (EdREN Handbook)', '', '', '', '', 'http://www.renal.org/rixg/nodiagnosis.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'No diagnosis stated (RIXG)', 'Chronic Renal Failure (EdREN)', '', '', '', ''), ('82', 'edtaCode', 'Myeloma kidney (or light chain disease)', '', '', '', '', '', '', '', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/myel.html', '', '', '', '', '', 'Kidney disease in myeloma', '', '', '', '', ''), ('12', 'edtaCode', 'IgA nephropathy', 'http://www.igan-world.org/infoprof.htm', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', '', '', '', 'IgA nephropathy for professionals (IgAN Network)', 'Blood pressure and renal disease (EdREN Handbook)', 'Chronic renal failure (Merck)', '', '', '', 'http://www.igan-world.org/infopatients.htm', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/Iga.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/IgALong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', 'IgA nephropathy for patients (IgAN Network)', 'IgA nephropathy (NKF)', 'IgA nephropathy (EdREN)', 'Blood pressure and kidney disease (EdREN)', 'Chronic renal failure (EdREN)', ''), ('HD', 'treatment', 'Haemodialysis', 'http://renux.dmed.ed.ac.uk/EdREN/medinfo/medHD.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKhaemodial.html', '', '', '', '', 'Haemodialysis for the non-specialist', 'Haemodialysis for the renal unit SHO', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/haemodialysis.html', 'http://www.kidneypatientguide.org.uk/site/HD.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/HDShort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diet_CRF.html', '', '', 'Info on haemodialysis from the NKF', 'From the Kidney Patient Guide, with animations', 'Info on haemodialysis from EdREN', 'Diet for people with kidney disease', '', ''), ('PD', 'treatment', 'Peritoneal dialysis', 'http://renux.dmed.ed.ac.uk/EdREN/medinfo/medPD.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKPeritonealDialysis.html', '', '', '', '', 'PD for the non-specialist', 'Peritoneal dialysis for the renal unit SHO', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/pd.html', 'http://www.kidneypatientguide.org.uk/site/pd.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/PDShort.htm', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diet_CRF.html', '', '', 'Info on peritoneal dialysis from the NKF', 'From the Kidney Patient Guide, with animations', 'From EdREN', 'Diet for people with kidney disease', '', ''), ('TP', 'treatment', 'Kidney transplant', 'http://renux.dmed.ed.ac.uk/EdREN/medinfo/medTP.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenHDBKhome.html#anchor340890', '', '', '', '', 'Renal transplantation for the non-specialist', 'Edinburgh Transplant Unit Handbook', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/transplant.html', 'http://www.kidneypatientguide.org.uk/site/transplants.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/TransplantShort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diet_CRF.html', '', '', 'Info on kidney transplants', 'From the Kidney Patient Guide, with animations', 'From EdREN', 'Diet for people with kidney disease', '', ''), ('GEN', 'treatment', 'General nephrology (not dialysis, not transplant)', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', '', 'Blood pressure in renal disease', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diet_CRF.html', '', '', '', 'High blood pressure and kidney disease', 'Chronic kidney disease: preventing it from getting worse', 'Diet for people with kidney disease', '', '', ''), ('static', 'static', 'Further information', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenHDBKhome.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenHDBKhome.html#anchor340890', '', '', '', '', 'Edinburgh Renal Unit handbook', 'Edinburgh Transplant Unit handbook', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/index.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/longlist.html', 'http://kidney.niddk.nih.gov/kudiseases/a-z.asp', 'https://www.renalpatientview.org/infoLinks.do', '', '', 'Kidney info from the NKF', 'Kidney words explained (EdREN)', 'Kidney and urologic diseases from the NIDDK', 'See all our info links (on all diseases and treatments)', '', ''), ('14', 'edtaCode', 'Membranous nephropathy', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKnephrotic.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKProteinuria.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02', '', '', 'Nephrotic syndrome (EdREN Handbook)\r\n', 'Proteinuria (EdREN Handbook)\r\n', 'Blood pressure and renal disease (EdREN Handbook)\r\n', 'Chronic renal failure (Merck)', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Membranous.Long.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Membranous nephropathy (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('10', 'edtaCode', 'Glomerulonephritis', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', 'Blood pressure and renal disease (EdREN Handbook)\r\n', 'Chronic renal failure (Merck)', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/glom.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://kidney.niddk.nih.gov/kudiseases/pubs/glomerular/index.htm', '', '', 'Glomerulonephritis (NKF)', 'Blood pressure and kidney disease (EdREN)', 'Chronic renal failure (EdREN)', 'Glomerular diseases (NIDDK)', '', ''), ('11', 'edtaCode', 'FSGS with nephrotic syndrome', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKnephrotic.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKProteinuria.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', 'Nephrotic syndrome (EdREN Handbook)', 'Proteinuria (EdREN Handbook)', 'Blood pressure and renal disease (EdREN Handbook)', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/FSGSLong2.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/fsgs.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/NephroticLong.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/nephsyn_adult.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/nephsyn_child.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'FSGS (EdREN)', 'FSGS (NKF)', 'Nephrotic syndrome (EdREN)', 'Nephrotic syndrome in adults (NKF)', 'Nephrotic syndrome in children (NKF)', 'Chronic renal failure (EdREN)'), ('13', 'edtaCode', 'Dense deposit disease', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', '', '', '', '    (required)', 'Chronic renal failure (EdREN)', 'Blood pressure and kidney disease (EdREN)', '', '', ''), ('15', 'edtaCode', 'MPGN type 1', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', '', '', '', 'required', 'Chronic renal failure (EdREN)', 'Blood pressure and kidney disease (EdREN)', '', '', ''), ('16', 'edtaCode', 'Crescentic nephritis', '', '', '', '', '', '', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CrescenticShort.html', '', '', '', '', '', 'Crescentic nephritis (EdREN)', '', '', '', '', ''), ('17', 'edtaCode', 'FSGS with nephrotic syndrome', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKnephrotic.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKnephrotic.html', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKnephrotic.html', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', 'ephrotic syndrome (EdREN Handbook)\r\n                        NEPHROTIC SYNDROME (EdREN Handbook)', 'Proteinuria (EdREN Handbook)', 'Blood pressure and renal disease (EdREN Handbook)', 'Chronic renal failure (Merck)', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/FSGSLong2.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/fsgs.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/NephroticLong.html', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/nephsyn_adult.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', 'FSGS (EdREN)                                                         [In adults - see 11 for childre', 'FSGS (NKF)', 'Nephrotic syndrome (EdREN)', 'hrotic syndrome in adults, and in children (NKF)                                 Nephrotic syndrome', 'Chronic renal failure (EdREN)', ''), ('19', 'edtaCode', 'Glomerulonephritis', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', 'Hyptertension and renal disease', 'Chronic renal failure (Merck)', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/glom.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://kidney.niddk.nih.gov/kudiseases/pubs/glomerular/index.htm', '', '', 'Glomerulonephritis (NKF)', 'Blood pressure and the kidney (EdREN)', 'Chronic renal failure (EdREN)', 'Glomerular diseases (NIDDK)', '', ''), ('20', 'edtaCode', 'Reflux nephropathy', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''), ('21', 'edtaCode', 'Obstruction - neurogenic bladder', '', '', '', '', '', '', '', '', '', '', 'sdsd', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Obstruction.html', '', '', '', '', '', 'Obstructive nephropathy (EdREN)', '', '', '', '', ''), ('22', 'edtaCode', 'Obstructive nephropathy - congenital', '', '', '', '', '', '', '0', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Obstruction.html', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', '', '', '', '', 'Obstructive nephropathy (EdREN)\r\n                       Obstructive nephropathy (EdREN)', 'Congenital kidney diseases (from NephKids)', '', '', '', ''), ('23', 'edtaCode', 'Obstructive nephropathy - acquired', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Obstruction.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Obstructive nephropathy (EdREN)                       Obstructive nephropathy (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('24', 'edtaCode', 'Reflux nephropathy', 'http://renux.dmed.ed.ac.uk/EdREN/Teachingbits/UTI.html#anchor585924', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', 'Reflux nephropathy (EdREN - Education)', 'Chronic renal failure (Merck)', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/reflux.html', 'http://www.kidney.org.uk/Medical-Info/reflux/index.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', 'Reflux nephropathy (EdREN)', 'Reflux nephropathy (NKF)', 'Chronic renal failure (EdREN)', '', '', ''), ('29', 'edtaCode', 'Reflux nephropathy (pyelonephritis)', 'http://renux.dmed.ed.ac.uk/EdREN/Teachingbits/UTI.html#anchor585924', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', 'Reflux nephropathy teaching information (EdREN)', 'Chronic renal failure (Merck)', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/reflux.html', 'http://www.kidney.org.uk/Medical-Info/reflux/index.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', 'Reflux nephropathy (EdREN)', 'Reflux nephropathy (NKF)', 'Chronic renal failure (EdREN)', '', '', ''), ('30', 'edtaCode', 'Interstitial nephritis', '', '', '', '', '', '', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', '', '', '', '', '', 'nterstitial nephritis (EdREN)', '', '', '', '', ''), ('31', 'edtaCode', 'Analgesic nephropathy', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Interstitial nephritis (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('32', 'edtaCode', 'Cis-platin nephropathy', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', '', '', '', '', 'Interstitial nephritis (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('33', 'edtaCode', 'Cyclosporin nephropathy', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Interstitial nephritis (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('34', 'edtaCode', 'Lead nephropathy', '', '', '', '', '', '', '', '', '', '', '', '', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Interstitial nephritis (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('39', 'edtaCode', 'Drug-induced interstitial nephropathy', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Interstitial nephritis (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('40', 'edtaCode', 'Cystic kidney disease (unspecified type)', 'http://renux.dmed.ed.ac.uk/EdREN/Teachingbits/nonPCKD.html', '', '', '', '', '', 'Diseases that may be confused with PKD (from EdREN)', '', '', '', '', '', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Kidney cysts (NKF)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('42', 'edtaCode', 'Polycystic kidney disease (infantile type)', '', '', '', '', '', '', '', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/arpkd.html', 'http://www.pkdcharity.org.uk/arpkd.html', '', '', '', '', 'Infantile PKD (NKF)', 'ARPKD (PKD Charity)', '', '', '', ''), ('43', 'edtaCode', 'Medullary cystic disease/nephronophthisis', '', '', '', '', '', '', 'info required', '', '', '', '', '', '', '', '', '', '', '', 'info required', '', '', '', '', ''), ('49', 'edtaCode', 'Cystic kidney disease (other specified type)', '', '', '', '', '', '', 'info required', '', '', '', '', '', '', '', '', '', '', '', 'info required', '', '', '', '', ''), ('50', 'edtaCode', 'Inherited nephropathy (unspecified type)', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', '', '', '', '', 'Congenital kidney diseases (from NephKids)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('51', 'edtaCode', 'Alport syndrome', '', '', '', '', '', '', 'See patient links', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/AlportLong.html', 'http://www.kidney.org.uk/Medical-Info/alports/index.html', '', '', '', '', 'Alport syndrome (EdREN)', 'Alport\'s syndrome (NKF)', '', '', '', ''), ('52', 'edtaCode', 'Cystinosis', 'http://www.ncbi.nlm.nih.gov/entrez/dispomim.cgi?id=219800', '', '', '', '', '', 'Cystinosis (OMIM) -  very long, not very up to date', '', '', '', '', '', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', '', '', '', '', '', 'Congenital kidney diseases (from NephKids)', '', '', '', '', ''), ('53', 'edtaCode', 'Primary oxalosis', '', '', '', '', '', '', '', '', '', '', '', '', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', 'http://ghr.nlm.nih.gov/condition=primaryhyperoxaluria', 'http://www.ohf.org/about_disease.html', '', '', '', 'Congenital kidney diseases (from NephKids)', 'Primary Hyperoxaluria (NIH)', 'Primary Hyperoxaluria (Oxalosis Foundation)', '', '', ''), ('54', 'edtaCode', 'Fabry disease', '', '', '', '', '', '', 'See patients links', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/fabry-disease/index.html', '', '', '', '', '', 'Fabry disease (NKF)', '', '', '', '', ''), ('59', 'edtaCode', 'Hereditary nephropathy (other specified type)', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''), ('61', 'edtaCode', 'Oligomeganephronic dysplasia', '', '', '', '', '', '', '', '', '', '', '', '', 'http://cnserver0.nkf.med.ualberta.ca/nephkids/congdiseases.htm', '', '', '', '', '', 'Congenital kidney diseases (from NephKids)', '', '', '', '', ''), ('63', 'edtaCode', 'Congenital renal dysplasia', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/small-singlekid.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/reflux.html', 'http://www.kidney.org.uk/Medical-Info/reflux/index.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', 'Single or small kidney (NKF)', 'Reflux nephropathy (EdREN)', 'Reflux nephropathy (NKF)', 'Chronic renal failure (EdREN)', '', ''), ('66', 'edtaCode', 'Prune belly syndrome', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Obstruction.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'Obstructive nephropathy (EdREN)                       Obstructive nephropathy (EdREN)', 'Chronic renal failure (EdREN)', '', '', '', ''), ('70', 'edtaCode', 'Renal artery stenosis (or renovascular disease - type unspecified\')', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/Ras.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/angioshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', 'Renal artery stenosis (NKF; requires review)', 'Renal arteriography and angioplasty (EdREN)', 'Chronic renal failure (EdREN)', '', '', ''), ('71', 'edtaCode', 'Nephropathy caused by malignant hypertension', '', '', '', '', '', '', '0', '', '', '', '', '', '', '', '', '', '', '', '(needed)', '', '', '', '', ''), ('72', 'edtaCode', 'Hypertensive nephropathy', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', 'http://www.merckmedicus.com/pp/us/hcp/frame_micromedex.jsp?pg=http%3A%2F%2Fmerck.micromedex.com%2Fin', '', '', '', '', 'Blood pressure and renal disease (EdREN Handbook)', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', '', '', '', '0', 'Blood pressure and kidney disease (EdREN)                         Blood pressure and kidney disease', 'Chronic renal failure (EdREN)', '', '', ''), ('73', 'edtaCode', 'Polyarteritis (vasculitis)', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKsystvasc.html', '', '', '', '', '', 'Vasculitis (EdREN Handbook)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/vasc.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/VasculitisLong.html', '', '', '', '', 'Vasculitis (NKF)', 'Vasculitis (EdREN)', '', '', '', ''), ('74', 'edtaCode', 'Wegener\'s granulomatosis', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKsystvasc.html', '', '', '', '', '', 'Vasculitis (EdREN Handbook)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/vasc.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/VasculitisLong.html', '', '', '', '', 'Vasculitis (NKF)', 'Vasculitis (EdREN)', '', '', '', ''), ('75', 'edtaCode', 'Cholesterol emboli/ischaemic nephropathy', '', '', '', '', '', '', '[links as for 89]', '', '', '', '', '', '', '', '', '', '', '', '[links as for 89]', '', '', '', '', ''), ('76', 'edtaCode', 'Glomerulonephritis related to liver cirrhosis', '', '', '', '', '', '', '[links as for 89]', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''), ('78', 'edtaCode', 'Cryoglobulinaemia', '', '', '', '', '', '', '[links as for 89]', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''), ('79', 'edtaCode', 'Renal vascular disease (other cause)', '', '', '', '', '', '', '[links as for 89]', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/Ras.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/angioshort.html', '', '', '', '', 'Renal artery stenosis (NKF)', 'Renal arteriography and angioplasty (EdREN)', '', '', '', ''), ('PRE', 'treatment', 'General nephrology (not dialysis, not transplant)', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', '', 'Blood pressure in renal disease', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/BPshort.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diet_CRF.html', '', '', '', 'High blood pressure and kidney disease', 'Chronic kidney disease: preventing it from getting worse', 'Diet for people with kidney disease', '', '', ''), ('81', 'edtaCode', 'Diabetic nephropathy (II)', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02', '', '', '', '', '', 'Chronic renal failure (Merck)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/diabetes.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/Diabetic_nephLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', 'Diabetes and the kidney (NKF)', 'Diabetic kidney disease (EdREN)', 'Chronic renal failure (EdREN)', '', '', ''), ('83', 'edtaCode', 'Amyloidosis', '', '', '', '', '', '', 'See patient links', '', '', '', '', '', 'http://www.intelihealth.com/IH/ihtIH/WSIHW000/9339/9444.html', 'http://kidney.niddk.nih.gov/kudiseases/pubs/amyloidosis/', 'http://amyloidosis.org/whatisit.asp', 'http://www.information-on-amyloidosis.com/', '', '', 'Amyloidosis from InteliHealth (US; complicated)', 'NIDDK; Simpler but mentions Primary and Dialysis-related amyloid only', 'Amyloidosis support network (very comprehensive, but complicated)', 'From NCERx - again, very detailed, complicated', '', ''), ('84', 'edtaCode', 'SLE (Lupus nephritis)', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKsle.html', '', '', '', '', '', 'Treatment of SLE (EdREN Handbook)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/lupus.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/LupusLong.html', '', '', '', '', 'Lupus and lupus kidney disease (NKF)', 'Lupus nephritis (EdREN)', '', '', '', ''), ('85', 'edtaCode', 'Henoch-Schonlein purpura', '', '', '', '', '', '', 'Information source required', '', '', '', '', '', '', '', '', '', '', '', 'Info link required', '', '', '', '', ''), ('86', 'edtaCode', 'Goodpasture\'s disease', '', '', '', '', '', '', 'See patient info', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/GoodpastureLong.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/GoodpastureShort.html', '', '', '', '', 'Goodpasture\'s disease (long version) from EdREN', 'Goodpasture\'s disease (short version) from EdREN', '', '', '', ''), ('87', 'edtaCode', 'Scleroderma kidney', '', '', '', '', '', '', '(Links required)', '', '', '', '', '', '', '', '', '', '', '', '(Links required)', '', '', '', '', ''), ('88', 'edtaCode', 'HUS and TTP', '', '', '', '', '', '', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/HUS.Long.html', 'http://kidney.niddk.nih.gov/kudiseases/pubs/hemolyticuremic/index.htm', '', '', '', '', 'HUS and TTP (EdREN', 'HUS in childhood (NIDDK)', '', '', '', ''), ('89', 'edtaCode', 'Small vessel vasculitis (or other multisystem disease)', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKsystvasc.html', '', '', '', '', '', 'Systemic vasculitis (EdREN Handbook)', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/vasc.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/VasculitisLong.html', '', '', '', '', 'Vasculitis (NKF)', 'Vasculitis (EdREN)', '', '', '', ''), ('90', 'edtaCode', 'Cortical necrosis or irreversible acute tubular necrosis', '', '', '', '', '', '', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html#anchor544505', '', '', '', '', '', 'Acute tubular necrosis (EdREN)', '', '', '', '', ''), ('91', 'edtaCode', 'Tuberculosis', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '(Information required)', '', '', '', '', ''), ('92', 'edtaCode', 'Urate nephropathy', '', '', '', '', '', '', '', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html#anchor544505', '', '', '', '', '', 'Interstitial nephritis (EdREN)', '', '', '', '', ''), ('93', 'edtaCode', 'Nephrocalcinosis', '', '', '', '', '', '', '(Links required)', '', '', '', '', '', '', '', '', '', '', '', '(Links required)', '', '', '', '', ''), ('94', 'edtaCode', 'Balkan nephropathy', '', '', '', '', '', '', '(Links required)', '', '', '', '', '', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/InterstitialLong.html', '', '', '', '', '', 'Interstitial nephritis (EdREN)', '', '', '', '', ''), ('95', 'edtaCode', 'Kidney tumour', '', '', '', '', '', '', '', '', '', '', '', '', 'http://www.patient.co.uk/showdoc/27000676/', 'http://www.merckmedicus.com/pp/us/hcp/hcp_patient_resource_allhandouts_content_search.jsp?pg=/ppdocs', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/small-singlekid.html', '', '', '', 'Kidney cancer (Patient UK)', 'Kidney cancer (Merck)', 'Single or small kidney (NKF)\r\n', '', '', ''), ('96', 'edtaCode', 'Loss of kidney through operation or trauma', '', '', '', '', '', '', '', '', '', '', '', '', 'http://www.kidney.org.uk/Medical-Info/kidney-disease/small-singlekid.html', 'http://kidney.niddk.nih.gov/kudiseases/pubs/solitarykidney/index.htm', '', '', '', '', 'Single or small kidney (NKF)', 'Solitary kidney (NIDDK)', '', '', '', ''), ('99', 'edtaCode', 'Other kidney disease', 'http://www.renal.org/rixg/nodiagnosis.html', '', '', '', '', '', 'No diagnosis stated (RIXG)', '', '', '', '', '', 'http://www.renal.org/rixg/nodiagnosis.html', '', '', '', '', '', 'No diagnosis stated (RIXG)', '', '', '', '', ''), ('DEF', 'edtaCode', 'No diagnosis stated', 'http://www.renal.org/rixg/nodiagnosis.html', '', '', '', '', '', 'Why is this message showing?', '', '', '', '', '', 'http://www.renal.org/rixg/nodiagnosis.html', '', '', '', '', '', 'Why is this message showing?', '', '', '', '', ''), ('100', 'edtaCode', 'Chronic renal failure, cause uncertain', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', 'Chronic renal failure (Merck)', 'Blood pressure and renal disease (EdREN Handbook)', '', '', '', '', 'http://www.renal.org/rixg/nodiagnosis.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'No diagnosis stated (RIXG)', 'Chronic Renal Failure (EdREN)', '', '', '', ''), ('0', 'edtaCode', 'Chronic renal failure, cause uncertain', 'http://merck.micromedex.com/index.asp?page=bpm_brief&article_id=BPM01NP02&hilight=chronic|renal|fail', 'http://renux.dmed.ed.ac.uk/EdREN/Handbookbits/HDBKBP.html', '', '', '', '', 'Chronic renal failure (Merck)', 'Blood pressure and renal disease (EdREN Handbook)', '', '', '', '', 'http://www.renal.org/rixg/nodiagnosis.html', 'http://renux.dmed.ed.ac.uk/EdREN/EdRenINFObits/CRFLong.html', '', '', '', '', 'No diagnosis stated (RIXG)', 'Chronic Renal Failure (EdREN)', '', '', '', '');

-- ----------------------------
--  Table structure for `letter`
-- ----------------------------
DROP TABLE IF EXISTS `letter`;
CREATE TABLE `letter` (
`id` int(11) NOT NULL DEFAULT '0',
`nhsno` varchar(100) NOT NULL DEFAULT '',
`unitcode` varchar(20) NOT NULL DEFAULT '',
`date` datetime DEFAULT '0000-00-00 00:00:00',
`type` varchar(100) DEFAULT '',
`content` text,
KEY `nhsno_unitcode` (`nhsno`,`unitcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `letter`
-- ----------------------------
INSERT INTO `letter` VALUES ('1', '1234567890', 'a', '2009-11-02 00:00:00', 'for', 'This is a formatted letter\n\nDEOCSD:\nsdsd\n\nLong line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line Long line \n\nShort line\n\nBye!');

-- ----------------------------
--  Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
`id` bigint(20) NOT NULL DEFAULT '0',
`date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
`actor` varchar(100) NOT NULL DEFAULT '',
`action` varchar(100) NOT NULL DEFAULT '',
`nhsno` varchar(100) DEFAULT '',
`user` varchar(100) DEFAULT '',
`unitcode` varchar(100) DEFAULT '',
`extrainfo` varchar(200) DEFAULT '',
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `log`
-- ----------------------------
INSERT INTO `log` VALUES ('1', '2009-10-02 14:41:28', 's', 'logon', '', 's', '', ''), ('2', '2009-10-04 09:52:32', 's', 'logon', '', 's', '', ''), ('3', '2009-10-04 10:45:15', 's', 'logon', '', 's', '', ''), ('4', '2009-10-04 17:08:46', 's', 'logon', '', 's', '', ''), ('5', '2009-10-04 17:10:09', 's', 'logon', '', 's', '', ''), ('6', '2009-10-04 17:16:54', 's', 'logon', '', 's', '', ''), ('7', '2009-10-04 17:20:48', 's', 'logon', '', 's', '', ''), ('8', '2009-10-04 17:22:52', 's', 'logon', '', 's', '', ''), ('9', '2009-10-04 17:24:39', 'system', 'patient data load', '6250604863', '', 'a', 'rfpfg_14128_6250604863.gpg copy.xml'), ('10', '2009-10-04 17:26:39', 'system', 'patient data load', 'GSTT222222', '', 'a', 'rj100_000004_GSTT222222.gpg copy.xml'), ('11', '2009-10-04 17:27:39', 'system', 'patient data load', 'GSTT222222', '', 'a', 'rj100_000004_GSTT222222.gpg copy.xml'), ('12', '2009-10-04 17:30:39', 'system', 'patient data load', 'GSTT222222', '', 'a', 'rj100_000004_GSTT222222.gpg copy.xml'), ('13', '2009-10-04 17:34:12', 's', 'logon', '', 's', '', ''), ('14', '2009-10-04 17:36:30', 's', 'logon', '', 's', '', ''), ('15', '2009-12-08 16:12:23', 'p', 'logon', '', 'p', 'a', ''), ('16', '2009-12-08 16:20:08', 'p', 'logon', '', 'p', 'a', ''), ('17', '2009-12-08 16:21:36', 'p', 'logon', '', 'p', 'a', ''), ('18', '2009-12-08 16:23:59', 'p', 'patient view', '1234567890', '', 'a', ''), ('19', '2009-12-08 16:24:08', 'p', 'patient view', '1234567890', '', 'a', ''), ('20', '2009-12-08 16:25:57', 'p', 'patient view', '1234567890', '', 'a', '');

-- ----------------------------
--  Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
`id` int(11) NOT NULL DEFAULT '0',
`nhsno` varchar(20) NOT NULL DEFAULT '',
`unitcode` varchar(20) NOT NULL DEFAULT '',
`startdate` datetime DEFAULT '0000-00-00 00:00:00',
`name` varchar(100) DEFAULT '',
`dose` varchar(100) DEFAULT '',
PRIMARY KEY (`id`),
KEY `nhsno_unitcode` (`nhsno`,`unitcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `news`
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
`id` int(11) NOT NULL DEFAULT '0',
`datestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
`unitcode` varchar(100) NOT NULL DEFAULT '',
`admin` tinyint(1) NOT NULL DEFAULT '0',
`patient` tinyint(1) NOT NULL DEFAULT '0',
`everyone` tinyint(10) NOT NULL DEFAULT '0',
`headline` varchar(255) NOT NULL DEFAULT '',
`body` text NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `news`
-- ----------------------------
INSERT INTO `news` VALUES ('1', '2009-10-04 17:36:58', 'all', '1', '0', '0', 'Test news', 'sadasf asdf akjnd laikd knapojd kaisjd\r\n\r\najndl\r\njasdkj\r\n\r\najsd\r\najd\r\n;;ajd');

-- ----------------------------
--  Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
`nhsno` varchar(100) NOT NULL DEFAULT '',
`surname` varchar(100) DEFAULT '',
`forename` varchar(100) DEFAULT '',
`dateofbirth` varchar(100) DEFAULT '',
`sex` varchar(100) DEFAULT '',
`address1` varchar(100) DEFAULT '',
`address2` varchar(100) DEFAULT '',
`address3` varchar(100) DEFAULT '',
`postcode` varchar(100) DEFAULT '',
`telephone1` varchar(100) DEFAULT '',
`telephone2` varchar(100) DEFAULT '',
`mobile` varchar(100) DEFAULT '',
`centreCode` varchar(100) NOT NULL DEFAULT '',
`diagnosis` varchar(100) DEFAULT '',
`treatment` varchar(100) DEFAULT '',
`transplantstatus` varchar(100) DEFAULT '',
`hospitalnumber` varchar(100) DEFAULT '',
`gpname` varchar(100) DEFAULT '',
`gpaddress1` varchar(100) DEFAULT '',
`gpaddress2` varchar(100) DEFAULT '',
`gpaddress3` varchar(100) DEFAULT '',
`gppostcode` varchar(100) DEFAULT '',
`gptelephone` varchar(100) DEFAULT '',
PRIMARY KEY (`nhsno`,`centreCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `patient`
-- ----------------------------
INSERT INTO `patient` VALUES ('1234567890', 'Doe', 'John', '1965-04-22', 'M', '23 Fildings Cresent', 'Dodah Place', 'Notown', 'NH5 4RG', '01222 222222', '020 12931234', null, 'a', 'DEF', 'TP', null, '123456', 'Dr De Ath', '10 Holby City', 'BBC Bristol', 'Thingy Dong', 'FG4', '029838 4434 4'), ('4329528096', 'EPRTESTONE', 'CAROL', '1980-12-21', 'F', 'DUMMY PATIENT FOR LAB', 'TESTING', 'TESTING', 'SE1 7EH', '020-7777-8888', null, null, 'rj100', 'DEF', 'GEN', null, 'Z105072', 'COSTA D', 'THE SOUTH LAMBETH RD PRAC', '1 SELWAY HOUSE', '272 SOUTH LAMBETH ROAD', 'SW8 1UL', '020 76221923'), ('GSTT222222', 'EPRTEST-RPV-ONE', 'RPV ONE', '1980-12-12', 'M', 'MY HOUSE', 'MY STREET', null, null, null, null, null, 'rj100', 'DEF', 'GEN', null, '4534541G', 'HOLMES MB', '7 DAVID PLACE', 'ST.HELIER', 'JERSEY', 'JE2 4TD', '01534 736666');

-- ----------------------------
--  Table structure for `result_heading`
-- ----------------------------
DROP TABLE IF EXISTS `result_heading`;
CREATE TABLE `result_heading` (
`headingcode` varchar(20) NOT NULL DEFAULT '',
`heading` varchar(30) NOT NULL DEFAULT '',
`rollover` varchar(50) NOT NULL DEFAULT 'Click for info',
`link` varchar(100) NOT NULL DEFAULT '',
`panel` int(11) NOT NULL DEFAULT '0',
`panelorder` int(11) NOT NULL DEFAULT '0',
PRIMARY KEY (`headingcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `result_heading`
-- ----------------------------
INSERT INTO `result_heading` VALUES ('urea', 'Urea', 'Urea (2.5-7.0) Click for info', 'http://www.renal.org/rixg/results/urea.html', '1', '1'), ('creatinine', 'Creatinine', 'Creatinine (60-120) Click for info', 'http://www.renal.org/rixg/results/creatinine.html', '1', '2'), ('potassium', 'K', 'Potassium (3.5-5.0) Click for info', 'http://www.renal.org/rixg/results/potassium.html', '1', '3'), ('calcium', 'Ca', 'Calcium (2.1-2.6) Click for info', 'http://www.renal.org/rixg/results/calcium.html', '1', '4'), ('phosphate', 'PO4', 'Phosphate (0.8-1.4) Click for info', 'http://www.renal.org/rixg/results/phosphate.html', '1', '6'), ('hb', 'Hb', 'Haemoglobin (115-180) Click for info', 'http://www.renal.org/rixg/results/haemoglobin.html', '1', '7'), ('wbc', 'wbc', 'White blood cell count (4-11) Click for info', 'http://www.renal.org/rixg/results/wbc.html', '1', '8'), ('platelets', 'plats', 'Platelets (150-400) Click for info', 'http://www.renal.org/rixg/results/platelets.html', '1', '9'), ('ciclosporin', 'Ciclo', 'Ciclosporin (cyclosporin) Click for info', 'http://www.renal.org/rixg/results/ciclosporin.html', '3', '6'), ('adjustedcalcium', 'AdjCa', 'Adjusted Calcium (2.1-2.6) Click for info', 'http://www.renal.org/rixg/results/adjcalcium.html', '1', '5'), ('albumin', 'Alb', 'Albumin (35-50) Click for info', 'http://www.renal.org/rixg/results/albumin.html', '2', '1'), ('bpdia', 'BPdia', 'Diastolic blood pressure - Click for info', 'http://www.renal.org/rixg/results/bp.html', '3', '3'), ('bpsys', 'BPsys', 'Systolic blood pressure - Click for info', 'http://www.renal.org/rixg/results/bp.html', '3', '2'), ('cholesterol', 'Cholest', 'Cholesterol - Click for info', 'http://www.renal.org/rixg/results/lipids.html', '2', '7'), ('crp', 'CRP', 'C-reactive protein (0-10) Click for info', 'http://www.renal.org/rixg/results/crp.html', '2', '2'), ('glucose', 'Gluc', 'Glucose (3.5-7, or 11) Click for info', 'http://www.renal.org/rixg/results/glucose.html', '2', '9'), ('hba1c', 'HbA1c', 'HbA1c (less than 7%) Click for info', 'http://www.renal.org/rixg/results/glucose.html', '3', '10'), ('height', 'Height', 'Click for info', 'http://www.renal.org/rixg/results/weightheight.html', '3', '4'), ('ktv', 'Kt/V', 'Kt/V (dialysis adequacy measure) Click for info', 'http://www.renal.org/rixg/results/ktv.html', '4', '6'), ('pth', 'PTH', 'Parathyroid hormone - Click for info', 'http://www.renal.org/rixg/results/pth.html', '3', '9'), ('tacrolimus', 'Tacro', 'Tacrolimus - Click for info', 'http://www.renal.org/rixg/results/tacrolimus.html', '3', '7'), ('tg', 'TG', 'Triglycerides - Click for info', 'http://www.renal.org/rixg/results/lipids.html', '2', '8'), ('urr', 'URR', 'Urea reduction ratio - Click for info', 'http://www.renal.org/rixg/results/urr.html', '4', '5'), ('weight', 'Weight', 'in kg.  Click for info', 'http://www.renal.org/rixg/results/weightheight.html', '3', '1'), ('egfr', 'eGFR', 'Estimated GFR (over 60) Click for info', 'http://www.renal.org/rixg/results/egfr.html', '1', '10'), ('inr', 'INR', 'Warfarin dose control (Usually 2-4) - Click for in', 'http://www.renal.org/rixg/results/inr.html', '3', '5'), ('sodium', 'Na', 'Sodium (135-147) Click for info', 'http://www.renal.org/rixg/results/sodium.html', '2', '3'), ('hco3', 'HCO3', 'Bicarbonate (20-30) Click for info', 'http://www.renal.org/rixg/results/hco3.html', '2', '4'), ('pcr', 'PCR', 'Protein Creatinine ratio (less than 15) Click for', 'http://www.renal.org/rixg/results/pcr.html', '2', '5'), ('acr', 'ACR', 'Albumin:creatinine ratio (less than 3.5) Click for', 'http://www.renal.org/rixg/results/acr.html', '2', '6'), ('sirolimus', 'Siro', 'Sirolimus - Click for info', 'http://www.renal.org/rixg/results/sirolimus.html', '3', '8'), ('bili', 'Bili', 'Bilirubin (liver test) (2-17) Click for info', 'http://www.renal.org/rixg/results/lft.html', '5', '1'), ('ast', 'AST', 'AST (liver test) (10-45) Click for info', 'http://www.renal.org/rixg/results/lft.html', '5', '2'), ('alt', 'ALT', 'AST (liver test) (10-50) Click for info', 'http://www.renal.org/rixg/results/lft.html', '5', '3'), ('alp', 'AlkP', 'AlkP (liver test) (40-125) Click for info', 'http://www.renal.org/rixg/results/lft.html', '5', '4'), ('ggt', 'GGT', 'GGT (liver test) (5-55) Click for info', 'http://www.renal.org/rixg/results/lft.html', '5', '5'), ('ferritin', 'Ferr', 'Ferritin (iron test) (17-300) Click for info', 'http://www.renal.org/rixg/results/iron.html', '5', '6'), ('iron', 'Iron', 'Iron (10-32) Click for info', 'http://www.renal.org/rixg/results/iron.html', '5', '7'), ('transferrin', 'Tferrin', 'Transferrin (iron test) (2-4) Click for info', 'http://www.renal.org/rixg/results/iron.html', '5', '8'), ('ironsat', 'Fe Sat', 'Iron Saturation (14-56) Click for info', 'http://www.renal.org/rixg/results/iron.html', '5', '9'), ('urate', 'Urate', 'Uric Acid (0.12-0.4) Click for info', 'http://www.renal.org/rixg/results/urate.html', '5', '10');

-- ----------------------------
--  Table structure for `testresult`
-- ----------------------------
DROP TABLE IF EXISTS `testresult`;
CREATE TABLE `testresult` (
`nhsno` varchar(100) NOT NULL DEFAULT '',
`unitcode` varchar(20) NOT NULL DEFAULT '',
`testcode` varchar(100) NOT NULL DEFAULT '',
`datestamp` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
`prepost` varchar(100) DEFAULT '',
`value` varchar(100) NOT NULL DEFAULT '',
KEY `nhsno_testcode` (`nhsno`,`testcode`,`unitcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `testresult`
-- ----------------------------
INSERT INTO `testresult` VALUES ('1234567890', 'a', 'egfr', '2007-12-12 13:00:00', '', '88'), ('1234567890', 'a', 'egfr', '2007-12-12 13:00:00', '', '88'), ('1234567890', 'a', 'hb', '2007-12-11 09:00:00', '', '16.0'), ('1234567890', 'a', 'hb', '2007-12-11 12:00:00', '', '12.0'), ('1234567890', 'a', 'hb', '2007-12-11 15:00:00', '', '13.0'), ('1234567890', 'a', 'hb', '2007-12-12 10:00:00', '', '11.6'), ('1234567890', 'a', 'hb', '2007-12-12 13:00:00', '', '11.2'), ('1234567890', 'a', 'platelets', '2007-12-12 10:00:00', '', '333'), ('1234567890', 'a', 'platelets', '2007-12-12 13:00:00', '', '120'), ('1234567890', 'a', 'sodium', '2007-12-12 10:00:00', '', '155'), ('1234567890', 'a', 'sodium', '2007-12-12 13:00:00', '', '156'), ('1234567890', 'a', 'urea', '2007-12-11 09:00:00', '', '6.7'), ('1234567890', 'a', 'urea', '2007-12-11 09:00:00', '', '6.7'), ('1234567890', 'a', 'urea', '2007-12-13 08:00:00', '', '7.0'), ('1234567890', 'a', 'urea', '2007-12-13 08:00:00', '', '7.0');

-- ----------------------------
--  Table structure for `treatment`
-- ----------------------------
DROP TABLE IF EXISTS `treatment`;
CREATE TABLE `treatment` (
`nhsNo` varchar(100) NOT NULL DEFAULT '',
`treatmentCode` varchar(100) NOT NULL DEFAULT '',
PRIMARY KEY (`nhsNo`,`treatmentCode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `uktcode`
-- ----------------------------
DROP TABLE IF EXISTS `uktcode`;
CREATE TABLE `uktcode` (
`id` int(11) NOT NULL DEFAULT '0',
`uktcode` varchar(10) NOT NULL DEFAULT '',
`description` varchar(100) NOT NULL DEFAULT '',
PRIMARY KEY (`id`),
UNIQUE KEY `uktcode_unique` (`uktcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `uktcode`
-- ----------------------------
INSERT INTO `uktcode` VALUES ('1', 'A', 'Active'), ('2', 'S', 'Suspended'), ('3', 'T', 'Transplanted'), ('4', 'R', 'Not on list'), ('5', 'N', 'Not on list'), ('6', 'O', 'Not on list');

-- ----------------------------
--  Table structure for `uktstatus`
-- ----------------------------
DROP TABLE IF EXISTS `uktstatus`;
CREATE TABLE `uktstatus` (
`nhsno` varchar(20) NOT NULL DEFAULT '',
`kidney` varchar(10) DEFAULT '',
`pancreas` varchar(10) DEFAULT ''
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `unit`
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit` (
`unitcode` varchar(100) NOT NULL DEFAULT '',
`name` varchar(100) NOT NULL DEFAULT '',
`address1` varchar(100) DEFAULT NULL,
`address2` varchar(100) DEFAULT NULL,
`address3` varchar(100) DEFAULT NULL,
`postcode` varchar(100) DEFAULT NULL,
`uniturl` varchar(100) DEFAULT NULL,
`trusturl` varchar(100) DEFAULT NULL,
`rpvadminname` varchar(100) DEFAULT NULL,
`rpvadminphone` varchar(100) DEFAULT NULL,
`unitenquiriesphone` varchar(100) DEFAULT NULL,
`unitenquiriesemail` varchar(100) DEFAULT NULL,
`appointmentphone` varchar(100) DEFAULT NULL,
`appointmentemail` varchar(100) DEFAULT NULL,
`outofhours` varchar(100) DEFAULT NULL,
`peritonealdialysisphone` varchar(100) DEFAULT NULL,
`peritonealdialysisemail` varchar(100) DEFAULT NULL,
`haemodialysisunitname1` varchar(100) DEFAULT NULL,
`haemodialysisunitphone1` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation1` varchar(100) DEFAULT NULL,
`haemodialysisuniturl1` varchar(100) DEFAULT NULL,
`haemodialysisunitname2` varchar(100) DEFAULT NULL,
`haemodialysisunitphone2` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation2` varchar(100) DEFAULT NULL,
`haemodialysisuniturl2` varchar(100) DEFAULT NULL,
`haemodialysisunitname3` varchar(100) DEFAULT NULL,
`haemodialysisunitphone3` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation3` varchar(100) DEFAULT NULL,
`haemodialysisuniturl3` varchar(100) DEFAULT NULL,
`haemodialysisunitname4` varchar(100) DEFAULT NULL,
`haemodialysisunitphone4` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation4` varchar(100) DEFAULT NULL,
`haemodialysisuniturl4` varchar(100) DEFAULT NULL,
`haemodialysisunitname5` varchar(100) DEFAULT NULL,
`haemodialysisunitphone5` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation5` varchar(100) DEFAULT NULL,
`haemodialysisuniturl5` varchar(100) DEFAULT NULL,
`haemodialysisunitname6` varchar(100) DEFAULT NULL,
`haemodialysisunitphone6` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation6` varchar(100) DEFAULT NULL,
`haemodialysisuniturl6` varchar(100) DEFAULT NULL,
`haemodialysisunitname7` varchar(100) DEFAULT NULL,
`haemodialysisunitphone7` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation7` varchar(100) DEFAULT NULL,
`haemodialysisuniturl7` varchar(100) DEFAULT NULL,
`haemodialysisunitname8` varchar(100) DEFAULT NULL,
`haemodialysisunitphone8` varchar(100) DEFAULT NULL,
`haemodialysisunitlocation8` varchar(100) DEFAULT NULL,
`haemodialysisuniturl8` varchar(100) DEFAULT NULL,
PRIMARY KEY (`unitcode`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `unit`
-- ----------------------------
INSERT INTO `unit` VALUES ('a', 'a', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null), ('b', 'b', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`username` varchar(100) NOT NULL DEFAULT '',
`password` varchar(100) NOT NULL DEFAULT '',
`role` varchar(100) NOT NULL DEFAULT '',
`name` varchar(100) DEFAULT NULL,
`email` varchar(100) DEFAULT NULL,
`nhsno` varchar(100) DEFAULT '',
`unitcode` varchar(100) DEFAULT NULL,
`firstlogon` tinyint(1) DEFAULT '0',
`dummypatient` tinyint(1) NOT NULL DEFAULT '0',
`lastlogon` datetime DEFAULT NULL,
`failedlogons` int(10) DEFAULT '0',
`accountlocked` tinyint(1) DEFAULT '0',
PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `user`
-- ----------------------------
INSERT INTO `user` VALUES ('s', '0a1b086f072513ebb1d3d715166583135b706781ce4948cb1eb90b9837eb5707', 'superadmin', 's', null, '', null, '0', '0', '2010-01-26 17:04:48', '0', '0'), ('a', 'ed02457b5c41d964dbd2f2a609d63fe1bb7528dbe55e1abf5b52c249cd735797', 'unitadmin', 'a', null, '', 'a', '0', '0', null, '0', '0'), ('b', '4625fd63b0e96fc0d656ae7381605e48d4a0f63a319fc743adf22688613883c7', 'unitadmin', 'b', null, '', 'b', '0', '0', null, '0', '0'), ('p', '891e12e156d8c6609c6d5f3e04b2fc8da6d9ff3d7e9f906314c0909da69637eb', 'patient', 'p', 'test@test.com', '1234567890', 'a', '0', '0', '2010-01-26 18:54:55', '0', '0'), ('q', 'b6197fe0d62a4e463edd2925382d4d268c4fce0859378682608efa4fda326f26', 'patient', 'q', null, '2345678901', 'a', '0', '0', '2010-01-26 18:55:38', '0', '0'), ('y', '96ee59df0b588d3d0c2402e6bf6f51403e94332a6da5924c3a087f92659aa44e', 'patient', 'y', null, '5678901234', 'b', '0', '0', null, '0', '0'), ('z', '95fbeb8f769d2c0079d1d11348877da944aaefaba6ecf9f7f7dab6344ece8605', 'patient', 'z', null, '3456789012', 'b', '0', '0', null, '0', '0'), ('o-GP', '599491574e0c67600b04916d5cc046934c3c4d0920d9731ecc13720c7670f1b2', 'patient', 'oo oooooo-GP', null, '1029384756', 'a', '1', '0', null, '0', '0'), ('o', '599491574e0c67600b04916d5cc046934c3c4d0920d9731ecc13720c7670f1b2', 'patient', 'oo oooooo', '', '1029384756', 'a', '1', '0', null, '0', '0');

