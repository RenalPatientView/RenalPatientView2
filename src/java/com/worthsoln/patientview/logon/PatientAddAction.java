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
import com.worthsoln.patientview.logging.AddLog;
import com.worthsoln.patientview.unit.Unit;

public class PatientAddAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        String password = LogonUtils.generateNewPassword();
        String gppassword = LogonUtils.generateNewPassword();
        String name = BeanUtils.getProperty(form, "name");
        String email = BeanUtils.getProperty(form, "email");
        String nhsno = BeanUtils.getProperty(form, "nhsno").trim();
        String unitcode = BeanUtils.getProperty(form, "unitcode");
        String overrideDuplicateNhsno = BeanUtils.getProperty(form, "overrideDuplicateNhsno");
        boolean dummypatient = "true".equals(BeanUtils.getProperty(form, "dummypatient"));
        PatientLogon patient =
                new PatientLogon(username, password, name, email, nhsno, unitcode, true, dummypatient, null, 0, false);
        PatientLogon gp =
                new PatientLogon(username + "-GP", gppassword, name + "-GP", null, nhsno, unitcode, true, dummypatient,
                        null, 0, false);
        DatabaseDAO dao = getDao(request);
        PatientLogon existingPatientwithSameUsername = (PatientLogon) dao.retrieveItem(new PatientLogonDao(patient));
        PatientLogon existingPatientwithSameNhsno = (PatientLogon) dao.retrieveItem(new PatientNhsnoLogonDao(patient));
        String mappingToFind = "";
        if (existingPatientwithSameUsername != null) {
            request.setAttribute(LogonUtils.USER_ALREADY_EXISTS, username);
            patient.setUsername("");
            mappingToFind = "input";
        }
        if (existingPatientwithSameNhsno != null && !overrideDuplicateNhsno.equals("on")) {
            request.setAttribute(LogonUtils.NHSNO_ALREADY_EXISTS, nhsno);
            mappingToFind = "input";
        }
        if (mappingToFind.equals("")) {
            PatientLogon hashedPatient = (PatientLogon) patient.clone();
            PatientLogon hashedGp = (PatientLogon) gp.clone();
            hashedPatient.setPassword(LogonUtils.hashPassword(hashedPatient.getPassword()));
            hashedGp.setPassword(LogonUtils.hashPassword(hashedGp.getPassword()));
            dao.insertItem(new LogonDao(hashedPatient));
            dao.insertItem(new LogonDao(hashedGp));
            AddLog.addLog(request.getUserPrincipal().getName(), AddLog.PATIENT_ADD, patient.getUsername(),
                    patient.getNhsno(), patient.getUnitcode(), "");
            mappingToFind = "success";
        }
        HibernateUtil.putListInRequest(Unit.class, "units", request);
        request.setAttribute("patient", patient);
        request.getSession().setAttribute("gp", gp);
        return mapping.findForward(mappingToFind);
    }

    public String getIdentifier() {
        return null;
    }

    public String getDatabaseName() {
        return "patientview";
    }
}
