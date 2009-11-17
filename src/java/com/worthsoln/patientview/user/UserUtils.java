package com.worthsoln.patientview.user;

import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.DatabaseUpdateQuery;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.UserDao;

public class UserUtils {

    public static void removePatientFromSystem(String nhsno, String unitcode) {
        String[] tableNames = new String[]{"user", "testresult", "letter",};        //TODO add medicines and diagnosis
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

    public static String retrieveUnitcode(String username) {
        DatabaseDAO dao = new DatabaseDAO("patientview");
        User user = (User) dao.retrieveItem(new UserDao(new User(username)));
        String unitcode = user.getUnitcode();
        return unitcode;
    }

}
