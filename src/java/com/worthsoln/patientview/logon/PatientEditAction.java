package com.worthsoln.patientview.logon;

import java.util.List;
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

public class PatientEditAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        String password = BeanUtils.getProperty(form, "password");
        String name = BeanUtils.getProperty(form, "name");
        String email = BeanUtils.getProperty(form, "email");
        String nhsno = BeanUtils.getProperty(form, "nhsno");
        String unitcode = BeanUtils.getProperty(form, "unitcode");
        String overrideDuplicateNhsno = BeanUtils.getProperty(form, "overrideDuplicateNhsno");
        boolean firstlogon = "true".equals(BeanUtils.getProperty(form, "firstlogon"));
        boolean dummypatient = "true".equals(BeanUtils.getProperty(form, "dummypatient"));
        PatientLogon patient =
                new PatientLogon(username, password, name, email, nhsno, unitcode, firstlogon, dummypatient);
        DatabaseDAO dao = getDao(request);
        String mappingToFind = "";
        PatientLogon existingPatientwithSameNhsno = (PatientLogon) dao.retrieveItem(new PatientNhsnoLogonDao(patient));
        if (existingPatientwithSameNhsno != null && !username.equals(existingPatientwithSameNhsno.getUsername()) &&
                !overrideDuplicateNhsno.equals("on")) {
            request.setAttribute(LogonUtils.NHSNO_ALREADY_EXISTS, nhsno);
            mappingToFind = "input";
        } else {
            dao.updateItem(new LogonDao(patient));
            HibernateUtil.retrievePersistentObjectAndAddToRequestWithIdParameter(request, Unit.class, unitcode, "unit");
            UnitPatientsAllWithTreatmentDao patientDao = new UnitPatientsAllWithTreatmentDao(unitcode);
            List patients = dao.retrieveList(patientDao);
            request.setAttribute("patients", patients);
            mappingToFind = "success";
        }
        return mapping.findForward(mappingToFind);
    }

    public String getIdentifier() {
        return null;
    }

    public String getDatabaseName() {
        return "patientview";
    }
}
