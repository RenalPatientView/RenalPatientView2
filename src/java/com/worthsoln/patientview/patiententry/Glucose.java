package com.worthsoln.patientview.patiententry;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Glucose {

    private Calendar datetime;
    private String glucose;

    public Glucose() {
    }

    public Glucose(String year, String month, String day, String hour, String minute, String glucose) {
        setDatetime(year, month, day, hour, minute);
        setGlucose(glucose);
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

    public String getGlucose() {
        return glucose;
    }

    public void setGlucose(String glucose) {
        this.glucose = glucose;
    }
}