package com.worthsoln.patientview.logon;

public class UnitAdmin extends Logon implements Cloneable {

    public UnitAdmin() {
    }

    public UnitAdmin(String username) {
        setUsername(username);
    }

    public UnitAdmin(String username, String password, String name, String email, String unitcode, String role,
                     boolean firstlogon) {
        setUsername(username);
        setPassword(password);
        setName(name);
        setEmail(email);
        setUnitcode(unitcode);
        setRole(role);
        setFirstlogon(firstlogon);
        setScreenname("");
        setSplashpage("");
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
