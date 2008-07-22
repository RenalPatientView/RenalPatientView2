package com.worthsoln.patientview.user;

import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.DatabaseUpdateQuery;

public class UserUtils {

    public static void removePatientFromSystem(String nhsno, String unitcode) {
        String[] tableNames = new String[]{"user", "testresult", "letter", };        //TODO add medicines and diagnosis
        for (int i = 0; i < tableNames.length; i++) {
            runDeleteQuery("DELETE FROM " + tableNames[i] + " WHERE nhsno = ? AND unitcode = ?", nhsno, unitcode);
        }
        runDeleteQuery("DELETE FROM patient WHERE nhsno = ? and centreCode = ?", nhsno, unitcode);
    }

    private static void runDeleteQuery(String removePatientSql, String nhsno, String unitcode) {
        DatabaseUpdateQuery query = new DatabaseUpdateQuery(removePatientSql, new Object[]{nhsno, unitcode});
        DatabaseDAO dao = new DatabaseDAO("patientview");
        dao.doExecute(query);
    }
}
