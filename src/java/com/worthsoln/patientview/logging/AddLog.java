package com.worthsoln.patientview.logging;

import net.sf.hibernate.HibernateException;
import com.worthsoln.HibernateUtil;

public class AddLog {

    public static final String PASSWORD_RESET = "password reset";
    public static final String PASSWORD_CHANGE = "password change";
    public static final String PASSWORD_LOCKED = "password locked";
    public static final String PASSWORD_UNLOCKED = "password unlocked";
    public static final String ACTOR_SYSTEM = "system";
    public static final String PATIENT_DATA_FOLLOWUP = "patient data load";
    public static final String PATIENT_DATA_REMOVE = "patient data remove";
    public static final String LOGGED_ON = "logon";
    public static final String PATIENT_ADD = "patient add";
    public static final String PATIENT_VIEW = "patient view";
    public static final String ADMIN_ADD = "admin add";
    public static final String UKT_DATA_REPLACE = "ukt data";

    public static void addLog(String actor, String action, String user, String nhsno, String unitcode,
                              String extrainfo) {
        LogEntry entry = new LogEntry(nhsno, user, action, actor, unitcode, extrainfo);
        try {
            HibernateUtil.saveOrUpdateWithTransaction(entry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
