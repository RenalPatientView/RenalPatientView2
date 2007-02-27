package com.worthsoln.patientview;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Result {

    private String nhsno;
    private Calendar timeStamp;
    private String prepost;
    private Map results = new HashMap();

    public Result(TestResult testResult) {
        this.nhsno = testResult.getNhsno();
        this.prepost = testResult.getPrepost();
        this.timeStamp = testResult.getDatestamped();
    }

    public Result(String nhsno, String prepost, Calendar timeStamp) {
        this.nhsno = nhsno;
        this.prepost = prepost;
        this.timeStamp = timeStamp;
    }

    public void addResult(String testCode, String value) {
        results.put(testCode, value);
    }

    public String getValue(String testCode) {
        Object value = results.get(testCode);

        if (value == null) {
            return "";
        } else {
            return (String) value;
        }
    }

    public String getPrepost() {
        return prepost;
    }

    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public String getFormattedTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yy HH:mm");

        if ((timeStamp.get(Calendar.HOUR_OF_DAY) == 0) && (timeStamp.get(Calendar.MINUTE) == 0)) {
            return dateFormat.format(timeStamp.getTime());
        } else {
            return dateTimeFormat.format(timeStamp.getTime());
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Result)) {
            return false;
        }

        final Result result = (Result) o;

        if ((nhsno != null)
            ? !nhsno.equals(result.nhsno)
            : result.nhsno != null) {
            return false;
        }

        if ((prepost != null)
            ? !prepost.equals(result.prepost)
            : result.prepost != null) {
            return false;
        }

        if ((timeStamp != null)
            ? !timeStamp.equals(result.timeStamp)
            : result.timeStamp != null) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result;

        result = ((nhsno != null)
                  ? nhsno.hashCode()
                  : 0);
        result = 29 * result + ((timeStamp != null)
                                ? timeStamp.hashCode()
                                : 0);
        result = 29 * result + ((prepost != null)
                                ? prepost.hashCode()
                                : 0);

        return result;
    }
}
