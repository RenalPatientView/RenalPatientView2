package com.worthsoln.patientview;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Timestamp;
import com.worthsoln.database.StorableItem;

public class TestResultDao extends StorableItem {

    private TestResult testResult;

    public TestResultDao() {
    }

    public TestResultDao(TestResult testResult) {
        this.testResult = testResult;
    }

    public String getIdColumnName() {
        return "nhsno";
    }

    public Object getIdParameter() {
        return testResult.getNhsno();
    }

    public String[] getColumnNames() {
        return new String[]{"testcode", "prepost", "datestamp", "value"};
    }

    public ArrayList getColumnParameters() {
        ArrayList params = new ArrayList();

        params.add(testResult.getTestcode());

        Calendar timestampCal = testResult.getDatestamped();
        Timestamp timestamp = new Timestamp(timestampCal.getTimeInMillis());

        params.add(timestamp);
        params.add(testResult.getPrepost());
        params.add(testResult.getValue());

        return params;
    }

    public static Calendar createTimestamp(String dateTimeString) {
        Calendar cal = null;

        if (-1 != dateTimeString.indexOf("-")) {
            cal = createIsoDatestamp(dateTimeString);
        } else {
            cal = createNormalDatestamp(dateTimeString);
        }

        return cal;
    }

    private static Calendar createNormalDatestamp(String dateTimeString) {
        Calendar datestamp = Calendar.getInstance();
        int year = Integer.parseInt(dateTimeString.substring(6, 10));
        int month = Integer.parseInt(dateTimeString.substring(3, 5));
        int day = Integer.parseInt(dateTimeString.substring(0, 2));

        datestamp.set(year, month - 1, day, 0, 0, 10);

        if (dateTimeString.length() == 16) {
            datestamp.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateTimeString.substring(11, 13)));
            datestamp.set(Calendar.MINUTE, Integer.parseInt(dateTimeString.substring(14, 16)));
        } else {
            datestamp.set(Calendar.HOUR_OF_DAY, 0);
            datestamp.set(Calendar.MINUTE, 0);
        }

        datestamp.set(Calendar.SECOND, 10);
        datestamp.set(Calendar.MILLISECOND, 0);

        return datestamp;
    }

    private static Calendar createIsoDatestamp(String dateTimeString) {
        Calendar datestamp = Calendar.getInstance();
        int year = Integer.parseInt(dateTimeString.substring(0, 4));
        int month = Integer.parseInt(dateTimeString.substring(5, 7));
        int day = Integer.parseInt(dateTimeString.substring(8, 10));

        datestamp.set(year, month - 1, day, 0, 0, 10);

        if (-1 != dateTimeString.indexOf("T")) {
            datestamp.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dateTimeString.substring(11, 13)));
            datestamp.set(Calendar.MINUTE, Integer.parseInt(dateTimeString.substring(14, 16)));

            if (dateTimeString.length() == 19) {
                datestamp.set(Calendar.SECOND, Integer.parseInt(dateTimeString.substring(17, 19)));
            }
        } else {
            datestamp.set(Calendar.HOUR_OF_DAY, 0);
            datestamp.set(Calendar.MINUTE, 0);
            datestamp.set(Calendar.SECOND, 10);
        }

        datestamp.set(Calendar.MILLISECOND, 0);

        return datestamp;
    }

    public Class getTableMapper() {
        return TestResult.class;
    }

    public String getTableName() {
        return "testresult";
    }
}
