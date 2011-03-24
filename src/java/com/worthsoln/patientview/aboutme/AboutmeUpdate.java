package com.worthsoln.patientview.aboutme;

import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.PatientUtils;
import com.worthsoln.patientview.logon.LogonUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AboutmeUpdate extends DatabaseAction {

    public ActionForward execute(
            ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);

        HibernateUtil.extractDataFromFormMakeObjectAndUpdate(new Aboutme(), form, request, "aboutme");

        request.setAttribute("patient", patient);

        return LogonUtils.logonChecks(mapping, request, "success");
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "aboutme";
    }
}
