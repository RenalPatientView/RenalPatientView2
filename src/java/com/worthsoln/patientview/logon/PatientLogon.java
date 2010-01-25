package com.worthsoln.patientview.logon;

public class PatientLogon extends Logon implements Cloneable {

    public PatientLogon() {
    }

    public PatientLogon(String username) {
        setUsername(username);
    }

    public PatientLogon(String username, String password, String name, String email, String nhsno, String unitcode,
                        boolean firstlogon, boolean dummypatient) {
        setUsername(username);
        setPassword(password);
        setName(name);
        setEmail(email);
        setNhsno(nhsno);
        setUnitcode(unitcode);
        setRole("patient");
        setFirstlogon(firstlogon);
        setDummypatient(dummypatient);
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
