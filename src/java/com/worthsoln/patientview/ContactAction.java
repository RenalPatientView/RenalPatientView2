package com.worthsoln.patientview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.unit.Unit;

public class ContactAction extends DatabaseAction {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Patient patient = PatientUtils.retrievePatient(request, getDao(request));

        if (patient != null) {
            request.setAttribute("patient", patient);
            HibernateUtil.retrievePersistentObjectAndAddToRequestWithIdParameter(request, Unit.class,
                patient.getCentreCode(), "unit");
        } else if (!request.isUserInRole("patient")) {
            return LogonUtils.logonChecks(mapping, request, "control");
        }

        DynaActionForm feedbackForm = (DynaActionForm) form;
        feedbackForm.set("annonymous","true");

        return LogonUtils.logonChecks(mapping, request);
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "patient";
    }
}
