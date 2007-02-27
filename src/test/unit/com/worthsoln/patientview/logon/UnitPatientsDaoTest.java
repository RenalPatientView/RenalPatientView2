package com.worthsoln.patientview.logon;

import junit.framework.TestCase;

public class UnitPatientsDaoTest extends TestCase {

    public void test() {
        UnitPatientsDao upDao = new UnitPatientsDao("abc");

        assertEquals("SELECT * FROM user WHERE unitcode = ? AND role = ?", upDao.getRetrieveListQuery().getSql());
    }
}
