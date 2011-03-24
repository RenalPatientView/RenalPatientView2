package com.worthsoln.patientview.aboutme;

import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.PatientUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutmeDisplay extends DatabaseAction {

    public ActionForward execute(
            ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);
        String nhsno = patient.getNhsno();

        Aboutme aboutme = AboutmeUtils.fetchAboutmeForPatient(nhsno);

        request.setAttribute("patient", patient);
        
        if (null != aboutme) {
            request.setAttribute("aboutme", aboutme);
            return LogonUtils.logonChecks(mapping, request);
        } else {
            return LogonUtils.logonChecks(mapping, request, "editaboutme");
        }
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "aboutme";
    }
}