package com.worthsoln.patientview.logon;

public class PatientNhsnoLogonDao extends LogonDao {

    public PatientNhsnoLogonDao(Logon logon) {
        super(logon);
    }

    public Class getTableMapper() {
        return PatientLogon.class;
    }

    public String getIdColumnName() {
        return "nhsno";
    }

    public Object getIdParameter() {
        return getNhsnumber();
    }

}
