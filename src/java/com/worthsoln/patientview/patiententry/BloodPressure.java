package com.worthsoln.patientview.patiententry;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class BloodPressure {

    private Calendar datetime;
    private String sys;
    private String dia;

    public BloodPressure() {
    }

    public BloodPressure(String year, String month, String day, String hour, String minute, String sys, String dia) {
        setDatetime(year, month, day, hour, minute);
        setSys(sys);
        setDia(dia);
    }

    public void setDatetime(String year, String month, String day, String hour, String minute) {

        this.datetime = Calendar.getInstance();

        datetime.set(Integer.decode(year), Integer.decode(month)
                , Integer.decode(day), Integer.decode(hour), Integer.decode(minute), 0);
    }

    public String getStringDate() {
        DateFormat format = new SimpleDateFormat("d-MMM-yyyy");
        return format.format(datetime.getTime());
    }

    public String getStringTime() {
        DateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(datetime.getTime());
    }

    public Calendar getDatetime() {
        return datetime;
    }

    public void setDatetime(Calendar datetime) {
        this.datetime = datetime;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
}
