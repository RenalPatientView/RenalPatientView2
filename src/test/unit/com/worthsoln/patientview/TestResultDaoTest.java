package com.worthsoln.patientview;

import java.util.Calendar;
import junit.framework.TestCase;

public class TestResultDaoTest extends TestCase {

    private TestResultDao dao;

    public void setUp() {
        dao = new TestResultDao();
    }

    public void testCreateTimestampJustDate() {
        Calendar cal = Calendar.getInstance();

        cal.set(2004, 9, 1, 0, 0, 10);

        Calendar timestamp = TestResultDao.createTimestamp("01/10/2004");

        assertEquals(cal.get(Calendar.YEAR), timestamp.get(Calendar.YEAR));
        assertEquals(cal.get(Calendar.MONTH), timestamp.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.DATE), timestamp.get(Calendar.DATE));
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), timestamp.get(Calendar.HOUR_OF_DAY));
        assertEquals(cal.get(Calendar.MINUTE), timestamp.get(Calendar.MINUTE));
        assertEquals(cal.get(Calendar.SECOND), timestamp.get(Calendar.SECOND));
    }

    public void testCreateTimestampDateAndTime() {
        Calendar cal = Calendar.getInstance();

        cal.set(2004, 9, 1, 13, 45, 10);

        Calendar timestamp = TestResultDao.createTimestamp("01/10/2004 13:45");

        assertEquals(cal.get(Calendar.YEAR), timestamp.get(Calendar.YEAR));
        assertEquals(cal.get(Calendar.MONTH), timestamp.get(Calendar.MONTH));
        assertEquals(cal.get(Calendar.DATE), timestamp.get(Calendar.DATE));
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), timestamp.get(Calendar.HOUR_OF_DAY));
        assertEquals(cal.get(Calendar.MINUTE), timestamp.get(Calendar.MINUTE));
        assertEquals(cal.get(Calendar.SECOND), timestamp.get(Calendar.SECOND));
    }
}
