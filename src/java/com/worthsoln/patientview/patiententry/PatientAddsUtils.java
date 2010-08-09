package com.worthsoln.patientview.patiententry;

import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.TestResult;
import com.worthsoln.patientview.TestResultDao;

import java.util.Calendar;

public class PatientAddsUtils {

    static void addPatientEnteredResultToDatabase(DatabaseDAO dao, String nhsno, String testCode, String testValue, Calendar dateTime) {
        TestResult testResult = new TestResult(nhsno, "PATIENT", dateTime, testCode, testValue);
        TestResultDao testResultDao = new TestResultDao(testResult);
        dao.insertItem(testResultDao);
    }
}
