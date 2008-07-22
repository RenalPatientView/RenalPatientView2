package com.worthsoln.patientview.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.PatientLogon;
import com.worthsoln.patientview.logon.PatientLogonDao;
import com.worthsoln.patientview.unit.Unit;

public class UserDeleteAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        PatientLogon patient = new PatientLogon(username);
        DatabaseDAO dao = getDao(request);
        patient = (PatientLogon) dao.retrieveItem(new PatientLogonDao(patient));
        String mappingToFind = "";
        if (patient != null) {
            if ("patient".equals(patient.getRole())) {
                UserUtils.removePatientFromSystem(patient.getNhsno(), patient.getUnitcode());
            }
            dao.deleteItem(new PatientLogonDao(patient));
            mappingToFind = "success";
        } else {
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
