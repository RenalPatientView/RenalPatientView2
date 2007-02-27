package com.worthsoln.patientview;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestResult {

    private String nhsno;
    private Calendar datestamped;
    private String prepost;
    private String testcode;
    private String value;

    public TestResult() {
    }

    public TestResult(String nhsno, Calendar datestamp, String testcode, String value) {
        this.nhsno = nhsno;
        this.testcode = testcode;
        this.datestamped = datestamp;
        this.value = value;
        this.prepost = "";
    }

    public Calendar getDatestamped() {
        return datestamped;
    }

    public void setDatestamp(Timestamp datestamped) {
        Calendar cal = Calendar.getInstance();

        cal.setTimeInMillis(datestamped.getTime());

        this.datestamped = cal;
    }

    public void setDatestampString(String dateStampString) {
        this.datestamped = TestResultDao.createTimestamp(dateStampString);
    }

    public String getNhsno() {
        return nhsno;
    }

    public void setNhsno(String nhsno) {
        this.nhsno = nhsno;
    }

    public String getPrepost() {
        return prepost;
    }

    public void setPrepost(String prepost) {
        this.prepost = prepost;
    }

    public String getTestcode() {
        return testcode;
    }

    public void setTestcode(String testcode) {
        this.testcode = testcode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormattedDatestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

        if ((datestamped.get(Calendar.HOUR_OF_DAY) == 0) && (datestamped.get(Calendar.MINUTE) == 0)) {
            return dateFormat.format(datestamped.getTime());
        } else {
            return dateTimeFormat.format(datestamped.getTime());
        }
    }

    public String getSortingDatestamp() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm");

        return dateTimeFormat.format(datestamped.getTime());
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof TestResult)) {
            return false;
        }

        final TestResult testResult = (TestResult) o;

        if ((datestamped != null)
            ? !datestamped.equals(testResult.datestamped)
            : testResult.datestamped != null) {
            return false;
        }

        if ((nhsno != null)
            ? !nhsno.equals(testResult.nhsno)
            : testResult.nhsno != null) {
            return false;
        }

        if ((prepost != null)
            ? !prepost.equals(testResult.prepost)
            : testResult.prepost != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;

        result = ((nhsno != null)
                  ? nhsno.hashCode()
                  : 0);
        result = 29 * result + ((datestamped != null)
                                ? datestamped.hashCode()
                                : 0);
        result = 29 * result + ((prepost != null)
                                ? prepost.hashCode()
                                : 0);

        return result;
    }
}
