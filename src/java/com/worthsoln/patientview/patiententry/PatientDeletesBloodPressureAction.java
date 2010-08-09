package com.worthsoln.patientview.patiententry;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;
import java.util.Date;

public class PatientDeletesBloodPressureAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, BloodPressure> bloodPressures = (Map<Long, BloodPressure>) session.getAttribute("bloodPressures");


        Long bpKey = Long.decode(BeanUtils.getProperty(form, "bpkey"));



        bloodPressures.remove(bpKey);

        session.setAttribute("bloodPressures",bloodPressures);

        return mapping.findForward("success");
    }
}