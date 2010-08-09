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

public class PatientAddsGlucoseAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        Map<Long, Glucose> glucoses = (Map<Long, Glucose>) session.getAttribute("glucoses");

        if (null == glucoses) {
            glucoses = new TreeMap<Long, Glucose>();
        }

        String year = BeanUtils.getProperty(form, "year");
        String month = BeanUtils.getProperty(form, "month");
        String day = BeanUtils.getProperty(form, "day");
        String hour = BeanUtils.getProperty(form, "hour");
        String minute = BeanUtils.getProperty(form, "minute");
        String gluc = BeanUtils.getProperty(form, "glucose");

        BeanUtils.setProperty(form, "year", "");
        BeanUtils.setProperty(form, "month", "");
        BeanUtils.setProperty(form, "day", "");
        BeanUtils.setProperty(form, "hour", "");
        BeanUtils.setProperty(form, "minute", "");
        BeanUtils.setProperty(form, "glucose", "");

        Glucose glucose = new Glucose(year, month, day, hour, minute, gluc);

        glucoses.put((new Date()).getTime(), glucose);

        session.setAttribute("glucoses", glucoses);

        return mapping.findForward("success");
    }
}