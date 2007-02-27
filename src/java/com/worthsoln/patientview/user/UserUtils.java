package com.worthsoln.patientview.user;

import com.worthsoln.database.DatabaseUpdateQuery;
import com.worthsoln.database.DatabaseDAO;

public class UserUtils {

    public static void removePatientFromSystem(String nhsno) {
        String[] tableNames = new String[]{"patient", "user", "testresult", "letter", };
        for (int i = 0; i < tableNames.length; i++) {
            runDeleteQuery("DELETE FROM " + tableNames[i] + " WHERE nhsno = ?", nhsno);
        }
    }

    private static void runDeleteQuery(String removePatientSql, String nhsno) {
        DatabaseUpdateQuery query = new DatabaseUpdateQuery(removePatientSql, new Object[]{nhsno});
        DatabaseDAO dao = new DatabaseDAO("patientview");
        dao.doExecute(query);
    }
}
