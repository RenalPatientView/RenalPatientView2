package com.worthsoln.patientview.parser;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.worthsoln.patientview.TestResult;
import com.worthsoln.patientview.TestResultDateRange;
import com.worthsoln.patientview.letter.Letter;

public class ResultParserPest {

    private File emptyFile;
    private ResultParser parser;

    public void setUp() {
        try {
            emptyFile = new File("q:/patientview/src/test/letters.xml");
            parser = new ResultParser();

            parser.parseResults(null, emptyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pestNhsNo() throws IOException, ParserConfigurationException, SAXException {

        // assertEquals("1111111111", parser.getData("nhsno"));
    }

    public void pestHospitalNo() throws IOException, ParserConfigurationException, SAXException {

        // assertEquals("999997", parser.getData("hospitalnumber"));
    }

    public void pestTransplantStatus() throws IOException, ParserConfigurationException, SAXException {

        // assertEquals("Active Kid", parser.getData("tpstatus"));
    }

    public void pestCentreCode() {

        // assertEquals("RQR00", parser.getData("centrecode"));
    }

    public void pestCentreName() {

        // assertEquals("St. James's University Hospital", parser.getData("centrename"));
    }

    public void pestcentreaddress1() {

        // assertEquals("Renal Unit", parser.getData("centreaddress1"));
    }

    public void pestcentreaddress2() {

        // assertEquals("Beckett Street", parser.getData("centreaddress2"));
    }

    public void pestcentreaddress3() {

        // assertEquals("Leeds", parser.getData("centreaddress3"));
    }

    public void pestcentreaddress4() {

        // assertEquals("North Yorks", parser.getData("centreaddress4"));
    }

    public void pestcentrepostcode() {

        // assertEquals("LS9 7TF", parser.getData("centrepostcode"));
    }

    public void pestcentretelephone() {

        // assertEquals("0113 206 4600", parser.getData("centretelephone"));
    }

    public void pestcentreemail() {

        // assertEquals("renal@leedsth.nhs.uk", parser.getData("centreemail"));
    }

    public void pestDiagnosisEDTA() {

        // assertEquals("80", parser.getData("diagnosisedta"));
    }

    public void pestGpName() {

        // assertEquals("Dr Jumbo", parser.getData("gpname"));
    }

    public void pestGpAddress1() {

        // assertEquals("83 Anywhere St", parser.getData("gpaddress1"));
    }

    public void pestGpAddress2() {

        // assertEquals("Dumbo Retreat", parser.getData("gpaddress2"));
    }

    public void pestGpAddress3() {

        // assertEquals("Trunkville", parser.getData("gpaddress3"));
    }

    public void pestGpPostcode() {

        // assertEquals("H34 4FR", parser.getData("gppostcode"));
    }

    public void pestGpTelephone() {

        // assertEquals("004434  4567 234", parser.getData("gptelephone"));
    }

    public void pestNoResults() {
        Collection testResults = parser.getTestResults();

        // assertEquals(5, testResults.size());
    }

    public void pestResultsHaveCorrectNhsNo() {
        Collection results = parser.getTestResults();
        Iterator iterator = results.iterator();
        TestResult testResult = (TestResult) iterator.next();

        // assertEquals("1111111111", testResult.getNhsno());
        // assertEquals("hb", testResult.getTestcode());
        // assertEquals("13/09/04", testResult.getFormattedDatestamp());
        // assertEquals("POST", testResult.getKidney());
        // assertEquals("128.", testResult.getPancreas());
        testResult = (TestResult) iterator.next();

        // assertEquals("1111111111", testResult.getNhsno());
        // assertEquals("hb", testResult.getTestcode());
        // assertEquals("08/09/04", testResult.getFormattedDatestamp());
        // assertEquals("", testResult.getKidney());
        // assertEquals("136.", testResult.getPancreas());
        testResult = (TestResult) iterator.next();

        // assertEquals("1111111111", testResult.getNhsno());
        // assertEquals("wbc", testResult.getTestcode());
        // assertEquals("08/10/04", testResult.getFormattedDatestamp());
        // assertEquals("", testResult.getKidney());
        // assertEquals("5.8", testResult.getPancreas());
        testResult = (TestResult) iterator.next();

        // assertEquals("1111111111", testResult.getNhsno());
        // assertEquals("wbc", testResult.getTestcode());
        // assertEquals("01/10/04 11:10", testResult.getFormattedDatestamp());
        // assertEquals("", testResult.getKidney());
        // assertEquals("9.7", testResult.getPancreas());
        testResult = (TestResult) iterator.next();

        // assertEquals("1111111111", testResult.getNhsno());
        // assertEquals("wbc", testResult.getTestcode());
        // assertEquals("27/09/04", testResult.getFormattedDatestamp());
        // assertEquals("", testResult.getKidney());
        // assertEquals("6.8", testResult.getPancreas());
    }

    public void pestDateRangeNumber() {
        Collection dateRanges = parser.getDateRanges();

        // assertEquals(2, dateRanges.size());
    }

    public void pestDateRanges() {
        Collection dateRanges = parser.getDateRanges();
        Iterator iterator = dateRanges.iterator();
        TestResultDateRange resultDateRange = (TestResultDateRange) iterator.next();

        // assertEquals("1111111111", resultDateRange.getNhsNo());
        // assertEquals("hb", resultDateRange.getTestCode());
        // assertEquals("28/04/2004", resultDateRange.getStartDate());
        // assertEquals("15/10/2004", resultDateRange.getStopDate());
        resultDateRange = (TestResultDateRange) iterator.next();

        // assertEquals("1111111111", resultDateRange.getNhsNo());
        // assertEquals("wbc", resultDateRange.getTestCode());
        // assertEquals("28/04/2004", resultDateRange.getStartDate());
        // assertEquals("15/10/2004", resultDateRange.getStopDate());
    }

    public void testLetters() {
        Collection letters = parser.getLetters();
        Iterator iterator = letters.iterator();
        Letter letter = (Letter) iterator.next();

/*
        assertEquals("Renal Clinic", letter.getName());
        assertEquals(16, letter.getStartdate().get(Calendar.DAY_OF_MONTH));
        assertEquals(2, letter.getStartdate().get(Calendar.MONTH));
        assertEquals(2000, letter.getStartdate().get(Calendar.YEAR));
        assertTrue(letter.getDiagnosis().indexOf("data") != -1);
*/

        letter = (Letter) iterator.next();
    }
}
