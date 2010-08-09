package com.worthsoln.patientview.patiententry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

public class PatientAddsWeightAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, Weight> weights = (Map<Long, Weight>) session.getAttribute("weights");

        if (null == weights) {
            weights = new TreeMap<Long, Weight>();
        }

        String year = BeanUtils.getProperty(form, "year");
        String month = BeanUtils.getProperty(form, "month");
        String day = BeanUtils.getProperty(form, "day");
        String hour = BeanUtils.getProperty(form, "hour");
        String minute = BeanUtils.getProperty(form, "minute");
        String heavyiness = BeanUtils.getProperty(form, "weight");

        BeanUtils.setProperty(form, "year", "");
        BeanUtils.setProperty(form, "month", "");
        BeanUtils.setProperty(form, "day", "");
        BeanUtils.setProperty(form, "hour", "");
        BeanUtils.setProperty(form, "minute", "");
        BeanUtils.setProperty(form, "weight", "");

        Weight weight = new Weight(year, month, day, hour, minute, heavyiness);

        weights.put((new Date()).getTime(), weight);

        session.setAttribute("weights", weights);

        return mapping.findForward("success");
    }
}