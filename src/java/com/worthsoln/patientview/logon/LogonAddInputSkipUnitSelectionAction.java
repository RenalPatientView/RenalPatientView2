package com.worthsoln.patientview.logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.unit.Unit;

public class LogonAddInputSkipUnitSelectionAction extends Action {

    public ActionForward execute(
            ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User user = (User) HibernateUtil.getPersistentObject(User.class, request.getUserPrincipal().getName());
        ActionForward actionForward;
        if (user.getRole().equals("superadmin")) {
            HibernateUtil.putListInRequest(Unit.class, "units", request);
            actionForward = LogonUtils.logonChecks(mapping, request);
        } else {
            HibernateUtil.retrievePersistentObjectAndAddToRequestWithIdParameter(request, Unit.class,
                    user.getUnitcode(), "unit");
            actionForward = LogonUtils.logonChecks(mapping, request, "skipunitchoice");

        }
        return actionForward;
    }
}
