package com.worthsoln.patientview.logon;

public class SuperAdmin extends Logon {

    public SuperAdmin(String username, String password, String name, String email) {
        setUsername(username);
        setPassword(password);
        setName(name);
        setEmail(email);
        setRole("superadmin");
    }
}
