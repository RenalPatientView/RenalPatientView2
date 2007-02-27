package com.worthsoln.patientview.logon;

public abstract class Logon {

    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private String nhsno;
    private String unitcode;
    private boolean firstlogon;
    private boolean dummypatient;

    public Logon() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNhsno() {
        return nhsno;
    }

    public void setNhsno(String nhsno) {
        this.nhsno = nhsno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFirstlogon() {
        return firstlogon;
    }

    public void setFirstlogon(boolean firstlogon) {
        this.firstlogon = firstlogon;
    }

    public String getDisplayRole() {
        return LogonUtils.displayRole(getRole());
    }

    public boolean isDummypatient() {
        return dummypatient;
    }

    public void setDummypatient(boolean dummypatient) {
        this.dummypatient = dummypatient;
    }
}
