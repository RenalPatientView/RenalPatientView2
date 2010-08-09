package com.worthsoln.patientview.patiententry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class PatientDeletesWeightAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, Weight> weights = (Map<Long, Weight>) session.getAttribute("weights");

        Long weightKey = Long.decode(BeanUtils.getProperty(form, "weightkey"));

        weights.remove(weightKey);

        session.setAttribute("weights", weights);

        return mapping.findForward("success");
    }
}