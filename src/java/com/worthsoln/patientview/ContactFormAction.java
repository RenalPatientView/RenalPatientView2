package com.worthsoln.patientview;

import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.LogonUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactFormAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        Patient patient = PatientUtils.retrievePatient(request, getDao(request));
        if (patient != null) {
            String message = request.getParameter("message");
            String type = request.getParameter("type");
            String subject = "Renal Patient View Enquiry";

            if ("unit".equals(type)) {
                // Send to unit
                String unitEmail = request.getParameter("unit");
                if (unitEmail != null && unitEmail.length() > 0) {
                    EmailUtils.sendEmail(request.getSession().getServletContext(), unitEmail, subject, message);
                }
            } else if ("admin".equals(type)) {
                // Send  to admin
                EmailUtils.sendEmail(request.getSession().getServletContext(), subject, message);
            }
        } else if (!request.isUserInRole("patient")) {
            return LogonUtils.logonChecks(mapping, request, "control");
        }
        request.setAttribute("emailSent", true);
        return LogonUtils.logonChecks(mapping, request);
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "patient";
    }
}