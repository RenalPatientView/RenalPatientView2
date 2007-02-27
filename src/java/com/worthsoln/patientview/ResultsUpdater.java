package com.worthsoln.patientview;

import java.io.File;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import javax.servlet.ServletContext;
import net.sf.hibernate.HibernateException;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.DatabaseUpdateQuery;
import com.worthsoln.patientview.diagnosis.Diagnosis;
import com.worthsoln.patientview.letter.Letter;
import com.worthsoln.patientview.logging.AddLog;
import com.worthsoln.patientview.medicine.Medicine;
import com.worthsoln.patientview.parser.ResultParser;
import com.worthsoln.patientview.user.UserUtils;

public class ResultsUpdater {

    private DatabaseDAO dao;

    public ResultsUpdater(DatabaseDAO dao) {
        this.dao = dao;
    }

    public void update(ServletContext context, File xmlFile) {
        try {
            ResultParser parser = new ResultParser();
            parser.parseResults(context, xmlFile);
            if ("Remove".equalsIgnoreCase(parser.getFlag())
                    || "Dead".equalsIgnoreCase(parser.getFlag())
                    || "Died".equalsIgnoreCase(parser.getFlag())) {
                removePatientFromSystem(parser);
                AddLog.addLog(AddLog.ACTOR_SYSTEM, AddLog.PATIENT_DATA_REMOVE, "", parser.getPatient().getNhsno(),
                        xmlFile.getName());
            } else {
                updatePatientData(parser);
                AddLog.addLog(AddLog.ACTOR_SYSTEM, AddLog.PATIENT_DATA_FOLLOWUP, "", parser.getPatient().getNhsno(),
                        xmlFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void removePatientFromSystem(ResultParser parser) {
        String nhsno = parser.getData("nhsno");
        UserUtils.removePatientFromSystem(nhsno);
    }

    private void updatePatientData(ResultParser parser) {
        updatePatientDetails(parser.getPatient());
        updateCentreDetails(parser.getCentre());
        deleteDateRanges(parser.getDateRanges());
        insertResults(parser.getTestResults());
        deleteLetters(parser.getLetters());
        insertLetters(parser.getLetters());
        deleteOtherDiagnoses(parser.getData("nhsno"));
        insertOtherDiagnoses(parser.getOtherDiagnoses());
        deleteMedicines(parser.getData("nhsno"));
        insertMedicines(parser.getMedicines());
    }

    private void updatePatientDetails(Patient patient) {
        PatientDao patientDao = new PatientDao(patient);
        dao.deleteItem(patientDao);
        dao.insertItem(patientDao);
    }

    private void updateCentreDetails(Centre centre) {
        CentreDao centreDao = new CentreDao(centre);
        dao.deleteItem(centreDao);
        dao.insertItem(centreDao);
    }

    private void deleteDateRanges(Collection dateRanges) {
        String dateRangeDeleteSql =
                "DELETE FROM testresult WHERE nhsno = ? AND testcode = ? AND datestamp > ? AND datestamp < ?";
        for (Iterator iterator = dateRanges.iterator(); iterator.hasNext(); ) {
            TestResultDateRange testResultDateRange = (TestResultDateRange) iterator.next();
            Calendar startDate = TestResultDao.createTimestamp(testResultDateRange.getStartDate() + " 00:00");
            startDate.set(Calendar.SECOND, 0);
            Calendar stopDate = TestResultDao.createTimestamp(testResultDateRange.getStopDate() + " 23:59");
            stopDate.set(Calendar.SECOND, 59);
            Object[] params = new Object[4];
            params[0] = testResultDateRange.getNhsNo();
            params[1] = testResultDateRange.getTestCode();
            params[2] = new Timestamp(startDate.getTimeInMillis());
            params[3] = new Timestamp(stopDate.getTimeInMillis());
            DatabaseUpdateQuery query = new DatabaseUpdateQuery(dateRangeDeleteSql, params);
            dao.doExecute(query);
        }
    }

    private void insertResults(Collection testResults) {
        for (Iterator iterator = testResults.iterator(); iterator.hasNext(); ) {
            TestResult testResult = (TestResult) iterator.next();
            TestResultDao testResultDao = new TestResultDao(testResult);
            dao.insertItem(testResultDao);
        }
    }

    private void deleteLetters(Collection letters) {
        String letterDeleteSql = "DELETE FROM letter WHERE nhsno = ? AND date = ?";
        for (Iterator iterator = letters.iterator(); iterator.hasNext(); ) {
            Letter letter = (Letter) iterator.next();
            Object[] params = new Object[2];
            params[0] = letter.getNhsno();
            params[1] = new Timestamp(letter.getDate().getTimeInMillis());
            DatabaseUpdateQuery query = new DatabaseUpdateQuery(letterDeleteSql, params);
            dao.doExecute(query);
        }
    }

    private void insertLetters(Collection letters) {
        for (Iterator iterator = letters.iterator(); iterator.hasNext(); ) {
            Letter letter = (Letter) iterator.next();
            try {
                HibernateUtil.saveOrUpdateWithTransaction(letter);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteOtherDiagnoses(String nhsno) {
        String diagnosesDeleteSql = "DELETE FROM diagnosis WHERE nhsno = ?";
        Object[] params = new Object[]{nhsno};
        DatabaseUpdateQuery query = new DatabaseUpdateQuery(diagnosesDeleteSql, params);
        dao.doExecute(query);
    }

    private void insertOtherDiagnoses(Collection diagnoses) {
        for (Iterator iterator = diagnoses.iterator(); iterator.hasNext(); ) {
            Diagnosis diagnosis = (Diagnosis) iterator.next();
            try {
                HibernateUtil.saveOrUpdateWithTransaction(diagnosis);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteMedicines(String nhsno) {
        String deleteSql = "DELETE FROM medicine WHERE nhsno = ?";
        Object[] params = new Object[]{nhsno};
        DatabaseUpdateQuery query = new DatabaseUpdateQuery(deleteSql, params);
        dao.doExecute(query);
    }

    private void insertMedicines(Collection medicines) {
        for (Iterator iterator = medicines.iterator(); iterator.hasNext(); ) {
            Medicine medicine = (Medicine) iterator.next();
            try {
                HibernateUtil.saveOrUpdateWithTransaction(medicine);
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }
}
