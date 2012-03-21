package com.worthsoln.patientview.medicine;

import java.util.Calendar;


public class MedicineWithShortName extends Medicine{

    private String shortname;

    public MedicineWithShortName() {
    }

    public MedicineWithShortName(String nhsno, String unitcode, Calendar startdate, String name, String dose, String shortname) {
        super(nhsno, unitcode, startdate, name, dose);
        this.shortname = shortname;
    }

    public MedicineWithShortName(Medicine med, String shortName) {
        super(med.getNhsno(), med.getUnitcode(), med.getStartdate(), med.getName(), med.getDose());
        setShortname(shortName);
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
}
