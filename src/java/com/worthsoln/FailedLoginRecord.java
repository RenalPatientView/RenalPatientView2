package com.worthsoln;

import java.util.Calendar;

public class FailedLoginRecord {

    private int numberAttempts;
    private Calendar dateOfFirstFail;

    public FailedLoginRecord() {
    }

    public FailedLoginRecord(int numberAttempts, Calendar dateOfFirstFail) {
        this.numberAttempts = numberAttempts;
        this.dateOfFirstFail = dateOfFirstFail;
    }

    public int getNumberAttempts() {
        return numberAttempts;
    }

    public void setNumberAttempts(int numberAttempts) {
        this.numberAttempts = numberAttempts;
    }

    public Calendar getDateOfFirstFail() {
        return dateOfFirstFail;
    }

    public void setDateOfFirstFail(Calendar dateOfFirstFail) {
        this.dateOfFirstFail = dateOfFirstFail;
    }
}
