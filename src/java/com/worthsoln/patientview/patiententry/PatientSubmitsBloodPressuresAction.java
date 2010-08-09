package com.worthsoln.patientview.patiententry;

import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.patientview.PatientUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class PatientSubmitsBloodPressuresAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, BloodPressure> bloodPressures = (Map<Long, BloodPressure>) session.getAttribute("bloodPressures");

        DatabaseDAO dao = new DatabaseDAO("patientview");

        String nhsno = PatientUtils.retrieveNhsNo(request, dao);

        for (BloodPressure bloodPressure : bloodPressures.values()) {
            PatientAddsUtils.addPatientEnteredResultToDatabase(dao, nhsno, "bpsys", bloodPressure.getSys(), bloodPressure.getDatetime());
            PatientAddsUtils.addPatientEnteredResultToDatabase(dao, nhsno, "bpdia", bloodPressure.getDia(), bloodPressure.getDatetime());
        }

        session.removeAttribute("bloodPressures");

        return mapping.findForward("success");
    }
}