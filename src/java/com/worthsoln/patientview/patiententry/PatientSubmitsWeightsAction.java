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

public class PatientSubmitsWeightsAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, Weight> weights = (Map<Long, Weight>) session.getAttribute("weights");

        DatabaseDAO dao = new DatabaseDAO("patientview");

        String nhsno = PatientUtils.retrieveNhsNo(request, dao);

        for (Weight weight : weights.values()) {
            PatientAddsUtils.addPatientEnteredResultToDatabase(dao, nhsno, "weight", weight.getWeight(), weight.getDatetime());
        }

        session.removeAttribute("weights");

        return mapping.findForward("success");
    }
}