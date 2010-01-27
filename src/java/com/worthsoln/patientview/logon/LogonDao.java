package com.worthsoln.patientview.logon;

import java.util.ArrayList;
import com.worthsoln.database.StorableItem;

public class LogonDao extends StorableItem {

    private Logon logon;

    public LogonDao() {
    }

    public LogonDao(Logon logon) {
        this.logon = logon;
    }

    public String getIdColumnName() {
        return "username";
    }

    public String[] getColumnNames() {
        return new String[]{"password", "role", "name", "email", "nhsno", "unitcode", "firstlogon", "dummypatient",
                "lastlogon", "failedlogons", "accountlocked"};
    }

    public ArrayList getColumnParameters() {
        ArrayList params = new ArrayList();
        params.add(logon.getPassword());
        params.add(logon.getRole());
        params.add(logon.getName());
        params.add(logon.getEmail());
        params.add(logon.getNhsno());
        params.add(logon.getUnitcode());
        params.add(logon.isFirstlogon());
        params.add(logon.isDummypatient());
        params.add(logon.getLastlogon());
        params.add(logon.getFailedlogons());
        params.add(logon.isAccountlocked());
        return params;
    }

    public Object getIdParameter() {
        return logon.getUsername();
    }

    public Class getTableMapper() {
        return Logon.class;
    }

    public String getTableName() {
        return "user";
    }

    String getNhsnumber() {
        return logon.getNhsno();
    }
}
