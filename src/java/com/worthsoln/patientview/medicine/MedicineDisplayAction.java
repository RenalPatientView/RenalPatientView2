package com.worthsoln.patientview.medicine;

import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.PatientUtils;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.unit.Unit;
import com.worthsoln.patientview.unit.UnitUtils;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class MedicineDisplayAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);
        List medicines = getMedicinesForPatient(patient);
        request.setAttribute("medicines", medicines);
        request.setAttribute("patient", patient);
        return LogonUtils.logonChecks(mapping, request);
    }

    private List getMedicinesForPatient(Patient patient) throws HibernateException {
        List medicines = null;
        List<MedicineWithShortName> medicinesWithShortName = new ArrayList();
        if (patient != null) {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();


            medicines = session.find("from " + Medicine.class.getName()
                    + " as medicine where medicine.nhsno = ? order by medicine.unitcode, medicine.startdate desc",
                    patient.getNhsno(), Hibernate.STRING);
            tx.commit();
            HibernateUtil.closeSession();

            for (Object obj : medicines) {
                Medicine med = (Medicine) obj;
                Unit unit = UnitUtils.retrieveUnit(med.getUnitcode());
                medicinesWithShortName.add(new MedicineWithShortName(med, unit.getShortname()));
            }
        }
        return medicinesWithShortName;
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "medicine";
    }
}
