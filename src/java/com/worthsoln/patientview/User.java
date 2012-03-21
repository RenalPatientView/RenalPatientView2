package com.worthsoln.patientview;

import java.util.Date;

public class User {

    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private boolean emailverified;
    private String nhsno;
    private String unitcode;
    private boolean firstlogon;
    private boolean dummypatient;
    private Date lastlogon;
    private int failedlogons;
    private boolean accountlocked;
    private String screenname;
    private String splashpage;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

/*
    public User(String username, String password, String role, String email, boolean emailverified, String name, String nhsno, String unitcode,
                boolean dummypatient) {
        this.name = name;
        this.email = email;
        this.emailverified = emailverified;
        setUnitcode(unitcode);
        this.password = password;
        this.role = role;
        this.username = username;
        this.nhsno = nhsno;
        this.firstlogon = true;
        this.dummypatient = dummypatient;
    }

*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getNhsno() {
        return nhsno;
    }

    public void setNhsno(String nhsno) {
        this.nhsno = nhsno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailverified() {
        return emailverified;
    }

    public void setEmailverified(boolean emailverified) {
        this.emailverified = emailverified;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = (unitcode != null) ? unitcode.toUpperCase() : unitcode;
    }

    public boolean isFirstlogon() {
        return firstlogon;
    }

    public void setFirstlogon(boolean firstlogon) {
        this.firstlogon = firstlogon;
    }

    public boolean isDummypatient() {
        return dummypatient;
    }

    public void setDummypatient(boolean dummypatient) {
        this.dummypatient = dummypatient;
    }

    public Date getLastlogon() {
        return lastlogon;
    }

    public void setLastlogon(Date lastlogon) {
        this.lastlogon = lastlogon;
    }

    public int getFailedlogons() {
        return failedlogons;
    }

    public void setFailedlogons(int failedlogons) {
        this.failedlogons = failedlogons;
    }

    public boolean isAccountlocked() {
        return accountlocked;
    }

    public void setAccountlocked(boolean accountlocked) {
        this.accountlocked = accountlocked;
    }

    public String getScreenname() {
        return screenname;
    }

    public void setScreenname(String screenname) {
        this.screenname = screenname;
    }

    public String getSplashpage() {
        return splashpage;
    }

    public void setSplashpage(String splashpage) {
        this.splashpage = splashpage;
    }
}
