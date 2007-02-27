package com.worthsoln.patientview.logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.unit.Unit;
import com.worthsoln.patientview.logging.AddLog;

public class PasswordResetAction extends DatabaseAction {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        PatientLogon patient = new PatientLogon(username);
        DatabaseDAO dao = getDao(request);
        patient = (PatientLogon) dao.retrieveItem(new PatientLogonDao(patient));
        String mappingToFind = "";

        if (patient != null) {
            String password = LogonUtils.generateNewPassword();
            patient.setPassword(password);

            AddLog.addLog(request.getUserPrincipal().getName(), AddLog.PASSWORD_RESET, patient.getUsername(), "");
            dao.updateItem(new LogonDao(patient));

            mappingToFind = "success";
        } else {
            request.setAttribute(LogonUtils.USER_ALREADY_EXISTS, username);
            patient.setUsername("");

            mappingToFind = "input";
        }

        HibernateUtil.putListInRequest(Unit.class, "units", request);
        request.setAttribute("patient", patient);

        return mapping.findForward(mappingToFind);
    }

    public String getIdentifier() {
        return null;
    }

    public String getDatabaseName() {
        return "patientview";
    }
}
