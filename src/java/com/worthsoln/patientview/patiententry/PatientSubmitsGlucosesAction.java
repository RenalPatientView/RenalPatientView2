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

public class PatientSubmitsGlucosesAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, Glucose> glucoses = (Map<Long, Glucose>) session.getAttribute("glucoses");

        DatabaseDAO dao = new DatabaseDAO("patientview");

        String nhsno = PatientUtils.retrieveNhsNo(request, dao);

        for (Glucose glucose : glucoses.values()) {
            PatientAddsUtils.addPatientEnteredResultToDatabase(dao, nhsno, "glucose", glucose.getGlucose(), glucose.getDatetime());
        }

        session.removeAttribute("glucoses");

        return mapping.findForward("success");
    }
}