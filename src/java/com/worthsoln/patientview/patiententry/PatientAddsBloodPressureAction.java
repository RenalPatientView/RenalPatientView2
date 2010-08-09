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

public class PatientAddsBloodPressureAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, BloodPressure> bloodPressures = (Map<Long, BloodPressure>) session.getAttribute("bloodPressures");

        if (null == bloodPressures) {
            bloodPressures = new TreeMap<Long, BloodPressure>();
        }

        String year = BeanUtils.getProperty(form, "year");
        String month = BeanUtils.getProperty(form, "month");
        String day = BeanUtils.getProperty(form, "day");
        String hour = BeanUtils.getProperty(form, "hour");
        String minute = BeanUtils.getProperty(form, "minute");
        String sys = BeanUtils.getProperty(form, "sys");
        String dia = BeanUtils.getProperty(form, "dia");

        BeanUtils.setProperty(form, "year", "");
        BeanUtils.setProperty(form, "month", "");
        BeanUtils.setProperty(form, "day", "");
        BeanUtils.setProperty(form, "hour", "");
        BeanUtils.setProperty(form, "minute", "");
        BeanUtils.setProperty(form, "sys", "");
        BeanUtils.setProperty(form, "dia", "");

        BloodPressure bloodPressure = new BloodPressure(year, month, day, hour, minute, sys, dia);

        bloodPressures.put((new Date()).getTime(),bloodPressure);

        session.setAttribute("bloodPressures",bloodPressures);

        return mapping.findForward("success");
    }
}
